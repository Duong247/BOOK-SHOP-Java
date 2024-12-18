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
    if(session.getAttribute("dn")==null){
    	session.setAttribute("trang", "mt.jsp");
    	response.sendRedirect("dangnhap.jsp");
    }
    int kq=0,a=0,b=0;
	String aa=request.getParameter("txta");
	String bb=request.getParameter("txtb");
	if(aa!=null&& bb!=null){//Ko phai chay lan daU
	     a= Integer.parseInt(aa);
	     b= Integer.parseInt(bb);
	     kq=0;
	     if(request.getParameter("butcong")!=null)//kich vao +
	       kq=a+b;
	     if(request.getParameter("buttru")!=null)//kich vao -
		       kq=a-b;
	}
%>
<form action="mt.jsp" method="post">
     a=<input type="number" name="txta" value="<%=a%>"> <br> 
     b=<input type="number" name="txtb" value="<%=b%>"> <br> 
     kq=<input type="number" name="txtkq" value="<%=kq%>"> <br> 
     <input type="submit" name="butcong" value="+"> 
     <input type="submit" name="buttru" value="-">
     <input type="submit" name="butnhan" value="x">
     <input type="submit" name="butchia" value="/">   
   </form>
</body>
</html>