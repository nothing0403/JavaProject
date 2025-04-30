package cart.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import cart.dao.UserListDAO;
import cart.model.entity.User;

public class UserListDAOImpl extends BaseDao implements UserListDAO{

	private List<User> users = new CopyOnWriteArrayList<>();
	@Override
	public List<User> findAllUsers() {
		String sql = "select id, username, hash_password, hash_salt, email, completed from user order by id";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			try(ResultSet rs = pstmt.executeQuery()) {
				while(rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setHashPassword(rs.getString("hash_password"));
					user.setHashSalt(rs.getString("hash_salt"));
					user.setEmail(rs.getString("email"));
					user.setCompleted(rs.getBoolean("completed"));
					
					users.add(user);	
				}
				return users;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
