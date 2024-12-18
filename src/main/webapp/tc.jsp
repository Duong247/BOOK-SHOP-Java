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
	//session.setAttribute("trang", "tc.jsp");
	
 %>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
  

    
    <ul class="nav navbar-nav">
      <li class="active"><a href="sachControler">Trang chủ</a></li>
       <li><a href="htgioController">Giỏ hàng(0)</a></li>
       <li><a href="xacnhanController">Xác nhận đặt mua</a></li>
       <li><a href="lichsuController">Lịch sử mua hàng</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="LogoutController">
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
      	ArrayList<loai> dsloai = (ArrayList<loai>) request.getAttribute("dsloai");
         for(loai l: dsloai){
      %>
        <a href="sachControler?ml=<%=l.getMaloai()%>">
          <%=l.getTenloai() %> <hr>
        </a>    
      <%} %>
     </div>
     <div class="col-sm-8">
          <%
          //int PageCount = (int)request.getAttribute("PageCount");
          ArrayList<sach> ds= (ArrayList<sach>) request.getAttribute("dssach");
            int n=ds.size();
            for(int i=0;i<n;i++){
            	sach s=ds.get(i);
             %> 
          <div class="row">
            <div class="col-sm-4">
	            <img src="<%=s.getAnh() %>"> <br>
	             <%=s.getTensach() %> <br>
	             <%=s.getGia() %> <br>
	             
				<a href="giohangController?ms=<%=s.getMasach() %>&ts=<%=s.getTensach() %>&gia=<%=s.getGia() %>">
				   <img src="buynow.jpg">
				</a>	             
	         </div>
	         <%i++;if(i<n){s=ds.get(i); %>
	         <div class="col-sm-4">
	            <img src="<%=s.getAnh() %>"> <br>
	             <%=s.getTensach() %> <br>
	             <%=s.getGia() %> <br>
				<a href="giohangController?ms=<%=s.getMasach() %>&ts=<%=s.getTensach() %>&gia=<%=s.getGia() %>">
				   <img src="buynow.jpg">
				</a>
	         </div>
	         <%} %>
	         <%i++;if(i<n){s=ds.get(i); %>
	         <div class="col-sm-4">
	            <img src="<%=s.getAnh() %>"> <br>
	             <%=s.getTensach() %> <br>
	             <%=s.getGia() %> <br>
				<a href="giohangController?ms=<%=s.getMasach() %>&ts=<%=s.getTensach() %>&gia=<%=s.getGia() %>">
				   <img src="buynow.jpg">
				</a>
	         </div>
	         <%} %>
	         </div>
	       <%} %>
	  	
	  	<div class="text-center">
	  		<nav aria-label="Page navigation example">
			  <ul class="pagination">
			    <li class="page-item">
			      <a class="page-link" href="#" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    <li class="page-item"><a class="page-link" href="#">1</a></li>
			    <li class="page-item"><a class="page-link" href="#">2</a></li>
			    <li class="page-item"><a class="page-link" href="#">3</a></li>
			    <li class="page-item">
			      <a class="page-link" href="#" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
	  	</div>     
	       
	   		
     </div>     
           

     <div class="col-sm-2">
    <form action="sachControler" method="post">
        <input type="text" name="txttk" class="form-control" value="<%=request.getAttribute("txttk")!=null?request.getAttribute("txttk"):""%>"> <br>
        <input type="submit" name="but" value="Search" class="btn-primary">   
   	</form>
          
     </div>
 </div>
</div>

</body>
</html>
    