package com.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter();
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			String JdbcURL="jdbc:oracle:thin:@172.16.2.7:1521:orcl";
			String User="training";
			String password="training";
			Connection con=DriverManager.getConnection(JdbcURL,  User, password);
			
			String Name=request.getParameter("Name");
			String Email=request.getParameter("Email");
			String UserName=request.getParameter("UserName");
			String Password=request.getParameter("Password");

			PreparedStatement ps= con.prepareStatement("INSERT INTO Rohit (Name,Email,UserName,Password) VALUES(?,?,?,?)");
			ps.setString(1, Name);
			ps.setString(2, Email);
			ps.setString(3, UserName);
			ps.setString(4, Password);
				
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected>0)
			{
				System.out.println("data inserted ");
				response.getWriter().println("Signup Successfull");
				response.sendRedirect("LoginPage.jsp");
			}
			else	
			{
				response.sendRedirect("ErrorPage.jsp");
			}

			ps.close();
			con.close();

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
 
}