import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.PreparedStatement;;


public class DBConnection {

	public static Connection getConnection() {
		try { Class.forName("com.mysql.jdbc.Driver");
		//DriverManager.deregisterDriver(DriverManager.getDriver("jdbc:mysql://localhost:3306/vanisb"));
	return DriverManager.getConnection("jdbc:mysql://localhost:3306/vanisb", "root", "root");
			
			/*InitialContext initialContext=new InitialContext();
			Context context=(Context)initialContext.lookup("java:comp/env");
			DataSource ds=(DataSource)context.lookup("connpool");
			return ds.getConnection();*/
		}catch (Exception e) {
			return null;
		}
	}
	
	public static ResultSet getResultSet(String query) {
		try { PreparedStatement ps=getConnection().prepareStatement(query);
			return ps.executeQuery();
		}catch (Exception e) {
			return null;
		}
		
	}
	
	
}
