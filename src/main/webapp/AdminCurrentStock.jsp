<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="bean.*,java.util.*,bean.ProductBean"%>
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
       padding-top: 120px;
    }
    
     .vpTable {
        width: 60%;
        border-collapse: collapse;
        margin-left:380px; 
        margin-top:40px;
        background-color: rgba(165, 187, 103, 0.05); 
        box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.5);
        border-radius: 10px;
    }
    
    .vpTable:hover{
        box-shadow: 5px 5px 12px rgba(0, 0, 0, 0.5);
    }
    
    th, td {
        border: 1px solid #cacfd9;
        text-align: center;
        padding: 12.6px;
    }
    
    th {
        background-color: rgba(171, 191, 117,0.5); 
    }
</style>
</head>
<body >
<%@ include file="AdminLogin.jsp" %>
    <div class="container">
         <table class="vpTable">
        <tr>
	        <th>Product Code</th>
	        <th>Product Name</th>
	        <th>Product Brand</th>
	        <th>Quantity</th>
	        <th>Cost Price</th>
	        <th>Selling Price</th>
	     </tr>
        <%
   
		   ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("alist");
		   if (al.size() == 0) {
		       out.println("<tr><td colspan='7'>Products not Available..</td></tr><br>");
		   } else {
		       Iterator<ProductBean> it = al.iterator();
		       while (it.hasNext()) {
		           ProductBean pb = it.next();
		           out.println("<tr>");
		           out.println("<td>"+ pb.getPcode() +"</td>");
		           out.println("<td>"+ pb.getPname() +"</td>");
		           out.println("<td>"+ pb.getBrand() +"</td>");
		           out.println("<td>"+ pb.getQty() +"</td>");
		           out.println("<td>"+ pb.getCprice() +"</td>");
		           out.println("<td>"+ pb.getSprice() +"</td>");             
		       }
		   }
	       %>
    
     </table> 
    </div>
</body>
</html>