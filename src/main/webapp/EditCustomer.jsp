<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="bean.*"%>
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
	        top: 48%;
	        left: 50%;
	        transform: translate(-50%, -50%);
	        width: 25%;
	        height: 42%;
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
	margin-left:17px;
	font-size: 22px;
	font-weight: 580;
    }
    #form{
	  font-size: 18px;
    }

   #input{
	  padding: 8px;
   } 
  #upcustomer{
	  color: #fff;
	  background-color: #1c9f3b; 
	  border: 2px solid #28a745; 
	  padding: 8px 20px;
	  border-radius: 6px;
	  transition: all 1s ease;
	  font-size:17px;
	  margin-left:17px;
  }
  #upcustomer:hover{
    opacity: 0.8;
    color: black;
   }
</style>
</head>
<body>
<%@ include file="AdminLogin.jsp" %>
    <%
       CustomerBean cb = (CustomerBean) request.getAttribute("cbean");
    %>
    <div class="edbox">
       <span class="dtl">Edit Customer details</span><br/><br/>
       <div class="formBox">
           <form action="updateCust" method="post" id="form">
		        <input type="hidden" name="cid" value=<%=cb.getCid() %>>
		        PassWord: <input type="password" name="pwd" value=<%=cb.getpWord() %> class="input" id="input" required><br><br>
				FirstName: <input type="text" name="fName" value=<%=cb.getfName() %> class="input" id="input" required><br><br>
				LastName: <input type="text" name="lName" value=<%=cb.getlName()%> class="input" id="input" required><br><br>
		        PhoneNo: <input type="number" name="phn" value=<%=cb.getPhNo() %> class="input" id="input" required><br><br>
		        <input type="submit" value="UpdateCustomer" id="upcustomer">
			</form>
       </div>
    </div>
</body>
</html>