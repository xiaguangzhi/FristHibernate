<%@page import="java.util.Date"%>
<%@page import="com.iotek.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/show.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示商品</title>
</head>		
<body>
<div>
<div id="show_top_left">
<a href="#">首页</a>
<a href="#">登录</a>
<span><%=new Date().toLocaleString()%></span>
</div>
<div id="show_top_right">
<a href="#">我的购物车</a>
<a href="#">我的订单</a>
<a href="#">关于我们</a>
<a href="#">扫描二维码</a>
</div>

</div>
<br>
<hr>
<table id="show_table">
<caption>商品展示</caption>
	
		<%
			List<Product> listProduct = (List) session
					.getAttribute("listProduct");
		%>
	
		<%
			for (int i = 0; i < listProduct.size(); i++) {
				
		%>
		<tr>
	
			<td ><%=listProduct.get(i).getProductName()%></td>
			<td><%=listProduct.get(i).getProductType()%></td>
			<td><%=listProduct.get(i).getProductPrice()%></td> 
			<td><img class="image"
			alt="<%=listProduct.get(i).getProductName()%>"
			src="http://localhost:8080/Hibernate_FristWeb<%=listProduct.get(i).getProductDetail().getImage1()%>"></td>
			<td><img class="image"
			alt="<%=listProduct.get(i).getProductName()%>"
			src="http://localhost:8080/Hibernate_FristWeb<%=listProduct.get(i).getProductDetail().getImage2()%>"></td>
		<td><img class="image"
			alt="<%=listProduct.get(i).getProductName()%>"
			src="http://localhost:8080/Hibernate_FristWeb<%=listProduct.get(i).getProductDetail().getImage3()%>"></td>
		</tr>




		<%
			}
		%>
	</table>
</body>
</html>