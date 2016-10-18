<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<!-- 先导入jstl jar 包  再导入外部标签库 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 样式放的位置要放在头信息里:主要是加载网页信息完成后会自动处理样式 -->
<link rel="stylesheet" href="css/show.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
</head>
<body>
	<div>
		<div id="show_top_left">
			<a href="#">首页</a> <a href="#">登录</a> <span><%=new Date().toLocaleString()%></span>
		</div>
		<div id="show_top_right">
			<a href="#">我的购物车</a> <a href="#">我的订单</a> <a href="#">关于我们</a> <a
				href="#">扫描二维码</a>
		</div>

	</div>
	<br>
	<hr>
	<!-- 主页面主要功能显示基本的商品息供用户浏览  -->
	<div class="logo">
		<a href="#"><img src="images/logo.png" alt="英雄商城" id="logo_image"></a>
		<div id="input">
			<input type="text" name="input" id="input_text">
			<button value="查找" id="input_button">查找</button>
		</div>


	</div>
	<br>
	<br>
	<br>
	<br>
	<hr>

	<!--显示主页商品 ：
通过表格来显示  一列让他显示   5个商品   4列   每个单元格放一个商品信息-->
	<table>
		<caption>商品展示</caption>
		<c:forEach items="${sessionScope.listProduct}" var="product">
		
				<td>
				<div>
				<div><a href="show_product_detail.do?productid=${product.id}"><img alt="${product.productName.trim()}" src="<%=basePath%>${product.productDetail.image1}" /></a></div>
				<div><a href="show_product_detail.do?productid=${product.id}"><c:out value="${product.productName.trim()}"></c:out></a></div>
				<div><c:out value="${product.productPrice}"></c:out></div>
				<div><button>立即抢购</button></div>
				</div>
				
				</td>
				
			</c:forEach>
		
	</table>






</body>
</html>