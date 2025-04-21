package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CoffeeForm;

@WebServlet("/coffeeform")
public class CoffeeFormServlet extends HttpServlet{

	public CoffeeFormServlet() {
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/coffee_form.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		
		String milk = req.getParameter("milk");
		String coffee = req.getParameter("coffee");
		
		CoffeeForm cf = new CoffeeForm(milk, coffee);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/coffee_result.jsp");
		
		req.setAttribute("coffeeForm", cf);
		
		rd.forward(req, resp);
	}
	
}
