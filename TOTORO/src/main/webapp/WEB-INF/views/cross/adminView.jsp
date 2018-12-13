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
					<td class="text-center">홈팀</td>
					<td class="text-center">무승부</td>
					<td class="text-right">무승부</td>
					<td class="text-center">원정팀</td>
					<td class="text-center">원정</td>
					<td class="text-center">경기시간</td>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${list.size()>0}">
					<c:forEach items="${list}" var="crossVo">
								<tr >
									<td class="text-center"><button class="btn btn--stroke full-width" id="home"><c:out value="${crossVo.gameHome}"></c:out></button></td>
									<td class="text-center"><c:out value="${crossVo.gameHp}"></c:out></td>
									<td class="text-center"><button class="btn btn--stroke full-width">무승부</button></td>
									<td class="text-right"><c:out value="${crossVo.gameDp}"></c:out></td>
									<td class="text-center"><button class="btn btn--stroke full-width"><c:out value="${crossVo.gameAway}"></c:out></button></td>
									<td class="text-center"><c:out value="${crossVo.gameAp}"></c:out></td>
									<td class="text-center"><c:out value="${crossVo.gameDate}"></c:out></td>
									<td class="btn btn--primary">결과반영</td>
								</tr id=${crossVO.gameSeq}>
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
	
	
	
	$("#betTable>tbody>tr").on("click","#home",function(){
		alert("home click!");
	});
	
</script>

</html>