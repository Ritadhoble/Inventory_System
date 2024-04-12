<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventory System</title>
<link rel="stylesheet" href="style.css">
<style>
   html,body {
        height: 100%;
        padding: 0;
        margin: 0;
        background-color: #EEF3E2;
    }

   .edbox{
            position: absolute;
	        top: 50%;
	        left: 50%;
	        transform: translate(-50%, -50%);
	        width: 25%;
	        height: 48%;
	        padding: 35px;
	        text-align: center;
	        font-size: 17px;
	        font-weight: 550;
	        background-color: rgba(165, 187, 103, 0.05); 
            box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.5);
            border-radius: 10px;
	}
	.edbox:hover{
	   box-shadow: 5px 5px 12px rgba(0, 0, 0, 0.5);
	}
	.dtl{
	margin-left:25px;
	font-size: 22px;
	font-weight: 580;
    }
    #form{
	  font-size: 18px;
    }

   #input{
	  padding: 8px;
   }
 
  #update {
	  color: #fff;
	  background-color: #1c9f3b; 
	  border: 2px solid #28a745; 
	  padding: 8px 20px;
	  border-radius: 6px;
	  transition: all 1s ease;
	  font-size:17px;
	  margin-left:25px;
  }

   #update:hover{
    opacity: 0.8;
    color: black;
   }
   
</style>
</head>
<body>
	<%@ include file="AdminLogin.jsp" %>
	<div class="edbox">
	 <%
	  ProductBean pb = (ProductBean) request.getAttribute("pbean");
	 %>
	    <span class="dtl">Edit your product</span><br><br>
	         <form action="update" method="post" id="form">
				<input type="hidden" name="pcode" value=<%=pb.getPcode()%> />
				ProdCode: <input type="text" name="pcode" value=<%=pb.getPcode()%> class="input" id="input" readonly><br><br>
				ProdName: <input type="text" name="pname" value=<%=pb.getPname()%> class="input" id="input" readonly><br><br>
				CostPrice: <input type="text" name="cprice" value=<%=pb.getCprice()%> class="input" id="input" required><br><br>
				SellPrice: <input type="text" name="sprice" value=<%=pb.getSprice()%> class="input" id="input" required><br><br>
			    Quantity: <input type="text" name="qty" value=<%=pb.getQty()%> class="input" id="input" required><br><br>
			    <input type="submit" value="UpdateProduct" id="update">
	        </form>
	</div>
</body>
</html>