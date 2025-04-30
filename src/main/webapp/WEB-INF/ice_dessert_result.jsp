<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	 <head>
		<meta charset="UTF-8">
		<title>User Form</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<style>
		    .form_container{
		        max-width: 500px;
		        margin: 50px auto;
		        padding: 20px;
		    }
		</style>
	</head>
	<body style= "padding:20px">
	    <div>
	        <fieldset>
		        <legend>訂單結果</legend>
		        ${ ice }<p />
			    ${ icedesserts }<p />
		    </fieldset>
	    </div>
	    <a href="/JavaWeb2/ice" class="pure-button pure-button-primary">返回</a>
	</body>
</html>