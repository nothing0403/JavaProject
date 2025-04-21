<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>guestbook result</title>
	</head>
	<body>
	    <div>
	        ${ guestbooks.username }
	        ${ guestbooks.message }
	        ${ guestbooks.date }
	        <a href="/JavaWeb2/guestbook" class="pure-button pure-button-primary">返回</a>
	    </div>
	</body>
</html>