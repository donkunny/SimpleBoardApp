<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
	<title>Donkunny's Bulletin Board</title>
</head>
<body>
	<form:form commandName="boardVO" method="post">
		<table border="1">
			<tr>
				<th>제목</th>
				<td><input name="title"> </td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input name="content"> </td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input name="writer"> </td>
			</tr>
			<tr>
				<th><label for="password">비밀번호</label> </th>
				<td>
					<input type="password" id="pwd" name="pwd" />
					${msg}
				</td>
			</tr>
		</table>
		<div>
			<input type="submit" value="수정">
			<a href="<c:url value="/list" />">목록</a>
		</div>
	</form:form>
</body>
</html>