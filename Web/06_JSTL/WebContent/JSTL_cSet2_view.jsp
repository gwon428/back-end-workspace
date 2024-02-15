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
	<h2>cSet2에서 바인딩된 값을 찾아옴</h2>
	상품코드 : ${requestScope.CODE} <br>
	상품명 : ${requestScope.NAME} <br>
	상품가격 : ${requestScope.PRICE} <br>
</body>
</html>