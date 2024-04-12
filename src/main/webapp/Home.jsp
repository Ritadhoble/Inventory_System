<%@ page language="java" contentType="text/html; ISO-8859-1"
    pageEncoding="UTF-8"%>
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
		    margin-top:9%;
    }
</style>
</head>
<body>
<span class="msg">
    <%
   
     String msg=(String)request.getAttribute("msg");
     out.println(msg);
   %>
   </span>
   <%@ include file="index.html" %>
</body>
</html>