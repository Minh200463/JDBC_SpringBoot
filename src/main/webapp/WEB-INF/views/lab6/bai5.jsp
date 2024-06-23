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
	<h3>SEARCH AND PAGE</h3>
	<form action="/product/searchpage" method="post">
		<input name="keywords" value="${keywords }" placeholder="Search">
		<button>Search</button>
		<table border="1" style="width: 40%; margin-top: 10px">
			<thead>
				<th>ID</th>
				<th>Name</th>
				<th>Price</th>
				<th>Date</th>
			</thead>
			<c:forEach var="item" items="${page.content }">
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
		<a href="/product/searchpage?p=0">First</a> <a
			href="/product/searchpage?p=${page.number-1 }">Prev</a> <a
			href="/product/searchpage?p=${page.number+1 }">Next</a> <a
			href="/product/searchpage?p=${page.totalPages-1 }">Last</a>
	</form>
	<ul>
		<li>Số thực thể hiện tại: ${page.numberOfElements }</li>
		<li>Trang số: ${page.number +1}</li>
		<li>Kích thước trang: ${page.size}</li>
		<li>Tổng số thực thể: ${page.totalElements}</li>
		<li>Tổng số trang: ${page.totalPages}</li>
	</ul>
</body>
</html>