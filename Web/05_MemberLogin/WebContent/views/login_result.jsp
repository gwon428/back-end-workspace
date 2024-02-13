<%@page import="model.vo.Member"%>
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
Member member = (Member) session.getAttribute("member"); %>
<h1><%=member.getName()%>님의 회원 정보
	</h1>
	<ul>
		<li>아이디 : <%= member.getId() %> </li>
		<li>비밀번호 : <%= member.getPassword() %> </li>
		<li>이름 : <%= member.getName() %> </li>
	</ul>
</body>
</html>