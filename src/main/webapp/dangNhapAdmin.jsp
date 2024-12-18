<%@page import="dangnhapAdminModal.dangnhapAdminBo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f8f9fa; /* Màu nền nhạt */
    margin: 0;
    padding: 0;
  }

  .navbar {
    margin-bottom: 20px;
  }

  .form-container {
    max-width: 400px;
    margin: 50px auto;
    background: #fff;
    padding: 20px;
    border: 1px solid #ddd;
    border-radius: 5px;
    box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
  }

  .form-container h2 {
    text-align: center;
    margin-bottom: 20px;
  }

  .form-group label {
    font-weight: bold;
  }

  .form-group input {
    border-radius: 4px;
  }

  .btn-primary {
    width: 100%;
    border-radius: 4px;
  }

  .alert {
    margin-top: 10px;
  }

  .captcha-container {
    text-align: center;
    margin-bottom: 15px;
  }

  .captcha-container img {
    display: block;
    margin: 10px auto;
    max-width: 100%;
  }

  footer {
    text-align: center;
    margin-top: 50px;
    font-size: 0.9em;
    color: #666;
  }
</style>



</head>


<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
 
    <ul class="nav navbar-nav">
      <li class="active"><a href="mt.jsp">May tinh</a></li>
     <li><a href="bcc.jsp">BCC</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="Logout.jsp">
      <span class="glyphicon glyphicon-user"></span>
       Logout</a></li>
      <%if(session.getAttribute("dn")==null){ %>
      <li><a href="dangnhap.jsp">
      <span class="glyphicon glyphicon-log-in"></span>
       Login</a></li>
       <%}else{ %>
       <li><a href="dangnhap.jsp">
      <span class="glyphicon glyphicon-log-in"></span>
       Xin chao: <%=session.getAttribute("dn") %></a></li>
       <%} %>
    </ul>
  </div>
</nav>
<%
	String tb = null;
	dangnhapAdminBo dnbo = new dangnhapAdminBo();
	String un = (String) request.getAttribute("tendn");
	String pass = (String) request.getAttribute("mk");
	Integer countWrong = (Integer) session.getAttribute("countWrong");
	if(un != null){	
		tb = (String) request.getAttribute("tb");
	}
%>
<div class="form-container">
  <h2>Đăng nhập</h2>
  <form action="dangnhapAdminController" method="post">
    <div class="form-group">
      <label for="username">User name:</label>
      <input type="text" class="form-control" id="username" name="txtun" value="<%=un!=null?un:"" %>" autofocus>
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
      <input type="password" class="form-control" id="password" name="txtpass" value="<%=pass!=null?pass:"" %>">
    </div>
    <% if (countWrong > 3) { %>
      <div class="captcha-container">
        <img src="simpleCaptcha.jpg" alt="Captcha">
        <input type="text" class="form-control" name="answer" placeholder="Nhập captcha">
      </div>
    <% } %>
    <button type="submit" class="btn btn-primary">Login</button>
  </form>
  <% if (tb != null) { %>
    <div class="alert alert-danger">
      <%= tb %>
    </div>
  <% } %>
  <% if (request.getAttribute("capcha") != null) { %>
    <div class="alert alert-warning">
      <%= request.getAttribute("capcha") %>
    </div>
  <% } %>
</div>
   
</body>
</html>