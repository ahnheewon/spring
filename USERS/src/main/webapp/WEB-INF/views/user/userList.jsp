<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
table, tr, th, td {
border: 1px solid black;

padding: 0px;
}
body #margin {
margin-left: 500px;}


</style>
</head>
<body>


	<div id="dataList" class="col">
	<div id="margin">
		<table>
				<thead>
					<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>가입일자</th>
					<th>연락처</th>
					<th>이메일</th>
		
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${userInfoList}" var="userInfo"> <!-- 꺼내올 items, 담을 그릇이름 empInfo -->
						<tr  name="${userInfo.userId }">
						<!-- onclick="location.href='info?employeeId=${empInfo.employeeId}'" 
							이런 형식은 post방식으로 불가능. // 값을 넘기는 제일 쉬운 방식 ^^ -->
							<td>${userInfo.userId }</td>
							<td>${userInfo.userName }</td>
							<td><fmt:formatDate value="${userInfo.userDate }" pattern="yyyy/MM/dd"/></td>
							<td>${userInfo.userPhone }</td>
							<td>${userInfo.userEmail }</td>

							
						</tr>
					</c:forEach>
				</tbody>
		</table>
	  </div>
		
		<!-- 꼼수 -->
		<form id="input"> 
			<input type="hidden" name="userId">
		</form>
	</div>
	
	
	
	<script type="text/javascript">
		
		$('td #deleteBtn').click(function(){ //★★ 왜 td가 안붙으면 인식을 못하는거지?
			
			
		let empId =$(this).closest('tr').attr('name');

		//closest:JQuery -> 조상 중에(위로) 가장 가까운 태그
		console.log(empId);
	 	
	 	$.ajax({		
	 		url : 'delete/'+empId, //이렇게 안쓰면 key value로 묶임..
	 		success : function(data){ //data=> return된 message	
	 			console.log(typeof data);
	 			alert(data); 
	 		},
	 		error : function(reject){
	 		console.log(reject);
	 		alert(data);
		}
			})
 		return false; // 이 밑으로 이벤트가 전달되지 않도록.
		});
	</script>
	
	
	 <script type="text/javascript">
	
	let message = '${msg}';
	if(message != null && message != '') {
	// 사원 등록할 때만 뜨도록
	alert(message); 
	}
	
	 $('#dataList td').click(function(){
		let empId =$(this).parent().attr('name');
		$('#input > input ').val(empId);
		$('#input').prop('action','info')
					.prop('method','get') // post방식할 때 이런식으로 쓰세요 
					.submit();
		return false; // 이벤트가 전달되지 않도록.
		}); 
	 
	</script>
	

	
	<script type="text/javascript">
	 /*
	 $('#dataList td').click(function(){
	 	let empId = $(this).parent().attr('name'); // prop 접근 불가
	 	
	 	$.ajax({
	 		
	 		url : 'info',
	 		data : { "employeeId" : empId},
	 		
	 		// 동기식은 데이터를 요청하고나면 그 후 대기 상태.
	 		// 성공을 했으니 반환된 값을 뷰로 읽지 않고 데이터로 반환.
	 		
	 		success : function(data){
	 			$('body').html(data);
	 		},
	 		error : function(reject){
	 		console.log(reject);
	 	}
	 	
	 	})
	 	});
	 	*/
	</script>
	
	<script type="text/javascript">
	
	/*
	
	let empList = [];
	let emp ={};
		
	<c:forEach items="${empInfoList}" var="empInfo"> <!-- 꺼내올 items, 담을 그릇이름 empInfo -->
	// jsp는 String 타입으로 값을 가져온다...
			
		emp = {				
					employeeId :'${empInfo.employeeId}',
					firstName :'${empInfo.firstName}',
					lastName :'${empInfo.lastName}',
					departmentId :'${empInfo.departmentId}',
					jobId :'${empInfo.jobId}',
					salary : '${empInfo.salary}'
												}
	
		empList.push(emp);
		
		</c:forEach>
		
		console.log(empList);
		
		$('tbody').empty(); //위에 직접 적은 내용 삭제
		
		let thTag =$('#dataList th');
		
		$(empList).each(function(idx, obj){
			
			let tr = $('<tr/>');
			
			$(tr).append($('<td/>').text(obj.employeeId));
			$(tr).append($('<td/>').text(obj.firstName));
			$(tr).append($('<td/>').text(obj.lastName));
			$(tr).append($('<td/>').text(obj.departmentId));
			$(tr).append($('<td/>').text(obj.jobId));
			$(tr).append($('<td/>').text(obj.salary));
			$('#dataList tbody').append(tr);
		});
	*/
	</script>
	
	<script type="text/javascript">
	
	let maskingFunc = {
			checkNull : function (str){
				if(typeof str == "undefined" || str == null || str == ""){
					return true;
				}
				else{
					return false;
				}
			},
			/*
			※ 이메일 마스킹
			ex1) 원본 데이터 : abcdefg12345@naver.com
				 변경 데이터 : ab**********@naver.com
			ex2) 원본 데이터 : abcdefg12345@naver.com
			     변경 데이터 : ab**********@nav******
			*/
			email : function(str){
				let originStr = str;
				let emailStr = originStr.match(/([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\.[a-zA-Z0-9._-]+)/gi);
				let strLength;
				
				if(this.checkNull(originStr) == true || this.checkNull(emailStr) == true){
					return originStr;
				}else{
					strLength = emailStr.toString().split('@')[0].length - 3;
					
					// ex1) abcdefg12345@naver.com => ab**********@naver.com
					// return originStr.toString().replace(new RegExp('.(?=.{0,' + strLength + '}@)', 'g'), '*');

					// ex2) abcdefg12345@naver.com => ab**********@nav******
					return originStr.toString().replace(new RegExp('.(?=.{0,' + strLength + '}@)', 'g'), '*').replace(/.{6}$/, "******");
				}
			},
			/* 
			※ 휴대폰 번호 마스킹
			ex1) 원본 데이터 : 01012345678, 변경 데이터 : 010****5678
			ex2) 원본 데이터 : 010-1234-5678, 변경 데이터 : 010-****-5678
			ex3) 원본 데이터 : 0111234567, 변경 데이터 : 011***4567
			ex4) 원본 데이터 : 011-123-4567, 변경 데이터 : 011-***-4567
			*/
			phone : function(str){
				let originStr = str;
				let phoneStr;
				let maskingStr;
				
				if(this.checkNull(originStr) == true){
					return originStr;
				}
				
				if (originStr.toString().split('-').length != 3)
				{ // 1) -가 없는 경우
					phoneStr = originStr.length < 11 ? originStr.match(/\d{10}/gi) : originStr.match(/\d{11}/gi);
					if(this.checkNull(phoneStr) == true){
						return originStr;
					}
					
					if(originStr.length < 11)
					{ // 1.1) 0110000000
						maskingStr = originStr.toString().replace(phoneStr, phoneStr.toString().replace(/(\d{3})(\d{3})(\d{4})/gi,'$1***$3'));
					}
					else
					{ // 1.2) 01000000000
						maskingStr = originStr.toString().replace(phoneStr, phoneStr.toString().replace(/(\d{3})(\d{4})(\d{4})/gi,'$1****$3'));
					}
				}else
				{ // 2) -가 있는 경우
					phoneStr = originStr.match(/\d{2,3}-\d{3,4}-\d{4}/gi);
					if(this.checkNull(phoneStr) == true){
						return originStr;
					}
					
					if(/-[0-9]{3}-/.test(phoneStr))
					{ // 2.1) 00-000-0000
						maskingStr = originStr.toString().replace(phoneStr, phoneStr.toString().replace(/-[0-9]{3}-/g, "-***-"));
					} else if(/-[0-9]{4}-/.test(phoneStr))
					{ // 2.2) 00-0000-0000
						maskingStr = originStr.toString().replace(phoneStr, phoneStr.toString().replace(/-[0-9]{4}-/g, "-****-"));
					}
				}
				
				return maskingStr;
			}
			
		}
	</script>
	
</body>
</html>