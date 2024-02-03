package com.jdbc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out=response.getWriter();

			try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			String JdbcURL="jdbc:oracle:thin:@172.16.2.7:1521:orcl";
			String User="training";
			String password="training";
			Connection con=DriverManager.getConnection(JdbcURL,  User, password);
			
			String UserName=request.getParameter("UserName");
			String Password=request.getParameter("Password");
			
			String query="SELECT UserName FROM Rohit WHERE UserName=? and Password=?";
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1, UserName);
			ps.setString(2, Password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("/welcome.jsp");
				rd.forward(request, response);
				
			}
			else {
//				out.println("<font color=red size=18>Login Failed!!. Your UserName and Password is Wrong. Please Try Again<br><br>");
//				out.println("<a href=LoginPage.jsp>Try Again!!</a><br><br>");
//				out.println("<a href=SignupPage.jsp>Sign Up</a>");
//				out.println("<a href=SignupPage.jsp>Sign Up</a>");
				
				response.sendRedirect("FailedPage.jsp");
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}




