<%@page import="com.iotek.entity.Product"%>
<%@page import="com.iotek.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单详情</title>
</head>
<body>
<%User user=(User)session.getAttribute("user");
%>
<%Product  product=(Product)session.getAttribute("productitem");
%>
<h1>用户信息</h1>
<h2><%=user.getName()%></h2>
<h2><%=user.getUserDetail().getPhone()%></h2>
<h2><%=user.getUserDetail().getMoney()%></h2>
<h1>要购买的商品</h1>
<h2><%=product.getProductName() %></h2>

<h2><%=product.getProductType() %></h2>
<h2><%=product.getProductPrice() %></h2>
<h2><%=product.getProductDetail().getImage1()%></h2>


<h1>购买数量</h1>
<h2>数量为：1</h2>
<form action="bulid_orders.do" method="post">
请输入密保：<input type="password" name="provPassword">
<input type="submit" value="购买">

</form>



</body>
</html>