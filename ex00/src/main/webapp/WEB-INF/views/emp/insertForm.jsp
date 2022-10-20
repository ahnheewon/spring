<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insert" method="post">
		<div>
			<label for="employeeId">사원번호</label>
			<input type="number" id="employeeId" name="employeeId">
		</div>
		<div>
			<label for="employeeId">성</label>
			<input type="text" id="lastName" name="lastName">
		</div>
		<div>
			<label for="employeeId">이름</label>
			<input type="text" id="firstName" name="firstName">
		</div>
		<div>
			<label for="employeeId">이메일</label>
			<input type="text" id="email" name="email">
		</div>
		<div>
			<label for="employeeId">입사일</label>
			<input type="date" id="hireDate" name="hireDate">
		</div>
		<div>
			<label for="employeeId">직업</label>
			<input type="text" id="jobId" name="jobId">
		</div>
		<div>
			<label for="employeeId">급여</label>
			<input type="number" id="salary" name="salary">
		</div>
		
		<div>
			<button type="submit">등록</button>
			<button type="resert">취소</button>
		</div>
	
	
	</form>
</body>
</html>