<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- html 형식 없어도 됨 -->

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">  
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath }/freeBoard/list">게시판 조회</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath }/freeBoard/insert">게시판 등록</a>
      </ul>
    </div>
  </div>
</nav>