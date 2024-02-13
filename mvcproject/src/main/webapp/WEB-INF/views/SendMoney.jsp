<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.vin.bankdto.TransactionDTO" %>
    <%@ page import="com.vin.bankdto.AccountDTO"%>
    
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
<h1 class="acc_head">Send Money</h1>
       <form action="trxns">
            <table> 
 
               <tr ><td><label>Receiver Account Number :</label></td><td >  <input type="text" name="rec_acc" class="info_inp"  required></td></tr>
               <tr ><td><label >Receiver IFSC Code :</label></td><td ><input type="text"  name="rec_ifsc" class="info_inp"  ></td></tr>
              <tr ><td> <label>Description :</label></td><td ><input type="text" name="description"  class="info_inp"  required></td></tr>
               <tr ><td><label >Total Amount to transfer :</label></td><td ><input name="total_amount"  name="total_amt" class="info_inp"  required></td></tr>
         		
           </table>
           <button class="sign" onclick="checkSend()">send</button>
         </form>
    </div>
    
    
        <%}else{ %>
    <h3>Add your Account to Add Money</h3>
    <form action="home.jsp"><button class="sign">Home</button></form>
<%} %>
   <%--   <script>
    function checkSend(){
    	 
    	 var trn = <%=application.getAttribute("trn")>
    	  if(trn!=null){ 
    	 alert("money sended successfully");
    	 console.log("if condition");
    	 
    	  }else{
    	  alert("techinical problem while sending money");
    	  console.log("else condition");
    	  }
    
    </script> --%> 

</body>
</html>