<%@ page language="java" 
         contentType="text/html; charset=ISO-8859-1"
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

    .profdiv{
        padding:120px;
    }
    .vpBox{
        position: absolute;
	    top: 48%;
	    left: 50%;
	    transform: translate(-50%, -50%);
	    width: 24%;
	    height: 40%;
	    padding: 28px;
	    text-align: center;
	    background-color: rgba(165, 187, 103, 0.05); 
        box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.5);
        border-radius: 10px;
	}
	.vpBox:hover{
	   box-shadow: 5px 5px 12px rgba(0, 0, 0, 0.5);
	}
    .custdetail{
        margin-left:80px;
	    text-align: left;
	    font-size: 19px;
	    line-height:1.3;
    }
    .vphd{
        font-size: 25px;
        font-weight: 600;
        display: block; 
        margin-bottom: 25px;
    }
    .editdiv{
         margin-top:22px;
	    margin-left:50px;
	    display: flex;
    }
    .editdiv a{
		margin-right: 8px;
		  font-size:20px;
	} 
     .upd {
	  color: #fff;
	  background-color: #1c9f3b; 
	  border: 2px solid #28a745; 
	  padding: 8px 40px;
	  border-radius: 5px;
	  transition: all 1s ease;
	  font-size:17px;
	  margin-left:4px;
	  text-decoration:none;
  }
  #upd{
    background-color: #ca3342; 
    border: 2px solid #ca3342; 
  }
  .upd:hover{
    opacity: 0.8;
    color: black;
  }
</style>
</head>
<body class="bg">
<%@ include file="CustomerLogin.jsp" %>
      <div class="profdiv">
      <div class="vpBox">
         <span class="vphd">Your Profile Details</span> 
         <p class="custdetail">
            <%
	            out.println("Welcome Customer: "+cb.getfName()+"<br>");
	            out.println("CustomerCode: "+cb.getCid()+"<br>"+"Password:  "+cb.getpWord()+"<br>"+ "First Name:  "+cb.getfName()+"<br>"+"Last Name:  "+cb.getlName()+"<br>"
		        +"Mobile Number:  "+cb.getPhNo()+"<br>"+"Address:  "+cb.getAddr()+"<br>");
		    %>
         </p>
         <div class="editdiv">
             <a href="edit3" class="upd">Edit</a>
	         <a href="delete3" class="upd" id="upd">Delete</a>
	     </div>
	  </div>
      </div>  
</body>
</html>