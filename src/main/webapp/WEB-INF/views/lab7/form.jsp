<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>SEND EMAIL</h3>
<span>${message}</span>
	<form action="/mailer/send" method="post" enctype="multipart/form-data">
		<label for="from">From:</label>
        <input type="email" id="from" name="from" /><br><br>

        <label for="to">To:</label>
        <input type="email" id="to" name="to"/><br><br>

        <label for="cc">CC:</label>
        <input type="text" id="cc" name="cc"/><br><br>

        <label for="bcc">BCC:</label>
        <input type="text" id="bcc" name="bcc"/><br><br>

        <label for="subject">Subject:</label>
        <input type="text" id="subject" name="subject" /><br><br>

        <label for="body">Body:</label>
        <textarea id="body" name="body"></textarea><br><br>

        <label for="attachments">Attachments:</label> <br>
        <input type="file" id="attachments" name="attachments" multiple="multiple"/><br><br>

        <button type="submit">Send Email</button>
	</form>
</body>
</html>