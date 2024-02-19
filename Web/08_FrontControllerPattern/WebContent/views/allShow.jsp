<%@page import="model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
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
<h1>전체 리스트</h1>
	<%-- request.getAttribute는 반환 타입이 Object이기 때문에 강제 형 변환--%>
	<%
	ArrayList<Member> list = (ArrayList<Member>) request.getAttribute("list");
	%>
	<table border = "1">
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>비밀번호</th>
	</tr>
	<c:forEach items="${list}" var="m" varStatus="status">
	<tr>
		<td>${m.id}</td>
		<td>${m.name}</td>
		<td>${m.password}</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>