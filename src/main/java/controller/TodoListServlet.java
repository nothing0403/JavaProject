package controller;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dto.TodoDTO;
import service.TodoListService;
import service.TodoListServiceImpl;

@WebServlet("/todolist/*")
public class TodoListServlet extends HttpServlet{
	
	private TodoListService service = new TodoListServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		resp.getWriter().print("pathInfo = " + pathInfo);
		String id = req.getParameter("id");
		String completed = req.getParameter("checked"); 
		String text = req.getParameter("text"); 
		
		switch(pathInfo) {
		    case "/" , "/*": //顯示 TodoList 首頁
		    	List<TodoDTO> todos = service.findAllTodos();
		    	RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/todolist.jsp");
		    	req.setAttribute("todos", todos);
		    	rd.forward(req, resp);
		    	break;
		    case "/update": //修改 Todo 紀錄		  	    	
		    	if(completed != null) {
		    		service.updateTodoComplete(Integer.parseInt(id), Boolean.parseBoolean(completed));	    			    		
		    	}
		    	if(text != null) {
		    		service.updateTodoText(Integer.parseInt(id), text);
		    	}
		    	resp.sendRedirect("/JavaWebTodoList/todolist/");
	    		return;
	    		
		    case "/delete": //刪除某一項 Todo 紀錄 	
		    	service.deleteTodo(Integer.parseInt(id));
		    	resp.sendRedirect("/JavaWebTodoList/todolist/");
		    	break;
		    default: // 錯誤路徑
		    	resp.getWriter().print(" path error ");
		    	break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		if(!pathInfo.equals("/add")) {
			//錯誤路徑
			resp.getWriter().print(" path error ");
			return;
		}
		//進行新增程序
		String text = req.getParameter("text");
		Boolean completed = false;
		service.addTodo(text, completed);
		//重跑首頁
		resp.sendRedirect("/JavaWebTodoList/todolist/");
	}
}
