<%@page import="ketNoiModal.KetNoi"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	
	
	
	int kq=0,a=0,b=0;
	if(request.getAttribute("kq")!=null){
		kq = (int)request.getAttribute("kq");
	}
	if(request.getAttribute("a")!= null){
		kq = (int)request.getAttribute("a");
	}
	if(request.getAttribute("b")!= null){
		kq = (int)request.getAttribute("b");
	}
%>
   <form action="tinhController" method="post">
     a=<input type="number" name="txta" value="<%=a%>"> <br> 
     b=<input type="number" name="txtb" value="<%=b%>"> <br> 
     kq=<input type="number" name="txtkq" value="<%=kq%>"> <br> 
     <input type="submit" name="butcong" value="+"> 
   </form>
</body>
</html>