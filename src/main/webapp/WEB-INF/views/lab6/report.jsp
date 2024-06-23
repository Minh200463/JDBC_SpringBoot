<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>TỒN KHO THEO LOẠI</h3>
	<table border="1" style="width: 40%">
		<thead>
			<tr>
				<th>Loại hàng</th>
				<th>Tổng giá</th>
				<th>Số sản phẩm</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${items }">
				<tr>
					<td>${item.categories }</td>
					<td>${item.sum }</td>
					<td>${item.count }</td>
				</tr>
			</c:forEach>
		</tbody>


	</table>
</body>
</html>