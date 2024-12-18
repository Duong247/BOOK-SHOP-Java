<%@page import="khachHangModal.khachhang"%>
<%@page import="loaiModal.loai"%>
<%@page import="sachModal.sach"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nhà Sách</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        img { width: 160px; height: 200px; vertical-align: middle; }
        .col-sm-4 { text-align: center; margin: 10px 0; padding: 0; }
    </style>
</head>
<body>
<%
    ArrayList<sach> dsSach = null;
    ArrayList<loai> dsLoai = null;

    try {
        dsSach = (ArrayList<sach>) request.getAttribute("dsSach");
        dsLoai = (ArrayList<loai>) request.getAttribute("dsLoai");
    } catch (ClassCastException e) {
        dsSach = new ArrayList<>();
        dsLoai = new ArrayList<>();
        e.printStackTrace(); 
    }

    if (dsSach == null) dsSach = new ArrayList<>();
    if (dsLoai == null) dsLoai = new ArrayList<>();
%>
<%
	khachhang kh = null;
	if(session.getAttribute("user") != null){
		kh = (khachhang) session.getAttribute("user");
	}
%>
<nav class="navbar navbar-inverse">
    <ul class="nav navbar-nav">
        <li><a href="sachControler">Trang chủ</a></li>
        <li><a href="htgioController">
            <img src="image_sach/shopping_cart.png" alt="Giỏ hàng" style="height: 18px; width: 18px;"> Giỏ hàng
        </a></li>
        <li><a href="lichsuController">Lịch sử mua hàng</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li>
            <a href="<c:choose>
                        <c:when test="${not empty sessionScope.user}">
                            #
                        </c:when>
                        <c:otherwise>
                            dangnhapController
                        </c:otherwise>
                     </c:choose>">
                <span class="glyphicon glyphicon-user"></span>
                <c:choose>
                    <c:when test="${not empty sessionScope.user}">
                        ${sessionScope.user.getHoten()}
                    </c:when>
                    <c:otherwise>
                        Login
                    </c:otherwise>
                </c:choose>
            </a>
        </li>
        <li style="display: <c:choose>
                                <c:when test="${not empty sessionScope.user}">
                                    block
                                </c:when>
                                <c:otherwise>
									none
                                </c:otherwise>
                             </c:choose>;">
            <a href="dangnhapController"><span class="glyphicon glyphicon-log-in"></span> Logout</a>
        </li>
    </ul>
</nav>


<div class="container">
    <div class="row">
        <div class="col-sm-2">
            <c:forEach var="l" items="${dsloai}">
            	<div class="row">
                    <div class="col-sm-12">
                        <a href="sachControler?ml=${l.getMaloai()}">${l.getMaloai()}</a>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="col-sm-8">
            <div class="row">
                <%-- <% for (sach book : dsSach) { %>
                    <div class="col-sm-4">
                        <img src="<%= book.getAnh() %>" alt="<%= book.getTensach() %>"><br>
                        <a href="giohangController?ms=<%= book.getMasach() %>&ts=<%= book.getTensach() %>&gia=<%= book.getGia() %>&anh=<%= book.getAnh() %>">
                            <img src="image_sach/buynow.jpg" alt="Mua ngay" style="height: 24px; width: 95px; margin-top: 30px;">
                        </a><br>
                        <%= book.getTensach() %><br>
                        <%= book.getGia() %> VND
                    </div>
                <% } %> --%>
                <c:forEach var="s" items="${dssach}">
                	<div class="col-sm-4">
                        <img src="${s.getAnh()}" alt="${s.getTensach()}" height="150px" width="150px"><br>
                        <a href="giohangController?ms=${s.getMasach()}&ts=${s.getTensach()}&gia=${s.getGia()}&anh=${s.getAnh()}">
                            <img src="image_sach/buynow.jpg" alt="Mua ngay" style="height: 24px; width: 95px; margin-top: 30px;">
                        </a><br>
                        <div style="height: 50px">
                        	${s.getTensach()}<br>
                        </div>
                        
                        ${s.getGia()} VND
                    </div>
                </c:forEach>
            </div>
        </div>

        <div class="col-sm-2">
            <form action="sachControler" method="get">
                <input type="text" name="key" placeholder="Tìm kiếm sách">
                <input class="btn btn-primary" type="submit" value="Search" style="width: 70px; height: 30px;">
            </form>
        </div>
    </div>
</div>
</body>
</html>