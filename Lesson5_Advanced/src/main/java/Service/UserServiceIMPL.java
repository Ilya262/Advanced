package Service;

import java.util.List;

import DAO.UserDaoIMPL;
import DAOInterface.UserDao;
import ServiceInterface.UserService;
import domain.User;

public class UserServiceIMPL implements UserService {

	
	UserDao userdao;
	
	
	public UserServiceIMPL() {
	
		userdao = new UserDaoIMPL();
	}

	@Override
	public User create(User user) {
	
		return userdao.create(user);
	}

	@Override
	public User read_by_id(Integer id) {
		// TODO Auto-generated method stub
		return userdao.read_by_id(id);
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return userdao.update(user);
	}

	@Override
	public void delete(Integer id) {
		userdao.delete(id);
		
	}

	@Override
	public List<User> read_all() {
		// TODO Auto-generated method stub
		return userdao.read_all();
	}

	
	
	
	
	
	
	
	
	
}
