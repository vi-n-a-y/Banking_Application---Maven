<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  errorPage="error.jsp"%>
<%-- <%@ page import="com.vin.bankdto.BankDTO"%>   --%>

<!Doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Application</title>
<link rel="stylesheet" href="WEB-INF/views/bank.css">

<%

response.setHeader("Pragma","no-cache");

response.setHeader("Cache-Control","no-store");

response.setHeader("Expires","0");

response.setDateHeader("Expires",-1);



%>
</head>
<body>

 

    <div class="main_container">
      <div class="credit" id="credit">
			
			<div> 
			
			<form id="form1" action="home" method="get">
        <table>         
            <tr ><td><label >User Name:  </label></td><td><input type="text" name="u_name" size=23 class="info_inp"  placeholder="Enter your Name..." required></td></tr>
            <tr ><td><label >Password : </label></td><td ><input type="password" size=23 name="u_pass" class="info_inp"  placeholder="Enter password Here..." required></td></tr>		 
        </table>
        <a href="#" class="forgot">forgot password ?</a>
         <button class="sign_sub">Submit</button></form> 
          <button class="sign_regi" onclick="register()">Register</button>		
    	</div> 
    </div>
    
   		 <div class="info" id="info">
   		 <form action="Regi" method="post">
   		 
            <table> 
            	
               <tr><td><label>User Name :</label></td><td><input type="text" name="regi_name" class="info_inp"  placeholder="Enter your Name.."></td></tr>
               <tr ><td><label >Password :</label></td><td><input type="password"  name="regi_pass" class="info_inp"  placeholder="Enter password Here..."></td></tr>
               <tr ><td> <label>full Name :</label></td><td ><input type="text" name="fullName"  class="info_inp"  placeholder="Enter full Name Here..."></td></tr>
               <tr ><td><label>email :</label></td><td >  <input type="text" name="email" class="info_inp"  placeholder="Enter your email Here..."></td></tr>
               <tr ><td><label >Phone No. :</label></td><td ><input type="text"  name="phNo" class="info_inp"  placeholder="Enter Phone Number Here..."></td></tr>
               <tr ><td><label >Address :</label></td><td ><input type="text"  name="address" class="info_inp"  placeholder="Enter your Address Here..."></td></tr>        		

           
           </table>
           <button class="regi_btn" >submit</button>
           </form>
                        
    <div class="regi_div" >  
            
         <table><tr><td><button class="regi_btn2" onclick="register()">signin</button></td></tr></table>                         
	</div>
</div>

</div>

<script>
       
        function register(){
            var credit = document.getElementById("credit")
           var  info=document.getElementById("info");
           if(info.style.display!="block" && credit.style.display!="none"){
            credit.style.display="none";
            info.style.display="block";           
           } 
          else {
            info.style.display="none";
            credit.style.display="block";
           }          
        }
</script>               
</body>
</html>