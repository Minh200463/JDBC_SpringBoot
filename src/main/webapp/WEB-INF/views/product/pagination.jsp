<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>PAGINATION</h3>
	<table border="1" style="width: 40%">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Date</th>
		</tr>
		<c:forEach var="item" items="${page.content }">
			<tr>
				<td>${item.id }</td>
				<td>${item.name }</td>
				<td>${item.price }</td>
				<td>${item.createdate }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/product/page?p=0">First</a>
	<a href="/product/page?p=${page.number-1 }">Prev</a>
	<a href="/product/page?p=${page.number+1 }">Next</a>
	<a href="/product/page?p=${page.totalPages-1 }">Last</a>
	<ul>
		<li>Số thực thể hiện tại: ${page.numberOfElements }</li>
		<li>Trang số: ${page.number }</li>
		<li>Kích thước trang: ${page.size}</li>
		<li>Tổng số thực thể: ${page.totalElements}</li>
		<li>Tổng số trang: ${page.totalPages}</li>
	</ul>
</body>
</html>