package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class display {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/igt", "root","1234");
			Statement stmt = con.createStatement();

	            ResultSet resultSet = stmt.executeQuery("Select * from EmpExam");

	            while (resultSet.next()) {
	                int Id = resultSet.getInt("e_id");
	                String Name = resultSet.getString("e_name");
	                int age = resultSet.getInt("age");
	                String desig = resultSet.getString("desig");
	                int sal = resultSet.getInt("salary");

	                System.out.println("ID: " + Id);
	                System.out.println("Name: " + Name);
	                System.out.println("Age: " + age);
	                System.out.println("Designation : " + desig);
	                System.out.println("Salary: " + sal);
	                System.out.println("-------------------------");
	            }

	            // Close the resources
	            resultSet.close();
	            stmt.close();
	            con.close();
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
