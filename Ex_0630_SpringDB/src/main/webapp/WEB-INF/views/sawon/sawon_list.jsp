<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>직책</th>
			<th>급여</th>
		</tr>
		
		<c:forEach var="sawon" items="${ list }">
			<tr>
				<td>${ sawon.sabun }</td>
				<td>${ sawon.saname }</td>
				<td>${ sawon.sajob }</td>
				<td>${ sawon.sapay }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>





















