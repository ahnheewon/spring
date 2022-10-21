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
	
	
	<form id="insertForm" action="insert" method="post" onsubmit="return formOption()">
	<!-- 꼭 post방식 // get방식으로 하면 새로고침하는 수준. -->
	<div>
		<h3>게시글 등록</h3>
	</div>
	<table>
		<tr>
			<th>번호</th>
			<td><input type="number" name="bno" value="${no }" readonly></td>
			<!-- 값을 넘겨주므로 value -->
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="contents"></textarea></td>
		</tr>
			<tr>
			<th>첨부이미지</th>
			<td><input type="text" name="image"></td>
		</tr>
	</table>
	<button type="submit">등록</button>
	<button type="button">목록</button>
	</form>
	
	<script type="text/javascript">
	$(document).ready(function(){
		$('button[type="submit"]').click(formOption);
		$('button:contains("목록")').click(function(){
			location.href='list'; //상대경로로 보내버리기.
		})
	});
	
	function formOption(){
		let title = $('input[name="title"]');
		let writer = $('input[name="writer"]');
		let contents = $('textarea[name="contents"]');
		
		if(title.val() == ""){ // 공백일 시
			alert("제목이 입력되지 않았습니다.");
			title.focus();
			return false;
		}
		
		if(writer.val() == ""){ // 공백일 시
			alert("작성자가 입력되지 않았습니다.");
			writer.focus();
			return false;
		}
		
		if(contents.val() == ""){ // 공백일 시
			alert("내용이 입력되지 않았습니다.");
			contents.focus();
			return false;
		}
		return true;
		
		$('#insertForm').submit();
		
	}
	</script>
	
</body>
</html>