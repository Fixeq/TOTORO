<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section class="s-content">

	<table id = "myBetTable">
		<thead>
			<tr>
					<td class="text-center">게임번호</td>
					<td class="text-center">구매일시</td>
					<td class="text-center">구매금액</td>
					<td class="text-center">상태</td>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${list.size()>0}">
					<c:forEach items="${list}" var="myBetVO">
								<tr>
									<td class="text-center"><c:out value="${myBetVO.betSeq}"></c:out></td>
									<td class="text-center"><c:out value="${myBetVO.betDate}"></c:out></td>
									<td class="text-center"><c:out value="${myBetVO.betCash}"></c:out></td>
									<td class="text-center"><c:out value="${myBetVO.betResultString}"></c:out></td>
								</tr>
								<div><table id = "boardList" border = "1"></table></div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="99">베팅한 게임이 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</section> <!-- s-content -->

<script type="text/javascript">
	$(document).ready(function(){
		alert("betHistory");
	});
	
	$("#myBetTable>tbody").on("click","tr",function(){
		var tr = $(this);
		var td = tr.children();
		var ajgameSeq = td.eq(0).text();
		alert("gameSeq : "+ajgameSeq);
		
		
		//ajax 통신
        $.ajax({
            type:"POST",
            url:"do_search_byGameSeq.do",
            dataType:"html",// JSON
            data:{
            "ajgameSeq": ajgameSeq
            },	
            success: function(data){//통신이 성공적으로 이루어 졌을때 받을 함수
            	console.log(data);
            	var myson = $.parseJSON(data);//parse JSON
				
            	console.log(myson);
            	
        		tmpHtml += "<thead><tr><td>gameSeq</td><td>betSeq</td><td>betChoice</td><td>gameHome</td><td>gameAway</td><td>gameHp</td><td>gameDp</td><td>gameAp</td><td>gameResult</td></tr></thaed>";
        		$("#boardList").append(tmpHtml);

            	
            	for(var i = 0 ; i <myson.length;i++){
    				var tmpHtml = "";
            		tmpHtml2 = "<tbody><tr><td>"+myson[i].gameSeq+"</td><td>"+myson[i].getBetSeq+"</td><td>"+myson[i].getBetChoice+"</td><td>"+myson[i].getGameHome+"</td><td>"+myson[i].getGameAway+"</td><td>"+myson[i].getGameHp+"</td><td>"+myson[i].getGameDp+"</td><td>"+myson[i].getGameAp+"</td><td>"+myson[i].getGameResult+"</td></tr></tbody>";

            		$("#boardList").append(tmpHtml2);
            	
            	}

/*             	var myJSON = JSON.stringify(data);
            	console.log(myJSON);
 */            	
            	
            	/*  
            	var parseData = $.parseJSON(data);
            	alert(parseData.gameSeq);
				console.log(parseData);
            	*/
            	
            	

            	

            	
	       },
	       complete: function(data){//무조건 수행
	             
	       },
	       error: function(xhr,status,error){
             
            }
       }); //--ajax

	});
</script>


</body>
</html>