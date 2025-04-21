<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>guestbook form</title>
	</head>
	<body>
	    <form class="pure-form pure-form-stacked" method="POST" action"/JavaWeb2"/guestbook>
	    <h1>使用者名稱</h1>
	    <input name="username" type="text" required>
	    <Textarea name="message" rows="5" columns="33" required></Textarea>
	    <button type="submit" class="pure-form pure-form-primary">送出</button>
	</body>
</html>