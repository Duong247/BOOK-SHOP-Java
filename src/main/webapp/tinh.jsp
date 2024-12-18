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
     String aa=request.getParameter("txta");
     String bb=request.getParameter("txtb");
     if(aa!=null&& bb!=null){//Ko phai chay lan daU
	     int a= Integer.parseInt(aa);
	     int b= Integer.parseInt(bb);
	     int kq=a+b;
	     response.sendRedirect("maytinh.jsp?k="+kq+"&a="+a+"&b="+b);
     }else
    	 out.print("Chay lan dau");
  %>
</body>
</html>