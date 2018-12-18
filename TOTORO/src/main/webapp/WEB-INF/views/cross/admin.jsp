<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon&amp;subset=korean" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Jua&amp;subset=korean" rel="stylesheet">
<style>
.doHyeon{
	font-family: 'Do Hyeon', sans-serif;
}

.jua{
font-family: 'Jua', sans-serif;
}

</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section class="s-content">

	<table id = "betTable">
		<thead class="doHyeon">
			<tr>
					<th class="text-center">홈팀</th>
					<th class="text-center">홈팀수</th>
					<th class="text-center">원정팀</th>
					<th class="text-center">원정점수</th>
					<th class="text-center">경기시간</th>
					<th class="text-center">종료여부</th>
			</tr>
		</thead>
		<tbody class="jua">
			<c:choose>
				<c:when test="${noList.size()>0}">
				<script>
					var list =[];
				</script>
					<c:forEach items="${noList}" var="noVo">	
						<form id="${noVo.gameSeq}"  action="/totoro/cross/close.do"  method="post" >
								<tr>
									<td class="text-center"><button class="btn btn--stroke full-width"><c:out value="${noVo.gameHome}"></c:out></button></td>
									<td class="text-center"><input type="text" name="homeScore" ></td>
									<td class="text-center"><button class="btn btn--stroke full-width"><c:out value="${noVo.gameAway}"></c:out></button></td>
									<td class="text-center"><input type="text" name="awayScore"></td>
									<td class="text-center"><c:out value="${noVo.gameDate}"></c:out></td>
									<td><input id="${noVo.gameSeq}" class="btn btn--primary full-width" type="button" value="마감" onclick="closeCross(this)"/><input type="hidden" name= "gameSeq" value="${noVo.gameSeq}"></td>
								</tr>
						</form>
					</c:forEach>					
				</c:when>
			
			</c:choose>
			
			
			<c:choose>
				<c:when test="${yesList.size()>0}">
					<c:forEach items="${yesList}" var="yesVo">
								<tr>
									<td class="text-center"><button class="btn btn--stroke full-width"><c:out value="${yesVo.gameHome}"></c:out></button></td>
									<td class="text-center"><c:out value="${yesVo.gameHs}"></c:out></td>
									<td class="text-center"><button class="btn btn--stroke full-width"><c:out value="${yesVo.gameAway}"></c:out></button></td>
									<td class="text-center"><c:out value="${yesVo.gameAs}"></c:out></td>
									<td class="text-center"><c:out value="${yesVo.gameDate}"></c:out></td>
									<td class="text-center">경기종료</td>
								</tr>
					</c:forEach>					
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="99">진행중인 게임이 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
			
		</tbody>
	</table>
	<form action="/totoro/cross/makeGame.do" method="get">
		<div align="right">
			<input class="btn btn--primary full-width" type="submit" value="경기생성"> 
		</div>
	</form>
</section> <!-- s-content -->
s
</body>

<script type="text/javascript">
	$(document).ready(function(){   
		alert("6");
	});
	
	function closeCross(e){
		var td = $(e).parent();
		var tr = $(td).parent();

		console.log(tr);
		
		var varNum = $(tr).find("td").eq(1).find(":input:text").val();
		console.log("varNum : "+varNum);
		
		var varNum2 = $(tr).find("td").eq(3).find(":input:text").val();
		console.log("varNum2 : "+varNum2);
		
		var varId = $(tr).find("td").eq(5).find(":input:button").attr('id');
		console.log("varId : "+varId);

		if(varNum =="" ||varNum2 ==""){
			alert("공백은 허용하지 않습니다");
			return ;
		}
		
		if(!isNaN(varNum) && !isNaN(varNum2)){
			console.log("varNum: " + varNum);
			console.log("varNum2: " + varNum2);
			
			console.log("숫자입니다.");

		}else{
			console.log("varNum: " + varNum);
			console.log("varNum2: " + varNum2);

			alert("숫자를 입력하세요.");
			return;
		}
		
		if((varNum*10)%10==0 && (varNum2*10)%10==0 ){
			console.log("정수입니다.");
		}else{
			alert("정수를 입력하세요");
			return;
		}
		
		if((varNum>=0) && (varNum2>=0)){
			console.log("양수입니다.");
			
		}else{
			alert("양수를 입력하세요");
			return ;
		}
		
		console.log("로직이 정상수행되었습니다.");
		
		$( "#"+varId ).submit();
	};	
	

</script>

</html>