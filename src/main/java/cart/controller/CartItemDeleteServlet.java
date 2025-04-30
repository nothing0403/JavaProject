package cart.controller;

import java.io.IOException;
import java.util.List;

import cart.model.dto.OrderDTO;
import cart.model.dto.ProductDTO;
import cart.service.ProductService;
import cart.service.impl.ProductServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/product/cart/item/delete")
public class CartItemDeleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		int index = Integer.parseInt(req.getParameter("index"));
		
		if(session.getAttribute("cart") != null) {
			List<OrderDTO> cart = (List<OrderDTO>)session.getAttribute("cart");
			cart.remove(index);
			session.setAttribute("cart", cart);
		}
		
		resp.sendRedirect("/JavaWebCart/product/cart");
	}
	
}
