<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
table, tr, th, td {
border: 1px solid black;
margin: 0px;
padding: 0px;
}
</style>
</head>
<body>


	<div id="dataList">
		<button type="button" onclick="location.href='insertForm'">사원등록</button> <!-- 단순 페이지 전환 -->
		<table>
				<thead>
					<tr>
					<th>사원번호</th>
					<th>성</th>
					<th>이름</th>
					<th>직업</th>
					<th>급여</th>
					<th>부서번호</th>
					<th>삭제</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${empInfoList}" var="empInfo"> <!-- 꺼내올 items, 담을 그릇이름 empInfo -->
						<tr  name="${empInfo.employeeId }">
						<!-- onclick="location.href='info?employeeId=${empInfo.employeeId}'" 
							이런 형식은 post방식으로 불가능. // 값을 넘기는 제일 쉬운 방식 ^^ -->
							<td>${empInfo.employeeId }</td>
							<td>${empInfo.lastName }</td>
							<td>${empInfo.firstName }</td>
							<td>${empInfo.jobId }</td>
							<td>${empInfo.salary }</td>
							<td>${empInfo.departmentId }</td>
							<td><button type="button" id="deleteBtn">직원삭제</button></td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
		
		<!-- 꼼수 -->
		<form id="input"> 
			<input type="hidden" name="employeeId">
		</form>
	</div>
	
	
	
	<script type="text/javascript">
		
		$('td #deleteBtn').click(function(){ //★★ 왜 td가 안붙으면 인식을 못하는거지?
			
			
		let empId =$(this).closest('tr').attr('name');

		//closest:JQuery -> 조상 중에(위로) 가장 가까운 태그
		console.log(empId);
	 	
	 	$.ajax({		
	 		url : 'delete/'+empId, //이렇게 안쓰면 key value로 묶임..
	 		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	 		//★★★★한글깨짐 방지 해도 안되는데 무슨이유???
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
	
</body>
</html>