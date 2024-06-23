<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/product/search" method="post">
		<input name="min" value="${param.min}" placeholder="Min Price?"> <br>
		<input name="max" value="${param.max}" placeholder="Max Price?"> <br>
		<button>Search</button>
	</form>
	<table border="1" style="width: 40%">
	<thead>
		<th>Id</th>
		<th>Name</th>
		<th>Price</th>
		<th>Date</th>
	</thead>
	<c:forEach var="item" items="${items }">
		<tbody>
		<tr>
			<td>${item.id }</td>
			<td>${item.name }</td>
			<td>${item.price }</td>
			<td>${item.createdate }</td>
		</tr>
		</tbody>
	</c:forEach>
	</table>
</body>
</html>