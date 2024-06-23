<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post">
		<input type="text" placeholder="Category id?" value="${item.id }" name="id"><br>
		<input type="text" placeholder="Category Name?" value="${item.name }" name="name"> <br>
		<hr>
		<button formaction="/category/create">Create</button>
		<button formaction="/category/update">Update</button>
		<a href="/category/delete/${item.id }">Delete</a>
		<a href="/category/index">Reset</a>
	</form>
</body>
</html>