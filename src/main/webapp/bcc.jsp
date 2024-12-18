<%@page import="ketNoiModal.KetNoi"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>



 <%if(session.getAttribute("dn")==null){
    	session.setAttribute("trang", "bcc.jsp");
    	response.sendRedirect("dangnhap.jsp");
    }%>

<table>
   <tr>
      <td>
          <%@include file="trai.jsp" %>
      </td>
      <td>
    
Chon 1 bang cc: <br>
  <%for(int i=1;i<=9;i++){ %>
    <%=i %>
   <%} %>   
  <%for(int i=1;i<=9;i++){ 
       out.print(i);
  
     } %>  
<br>Bang cuu chuong thu: <%=request.getParameter("t") %>
  <table class="table table-bordered table-hover">
     <%for(int i=1;i<=9;i++){ %>
       <tr>
           <%for(int j=1;j<=9;j++){ %>
              <td>
                 <%=j %>x<%=i %>=<%=i*j %>
              </td>
            <%} %>  
       </tr>
     <%} %>  
     
  </table>
  </td>
   </tr>
</table>
</body>
</html>