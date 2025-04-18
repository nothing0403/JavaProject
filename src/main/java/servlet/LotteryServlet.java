package servlet;

import java.io.IOException;
import java.util.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(urlPatterns = "/Lottery")
public class LotteryServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Random rd = new Random();
		Set<Integer> nums = new LinkedHashSet<>();
		while(nums.size()<5) {
			int num = rd.nextInt(39)+1;
			nums.add(num);
		}
		//resp.getWriter().print(nums);
		//生成調度器
		RequestDispatcher rdr = req.getRequestDispatcher("/lottery.jsp");
		//傳遞樂透號碼，裝配要傳遞的內容
		req.setAttribute("numbers", nums);
		//傳遞要求來源和回應來源資料
		rdr.forward(req, resp);
	}
    
}
