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
	    <form class="pure-form " method="POST" action"/JavaWeb2"/ice>
	    <fieldset>
	        <legend>選擇主餐</legend>
		    <input type="radio" name="mainDish" value="刨冰" checked>刨冰🍧(50元)<p />
		    <input type="radio" name="mainDish" value="豆花" checked>豆花🍮(40元)<p />
	    </fieldset>
	    <fieldset>
	        <legend>選擇加料(每樣10元)</legend>
	        <!-- 多選 Servlet 後台使用 req.getParamterValues("toppings") 會得到 String[] -->
	        <input type="checkbox" name="toppings" value="花生" checked>花生🥜<p />
	        <input type="checkbox" name="toppings" value="綠豆" checked>綠豆🌱<p />
	        <input type="checkbox" name="toppings" value="紅豆" checked>紅豆🍒<p />
	        <input type="checkbox" name="toppings" value="芋園" checked>芋圓🥔<p />
	        <input type="checkbox" name="toppings" value="粉圓" checked>粉圓⚪<p />
	        <input type="checkbox" name="toppings" value="煉乳" checked>煉乳🍼<p />
	    </fieldset>
	    <button type="submit" class="pure-button pure-button-primary">結帳</button>
	</body>
</html>