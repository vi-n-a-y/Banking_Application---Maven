<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  errorPage="error.jsp" %>
    <%@ page import="com.vin.bankdto.BankDTO"%>
<%@ page import="com.vin.bankdto.AccountDTO"%>
<%@ page import="com.vin.bankdto.TransactionDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="com.vin.bankdao.BankDAO"%>
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
 	    <% BankDAO trxn = new BankDAO(); %>
        <% List<TransactionDTO> stm=trxn.setMiniStatement(data.getAccountNumber()); %>
<%if(!stm.isEmpty()){ %>
<div class="stmPage" id="st">

        
        <div class=pers_info>
        
 <a  href="logout.jsp" ><button class="home_btn" >logout</button></a>
 <a href="home.jsp"><button class="home_btn" >Home</button></a>
        
        <h1 class="acc_head">statement Form</h1>
        
       
        
         <div  class="min_stm">       
        <label>Start Date : </label>
        <input type="date" placeholder="select start date">
        <label>End Date :</label>
        <input type="date" placeholder="select end date">
        
       
        
        
        
        
        
        </div>
        
        <table border=1>
        
        <caption ><font >Mini-Statement Form</font></caption>
        <tr><th>Trxn_id</th><th>Date</th><th>From Account No:</th><th>To Account No</th><th>Description</th><th>Amount Send</th><th>Current Balance</th>
        <%for(TransactionDTO mini : stm ){ %>
        <tr><td><%=mini.getTrnId() %></td><td><%=mini.getTrnDate() %></td><td><%=mini.getFromAcc()%></td><td><%=mini.getToAcc() %></td><td><%=mini.getDescription() %></td><td><%=mini.getAmountSend() %></td><td><%=mini.getBalance() %></td></tr>
       <%} %>
        
        </table>
         <%}else{%>
        	<h1 class="acc_head">No transaction found from your Account</h1>
        	<form action="home.jsp"><button class="sign">Home</button></form>
        	
     <%}%>
      <%}else{%>
        	<h1 class="acc_head">Please add your Account to get Statement</h1>
        	<form action="home.jsp"><button class="sign">Home</button></form>
        	
     <%}%>
        
        </div>
        
        </div> 

</body>
</html>