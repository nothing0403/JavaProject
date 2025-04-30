<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding:20px">
	    <div>
	        <h2>使用者資料結果</h2>
	        <fieldset>
	            <legend>Coffee Result</legend>
	            咖啡類型: ${ coffeeForm.kind }<p/> 
	            牛奶毫升數: ${ coffeeForm.milk }<p/> 
	            咖啡毫升數: ${ coffeeForm.coffee }<p/> 
	            描述: ${ coffeeForm.text }<p/> 
	            
	            <a href="/JavaWeb2/coffeeform" class="pure-button pure-button-primary">返回</a>    
	        </fieldset>
	    </div>
	</body>
</html>