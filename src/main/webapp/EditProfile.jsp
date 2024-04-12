<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="bean.CustomerBean"%>
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
	        top: 54%;
	        left: 50%;
	        transform: translate(-50%, -50%);
	        width: 25%;
	        height: 56%;
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
   .ed{
        margin-top:2px;
        text-align: center;
        font-size: 27px;
      }
       .frm{
        font-size:18px;
      }
     .custname {
      font-size: 22px;    
      }
       .upd {
	  color: #fff;
	  background-color: #1c9f3b; 
	  border: 2px solid #28a745; 
	  padding: 8px 20px;
	  border-radius: 5px;
	  transition: all 1s ease;
	  font-size:17px;
	  margin-left:30px;
  }

   .upd:hover{
    opacity: 0.8;
    color: black;
   }
   
   
   #input{
	  padding: 8px;
   }   
      
</style>
</head>
<body class="bg">
<%@ include file="CustomerLogin.jsp" %>
   <div class="edbox">
     <span class="custname">
     <%
      out.println("Profile belongs to : "+"<u>"+cb.getfName()+"</u>"+"<br><br>");
      out.println("Edit Your Profile<br><br>");
   %>
   </span>
   <form action="updateProf" method="post" class="frm">
       Password: <input type="password" name="pwd" value="<%=cb.getpWord()%>" class="input" id="input" required><br><br>
       FirstName: <input type="text" name="fName" value="<%=cb.getfName()%>" class="input" id="input" required><br><br>
       LastName: <input type="text"  name="lName" value="<%=cb.getlName()%>" class="input" id="input" required><br><br>
       PhoneNo:   <input type="number" name="phno"  value="<%=cb.getPhNo()%>" class="input" id="input" required><br><br>
       Address:   <input type="text" name="address"  value="<%=cb.getAddr()%>" class="input" id="input" required><br><br>
       <input type="submit" value="UpdateProfile" class="upd" >
   </form>
 
   </div>
  </body>
</html>
