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
              var parseData = $.parseJSON(data);
				
              alert(parseData);
              console.log(parseData);
              $("#userId").val(parseData.userId);
              $("#name").val(parseData.name);
              $("#password").val(parseData.password);
              
              $("#login").val(parseData.login);
              $("#recommend").val(parseData.recommend);
              $("#email").val(parseData.email);
              $("#userIntLevel").val(parseData.userIntLevel);
              $("#regDt").val(parseData.regDt);
              
              $("#userId").prop("disabled",true);
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