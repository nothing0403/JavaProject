package dao;

import java.util.List;

import model.entity.Product;

public class ProductDAO {
	
	//以內建List來儲存固定菜單，故沒有save、update、delete、add之類的功能
	private static List<Product> products = List.of(
			new Product("牛肉麵", 150), new Product("陽春麵", 60), new Product("番茄麵", 100));
	
	public List<Product> findAll() {
		return products;
	}
	
	public Product getProduct(String item) {
		return products.stream()
					   .filter(p -> p.getItem().equals(item))
					   .findFirst()
					   .orElseThrow();
	}
}
