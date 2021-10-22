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
	<p>과일목록</p>
	
	<c:forEach var="vo" items="${ list }"><!-- Model에 저장한 것도 requestScope에 저장됨. 따라서 requestScope.list라고 적어도 되고 list라고만 적어도 됨 -->
		${ vo }<br>
	</c:forEach>
</body>
</html>













