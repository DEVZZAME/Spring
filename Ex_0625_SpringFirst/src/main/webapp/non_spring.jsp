<%@page import="vo.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	PersonVO p1 = new PersonVO();
	p1.setName("일길동");
	p1.setAge(20);
	p1.setTel("010-111-1111");
	
	request.setAttribute("p1", p1);
	
	PersonVO p2 = new PersonVO();
	p2.setName("어렵길동");
	p2.setAge(30);
	p2.setTel("017-222-2222");
	
	request.setAttribute("p2", p2);
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>${p1.name }/${p1.age }/${p1.tel }</p>
	<p>${p2.name }/${p2.age }/${p2.tel }</p>
</body>
</html>