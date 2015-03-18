package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	public void update(String update) throws Exception{
		closeConnection();
		try{
			conn = createConnection(database, hostname, username, password, port);
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(update);
			conn.commit();
			conn.close();
		}catch(SQLException | ClassNotFoundException e){
			conn.rollback();
			conn.close();
			throw e;
		}
	}
	
	Connection conn ;
	public ResultSet query(String query) throws ClassNotFoundException, SQLException{
		closeConnection();
		conn = createConnection(database, hostname, username, password, port);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}
	
	public void closeConnection() throws SQLException {
		if(conn != null && !conn.isClosed()){
			conn.close();
			conn = null;
		}
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
	
	/**
	 * this method is used to avoid SQL injection. this method will insert a backslash if a character is not a letter or a number
	 * @param str
	 * @return
	 */
	public static String insertBackSlash(String str) {
		String result = "";
		for(int i = 0; i < str.length(); result+=str.charAt(i++))
			if(str.charAt(i) == '\'' || str.charAt(i) == '\"')	// if the character is not a letter or a number
				result+="\\";
		return result;
	}
}