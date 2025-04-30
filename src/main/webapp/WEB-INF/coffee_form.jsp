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
	    <div class="form-container">
	        <h2>咖啡類型規則表格</h2>
	        <table class="pure-table">
			    <thead>
			        <tr>
			            <th>牛奶與咖啡比例</th>
			            <th>咖啡類型</th>
			            <th>描述</th>			            
			        </tr>
			    </thead>
			    <tbody>
			        <tr>
			            <td>牛奶>=3*咖啡</td>
			            <td>濃郁的拿鐵</td>
			            <td>牛奶的比例遠高於咖啡，味道偏向牛奶。</td>			            
			        </tr>
			        <tr>
			            <td>牛奶>=1.5*咖啡</td>
			            <td>平衡的拿鐵咖啡</td>
			            <td>牛奶與咖啡的比例較為平衡，風味溫和。</td>			           
			        </tr>
			        <tr>
			            <td>牛奶==咖啡</td>
			            <td>標準卡布奇諾</td>
			            <td>牛奶與咖啡的比例恰到好處，典型的卡布奇諾。</td>			            
			        </tr>
			        <tr>
			            <td>咖啡>=3*牛奶</td>
			            <td>濃縮咖啡</td>
			            <td>咖啡的比例遠高於牛奶，口感濃烈，偏向純咖啡。</td>			           
			        </tr>
			        <tr>
			            <td>其他情況</td>
			            <td>普通咖啡</td>
			            <td>牛奶與咖啡的比例較為普通，適合日常飲用。</td>			           
			        </tr>
			    </tbody>
			</table>
	        <form class="pure-form pure-form-stacked" method="POST" action"/JavaWeb2"/coffeeform>
	            <fieldset>
	                <legend>Coffee Form</legend>
	                <label>請輸入牛奶毫升數:</label>
	                <input name="milk" type="text" required/>
	                <p/>
	                <label>請輸入咖啡毫升數:</label>
	                <input name="coffee" type="text" required/>              
	                       
	                <button type="submit" class="pure-form pure-form-primary">送出</button>                
	            </fieldset>
	    </div>
	</body>
</html>