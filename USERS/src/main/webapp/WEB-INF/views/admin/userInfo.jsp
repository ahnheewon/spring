<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %> 

	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, tr, th, td {
border: 1px solid black;
}
</style>
</head>
<body>

	<form action="userUpdate" method="post">
	<table>
		<tr>
			<th>아이디</th>
			<td><input type="number" name="userId" value="${userInfo.employeeId }" readonly></td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${userInfo.userName }</td>
		</tr>
		<tr>
			<th>가입일</th>
			<td><fmt:formatDate value="${userInfo.userDate }" pattern="yyyy년MM월dd일"/> </td>
		</tr>
		<tr>
			<th>연락처</th>
			<td>${userInfo.userPhone }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${userInfo.userEmail }</td>
		</tr>
	</table>
	
	<button type="submit">회원 수정</button>
	</form>

<script type="text/javascript">
</script>

</body>
</html>