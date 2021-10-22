<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>주민</th>
			<th>담당자</th>
		</tr>
		
		<c:forEach var="gogek" items="${ list }">
			<tr>
				<td>${gogek.gobun }</td>
				<td>${gogek.goname }</td>
				<td>${gogek.goaddr }</td>
				<td>${gogek.gojumin }</td>
				<td>${gogek.godam }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>