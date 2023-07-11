package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public register() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int ph = Integer.parseInt(request.getParameter("ph"));
		int marks = Integer.parseInt(request.getParameter("marks"));
		String branch = request.getParameter("branch");
		
		try {		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/igt", "root","1234");
			Statement stmt = con.createStatement();
			PreparedStatement pstmt=con.prepareStatement("insert into Stu values(?,?,?,?,?)");
				
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setInt(3, ph);
				pstmt.setInt(4, marks);
				pstmt.setString(5, branch);
				pstmt.execute();
				
				request.setAttribute("message", "Congrats, you are successfully registered!");
				
				request.getRequestDispatcher("success.html").forward(request, response);
	}
	
catch (Exception e) {
	System.out.println(e);
}
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
