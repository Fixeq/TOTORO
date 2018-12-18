<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section class="s-content">
<div class="row">
	<div class="col-ten tab-full">
	<form method="get" id="betForm" action="/totoro/cross/makeUserBet.do">
	<table id = "betTable">
		<thead>
			<tr>
					<th colspan="2" class="text-center">HOME</th>
					<th colspan="2" class="text-center">DRAW</th>
					<th colspan="2" class="text-center">AWAY</th>
					<th class="text-center">경기시간</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${list.size()>0}">
					<c:forEach items="${list}" var="crossVo">
								<tr>
<%-- 								<td class="text-center"><button class="btn btn--stroke full-width" id="${crossVo.gameHp}"><c:out value="${crossVo.gameHome}"></c:out></button></td>
									<td class="text-center"><c:out value="${crossVo.gameHp}"></c:out></td>
									<td class="text-center"><button class="btn btn--stroke full-width" id="${crossVo.gameDp}">무승부</button></td>
									<td class="text-right"><c:out value="${crossVo.gameDp}"></c:out></td>
									<td class="text-center"><button class="btn btn--stroke full-width" id="${crossVo.gameAp}"><c:out value="${crossVo.gameAway}"></c:out></button></td>
									<td class="text-center"><c:out value="${crossVo.gameAp}"></c:out></td>
									<td class="text-center"><c:out value="${crossVo.gameDate}"></c:out></td>
 --%>								
 									<td id="betSeq"></td>
	 								<td class="text-center"><input type="radio" id="${crossVo.gameHp}" name="${crossVo.gameSeq}" value="1" onclick="clickGet(this)"> <c:out value="${crossVo.gameHome}"></c:out></td>
									<td class="text-center"><c:out value="${crossVo.gameHp}"></c:out></td>
									<td class="text-center"><input type="radio" id="${crossVo.gameDp}" name="${crossVo.gameSeq}" value="2" onclick="clickGet(this)">무승부</td>
									<td class="text-center"><c:out value="${crossVo.gameDp}"></c:out></td>
									<td class="text-center"><input type="radio" id="${crossVo.gameAp}" name="${crossVo.gameSeq}" value="3" onclick="clickGet(this)"><c:out value="${crossVo.gameAway}"></c:out></td>
									<td class="text-center"><c:out value="${crossVo.gameAp}"></c:out></td>
									<td class="text-center"><c:out value="${crossVo.gameDate}"></c:out></td>
								
 								</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="99">진행중인 게임이 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
				<input type="submit" value="베팅하기">
		</tbody>
	</table>
		</div>
	
		<div class="col-two tab-full">
			구매내역확인
			<table>
				<thead>
					<th>NO</th>
					<th>CHOICE</th>
					<th>BETTING</th>
				</thead>
				<tbody id="betCheck">
					<tr id="totalBetCount">
						<script>
							var first = 1;
						</script>
					</tr>
					<tr id="sumPoint">
						<tr>
							<td>return : </td><td id="sum"></td>
						</tr>
					</tr>
					<tr><td><h4>Money</h4></td> <td><input type="text" id="money" name="money"></td></tr>
					
				</tbody>
			</table>
			<input type="submit" value="betting">
		</div>
</div>
	</form>
</section> <!-- s-content -->
</body>

<script>
	var varGameSeq = new Array();
	var finalNum = 1;
</script>

<script type="text/javascript">
	$(document).ready(function(){   
		alert("cross777");
		
		$("#money").keyup(function(){
			var t1 = $("#money").val();
			console.log(t1);
			t1 = t1 * first;
			
			$("#sum").text(t1);
		});
	});
	
	function clickGet(a){
		
		varName = a.name;
		varId = a.id;
		console.log(varName);
		console.log("varId = " + varId);
		
		varGameSeq.push(varName);
		console.log("varGameSeq : " + varGameSeq);
		console.log("val[] : " + varGameSeq[0]);
		console.log("val[] : " + varGameSeq[1]);
		console.log("length : " + varGameSeq.length);
		
		finalNum = finalNum * varId ;

		console.log("finalNum : " + finalNum);
		
/* 		first = first * radioPercent;

		
		console.log(first);
 		
 */		$("#totalBetCount").append("<tr><td>"+varName+"</td><td>"+varId+"</td><td>"+finalNum+"</td></tr>");
 		$("#sumPoint").append("<tr><td>"+finalNum +"</td></tr>");
		
 	}
	
	$("#betForm").on("submit",function(){
		for(var i = 0 ; i < varGameSeq.length;i++){

			$("#betSeq").append("<tr><td><input type=\"hidden\" name=\"varSeq\" value=\""+varGameSeq[i]+"\"></td></tr>");
		}
		$("#betSeq").append("<tr><td><input type=\"hidden\" name=\"finalbetPercent\" value=\""+finalNum+"\"></td></tr>");
	});

</script>

</html>