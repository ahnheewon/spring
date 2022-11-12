<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
</head>
<body>

<h1>로그인 페이지</h1>
${param.error}

<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
  로그인 에러입니다.<br>
  예외 타입：${SPRING_SECURITY_LAST_EXCEPTION.getClass().name}<br>
  메시지：${SPRING_SECURITY_LAST_EXCEPTION.message}<br>
  <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
</c:if>

<form action="login" method="post">
<!-- 앞에 / 적으면 절대경로로 변경되어 contextPath가 빠지게 되므로 오류가 난다.
     ${pageContext.request.contextPath}/login 으로 표기합시다. -->
     
	<sec:csrfInput/>
<!--  밑에 적은 대로 input 태그로도 똑같이 표현 가능한데 <sec:csrfInput/>가 짧아서 더 편리함.  -->
	<%-- <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/> --%>
  <dl>
    <dt>
      로그인 ID
    </dt>
    <dd>
      <input type="text" name="userId">
    </dd>
    <dt>
      패스워드
    </dt>
    <dd>
      <input type="password" name="password">
    </dd>
  </dl>
  <button>로그인</button>
</form>
</body>
</html>
