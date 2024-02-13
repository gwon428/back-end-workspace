<!-- HTML 주석 : 화면[웹페이지 소스보기]에 보임 -->
<%-- JSP 주석 : 화면[웹페이지 소스보기]에 보이지 않음 --%>

<%--
	JSP Element
	1) 지시어 <%@ @> : 컨테이너에게 알려줄 내용 지정
					(import할 경우에도 / VO 자체로도 가져올 수 O)
	2) 스클릿틀릿 <% %> : 자바코드는 이 안에 지정 (화면단에 보이기 위해 사용 X)
	3) 출력문 <%= %> : 출력하는 내용 지정 

 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String name = (String) request.getAttribute("name"); %>
<h1><%=name %>님, 환영합니다!</h1>
</body>
</html>