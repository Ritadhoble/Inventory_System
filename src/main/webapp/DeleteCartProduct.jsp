<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventory System</title>
<style>
     .udp{
	         font-size: 27px;
	        font-weight: 550;
	        display: block; 
	        text-align:center;
	        color:darkgreen;
		    text-align:center;
		    margin-top:8%;
    }
</style>
</head>
<body>
    <%@ include file="ViewCartProduct.jsp" %>
     <span class="udp">
        <%
           String msg=(String) request.getAttribute("msg");
	       out.println(msg); 
	    %>
	</span> 
</body>
</html>