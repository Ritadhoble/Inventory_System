<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="bean.*"%>
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
    
    .container{
       padding:120px;
    }
    
    .tableBox {
        width: 80%; 
        margin-left:380px; 
        margin-top:90px;
     }
    
     table {
        width: 70%;
        border-collapse: collapse;
        background-color: rgba(165, 187, 103, 0.05); 
        box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.5);
        border-radius: 10px;
     }
    
    th, td {
        padding: 10px;
        text-align: center;
        border-bottom: 1px solid #ddd; 
    }
    
    th {
       background-color: rgba(171, 191, 117,0.5); 
    }
    
    tr:nth-child(even) {
        background-color: rgba(165, 187, 103, 0.05); 
    }
    
</style>
</head>
<body>
<%@ include file="AdminLogin.jsp" %>
 <div class="container">
    <div class="tableBox">
    <%
      ProductBean pb=(ProductBean)session.getAttribute("pbean");
      out.println("<table border='1'>");
     out.println("<tr><th>Pcode</th><th>Pname</th><th>Pbrand</th><th>PQty</th><th>costPrice</th><th>sellPrice</th></tr>");
     out.println("<tr><td>"+pb.getPcode()+"</td><td>"+pb.getPname()+"</td><td>"+pb.getBrand()+"</td><td>"+pb.getQty()+"</td><td>"+pb.getCprice()+"</td><td>"+pb.getSprice()+"</td></tr>");
     out.println("</table>");
   %>
   </div>
 </div>
  
</body>
</html>