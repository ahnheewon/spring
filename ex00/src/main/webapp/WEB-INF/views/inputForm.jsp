<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<form action="users" method="post">
	<input type="text" name="name">
	<input type="number" name="age">
	<button type="submit">전송</button>
	</form>
	
	<p>리스트로 처리</p>
	<form action="userList">
	<input type="text" name="list[0].name">
	<input type="number" name="list[0].age">
	<input type="text" name="list[1].name">
	<input type="number" name="list[1].age">
	<button type="submit">전송</button>
	</form>
	<br>
	<button onclick="javascript:ajaxUserList();">ajax</button>
	
	<script>
		function ajaxUserList() {
			let data = [
				{ "name" : "김윤지", "age" : 29 },
				{ "name" : "강석열", "age" : 33 }
			]
			
			$.ajax({
				
				url :'userList',
				type :'post', /* json 타입은 get으로 넘길 수 없다. */
				contentType : 'application/json', // application/이 붙어야한다
				data : JSON.stringify(data),
				
				success : function(data){
					console.log(data);
				},
				
				error : function(reject){
					console.log(reject);
					}
			})
		}
	</script>
</body>
</html>