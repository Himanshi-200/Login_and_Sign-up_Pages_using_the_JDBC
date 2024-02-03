package com.curd;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



@WebServlet("/UpdateRecordServlet")
public class UpdateRecordServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.getWriter();
		}
	 
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");	
				String dbURL="jdbc:oracle:thin:@172.16.2.7:1521:orcl";
				String dbUser="training";
				String dbpassword="training";
				Connection con=DriverManager.getConnection(dbURL,  dbUser, dbpassword);
				
				String Name=request.getParameter("Name");
				String UserName=request.getParameter("UserName");
				String Password=request.getParameter("Password");
				String query="UPDATE Rohit SET UserName=?, Password=? WHERE Name=?";

				PreparedStatement pstmt=con.prepareStatement(query);
				
				pstmt.setString(1, Name);
				pstmt.setString(2, UserName);
				pstmt.setString(3, Password);
				
				pstmt.executeUpdate();
				System.out.println("Updation is Successfully...");
				
				int row=pstmt.executeUpdate();
				if(row>0) {
					
					System.out.println(Name+" is Updated Successful");
					response.sendRedirect("MainCURDOperations.jsp");
				}
				else {
					System.out.println(Name+" is not found in this Database");
				
				
				pstmt.close();
				con.close();
				}
				
			}
			catch(Exception e) {
				System.out.println("Something went wrong!! ");
				e.printStackTrace();
			}
		}
	 
	}