<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		     <div class="credit" id="credit">
			
			<div> 
			
			<form id="form1" action="http://localhost:8080/Banking_application/home" method="post">
        <table>         
            <tr ><td><label >User Name:  </label></td><td><input type="text" name="u_name" size=23 class="info_inp"  placeholder="Enter your Name..." required></td></tr>
            <tr ><td><label >Password : </label></td><td ><input type="password" size=23 name="u_pass" class="info_inp"  placeholder="Enter password Here..." required></td></tr>		 
        </table>
        <a href="#" class="forgot">forgot password ?</a>
         <button class="sign_sub">Submit</button></form> 
          <button class="sign_regi" onclick="register()">Register</button>		
    	</div> 
    </div>
</body>
</html>