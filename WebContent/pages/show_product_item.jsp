<%@page import="com.iotek.entity.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品展示</title>
</head>
<body>
<%Product product=(Product)session.getAttribute("productitem");%>
<h2><%out.print(product.getProductName()); %></h2>
<h2><%out.print(product.getProductPrice()); %></h2>
<h2><%out.print(product.getProductType()); %></h2>
<h2><%out.print(product.getProductDetail().getCaption());%></h2>
<img alt="<%product.getProductName();%>" src="<%=product.getProductDetail().getImage1()%>">
<img alt="<%product.getProductName();%>" src="<%=product.getProductDetail().getImage2()%>">
<img alt="<%product.getProductName();%>" src="<%=product.getProductDetail().getImage3()%>">
<form action="add_buycar.do" method="post">
<input type="number" name="product_num">
<input type="hidden" name="product_id" value="<%=product.getId()%>">
<input type="submit" value="加入购物车">
<a href="buy_product.do?productid?productId=<%=product.getId()%>">直接购买</a>


</form>
</body>
</html>