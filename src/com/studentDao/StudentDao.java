package com.studentDao;
//DAO stands for Data Access Object.

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.entity.Student;
import com.mysql.jdbc.*;

public class StudentDao {

	
	public static boolean insertStudent(Student st)
	{
		boolean f = false;
		
		//3 Steps to initialize connection between JAVA App and database.
		
		try {
		
			Connection con = ConnectionJDBC.createC();
			String q = "Insert into students(std_id,std_name,std_phone_num,std_city) values(?,?,?,?)";
			
			PreparedStatement p = con.prepareStatement(q);
			
			p.setInt(1, st.getStd_Id());
			p.setString(2, st.getStd_Name());
			p.setString(3, st.getStd_Phone_Num());
			p.setString(4, st.getStd_City());
			
			p.executeUpdate();
			f = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
		
	}
	
	
	public static boolean deleteStudent(int x)
	{
		boolean f = false;
		
		try {
			Connection con = ConnectionJDBC.createC();
			
			//firing query.	
			String q = "delete from Students where std_id = ?;";
			
			PreparedStatement p = con.prepareStatement(q);
			//set parameters of query
			p.setInt(1, x);
			
			p.executeUpdate();
			
			f =true;
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
		
	}
	
	
	//To display student table
	
	public static boolean dispayStudent() {
		boolean f = false;
			
		try {
			Connection conn = ConnectionJDBC.createC();
				
			String query = "select * from students;";
					
			//here for select we use Statement interface :
			Statement st = conn.createStatement();
			
			//executing the query
			
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next())
			{
				int std_id = rs.getInt("std_id");
				String std_name = rs.getString("std_name");
				String std_phone_num = rs.getString("std_phone_num");
				String std_city = rs.getString("std_city");
				
				
				System.out.format("%s,%s,%s,%s\n",std_id, std_name, std_phone_num, std_city);
			}
			//closing the statement
			st.close();
			
			f = true;
		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
			
		return f;
	}
	
	
	
	public static boolean updateStudent(Student st, int updt_id) {
		boolean f = false;
		try {
			
			Connection con = ConnectionJDBC.createC();
//			String q = "update students set std_id = ?,  std_name = ?, std_phone_num = ?, std_city = ? where std_id = "+ new_id+";";
			String q = "update students set std_id = ?,  std_name = ?, std_phone_num = ?, std_city = ? where std_id = ? ;";
			
			PreparedStatement p = con.prepareStatement(q);
			
			p.setInt(1, st.getStd_Id());
			p.setString(2, st.getStd_Name());
			p.setString(3, st.getStd_Phone_Num());
			p.setString(4, st.getStd_City());
			p.setInt(5, updt_id);
			
			p.executeUpdate();
			f = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return f;
	}
	
	
	//case 5 Search student 
	
	public static boolean searchStudent(int search_id)
	{
		boolean f =  true;
		
		try {
			
		Connection conn = ConnectionJDBC.createC();
		
		String q = "select * from students where std_id =?;";
		
	
		//executing the query
		PreparedStatement st  = conn.prepareStatement(q);
		st.setInt(1, search_id);
		ResultSet rs = st.executeQuery(q);
		
//		if()
		
		while(rs.next())
		{
			int std_id = rs.getInt("std_id");
			String std_name = rs.getString("std_name");
			String std_phone_num = rs.getString("std_phone_num");
			String std_city = rs.getString("std_city");
			
			
			System.out.format("%s,%s,%s,%s\n",std_id, std_name, std_phone_num, std_city);
		}
		//closing the statement
		st.close();
		
		
		f = true;
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		
		return f;
	}
	
	
	
	
}
