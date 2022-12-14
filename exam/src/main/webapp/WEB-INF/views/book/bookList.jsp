<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, tr, th, td {
border: 1px solid black;
}

td img {
width: 70px;
}

</style>
</head>

<body>
<div id="bookListForm">
<!-- 도서리스트조회 -->


		<!--<button type="button" onclick="location.href='insertBook'">도서등록</button>  단순 페이지 전환 -->
		<table>
				<thead>
					<tr>
					<th>도서번호</th>
					<th>도서명</th>
					<th>표지</th>
					<th>출판일자</th>
					<th>금액</th>
					<th>출판사</th>
					<th>도서소개</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${list}" var="books"> <!-- 꺼내올 items, 담을 그릇이름 empInfo -->
					<!-- list[0].bookNo 이런 식으로 노가다 안하려고 var="books" 쓴겁니다. -->
						<tr  name="${books.bookNo }">
						<!-- onclick="location.href='info?employeeId=${empInfo.employeeId}'" 
							이런 형식은 post방식으로 불가능. // 값을 넘기는 제일 쉬운 방식 ^^ -->
							<td>${books.bookNo }</td>
							<td>${books.bookName }</td>
							<td><img src="<c:url value='/resources/images/${books.bookCovering }'/>"></td>
							<td><fmt:formatDate value="${books.bookDate }" pattern="yyyy/MM/dd"/></td>
							<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${books.bookPrice }"/> </td>
							<td>${books.bookPublisher }</td>
							<td>${books.bookInfo }</td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
</div>

<script type="text/javascript">
let resultMsg ='${msg}';
if(resultMsg != null && resultMsg != ""){
	alert(resultMsg);
}
</script>

</body>
</html>