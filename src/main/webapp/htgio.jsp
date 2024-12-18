<%@page import="giohangModal.hang"%>
<%@page import="giohangModal.giohangbo"%>
<%@page import="sachModal.sach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sachModal.sachbo"%>
<%@page import="loaiModal.loai"%>
<%@page import="loaiModal.loaibo"%>
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
<%
	session.setAttribute("trang", "tc.jsp");
	
 %>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
  

    
    <ul class="nav navbar-nav">
      <li class="active"><a href="sachControler">Trang chủ</a></li>
       <li><a href="htgioController">Giỏ hàng(0)</a></li>
       <li><a href="xacnhan.jsp">Xác nhận đặt mua</a></li>
       <li><a href="lichsu.jsp">Lịch sử mua hàng</a></li>
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
  
<div class="container">
 <div class="row">
     <div class="col-sm-2">
      <%
         loaibo lbo= new loaibo();
         for(loai l: lbo.getloai()){
      %>
        <a href="sachControler?ml=<%=l.getMaloai()%>">
          <%=l.getTenloai() %> <hr>
        </a>    
      <%} %>
     </div>
     <div class="col-sm-8">
     <form action="xoasuaController" method="post">
        <table class="table table-hover table-bordered">
         <%
           giohangbo gh=(giohangbo)session.getAttribute("gh");
           //giohangbo gh =(giohangbo) request.getAttribute("gh");
           
           if(gh!=null){
            for(hang h: gh.ds){%>
              <tr>
        <td><input type="checkbox" name="ck" value="<%=h.getMasach()%>"></td>
                 <td><%=h.getTensach() %></td>
                 <td><%=h.getGia() %></td>
                 <td><%=h.getSoluong() %></td>
                 <td>
				  <input type="number" name="<%=h.getMasach() %>" value="0"
				  style="width: 50px" class="form-control">
				  <button type="submit" name="butsuasl" value="<%=h.getMasach()%>" 
				  class="btn-link">
				     Sua
				  </button>                  
                 </td>
                 <td><%=h.getThanhtien() %></td>
                 <td>
		 <a href="xoasuaController?msxoa=<%=h.getMasach() %>">Xoa</a>         
     </td>
              </tr>
        	   
        <% } %>
            
          <%}
         %>
        </table> 
        <%if (gh!=null){ //out.print(gh.ds);%>
        
        <input type="submit" name="xoachon" value="Xoa" class="btn-link">
        <input type="submit" name="xoaall" value="Huy gio hang" class="btn-link">
        <a href="xacnhanColtroller" value="Dat hang" class="btn-link">Dat hang</a>
        </form>
        <%}else{ %>
        	<h2 class="text-center" style="color:#f00">Chua co mat hang trong gio</h2>
        <%} %>
        <%if(gh!=null)out.print("Tong thanh tien: "+ gh.Tong()); %>         
      </div>     
      <div class="col-sm-2">
     <form action="sachControler" method="post">
        <input type="text" name="txttk" class="form-control"> <br>
        <input type="submit" name="but" value="Search" class="btn-primary">   
   </form>
          
     </div>
 </div>
</div>

</body>
</html>
    