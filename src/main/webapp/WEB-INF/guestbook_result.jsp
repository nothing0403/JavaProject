<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding:20px">
	    <div>
	        <h2>訪客留言資料結果</h2>
	        <fieldset>
	            <legend>GuestBook Result</legend>
	            本次留言: ${ message }<p/> 
	            歷史留言: ${ guestbooks }<p/> 
	            <ol>
                    <c:forEach var='gb' items="${ guestbooks }">
                        <li>${ gb.message } ${ gb.date }</li>
                    </c:forEach>	            
	            </ol>
	            <p />
	            <table class="pure-table pure-table-bordered">
	                <thead>
	                    <tr>
	                        <th>No</th>
	                        <th>留言內容</th>
	                        <th>留言時間</th>
	                    </tr>
	                </thead>
	                <tbody>
	                    <c:forEach varStatus="i" var="gb" items="${ guestbooks }"> 
	                        <tr>
	                            <td>${ i.index + 1 }</td>
	                            <td>${ gb.message }</td>
	                            <td>
	                                <!-- 格式化日期 -->             
	                                <fmt:formatDate value="${ gb.date }" pattern="yyyy-MM-dd HH:mm:ss" />                             
	                            </td>
	                        </tr>
	                    </c:forEach>
	                </tbody>
	            <a href="/JavaWeb2/guestbook" class="pure-button pure-button-primary">返回</a>    
	        </fieldset>
	    </div>
	</body>
</html>