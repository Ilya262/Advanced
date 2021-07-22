package Service;

import java.util.List;

import org.apache.log4j.Logger;

import DAO.UserDAO;
import Interface.UserInterface;
import ServiceInterface.UserService;
import domain.User;

public class UserIMPL implements UserService {

	private static UserService userService;
	private UserInterface userdao;

	public static UserService getUserService() {

		if (userService == null) {

			userService = new UserIMPL();

		}
		return userService;

	}

	public UserIMPL() {

		userdao = new UserDAO();
	}

	@Override
	public User create(User user) {

		return userdao.create(user);
	}

	@Override
	public User read_by_id(Integer id) {
	
		return userdao.read_by_id(id);
	}

	@Override
	public User update(User user) {
		
		return userdao.update(user);
	}

	@Override
	public void delete(Integer id) {
		userdao.delete(id);

	}

	@Override
	public List<User> read_all() {
	
		return userdao.read_all();
	}

	@Override
	public User getUserEmail(String email) {
	
		return  userdao.getUserEmail(email);
	}

}
