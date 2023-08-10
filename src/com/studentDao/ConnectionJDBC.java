package com.studentDao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
	
	static Connection con;
	
	public static Connection createC() throws ClassNotFoundException
	{
		try {
			
			//1.load driver class
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.Connection
			String url = "jdbc:mysql://127.0.0.1:3306/student_management_system_application";
			String user = "root";
			String password = "123456";
			
			con = DriverManager.getConnection(url,user,password);
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return con;
	}
	
}
