package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.ProductDTO;
import service.ProductService;

@WebServlet("/begin")
public class OrderBeginServlet extends HttpServlet{

	private ProductService productService = new ProductService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		
		List<ProductDTO> productDTO = productService.findAll();
		
		req.setAttribute("productDTO", productDTO);
		rd.forward(req, resp);
	}
	
}
