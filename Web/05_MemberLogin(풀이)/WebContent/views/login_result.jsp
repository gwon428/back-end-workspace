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
	Member member = (Member) session.getAttribute("member");
	if (member != null) {
	%>

	<h1>로그인 정보</h1>
	<ul>
		<li>아이디 : <%=member.getId()%>
		</li>
		<li>비밀번호 : <%=member.getPassword()%>
		</li>
		<li>이름 : <%=member.getName()%>
		</li>
	</ul>
	<a href="/index.jsp">첫 페이지로 이동</a>
	<%
	} else {
	%>
	<h2>로그인 실패..! 다시 로그인 해주세요</h2>
	<a href="login.html">첫 페이지로 이동</a>
	<%
	}
	%>
</body>
</html>