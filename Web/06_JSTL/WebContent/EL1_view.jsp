<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1~50까지의 합산 결과 값 1) 기존 방식</h2>
	<p>request 값 : <%= request.getAttribute("result") %></p>
	<p>session값  : <%= session.getAttribute("result") %></p>
	
	<%-- 
		EL 문법
		- Attribute에 바인딩된 값을 찾아오는 로직을 태그로 바꾼 기술
		- 객체를 바인딩한 ${이름}이 사용된다.
		- [Scope를 생략하면 request 값이 나온다.]
	 --%>
	<h2>1~50까지의 합산 결과 값 2) EL 방식</h2>
				<%-- 해당 영역에 있는 값을 attribute로 가져오는? --%>
	<p>request 값 : ${requestScope.result}</p>
	<p>session 값 : ${sessionScope.result }</p>
	<%-- Scope를 생략하면 request 값이 나옴. --%>
	<p>scope 생략 시 : ${result}</p>
</body>
</html>