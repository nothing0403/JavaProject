package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CoffeeOrder;

@WebServlet("/coffeeOrder")
public class CoffeeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String type = req.getParameter("type");
		String size = req.getParameter("size");
		String sugar = req.getParameter("sugar");
		
		if(type == null | size == null | sugar == null) {
			resp.getWriter().print("飲料資訊輸入錯誤");
			return;
		}
		
		CoffeeOrder coffeeOrder = new CoffeeOrder(type, size, sugar);
		
		RequestDispatcher rd = req.getRequestDispatcher("coffee_order.jsp");
		//RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/coffee_order.jsp");
		req.setAttribute("coffeeOrder", coffeeOrder);
		rd.forward(req, resp);
		
	    //resp.getWriter().print(String.format(co.getInfo()));
	}
    
}
