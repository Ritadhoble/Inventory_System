<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import = "bean.*,java.util.*"%>
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

    .delete {
    color: #fff;
    background-color: #ca3342; 
    border: 2px solid #dc3545; 
    padding: 4px 8px;
    text-decoration: none;
    border-radius: 5px;
    transition: all 1s ease;
   }
 .delete {
    color: #fff;
    background-color: #ca3342; 
    border: 2px solid #dc3545; 
    padding: 4px 8px;
    text-decoration: none;
    border-radius: 5px;
    transition: all 1s ease;
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
   .delete:hover,
   .buy:hover {
    opacity: 0.8;
    color: black;
   }


    .udp{
	         font-size: 27px;
	        font-weight: 550;
	        display: block; 
	        text-align:center;
	        color:darkgreen;
		    text-align:center;
		    margin-top:8%;
    }	    margin-top:120px;
   
</style>
</head>
<body>
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
   
		   ArrayList<CartBean> al = (ArrayList<CartBean>)session.getAttribute("list");
           CustomerBean cbean = (CustomerBean)session.getAttribute("cbean");
		   if (al.size() == 0) {
		       out.println("<tr><td colspan='7'>Products not Available..</td></tr><br>");
		   } else {
		       Iterator<CartBean> it = al.iterator();
		       while (it.hasNext()) {
		           CartBean cb1 = it.next();
		           out.println("<tr>");
		           out.println("<td>"+ cb1.getPcode() +"</td>");
		           out.println("<td>"+ cb1.getPname() +"</td>");
		           out.println("<td>"+ cb1.getBrand() +"</td>");
		           out.println("<td>"+ cb1.getQty() +"</td>");
		           out.println("<td>"+ cb1.getSprice() +"</td>");
            out.println("<td class='action-column'>" +
            		        "<a href='buy?pcode=" + cb1.getPcode() + "' class='buy'>Buy</a>"+"&nbsp;&nbsp;&nbsp;"+
                            "<a href='remove?cid="+cbean.getCid()+"&pcode=" + cb1.getPcode() + "' class='delete'>Remove</a>" +
                        "</td>");
            out.println("</tr>");
        }
    }
%>
</table>
	</div>
</body>
</html>