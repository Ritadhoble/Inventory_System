<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="bean.CustomerBean,java.util.*,bean.ProductBean"%>
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

   .buy {
    color: #fff;
    background-color: #1c9f3b; 
    border: 2px solid #28a745; 
    padding: 4px 8px;
    text-decoration: none;
    border-radius: 4px;
    transition: all 1s ease;
   }
  
   .buy:hover,
   .cart:hover {
    opacity: 0.8;
    color: black;
   }
    
    .cart{
    color: #fff;
    background-color: #145DA0; 
    border: 2px solid #145DA0; 
    padding: 4px 8px;
    text-decoration: none;
    border-radius: 4px;
    transition: all 1s ease;
  
    }
</style>
</head>
<body >
<%@ include file="CustomerLogin.jsp" %>
    <div class="container">
        <table class="vpTable">
        <tr>
	        <th>Product Code</th>
	        <th>Product Name</th>
	        <th>Product Brand</th>
	        <th>Quantity</th>
	        <th>Price</th>
	        <th>Action</th>
	     </tr>
        <%
           ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("alist");
           CustomerBean cbean = (CustomerBean)session.getAttribute("cbean");
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
		           out.println("<td>"+ pb.getSprice() +"</td>");
		           out.println("<td class='action-column'>"+
		        		       "<a href='buy?pcode=" + pb.getPcode() + "' class='buy'>Buy</a>"+"&nbsp;&nbsp;&nbsp;"+
		                       "<a href='addtocart?cid="+cbean.getCid()+"+&pcode="+pb.getPcode()+"&pname="+pb.getPname()+"&brand="+pb.getBrand()+"&qty="+pb.getQty()+"&sprice="+pb.getSprice()+"' class='cart'>AddtoCart</a>"+
		                       "</td>");
		           out.println("</td>");
		                     
		       }
		   }
	       %>
    
     </table> 
    </div>
</body>
</html>