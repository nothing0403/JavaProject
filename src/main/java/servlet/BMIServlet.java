package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.Util;

@WebServlet("/bmi")
public class BMIServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String h = req.getParameter("h");
		String w = req.getParameter("w");
		
		if(!(Util.isDouble(h) && Util.isDouble(w))) {
			resp.getWriter().print("身高體重輸入錯誤");
			return;
		}
		
		resp.getWriter().print(String.format("BMI 為%s", BMICalcultor(h, w)));
		
		
		/*if(isDouble(h,w) == true) {
			if(BMICalcultor(h, w)>=18 & BMICalcultor(h, w) < 23) {
				resp.getWriter().print("正常");
			}
			else if(BMICalcultor(h, w)<18){
				resp.getWriter().print("過輕");
			}
			else {
				resp.getWriter().print("過重");
			}
		}
		else {
			resp.getWriter().print("身高體重輸入錯誤");
		}*/
	}
    
	private String BMICalcultor(String h, String w) {
		double height = Double.parseDouble(h);
		double weight = Double.parseDouble(w);
		double value =  weight/Math.pow((height/100.0),2);
		
		return (value<18?"過輕":value >= 23?"過重":"正常");
	}
	
	private boolean isDouble(String data1, String data2) {
		try {
			Double.parseDouble(data1);
			Double.parseDouble(data2);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
