<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventory System</title>
<style>
        html,body {
            height: 100%;
            padding: 0;
            margin: 0;
            background-color: #EEF3E2;
        }

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
<body class="bg">
<%@ include file="index.html" %>
  <div class="msg">
	   <%
	     session.invalidate();
	     out.println("Loggedout Successfully...<br><br><br>");
	   %>
  </div>
</body>
</html>