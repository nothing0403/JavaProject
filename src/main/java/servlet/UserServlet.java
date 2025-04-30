package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/user")
public class UserServlet extends HttpServlet{

	public UserServlet() {
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/user_form.jsp"); 
		rd.forward(req, resp);	
		
			
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String userName = req.getParameter("userName");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String height = req.getParameter("height");
		String weight = req.getParameter("weight");
		
		User user = new User(userName, gender, age, height, weight);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/user_result.jsp");
		req.setAttribute("user", user);
		rd.forward(req, resp);
	}
    
	
}
