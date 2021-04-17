package ConnectionUtill;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.xml.DOMConfigurator;

public class ConnectionUtill {
	
		
		
		private static String USER_NAME = "root";
		private static String USER_PASSWORD = "root";
		private  static String URL = "jdbc:mysql://localhost/ShopLesson?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";	
			
		public static Connection  openConnection() throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException  {
		
			Class.forName ("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance ();
			
			return DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
		}	
}
