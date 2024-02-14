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
<!-- request에 바인딩한 member 가져오기 -->
<% Member member = (Member) request.getAttribute("member"); %>
<h1>회원 검색 결과
	</h1>
	<ul>
		<li>아이디 : <%= member.getId() %> </li>
		<li>비밀번호 : <%= member.getPassword() %> </li>
		<li>이름 : <%= member.getName() %> </li>
	</ul>
	<a href="index.jsp">첫 페이지로 이동</a>
</body>
</html>