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
	<h3>SEARCH BY PRICE</h3>
	<form action="/product/search" method="post">
		<input name="min" value="${param.min}" placeholder="Min Price?"> <br>
		<input name="max" value="${param.max}" placeholder="Max Price?"> <br>
		<button>Search</button>
	</form>
	<table border="1" style="width: 40%">
	<c:forEach var="item" items="${items }">
		<tr>
			<td>${item.id }</td>
			<td>${item.name }</td>
			<td>${item.price }</td>
			<td>${item.createdate }</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>