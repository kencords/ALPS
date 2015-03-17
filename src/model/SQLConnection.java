package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sun.font.CreatedFontTracker;

public class SQLConnection {

	private static String database = "alps_db", hostname = "localhost", username = "root", port = "3306";
	public static String password;
	
	public SQLConnection(){
		
	}
	
	private static Connection createConnection(String database, String hostname, String username, String password, String port) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
        Connection connection=DriverManager.getConnection("jdbc:mysql://"+hostname+":"+port+"/"+database, username, password);
        return connection;
	}
	
	public void createDB(){
		
	}
	
	public void update(String update) throws ClassNotFoundException, SQLException{
		Connection conn = createConnection(database, hostname, username, password, port);
	}
	
	public ResultSet query(String query) throws ClassNotFoundException, SQLException{
		Connection conn = createConnection(database, hostname, username, password, port);
		Statement stmt = conn.createStatement();
		return stmt.executeQuery(query);
	}
	
	private static SQLConnection instance;
	
	public static SQLConnection getInstance(){
		if(instance == null)
			instance = new SQLConnection();
		return instance;
	}

	public static void checkConnection(String password) throws ClassNotFoundException, SQLException {
		createConnection(database, hostname, username, password, port);
		SQLConnection.password = password;
	}
}