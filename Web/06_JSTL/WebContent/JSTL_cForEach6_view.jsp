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
<%-- status : index를 가져올 수 있음
	index는 0부터, count는 1부터
 --%>
<c:forEach items="${arr}" var="menu" varStatus="status">
	<li>${status.index} ${status.count} ${menu}</li>
</c:forEach>
</body>
</html>