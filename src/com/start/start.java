package com.start;
import java.io.*;

import java.sql.DriverManager;

import com.entity.Student;
import com.studentDao.StudentDao;


public class start {

	public static void main(String[] args) throws IOException {
			
		System.out.println("Welcome to my Student Management Application\n");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean go =true;
		
		while(go)
		{
			System.out.println("\nPress 1 to ADD a new Student\n"
							+ "Press 2 to DELETE a Student\n"
							+ "Press 3 tp DISPLAY Student Records\n"
							+ "Press 4 to Update Student\n"
							+ "Press 5 to Search Student\n"
							+ "Press 6 to Count total records\n"
							+ "Press 7 to Display Records in descending order!\n"
							+ "Press 8 for LIKE Operator\n"
							+ "Press 9 to EXIT APPLICATION");
			
			int choice = Integer.parseInt(br.readLine()); //convert string(input) to int
			//using buffer Reader to take user input.
			switch(choice)
			{
			case 1:			//add student
				
				System.out.println("Enter Student ID");
				int  id = Integer.parseInt(br.readLine());
				
				System.out.println("Enter Student Name");
				String name = br.readLine();
				
				System.out.println("Enter Student Phone no:");
				String phone_no = br.readLine();
				
				System.out.println("Enter Student Student City");
				String city = br.readLine();
				
				//std obj
				Student std = new Student(id,name, phone_no,city);
				
				boolean ans =StudentDao.insertStudent(std);
				
				if(ans)
				{
					System.out.println("Student added Successfully.");
				}
				else
				{
					System.out.println("Something went wrong, Please try again.");
				}
				
			
				break;
				
				
			case 2:			//delete student  DONE.
				
				System.out.println("Enter Student id , which you want to delete");
				int id1 = Integer.parseInt(br.readLine());
				
							
				
				boolean to_delete = StudentDao.deleteStudent(id1);				
				if(to_delete)
				{
					System.out.println("Student "+ id1 + " deleted successfully.");
				}
				else {
					System.out.println("Something went Wrong.");
				}
				break;
				
				
			case 3:			//display student
				
				System.out.println("ID |  Name |  Phone_Number |  City\n");
				boolean disp = StudentDao.dispayStudent();
				
				
				if(disp)
				{
					System.out.println("\nStudents Detail fetched successfully\n");
				}
				else {
					System.out.println("Something went wrong.");
				}
				
				break;
				
			
			case 4:
				System.out.println("Enter Student ID");
				int  id2 = Integer.parseInt(br.readLine());
				
				System.out.println("Enter Student Name");
				String name2 = br.readLine();
				
				System.out.println("Enter Student Phone no:");
				String phone_no2 = br.readLine();
				
				System.out.println("Enter  Student City");
				String city2 = br.readLine();
				
				System.out.println("Student ID, which you want to update");
				int  new_id = Integer.parseInt(br.readLine());
				
				Student st3 = new Student(id2, name2, phone_no2, city2);
				
				boolean upd = StudentDao.updateStudent(st3, new_id);
				
				if(upd)
				{
					System.out.println("Student details updated successfully.");				
				}
				else
				{
					System.out.println("Something went wrong");
				}
				
				//print student details
				System.out.println("Updated Student "+ st3);
				
				
				break;
				
			case 5:
				
				System.out.println("Enter student id which you want to search.");
				
				int searchID = Integer.parseInt(br.readLine());
				
				
				boolean search = StudentDao.searchStudent(searchID);
				
				if(search)
				{
					System.out.println("Student is present");
				}
				else
				{
					System.out.println("Student is not present.");
				}
				
					
				break;
				
				
				
				
				
				
				
				
				
				
			case 9:			//exit application student
				go =false;
				System.out.println("\nThank you for using my Application!! \n");				
				break;
				
				
				default:{
					System.out.println("Wrong choice pls re-enter your choice");
				}
					
			}
			
			
			
			
		}
		
		
		
//		-------------------------------------------main ended
	}
}
