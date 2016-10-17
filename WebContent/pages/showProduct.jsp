<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理商品</title>
</head>
<body>
	<table border="1" cellpadding="6" cellspacing="0" bordercolor="#234545">

		<caption>管理商品</caption>
		<tr>
			<td>商品ID</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>商品类型</td>
			<td colspan="3" align="center">操作</td>
			<c:forEach items="${sessionScope.listProduct}" var="product">
				<tr>
				
				<td><c:out value="${product.id}"></c:out></td>
				<td><c:out value="${product.productName.trim()}"></c:out></td>
				<td><c:out value="${product.productPrice}"></c:out></td>
				<td><c:out value="${product.productType.trim()}"></c:out></td>
				<td><a href="../oper_product.do?${product.id}&oper=del">删除</a></td>
				<td><a href="../oper_product.do?${product.id}&oper=update">修改</a></td>
				<td><a href="../oper_product.do?${product.id}&oper=detail">详情</a></td>
			</tr>


			</c:forEach>
		</tr>


	</table>

</body>
</html>