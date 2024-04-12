<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventory System</title>
<style>
   .msg{
	      font-size: 27px;
	      font-weight: 550;
	      display: block; 
	      text-align:center;
	      color:darkgreen;
		  text-align:center;
		  margin-top:30px;		    
    }
</style>
</head>
<body>
<jsp:include page="ViewCustomer.jsp" />
   <div class="msg">
    <%
        String msg=(String)request.getAttribute("msg");
        out.println(msg);
    %>
    </div>
</body>
</html>