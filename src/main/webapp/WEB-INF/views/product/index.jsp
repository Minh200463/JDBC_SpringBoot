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
	<h3>SORTING BY ${field }</h3>
	<table border="1" style="width: 40%">
		<tr>
			<th><a href="/product/sort?field=id">ID</a></th>
			<th><a href="/product/sort?field=name">Name</a></th>
			<th><a href="/product/sort?field=price">Price</a></th>
			<th><a href="/product/sort?field=createdate">Date</a></th>
		</tr>
		<c:forEach var="item" items="${items }">
		<tr>
			<td>${item.id } </td>
			<td>${item.name } </td>
			<td>${item.price } </td>
			<td>${item.createdate } </td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>