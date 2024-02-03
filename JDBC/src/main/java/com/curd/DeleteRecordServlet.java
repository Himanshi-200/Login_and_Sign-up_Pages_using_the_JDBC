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

@WebServlet("/DeleteRecordServlet")
public class DeleteRecordServlet extends HttpServlet {
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
				System.out.println(Name+" is Deleted Successful");
				String query="DELETE FROM Rohit WHERE Name=?";
				PreparedStatement pstmt=con.prepareStatement(query);
				
				pstmt.setString(1, Name);
				
				int row=pstmt.executeUpdate();
				
				if(row>0) {
					
					System.out.println(Name+" is Deleted Successful");
					response.sendRedirect("MainCURDOperations.jsp");
				}
				else {
					System.out.println(Name+" is not found in this Database");
				}

				}
				catch(Exception e)
				{
					System.out.println("Record is not Found");
					e.printStackTrace();
				}
		}
	 
	}