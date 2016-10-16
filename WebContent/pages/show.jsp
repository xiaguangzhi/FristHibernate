<%@page import="com.iotek.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示商品</title>
</head>
<body>
	<ul>
		<%
			List<Product> listProduct = (List) session
					.getAttribute("listProduct");
		%>
		<%
			for (int i = 0; i < listProduct.size(); i++) {
		%>
		<li>
			<h3><%=listProduct.get(i).getProductName()%></h3>
			<h3><%=listProduct.get(i).getProductType()%></h3>
			<h3><%=listProduct.get(i).getProductPrice()%></h3> <img
			alt="<%=listProduct.get(i).getProductName()%>"
			src="<%=listProduct.get(i).getProductDetail().getImage2()%>">
		</li>




		<%
			}
		%>


	</ul>
</body>
</html>