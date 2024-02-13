<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Member mem = (Member) request.getAttribute("member");
	%>
	<h1><%=mem.getName()%>님의 회원 정보
	</h1>
	<ul>
		<li>아이디 : <%= mem.getId() %> </li>
		<li>비밀번호 : <%= mem.getPassword() %> </li>
		<li>이름 : <%= mem.getName() %> </li>
	</ul>
</body>
</html>