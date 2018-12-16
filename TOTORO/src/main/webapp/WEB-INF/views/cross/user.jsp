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
									<td class="text-center"><input type="radio" id="${crossVo.gameHome}" name="${crossVo.gameSeq}" value="${crossVo.gameHp}" onclick="clickGet(this)"><c:out value="${crossVo.gameHome}"></c:out></td>
									<td class="text-center"><c:out value="${crossVo.gameHp}"></c:out></td>
									<td class="text-center"><input type="radio" id="${crossVo.gameDp}" name="${crossVo.gameSeq}" value="${crossVo.gameDp}" onclick="clickGet(this)">무승부</td>
									<td class="text-center"><c:out value="${crossVo.gameDp}"></c:out></td>
									<td class="text-center"><input type="radio" id="${crossVo.gameAway}" name="${crossVo.gameSeq}" value="${crossVo.gameAp}" onclick="clickGet(this)"><c:out value="${crossVo.gameAway}"></c:out></td>
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
					<tr id="totalBetCount"></tr>
				</tbody>
			</table>
		</div>
</div>
	
</section> <!-- s-content -->
</body>

<script type="text/javascript">
	$(document).ready(function(){   
		alert("cross1");
	});
	
	function clickGet(a){
		varName = a.name;
		varId = a.id;
		console.log(varName);
		console.log(varId);
		
		var sum = 1000;
		
		var radioValue = $("input[name='"+varName+"']:checked").val();
		console.log(radioValue);
		$("#betCheck").append("<tr><td>"+varName+"</td><td>"+varId+"</td><td>"+radioValue+"</td></tr>");
		sum = sum * radioValue;
		$("#totalBetCount").append("<tr><td>"+sum +"</td></tr>")
	}

</script>

</html>