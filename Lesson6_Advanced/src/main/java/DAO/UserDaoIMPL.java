package DAO;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ConnectionUtill.ConnectionUtill;
import DAOInterface.UserDao;
import domain.User;

public class UserDaoIMPL implements UserDao {
	private String READ_ALL = "select *from  user";
	private String CREATE = "insert into user (name, lastname ,email,role,password )values (?,?,?,?,?)";
	private String READ_BY_ID = "select *from  user where id=?";

	private String READ_BY_EMAIL = "select *from  user where email=?";
	private String DELETE_BY_ID = "delete from user where id=?";
	private String UPDATE = "update from users set name=? lastName=? email=? role=? password=?    where id=?";
	Logger logger = Logger.getLogger(UserDaoIMPL.class);
	private Connection connection;

	private PreparedStatement preparedStatement;

	public UserDaoIMPL() {
		try {
			connection = ConnectionUtill.openConnection();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException | SQLException e) {
			logger.error(e);
			e.printStackTrace();
		}
	}

	public List<User> read_all() {
		List<User> userList = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			Integer id = result.getInt("id");
			String name = result.getString("name");
			String lastName = result.getString("lastName");
			String email = result.getString("email");
			String role = result.getString("role");

			userList.add(new User(id, name, lastName, email, role));

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}

		return userList;

	}

	public User create(User user) {

		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getRole());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.executeUpdate();

			// ResultSet result = preparedStatement.getGeneratedKeys();
			// result.next();

			// result.getInt(result.getInt(1));

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}
		return user;

	}

	public User read_by_id(Integer id) {
		User user = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			Integer userid = result.getInt("userid");
			String name = result.getString("name");
			String lastName = result.getString("lastName");
			String email = result.getString("email");
			String role = result.getString("role");
			String password = result.getString("password");
			user = new User(userid, name, lastName, email, role, password);

		} catch (SQLException e) {

			e.printStackTrace();
			logger.error(e);
		}

		return user;

	}

	public void delete(Integer id) {

		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			logger.error(e);
		}
	}

	public User update(User user) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE);

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getRole());
			preparedStatement.setInt(5, user.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			logger.error(e);
		}
		return user;

	}

	@Override
	public User UsergetEmail(String email) {
		User user = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_EMAIL);
			preparedStatement.setString(1, email);
			ResultSet result = preparedStatement.executeQuery();
		while(	result.next()) {
			Integer userid = result.getInt("id");
			String name = result.getString("Name");
			String lastName = result.getString("LastName");

			String role = result.getString("role");
			String password = result.getString("Password");
			user = new User(userid, name, lastName, email, role, password);

		} }catch (SQLException e) {

			e.printStackTrace();
			logger.error(e);
		}

		return user;

	}
}