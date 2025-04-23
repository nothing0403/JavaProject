package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.OrderDTO;
import service.OrderService;
import service.ProductService;

@WebServlet("/order")
public class OrderServlet extends HttpServlet{

	private OrderService orderService = new OrderService();
	private ProductService productService = new ProductService();
	
	
	// 查看歷史資料
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<OrderDTO> orderDTOs = orderService.getOrderHistory();
		//int totalPrice = orderService.TotalPrice();
		int totalPrice = orderDTOs.stream()
				  .mapToInt(dto -> productService.getPrice(dto.getMessage()))
				  .sum();
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/history.jsp");
		req.setAttribute("orderDTOs", orderDTOs);
		req.setAttribute("totalPrice", totalPrice);
		rd.forward(req, resp);
	}

	// 接收訂單的請求
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String item = req.getParameter("item");
		
		OrderDTO orderDTO = orderService.addOrder(item);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/result.jsp");
		req.setAttribute("orderDTO", orderDTO);
		rd.forward(req, resp);
	}

}
