<%@page import="com.kh.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--
 <%@ import java.util.ArrayList; %>
    <%@	import com.kh.model.vo.Member;%>
  --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- search랑 매핑할 Servlet 생성 
		 search.jsp <-- 결과 보여주기
		 
		--%> 
	
	<h2>회원 조회</h2>
	<form action = "search">
		검색할 회원 이름을 입력해주세요 <br>
		<input type="text" name="name">
		<input type="submit" value="조회">
	</form>

	<h1>전체 리스트</h1>
	<%-- request.getAttribute는 반환 타입이 Object이기 때문에 강제 형 변환--%>
	<%
	ArrayList<Member> list = (ArrayList<Member>) request.getAttribute("list");
	%>
	<table border = "1">
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
	</tr>
	<% for(Member m : list) { %>
	<%-- for(int i=0; i<list.size(); i++){ --%>
	<tr>
		<td><%-- list.get(i).getId() --%> <%= m.getId() %></td>
		<td><%-- list.get(i).getPassword() --%> <%= m.getPassword() %></td>
		<td><%-- list.get(i).getName() --%> <%= m.getName() %></td>
	</tr>
	<% } %>
	</table>
	

</body>
</html>