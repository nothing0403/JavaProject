package servlet;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.GuestBook;

@WebServlet("/guestbook")
public class GuestbookServlet extends HttpServlet{
	
	private static final List<GuestBook> guestbooks = new CopyOnWriteArrayList<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/guestbook_form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//取得表單的留言內容
		String username = req.getParameter("username");
		String message = req.getParameter("message");
		//建立GuestBook物件
		GuestBook guestbook = new GuestBook(username,message);
		//加入到guestbooks集合中
		guestbooks.add(guestbook);
		//重導到/WEB-INF/guestbook_result.jsp
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/guestbook_result.jsp");
		req.setAttribute("message", message);//本次留言
		req.setAttribute("guestbooks", guestbooks);//歷史留言
		rd.forward(req, resp);
	}

	

}
