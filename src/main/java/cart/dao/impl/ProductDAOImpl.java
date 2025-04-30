package cart.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import cart.dao.ProductDAO;
import cart.model.entity.Product;
import lombok.val;

public class ProductDAOImpl extends BaseDao implements ProductDAO{

	@Override
	public List<Product> findAllProducts(){
		List<Product> products = new CopyOnWriteArrayList<>();
		String sql = "select product_id, product_name, price, qty, image_base64 from product order by product_id";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					Product product = new Product();
					product.setProductId(rs.getInt("product_id"));
					product.setProductName(rs.getString("product_name"));
					product.setPrice(rs.getInt("price"));
					product.setQty(rs.getInt("qty"));
					product.setImageBase64(rs.getString("image_base64"));
					product.setTotal(rs.getInt("price")*rs.getInt("qty"));
					
					products.add(product);
				}
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public void add(Product product) {
		String sql = "insert into product(product_name, price, qty, image_base64) values( ?, ?, ?, ? )";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, product.getProductName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setInt(3, product.getQty());
			pstmt.setString(4, product.getImageBase64());
			
			int rowcount = pstmt.executeUpdate();
			System.out.println("新增成功筆數:" + rowcount);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer productId) {
		String sql = "delete from product where product_id = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, productId);
			int rowcount = pstmt.executeUpdate();
			System.out.println("資料刪除筆數:" + rowcount);												
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	

}
