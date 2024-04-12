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

   .mainBox{
       padding:120px;
    }

    .container {
        width: 400px;
        margin: 0 auto;
        padding: 20px;
        color: #333;
        text-align: center;
        background-color: rgba(165, 187, 103, 0.05); 
        box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.5);
        border-radius: 10px;
        margin-top: 40px;
    }
    
	.container:hover{
	   box-shadow: 5px 5px 12px rgba(0, 0, 0, 0.5);
	}

    .details {
        margin-bottom: 20px;
        line-height:2;
    }
  
    .msg{
       color:darkgreen;
       font-size:22px;
       font-weight:550;
    }

    .customer-name {
        font-size: 22px;
        font-weight: 600;
        color:darkblue;
    }

    .bill-details {
        font-size: 18px;
        text-align: left;
    }

    .thnkmsg{
       font-size: 20px;
        color: #333;
        margin-top: 20px;
    }
</style>
</head>
<body>
    <%@ include file="CustomerLogin.jsp" %>
    <div class="mainBox">
        <div class="container">
        <div class="details">
            <%
            	String pReg = (String)(request.getAttribute("pReg"));
                ProductBean pb=(ProductBean)request.getAttribute("pbean");
                String ans=(String)request.getAttribute("ans");
                String date=(String)request.getAttribute("date");
                String msg=(String)request.getAttribute("msg");
                out.println("<span class='customer-name'>Your Name is "+"<u>"+cb.getfName()+" "+cb.getlName()+"</u>"+"</span><br>");
                out.println("<span class='bill-details'>Today's Date is "+date+"</span>");
                out.println("<span class='bill-details'>Product Name: "+pb.getPname()+"</span><br>");
                out.println("<span class='bill-details'>Product Quantity: "+pReg+".</span><br>");
                out.println("<span class='bill-details'>Product Price: "+pb.getSprice()+"</span><br>");
                out.println("<span class='bill-details'>Total Amount  <b>Rs.&nbsp;"+ans+"</b></span>");
                out.println("<span class='msg'>"+msg+"</span>");
                out.println("<span class='thnkmsg'>"+" Thank you for your purchase! We hope you enjoy your products."+"</span>");
            %>
        </div>
    </div>
       
    </div>
   </body>
</html>

