package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/wellcome")
public class WelcomeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		if(isNumber(age) == true) {
			String adult = Integer.parseInt(age) >= 18 ? "成年":"未成年";
			resp.getWriter().print(name + "歡迎光臨("+age+"歲" + adult+")");
		}
		else {
			resp.getWriter().print(name + "歡迎光臨");
		}
	
	}
	
	private boolean isNumber(String data) {
		try {
			Integer.parseInt(data);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	private boolean isNumber2(String data) {
		return data.matches("\\d+");
	}
    
}
