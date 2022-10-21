<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<table>
	
	<tr>
	<th>번호</th>
	<td>${board.bno }</td>
	</tr>
	
	<tr>
	<th>제목</th>
	<td>${board.title }</td>
	</tr>
	
	<tr>
	<th>작성자</th>
	<td>${board.writer }</td>
	</tr>
	
	<tr>
	<th>내용</th>
	<td><textarea rows="3" cols="2" style="width:100px;" readonly>${board.contents }</textarea></td>
	</tr>
	
	<tr>
	<th>첨부파일</th>
	
	<%--방법1) <td><img alt="이미지" src="${pageContext.request.contextPath }/resources/images/${board.image }"></td> --%>
	<!-- 방법2) --><td><img src="<c:url value='/resources/images/${board.image }'/>"></td>
	<!-- ☆☆☆☆☆ ${pageContext.request.contextPath } 프로젝트의 contextPath를 불러온다. -->
	</tr>
	
	<tr>
	<th>작성일자</th>
	<td><fmt:formatDate value="${board.regdate }" pattern="yyyy/MM/dd"/></td>
	</tr>
	
	
	</table>
</body>
</html>