<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="insertForm" action="insert" method="post">
	<div>
		<h3>도서 등록</h3>
	</div>
	<table>
		<tr>
			<th>도서 번호</th>
			<td><input type="number" name="bookNo" value="${no }" readonly></td>
			<!-- 값을 넘겨주므로 value -->
		</tr>
		<tr>
			<th>도서명</th>
			<td><input type="text" name="bookName"></td>
		</tr>
		<tr>
			<th>도서표지</th>
			<td><input type="text" name="bookCovering"></td>
		</tr>
		<tr>
			<th>출판일자</th>
			<td><input type="date" name="bookDate"></td>
		</tr>
		<tr>
			<th>금액</th>
			<td><input type="number" name="bookPrice"></td>
		</tr>
		<tr>
			<th>출판사</th>
			<td><input type="text" name="bookPublisher"></td>
		</tr>
		<tr>
			<th>도서소개</th>
			<td><textarea name="bookInfo"></textarea></td>
		</tr>
	</table>
	<button type="submit">등록</button>
	<button type="button">조회</button>
	</form>
	
	<script type="text/javascript">
	
	<script type="text/javascript">
	$(document).ready(function(){
		$('button[type="submit"]').click(formOption);
		$('button:contains("조회")').click(function(){
			location.href='list'; //상대경로로 보내버리기.
		})
	});
	
	function formOption(){
		let bookName = $('input[name="bookName"]');
		let bookPublisher = $('input[name="bookPublisher"]');
		let bookInfo = $('textarea[name="bookInfo"]');
		
		if(bookName.val() == ""){ // 공백일 시
			alert("제목이 입력되지 않았습니다.");
			bookName.focus();
			return false;
		}
		
		if(bookPublisher.val() == ""){ // 공백일 시
			alert("작성자가 입력되지 않았습니다.");
			bookPublisher.focus();
			return false;
		}
		
		if(bookInfo.val() == ""){ // 공백일 시
			alert("내용이 입력되지 않았습니다.");
			bookInfo.focus();
			return false;
		}
		return true;
		
		$('#insertForm').submit();
		
	}
	</script>
	</script>
	
</body>
</html>