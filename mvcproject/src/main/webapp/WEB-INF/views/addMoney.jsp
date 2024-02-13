 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.vin.bankdto.AccountDTO"%>
    <%@ page import="java.util.List"%>
    <%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bank.css">

   <%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute("user")==null)
      response.sendRedirect("bank.jsp");

  %>  
</head>
<body>
	 <%AccountDTO data=(AccountDTO)session.getAttribute("data"); %>


<%if(data!=null){ %>
<div class="pers_info">
 <a  href="logout.jsp" ><button class="home_btn" >logout</button></a>
 <a href="home.jsp"><button class="home_btn" >Home</button></a>
        <h1 class="markRed">ADD MONEY</h1>
        <form action="add"> 

	<table>        
        <tr ><td><label >Account Number :</label></td><td><input type="text"  name="add_acc_nmbr" value=<%=data.getAccountNumber() %> class="info_inp"  ></td></tr>
        <tr ><td><label > IFSC Code :</label></td><td ><input type="text"  name="add_ifscc_cd" value=<%=data.getIfscCode() %> class="info_inp"  ></td></tr>
        <tr ><td><label > Current Balance :</label></td><td ><input type="text"  name="curr_balan" value=<%=data.getCurrBalance() %> class="info_inp"  ></td></tr>
        <tr ><td><label>Amount :</label></td><td >  <input type="text" name="add_amt" class="info_inp"  ></td></tr>  		 
    </table>
    <button  onclick="deposit()" class="sign">Deposit</button>
    </form>
    <%}else{ %>
    <h3>Add your Account to Add Money</h3>
    <form action="home.jsp"><button class="sign">Home</button></form>
<%} %>
    
    </div>
    
    <script>
function deposit(){
    window.location.reload();
} 
</script>

</body>
</html> 