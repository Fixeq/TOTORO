<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <style type="text/css" media="screen">
    
.doHyeon{
	font-family: 'Do Hyeon', sans-serif;
}

.jua{
font-family: 'Jua', sans-serif;
}
    
        .s-styles { 
            background: #f2f2f2;
            padding-top: 12rem;
            padding-bottom: 12rem;
        }

        .s-styles .section-intro h1 {
            margin-top: 0;
        }
     </style> 

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<section class="s-content">
	<table id = "myBetTable">
		<thead class="doHyeon">
			<tr>
					<td class="text-center" >게임번호</td>
					<td class="text-center">구매일시</td>
					<td class="text-center" >구매금액</td>
					<td class="text-center">상태</td>
			</tr>
		</thead>
		<tbody class="jua">
			<c:choose>
				<c:when test="${list.size()>0}">
					<c:forEach items="${list}" var="myBetVO">
								<tr id = "${myBetVO.betSeq}">
									<td class="text-center" width="25%"><c:out value="${myBetVO.betSeq}"></c:out></td>
									<td class="text-center" width="25%"><c:out value="${myBetVO.betDate}"></c:out></td>
									<td class="text-center" width="25%"><c:out value="${myBetVO.betCash}"></c:out></td>
									<td class="text-center" width="25%"><c:out value="${myBetVO.betResultString}"></c:out></td>
									<tr id = "${myBetVO.betSeq}">
										
								</tr>
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
		alert("betHistory112");
	});
	
	$("#myBetTable>tbody").on("click","tr",function(){
		var tr = $(this);
		var td = tr.children();
		var ajgameSeq = td.eq(0).text();
		alert("gameSeq : "+ajgameSeq);
		
		var itr = tr.attr('id');
		console.log("itr: "+itr);
		
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
            	
            	
            	for(var i = 0 ; i <myson.length;i++){
    				var tmpHtml = "";
            		tmpHtml2 = "<tr><td>"+myson[i].getBetSeq+"</td><td>"+myson[i].gameSeq+"</td><td>"+myson[i].getGameHome+"</td><td>"+myson[i].getGameAway+"</td><td>"+myson[i].getGameHp+"</td><td>"+myson[i].getGameDp+"</td><td>"+myson[i].getGameAp+"</td><td>"+myson[i].getBetChoice+"</td><td>"+myson[i].getGameResult+"</td></tr>";

            		$("#"+itr).after(tmpHtml2);
            	
            	}

            	
            	
            	
        		tmpHtml = "<tr><th>betSeq</th><th>gameSeq</th><th>gameHome</th><th>gameAway</th><th>gameHp</th><th>gameDp</th><th>gameAp</th><th>betChoice</th><th>gameResult</th></tr>";
        		$("#"+itr).after(tmpHtml);

            	
            	
            	

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