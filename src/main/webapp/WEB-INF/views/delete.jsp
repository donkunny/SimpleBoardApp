<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
	<title>Donkunny's Bulletin Board</title>
</head>
<body>
	<form name="deleteForm" action="<c:url value="/delete" />" method="post"> 
		<input name="seq" value="${seq}">
		비밀번호<input name="pwd" />
		<input type="submit">
		<a href="<c:url value="/read/${seq}" />">취소</a>
	</form>
	<div>${msg}</div>
</body>
</html>