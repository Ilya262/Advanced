package DAO;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import ConnectionUtill.ConnectionUtill;
import Interface.BucketInterface;
import domain.Bucket;

public class BucketDAO implements BucketInterface {

	
	private static String CREATE = "insert into bucket (user_id,product_id,purches_date)values (?,?,?)";
	private static String READ_ALL = "select *from  bucket";
	private static String READ_BY_ID = "select *from  bucket where id=?";
	private static String DELETE_BY_ID = "delete from bucket where id=?";
	
	Logger logger = Logger.getLogger(BucketDAO.class);
	Connection connection;
	PreparedStatement preparedStatement;

	public BucketDAO() {
		super();
		try {
			connection = ConnectionUtill.openConnection();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException | SQLException e) {

			logger.error(e);
		}
	}

	public Bucket create(Bucket backet) {

		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, backet.getUser_id());
			preparedStatement.setInt(2, backet.getProduct_id());
			preparedStatement.setDate(3,   new java.sql.Date(backet.getPurches_date().getTime()));

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
			
		}

		return backet;

	}

	public List<Bucket> read_all() {

		List<Bucket> backetlist = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
Integer bucketId=result.getInt("id");
			Integer user_id = result.getInt("user_id");
			Integer product_id = result.getInt("product_id");
			Date purches_date = result.getDate("purches_date");

			backetlist.add(new Bucket(bucketId, user_id, product_id, purches_date));
		} catch (SQLException e) {

			logger.error(e);
		}

		return backetlist;

	}

	public Bucket read_by_id(Integer id) {
		Bucket backet = null;
		try {

			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeQuery();

			ResultSet result = preparedStatement.executeQuery();
			result.next();

			Integer user_id = result.getInt("user_id");
			Integer product_id = result.getInt("product_id");
			Date purches_date = result.getDate("purches_date");

			backet = new Bucket(user_id, product_id, purches_date);

		} catch (SQLException e) {
			logger.error(e);
		}

		return backet;

	}

	public void delete(Integer id) {

		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			logger.error(e);
		}

	}

	public Bucket update(Bucket backet) {

		throw new IllegalStateException("there is no update for bucket");
	}
}
