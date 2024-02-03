package com.jdbc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class CURDOperation {
	
	//Insert Record in Database
	public static void insertData() {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			String dbURL="jdbc:oracle:thin:@172.16.2.7:1521:orcl";
			String dbUser="training";
			String dbpassword="training";
			Connection con=DriverManager.getConnection(dbURL,  dbUser, dbpassword);
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Name: ");
			String Name=sc.nextLine();
			System.out.println("Enter Email Id: ");
			String Email=sc.nextLine();
			System.out.println("Enter UserName: ");
			String UserName=sc.nextLine();
			System.out.println("Enter Password: ");
			String Password=sc.nextLine();
			
			String query="INSERT INTO Rohit (Name,Email,UserName,Password) VALUES(?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(query);

			ps.setString(1, Name);
			ps.setString(2, Email);
			ps.setString(3, UserName);
			ps.setString(4, Password);
			
			ps.executeUpdate();
			System.out.println("Insert Successful in Table");
	
			ps.close();
			con.close();

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	
	//Update Record in Database
	public static void updateData() {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			String dbURL="jdbc:oracle:thin:@172.16.2.7:1521:orcl";
			String dbUser="training";
			String dbpassword="training";
			Connection con=DriverManager.getConnection(dbURL,  dbUser, dbpassword);
			
			String query="UPDATE Rohit SET UserName=?, Password=? WHERE Name=?";
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter the UserName:- ");
			String username=br.readLine();
			System.out.println("Enter the Password:- ");
			String password=br.readLine();
			
			System.out.println("Enter the Name Which you want to Update:- ");
			String name=br.readLine();

			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			
			pstmt.executeUpdate();
			System.out.println("Updation is Successfully...");
			
			pstmt.close();
			con.close();
			
		}
		catch(Exception e) {
			System.out.println("Something went wrong ");
			e.printStackTrace();
		}
	}
	
	//Read Record From Database
	public static void readData() {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			String dbURL="jdbc:oracle:thin:@172.16.2.7:1521:orcl";
			String dbUser="training";
			String dbpassword="training";
			Connection con=DriverManager.getConnection(dbURL,  dbUser, dbpassword);
			
			String query="SELECT * FROM Rohit";
			PreparedStatement ps= con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			//System.out.println("Name"+" "+"Email"+" "+"UserName"+" "+"Password");
			
			while(rs.next()) {
				String name=rs.getString("Name");
				String email=rs.getString("Email");
				String userName=rs.getString("UserName");
				String password=rs.getString("Password");
				
				System.out.println(name+" "+email+" "+userName+" "+password);
		
			}
			
			System.out.println("All the Data in Table");
	
			ps.close();
			con.close();

			}
			catch(Exception e)
			{
				e.printStackTrace();
		}
	}
	
	//Delete Record From Database
	public static void deleteData() {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			String dbURL="jdbc:oracle:thin:@172.16.2.7:1521:orcl";
			String dbUser="training";
			String dbpassword="training";
			Connection con=DriverManager.getConnection(dbURL,  dbUser, dbpassword);
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the Name which you want to Delete:- ");
			String name=sc.nextLine();
			
			String query="DELETE FROM Rohit WHERE Name=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, name);
			
			int row=pstmt.executeUpdate();
			
			if(row>0) {
				System.out.println(name+" is Deleted Successful");
			}
			else {
				System.out.println(name+" is not found in this Database");
			}

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	
	
	//Main Method
	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
			
		while(true) {
			System.out.println("Database Connection Operation...");
			System.out.println("1: Insert Record");
			System.out.println("2: Update Record");
			System.out.println("3: Read/Retrive Record");
			System.out.println("4: Delete Record");
			System.out.println("5: Exit");
			System.out.println("Enter your choice: ");
				
			int choice=sc.nextInt();
			sc.nextLine();
				
			switch(choice) {
				case 1:
						System.out.println("Insert Record into Database...");
						insertData();
						break;
					
				case 2:
						System.out.println("Update Data From Table...");
						updateData();	
						break;
					
				case 3:
						System.out.println("Read Data From Table...");
						readData();
						break;
					
				case 4:
						System.out.println("Delete Data From Table...");
						deleteData();
						break;
						
				case 5:
						System.out.println("Exit...");
						System.exit(5);
						break;
					
				default:
						System.out.println("INVALID OPERATION");
				}
			}
		}
	}

