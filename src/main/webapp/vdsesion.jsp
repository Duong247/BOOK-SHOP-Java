<%@page import="tam.LuuTru"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(session.getAttribute("tong")==null){//Chua tao
	session.setAttribute("tong", (int)0);//tao ra session: tong
}
   String nn= request.getParameter("txtn");
   int s=0;
   if(nn!=null){
	   int n= Integer.parseInt(nn);
	   //b1: gan session vo bien s
	   s=(int)session.getAttribute("tong");
	   //b2: Thao tac trên s
	   s=s+n;
	   //b3: Luu bien s vao session: tong
	   session.setAttribute("tong", s);
	   out.print("Tong: "+ session.getAttribute("tong"));
   }
%>
<a href="mt.jsp"> Mo Mt </a>
<form action="vdsesion.jsp" method="post">
     n=<input type="number" name="txtn"> <br> 
     <input type="submit" name="but" value="Tong">   
   </form>
</body>
</html>