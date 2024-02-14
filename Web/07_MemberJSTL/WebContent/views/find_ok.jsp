<%@page import="model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 정보
	</h1>
	<ul>
		<li>아이디 : ${member.id} </li>
		<li>비밀번호 : ${member.password} </li>
		<li>이름 : ${member.name} </li>
	</ul>
	<a href="index.jsp">첫 페이지로 이동</a>
</body>
</html>