package com.entity;

public class Student {
	
	private int std_Id;
	private String std_Name;
	private String std_Phone_Num;
	private String std_City;
	
	
	public Student(int std_Id, String std_Name, String std_Phone_Num, String std_City) {
		super();
		this.std_Id = std_Id;
		this.std_Name = std_Name;
		this.std_Phone_Num = std_Phone_Num;
		this.std_City = std_City;
	}


	public Student(String std_Name, String std_Phone_Num, String std_City) {
		super();
		this.std_Name = std_Name;
		this.std_Phone_Num = std_Phone_Num;
		this.std_City = std_City;
	}


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getStd_Id() {
		return std_Id;
	}


	public void setStd_Id(int std_Id) {
		this.std_Id = std_Id;
	}


	public String getStd_Name() {
		return std_Name;
	}


	public void setStd_Name(String std_Name) {
		this.std_Name = std_Name;
	}


	public String getStd_Phone_Num() {
		return std_Phone_Num;
	}


	public void setStd_Phone_Num(String std_Phone_Num) {
		this.std_Phone_Num = std_Phone_Num;
	}


	public String getStd_City() {
		return std_City;
	}


	public void setStd_City(String std_City) {
		this.std_City = std_City;
	}
	
	
	
	@Override
	public String toString() {
		return "Student [std_Id=" + std_Id + ", std_Name=" + std_Name + ", std_Phone_Num=" + std_Phone_Num
				+ ", std_City=" + std_City + "]";
	}

	
	
	
	
	
	
}
