<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>   
<html>   
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title>CURD Operations</title>  
<style>   
	Body {
  		background-color: pink;
  		display:flex;
  		justify-content:center; 
	}  
	button {   
        background-color: #4CAF50;   
        width: 100%;  
        color: black;   
        padding: 15px;   
        margin: 10px 0px;   
        border: 2px solid balck;   
        cursor: pointer;   
    }
    input[type=text], input[type=password] { 
 		display:flex;
  		justify-content:center;   
        width: 100%;   
        margin: 8px 0;  
        padding: 12px 20px;   
        display: inline-block;   
        border: 2px solid green;   
        box-sizing: border-box;   
    }  
 	.container {   
        padding: 50px;   
        background-color: lightblue;  
        border: 5px solid balck; 
    }   
    .copyright{
    	display: flex;
    	justify-content: center;
    }
</style>   
</head>    
<body>
 	<div class="container">
        	<h1>WELCOME TO DATABASE</h1> 
        	<hr>
        	<hr>
   			<form action="CreateRecordServlet" method="post">
        	<h3>Create a New Record in Table:- </h3>
        	<label>Name : </label>   
            <input type="text" placeholder="Enter the Full Name" name="Name" >
            <label>Email Id : </label>   
            <input type="text" placeholder="Enter the Email Id" name="Email" >
            <label>UserName : </label>   
            <input type="text" placeholder="Enter the Username" name="UserName" >  
            <label>Password : </label>   
            <input type="password" placeholder="Enter the Password" name="Password" > 
        	<button onclick="create()" type="submit">CREATE</button>
        </form>	
        
        <hr>
       <form action="UpdateRecordServlet" method="post">  	
        	<h3>Update Record in Table:- </h3>
        	<label>Name : </label>
        	<input type="text" placeholder="Enter the Full Name" name="Name" >
            <label>UserName : </label>   
            <input type="text" placeholder="Enter the New Username" name="UserName" >  
            <label>Password : </label>   
            <input type="password" placeholder="Enter the New Password" name="Password" >
			<button onclick="update()" type="submit">UPDATE</button>
		</form>	
		<hr>
		<form action="DeleteRecordServlet" method="post">	
			<h3>Delete Record From Table:- </h3>
			<label>Name : </label>
        	<input type="text" placeholder="Enter the Full Name" name="Name">
			<button onclick="deletes()" type="submit">DELETE</button>
		</form>
		<hr>
		<form action="ReadRecordServlet" method="post">	
			<h3>Read Record From Table:- </h3>
			<button onclick="read()" type="submit">READ</button>
		</form>	
		<hr>
		<hr>
		<h3>User Login :</h3>
			<button onclick="login()" type="submit"><a href="LoginPage.jsp">Log In</a></button>
		<hr>
		<h3>User Signup :</h3>	
			<button onclick="signup()" type="submit"><a href="SignupPage.jsp">Sign Up</a></button>
      
      	  <div class="copyright">
        	<p>Copyright © 2024. All Right Reserved. Created by Rohit Kumar</p>
    	  </div>
      </div>   
    
    
    <script>
    	function create() {
      		alert("Create Record is Successful!");
    	}
    	function update() {
        	alert("Update Record is Successful!");
     	}
    	function deletes() {
        	alert("Delete Record is Successful!");
      	}
      	function read() {
          	alert("All Records!");
       	}
      	function login() {
          	alert("Please Login!!!");
       	}
      	function signup() {
          	alert("Please Signup!!!");
       	}
    </script>     
</body>     
</html>