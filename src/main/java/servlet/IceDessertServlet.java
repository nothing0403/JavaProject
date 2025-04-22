package servlet;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.GuestBook;
import model.IceDessert;
import model.ice.IceOrder;

@WebServlet("/ice")
public class IceDessertServlet extends HttpServlet{

	private static final List<IceDessert> icedesserts = new CopyOnWriteArrayList<>();
	//private static final List<IceOrder> iceOrders = new CopyOnWriteArrayList<>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/ice_dessert_form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String mainDish = req.getParameter("mainDish");
		String[] toppings = req.getParameterValues("toppings");
		//String mainDishName = req.getParameter("mainDish");
		//String[] toppingArray = req.getParameterValues("toppings");
		
		IceDessert ice = new IceDessert(mainDish, toppings);
		//IceOrder iceOrder = new IceOrder(mainDishName, toppingArray);
		icedesserts.add(ice);
		//iceOrders.add(iceOrder);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/ice_dessert_result.jsp");
		req.setAttribute("ice", ice);
		req.setAttribute("icedesserts", icedesserts);
		//req.setAttribute("iceOrders", iceOrders);
		rd.forward(req, resp);
	}

}
