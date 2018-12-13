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

	<table id = "betTable">
		<thead>
			<tr>
					<td class="text-center">홈팀</td>
					<td class="text-center">홈팀수</td>
					<td class="text-center">원정팀</td>
					<td class="text-center">원정점수</td>
					<td class="text-center">경기시간</td>
					<td class="text-center">종료여부</td>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${noList.size()>0}">
					<c:forEach items="${noList}" var="noVo">
								<tr id="${crossVO.gameSeq}">
									<td class="text-center"><button class="btn btn--stroke full-width"><c:out value="${noVo.gameHome}"></c:out></button></td>
									<td class="text-center"><input type="text" name="homeScore"></td>
									<td class="text-center"><button class="btn btn--stroke full-width"><c:out value="${noVo.gameAway}"></c:out></button></td>
									<td class="text-center"><input type="text" name="awayScore"></td>
									<td class="text-center"><c:out value="${noVo.gameDate}"></c:out></td>
									<td class="text-center"><input class="btn btn--primary" type="submit" value="마감"></td>
								</tr>
					</c:forEach>					
				</c:when>
			
			</c:choose>
			
			
			<c:choose>
				<c:when test="${yesList.size()>0}">
					<c:forEach items="${yesList}" var="yesVo">
								<tr id="${crossVO.gameSeq}">
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

</body>

<script type="text/javascript">
	$(document).ready(function(){   
		alert("cross");
	});
	
	
	$(".decideWteamBtn").on("click",function(){
		var parent = $(this).parent();
		
		var tr = $(parent).parent();
		
		tr.after('<tr><td colspan=\"2\">홈팀 점수</td><td colspan=\"2\"><input type=\"text\"/></td><td colspan=\"2\">원정팀 점수</td><td><input type=\"text\"/></td><td><button class=\"endData\">완료</button></td></tr>'); 
	});
	
	$("#endData").on("click",function(){
		alert("endData");
	});

</script>

</html>