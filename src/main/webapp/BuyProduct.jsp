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

    #container{
        width: 340px;
        height: 435px;
        position: absolute;
        top: 55%;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: rgba(165, 187, 103, 0.05); 
        box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.5);
        border-radius: 10px;
        padding: 30px 50px;
    }
    #container:hover{
         box-shadow: 5px 5px 12px rgba(0, 0, 0, 0.5);
    }
    .dtl{
        font-size: 22px;
        font-weight: 580;
        margin-left:50px;
    }
    #form{
        font-size: 18px;
        margin-left:40px;
    }

    #input{
        padding: 8px;
    }

    #button-container {
        display: flex;
        justify-content: center;
        margin-top: 20px;
        margin-right:45px;
    }

    .cancel {
        color: #fff;
        background-color: #ca3342; 
        border: 2px solid #dc3545; 
        padding: 6px 15px;
        text-decoration: none;
        border-radius: 6px;
        transition: all 1s ease;
        margin-left:40px;
     }

    #payment {
        color: #fff;
        background-color: #1c9f3b; 
        border: 2px solid #28a745; 
        padding: 8px 20px;
        border-radius: 6px;
        transition: all 1s ease;
        font-size:17px;
    }

    #payment:hover, .cancel:hover {
        opacity: 0.8;
        color: black;
    }
</style>
</head>
<body>
<%@ include file="CustomerLogin.jsp" %>
    <%
        ProductBean pb=(ProductBean)request.getAttribute("pbean");
    %>
    <div class="container" id="container">
        <span class="dtl">Product Purchase Details</span> 
        <div class="formBox">
            <form action="updateqty" method="post" id="form">
                <input type="hidden" name="pCode" value=<%=pb.getPcode() %>><br>
                PCode:  <input type="text" name="pCode" value=<%=pb.getPcode() %>  class="input" id="input" readonly><br><br>
                PName:  <input type="text" name="pName" value="<%=pb.getPname() %>" class="input" id="input" readonly><br><br>
                PBrand: <input type="text" name="pBrand" value="<%=pb.getBrand() %>" class="input" id="input" readonly><br><br>
                PQty: &nbsp;&nbsp;&nbsp;<input type="number" name="pQty" value=<%=pb.getQty() %> class="input" id="input" readonly><br><br>
                SPrice: &nbsp;&nbsp;<input type="number" name="sPrice" value=<%=pb.getSprice() %> class="input" id="input" readonly ><br><br>
                Enter here, how many you want to buy? &nbsp; &nbsp;<input type="number" name="preg" class="input" id="input" min="1" max="<%=pb.getQty() %>" required><br>
                <div id="button-container">
                    <input type="submit" value="PayNow" id="payment" required>
                    <a href="CurrentStock.jsp" class="cancel">Cancel</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
