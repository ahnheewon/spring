<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<body>
	<form id="insertForm" action="insert" method="post" onsubmit="return formOption()">
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
	
	<script>
	
	// 자바스크립트는 위에서 아래로 순서대로!
	
	function formOption(){
		// 1) 도서명 입력여부
		let bookName = $('input[name="bookName"]');
		
		if(bookName.val() == ''){ // 공백일 시
			alert("도서명이 입력되지 않았습니다.");
			bookName.focus();
			return false; // 값을 전달하지 않는다!
		}
		
		let bookPrice = $('input[name="bookPrice"]'); //not null이라 꼭 적어주기.
		
		if(bookPrice.val() == ""){ // 공백일 시
			alert("금액이 입력되지 않았습니다.");
			bookPrice.focus();
			return false;
		}
		
		let bookPublisher = $('input[name="bookPublisher"]');		
		
		if(bookPublisher.val() == ""){ // 공백일 시
			alert("출판사명이 입력되지 않았습니다.");
			bookPublisher.focus();
			return false;
		}
		
		let bookInfo = $('textarea[name="bookInfo"]');
		
		if(bookInfo.val() == ""){ // 공백일 시
			alert("내용이 입력되지 않았습니다.");
			bookInfo.focus();
			return false;
		}
		
		//alert('도서 등록이 완료되었습니다.');	
		return true; // 값을 전달해준다.
		$('#insertForm').submit();
		
	}

	
	$(document).ready(function(){
		$('button[type="submit"]').click(formOption);
		$('button:contains("조회")').click(function(){
			location.href='list'; //상대경로로 보내버리기.
		})
	});
	</script>

	
</body>
</html>