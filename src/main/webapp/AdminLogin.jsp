<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="bean.AdminBean"%>
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

    .navBox {
            display: flex;
            flex-direction: column; 
            position: fixed;
            width:100%;
            margin: 0;
     }

     .topBox {
            background: rgb(6, 50, 99);
            color: white;
            padding: 20px 30px;
            display: flex;
            justify-content: space-between; 
            align-items: center;
      }

     .name {
            font-size: 22px;
            margin-left: 10px;
      }

      .searchBox {
            display: flex;
            align-items: center;
            margin-right: 0;
       }

      .input ,
      .sbtn{
            padding: 10px 40px;
            margin-left: 15px;
            border-radius: 5px;
            outline: none;
            border-radius: 5px;
            font-size: 16px;
            border: 1px solid #ccc;
       }

       .input:hover,
        .sbtn:hover{
            border: 1px solid black;
       }
   
       .sbtn{
            padding: 8px;
            margin-right: 130px;
       }
       
     .leftBox {
		    position: fixed;
		    top: 80px;
		    left: 0;
		    height: 100vh; 
		    display: flex;
		    flex-direction: column;
		    justify-content: space-between; 
	  }

	.dashboard {
		    background-color: #c5ceae;
		    padding: 60px; 
		    flex: 1; 
	}
	
	.dashbtn {
	       display: block;
		   padding: 10px 15px;
		   margin-bottom: 22px;
		   background: rgb(205, 90, 52, 0.9);
		   color: rgb(241, 241, 245);
		   font-size: 20px;
		   text-decoration: none;
		   border-radius: 10px;
		   border: 2px solid #1e3551;
		   transition: all 0.5s ease;
	}
	
	.dashbtn:hover {
		   background: rgba(119, 42, 17, 0.9);
		   border: 2px solid rgb(241, 242, 245);
		   color: rgb(8, 19, 26);
	}
</style>
</head>
<body>
   <div class="navBox">
        <div class="topBox">
            <span class="name">
                 <%
			       AdminBean ab=(AdminBean)session.getAttribute("abean");
			       out.println("Admin Name: "+ab.getfName()+"&nbsp"+ab.getlName()+"<br>");
		         %>
            </span>
           <form action="search" method="post">
            <div class="searchBox">
              <input type="text" placeholder="Search..." class="input" name="pcode">
              <input type="submit" class="sbtn" value="Go">
            </div>
          </form>
        </div>

        <div class="leftBox">
            <div class="dashboard">
                <a href="Product.jsp" class="dashbtn">AddProducts</a>
                <a href="stock1" class="dashbtn">ViewProducts</a>
                <a href="currstock" class="dashbtn">CurrentStock</a>
                <a href="view" class="dashbtn">ViewCustomers</a>
                <a href="logout" class="dashbtn">Logout</a>
            </div>
        </div>
    </div>
</body>
</html>