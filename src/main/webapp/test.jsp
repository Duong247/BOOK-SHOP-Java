<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Gia tri session
<%=session.getAttribute("mysession") %> <br>
Gia tri cua bien request:
<%String st=(String)request.getAttribute("b1"); %> <%=st %>
</body>
</html>