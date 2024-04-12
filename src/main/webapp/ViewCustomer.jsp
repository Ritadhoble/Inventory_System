<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="bean.AdminBean,bean.CustomerBean,java.util.*"%>
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
    border-radius: 4px;
    transition: all 1s ease;
   }

	.edit {
	    color: #fff;
	    background-color: #1c9f3b; 
	    border: 2px solid #28a745; 
	    padding: 4px 8px;
	    text-decoration: none;
	    border-radius: 4px;
	    transition: all 1s ease;
	}
	
	
	.edit:hover, .delete:hover {
	    opacity: 0.8;
	    color: black;
	}
	    
</style>
</head>
<body>
<%@ include file="AdminLogin.jsp" %>
<div class="container">
   <table class="vpTable">
    <tr>
        <th>CID</th>
        <th>Password</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Phone Number</th>
        <th>Address</th>
        <th>Actions</th>
    </tr>
    <%
        ArrayList<CustomerBean> al = (ArrayList<CustomerBean>) session.getAttribute("alist");
        if (al.size() == 0) {
            out.println("<tr><td colspan='7'>Customers not Available..</td></tr>");
        } else {
            Iterator<CustomerBean> it = al.iterator();
            while (it.hasNext()) {
                CustomerBean cb = it.next();
                out.println("<tr>");
                out.println("<td>" + cb.getCid() + "</td>");
                out.println("<td>" + cb.getpWord() + "</td>");
                out.println("<td>" + cb.getfName() + "</td>");
                out.println("<td>" + cb.getlName() + "</td>");
                out.println("<td>" + cb.getPhNo() + "</td>");
                out.println("<td>" + cb.getAddr() + "</td>");
                out.println("<td class='action-column'>" +
                                "<a href='edit2?Cid=" + cb.getCid() + "' class='edit'>Update</a>" +"&nbsp;&nbsp;&nbsp;"+
                                "<a href='delete2?Cid=" + cb.getCid() + "' class='delete'>Remove</a>" +
                            "</td>");
                out.println("</tr>");
              
            }
        }
    %>
</table>
</div>
</body>
</html>