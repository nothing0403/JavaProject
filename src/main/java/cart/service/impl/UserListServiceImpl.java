package cart.service.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import cart.dao.UserListDAO;
import cart.dao.impl.UserListDAOImpl;
import cart.model.dto.UserDTO;
import cart.model.entity.User;
import cart.service.UserListService;

public class UserListServiceImpl implements UserListService{

	private List<UserDTO> userDTOs = new CopyOnWriteArrayList<>();
	private UserListDAO userListDAO = new UserListDAOImpl();
	
	@Override
	public List<UserDTO> findAllUsers() {
		List<User> users = userListDAO.findAllUsers();
		
		for(User user: users) {
			userDTOs.add(new UserDTO(user.getId(), user.getUsername(), user.getEmail(), user.getCompleted()));
		}
		return userDTOs;
	}

}
