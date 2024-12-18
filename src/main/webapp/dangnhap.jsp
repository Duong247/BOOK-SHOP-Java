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
  String un= request.getParameter("txtun");
  String pass= request.getParameter("txtpass");	
  String tb=null;
  if(un!=null&&pass!=null){
	  if(un.equals("abc")&&pass.equals("123")){
		  session.setAttribute("dn",un);
		  String url=(String)session.getAttribute("trang");
		  response.sendRedirect(url);
	  }else
		  tb="Dang nhap sai";
  }
%>
<form action="dangnhapController" method="post">
     User name=<input type="text" name="txtun"> <br>
     Password =<input type="password" name="txtpass"> <br> 
     <input type="submit" name="but" value="Login">   
   </form><br><%if(tb!=null) out.print(tb); %>
</body>
</html>