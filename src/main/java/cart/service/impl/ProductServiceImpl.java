package cart.service.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import cart.dao.ProductDAO;
import cart.dao.impl.ProductDAOImpl;
import cart.model.dto.ProductDTO;
import cart.model.entity.Product;
import cart.service.ProductService;

public class ProductServiceImpl implements ProductService{

	private ProductDAO productDAO = new ProductDAOImpl();
	
	@Override
	public List<ProductDTO> findAllProducts() {
		List<ProductDTO> productDTOs = new CopyOnWriteArrayList<>();
		List<Product> products = productDAO.findAllProducts();
		for(Product product : products) {
			productDTOs.add(new ProductDTO(
					                 product.getProductId(),
					                 product.getProductName(), 
					                 product.getPrice(), 
					                 product.getQty(), 
					                 product.getImageBase64(),
					                 product.getTotal()));
		}
		return productDTOs;
	}

	@Override
	public void add(String productName, String price, String qty, String productImageBase64) {
		
		Product product = new Product();
		
		product.setProductName(productName);
		product.setPrice(Integer.parseInt(price));
		product.setQty(Integer.parseInt(qty));
		product.setImageBase64(productImageBase64);
		
		productDAO.add(product);
	}

	@Override
	public void delete(Integer productId) {
		
		productDAO.delete(productId);
	}

}
