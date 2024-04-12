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

     .container{
		position: absolute;
        top: 54%;
        left: 50%;
        transform: translate(-50%, -50%);
        width: 25%;
        height: 60%;
        padding: 28px;
        font-size: 19px;
        text-align: center;
        background-color: rgba(165, 187, 103, 0.005); 
        box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.5);
        border-radius: 10px;
	 }
	
    .hd {
            font-size: 24px;
            font-weight: 600;
            text-align: center;
     }
	 .btn {
        display: inline-block;
        background: rgb(205, 90, 52,0.9);
        color: rgb(241, 241, 245);
        font-size: 20px;
        text-decoration: none;
        padding: 8px 28px;
        margin-top: 4px;
        border-radius: 6px;
        border: 2px solid #1e3551;
        transition: all 0.5s ease;
     }
    
      .btn:hover {
        border: 2px solid rgb(241, 242, 245);
        color: rgb(8, 19, 26);
     }
     .input {
        padding: 12px;
        border: 2px solid #ccc;
        border-radius: 8px;
        outline: none;
        font-size: 16px;
    }
      
    .input:hover{
        border: 2px solid #a5a0a0;
     }
     
     #input{
	   padding: 8px;
     }
    
     .form{
       margin-top: 20px;
     }

</style>
</head>
<body>
    <%@ include file="AdminLogin.jsp" %>
    <div class="container" id="container">
	  <span class="hd">Fill details for adding product</span><br><br>
	   <div class="formBox">
	      <form action="addproduct" method="post" id="form">
				PCode:  <input type="text" name="pcode" class="input" id="input" required><br><br>
				PName:  <input type="text" name="pname" class="input" id="input" required><br><br>
				PBrand: <input type="text" name="brand" class="input" id="input" required><br><br>
				PQty: &nbsp;&nbsp;&nbsp;<input type="number" name="qty" class="input" id="input" required/><br><br>
				CPrice:&nbsp;&nbsp;<input type="number" name="cprice" class="input" id="input" required/><br><br>
				SPrice:&nbsp;&nbsp;<input type="number" name="sprice" class="input" id="input" required/><br><br>
				<input type="submit" value="AddProduct" class="btn" required/>
	      </form>
       </div>
  </div>
</body>
</html>