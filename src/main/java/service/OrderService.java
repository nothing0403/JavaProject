package service;

import java.util.*;

import dao.OrderDAO;
import model.dto.OrderDTO;
import model.entity.Order;

public class OrderService {

	private OrderDAO orderDAO = new OrderDAO();
	private int totalPrice;
	private static final Map<String, Integer> menu = Map.of("牛肉麵",150,"陽春麵",60,"番茄麵",100);
	
	public OrderDTO addOrder(String item) {
		// 1: 根據訂單項目(item)新增一筆訂單並回傳訂單顯示資訊(OrderDTO)
		Order order = new Order();
		order.setItem(item);
		order.setPrice(menu.get(order.getItem())); // 價格一律 100 元
		// 傳給 orderDAO 儲存訂單
		orderDAO.save(order);
		// 2: 回傳訂單顯示資訊(OrderDTO)
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setMessage("您點了" + order.getItem() + "價格:" + order.getPrice() + "元");
		
		return orderDTO;
	}
	
	public List<OrderDTO> getOrderHistory(){
		List<Order> orders = orderDAO.findAll(); // 取得所有資料
		
		//儲存物件用的list
		List<OrderDTO> orderDTOs = new ArrayList<>();
		
		for(Order order : orders) {
			OrderDTO dto = new OrderDTO();
			dto.setMessage("您點了" + order.getItem() + "價格:" + order.getPrice() + "元");
			orderDTOs.add(dto);
		}
		return orderDTOs;
	}
	
	// 刪除一筆訂單根據 index
	public OrderDTO removeOrder(String index) {
		return removeOrder(Integer.parseInt(index));
	}
	
	// 刪除一筆訂單根據 index
	public OrderDTO removeOrder(int index) {
		orderDAO.remove(index);
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setMessage("index=" + index + ". 資料刪除成功");
		return orderDTO;
	}
	
	public int TotalPrice() {
		totalPrice = 0;
		List<Order> orders = orderDAO.findAll();
		for(Order order: orders) {
			totalPrice+=order.getPrice();
		}
		return totalPrice;
	}
	
	public OrderDTO updateOrder(int index, String newItem) {
		Order order = orderDAO.getOrder(index);
		order.setItem(newItem);
		order.setPrice(menu.get(newItem));
		orderDAO.update(index, order);
		
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setMessage("index=" + index + ". 資料上傳成功");
		return orderDTO;
	}
	
}
