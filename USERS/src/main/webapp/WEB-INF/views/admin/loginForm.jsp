<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#frm {
margin-left : 600px;
}
</style>
</head>
<body>
	<form id="frm" action="insert" method="post">
	
		<div>
			<label for="employeeId">아이디</label>
			<input type="text" id="userId" name="userId">
		</div>
		
		<div>
			<label for="employeeId">패스워드</label>
			<input type="password" id="userPassword" name="userPassword">
		</div>
		
		<div>
			<button onclick="login()">로그인</button>
			<button type="reset">취소</button>
		</div>
	
	</form>
</body>

<script type="text/javascript">
function login() {
	if(document.getElementById('userId')=='admin'){
		if(document.getElementById('userpassword')=='admin')
			document.getElementById('frm').value==submit
	}
}

</script>

</html>