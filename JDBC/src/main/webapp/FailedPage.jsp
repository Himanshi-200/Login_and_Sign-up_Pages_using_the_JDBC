<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>   
<html>   
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> LogIn Page </title>  
<style>   
	Body {
  		background-color: pink;
  		color: red;
  		display:flex;
  		justify-content:center; 
	}  
	button {   
        background-color: #4CAF50;   
        width: 100%;
        padding: 15px;   
        margin: 10px 0px;   
        border: 2px solid black;   
        cursor: pointer;   
         }   
 	form {   
        border: 5px solid black;   
    }   
 	input[type=text], input[type=password] { 
 		display:flex;
  		justify-content:center;   
        width: 100%;   
        margin: 8px 0;  
        padding: 12px 20px;   
        display: inline-block;   
        border: 2px solid black;   
        box-sizing: border-box;   
    }        
 	.container {   
        padding: 200px;   
        background-color: lightblue;  
    }   
</style>   
</head>    
<body>    
    <form>  
        <div class="container">
        	<h1>Login Failed Try Again!!!</h1> 
            <button type="submit"><a href="LoginPage.jsp">Log In</a></button>
			<button type="submit"><a href="SignupPage.jsp">Sign Up</a></button>
        </div>   
    </form>  
    
    <script>
    	alert("Login Failled. Your Entered UserName and Password is incorrect Try Again!!!");
    </script>   
</body>     
</html>  