<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加商品</title>

</head>
<body>
	<div
		style="margin: 0 auto; width: 40%; background-color: rgba(123, 211, 221, 0.5); border-radius: 25px 25px 25px 25px; text-align: center; padding: 25px 25px 25px 25px">
		<form action="add_product.do" enctype="multipart/form-data"
			method="post">
			<table>
				<caption>增加商品</caption>
				<tr>
					<td>商品:</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>类型</td>
					<td><select size="1" name="type" style="width: 145px">
					<option>战士</option>
					<option>射手</option>
					<option>法师</option>
					<option>刺客</option>
					<option>坦克</option>
					</select></td>
				</tr>
				<tr>
					<td>价格</td>
					<td><input type="text" name="price"></td>
				</tr>
				<tr>
					<td>皮肤1</td>
					<td><input type="file" name="image1"></td>
				</tr>
				<tr>
					<td>皮肤2</td>
					<td><input type="file" name="image2"></td>
				</tr>
				<tr>
					<td>皮肤3</td>
					<td><input type="file" name="image3"></td>
				</tr>
				<tr>
					<td>详情</td>
					<td><textarea rows="4" cols="40" name="caption"></textarea></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="增加" style="margin: 0 auto; width: 20%; background-color: rgba(123, 111, 121, 0.5); border-radius: 5px 5px 5px 5px; text-align: center;"></td>
				</tr>

			</table>

		</form>


	</div>
</body>
</html>