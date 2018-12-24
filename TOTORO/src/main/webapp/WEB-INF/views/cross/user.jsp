<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.totoro.code.CodeVO"%>
<%@page import="java.util.List"%>
<%@page import="com.sist.totoro.common.StringUtil"%>
<%@page import="com.sist.totoro.common.SearchVO"%>
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
<%
	String page_size ="10";//page_size
	String page_num  ="1";//page_num
	
	int totalCnt      =0;
	int bottomCount   =10;

	SearchVO vo =  (SearchVO)request.getAttribute("param");
	if(null !=vo ){
		page_size   = StringUtil.nvl(vo.getPage_size(), "10"); 
		page_num   = StringUtil.nvl(vo.getPage_num(), "1"); 
	}else{ 
		page_size = StringUtil.nvl(request.getParameter("page_size"), "10");
		page_num = StringUtil.nvl(request.getParameter("page_num"), "1");
	}
	
	int oPageSize = Integer.parseInt(page_size);
	int oPageNum  = Integer.parseInt(page_num);
	
	String iTotalCnt = (null == request.getAttribute("total_cnt"))?"0":request.getAttribute("total_cnt").toString();
	totalCnt = Integer.parseInt(iTotalCnt);

	List<CodeVO> code_page = (null == request.getAttribute("code_page"))?new ArrayList<CodeVO>():(List<CodeVO>)request.getAttribute("code_page");

%>

<%
	int myPoint = (Integer)session.getAttribute("userPoint");
%>
<script>
	var myPoint = <%=myPoint%>
</script>

<section class="s-content">
	<div class="col-five">
        <form  name="frm" id="frm" method="get" class="form-inline">
     		<input type="hidden" name="page_num" id="page_num">
			<%=StringUtil.makeSelectBox(code_page, page_size, "page_size", false) %>
			<button onclick="javascript:doSearch();">조회</button>
		</form>
	</div>
</section>

<section class="s-content">
<div class="row">
	<div class="col-twelve  tab-full">
	<form method="get" id="betForm" action="/totoro/cross/makeUserBet.do">
		<table id = "betTable">
			<thead class="doHyeon">
				<tr>
						<th class="text-center">NO</th>
						<th colspan="2" class="text-center">HOME</th>
						<th colspan="2" class="text-center">DRAW</th>
						<th colspan="2" class="text-center">AWAY</th>
						<th colspan="2" class="text-center">경기시간</th>
				</tr>
			</thead>
			<tbody class="jua">
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
		 								<td class="text-center"> <c:out value="${crossVo.no}"></c:out></td>
		 								<td class="text-center"><input type="radio" name="${crossVo.gameSeq}" value="1" onclick="clickGet(this)"> <c:out value="${crossVo.gameHome}"></c:out></td>
										<td class="text-center"><c:out value="${crossVo.gameHp}"></c:out></td>
										<td class="text-center"><input type="radio"  name="${crossVo.gameSeq}" value="2" onclick="clickGet(this)">무승부</td>
										<td class="text-center"><c:out value="${crossVo.gameDp}"></c:out></td>
										<td class="text-center"><input type="radio"  name="${crossVo.gameSeq}" value="3" onclick="clickGet(this)"><c:out value="${crossVo.gameAway}"></c:out></td>
										<td class="text-center"><c:out value="${crossVo.gameAp}"></c:out></td>
										<td class="text-center"><c:out value="${crossVo.gameDate}"></c:out></td>
	 									<td id="betSeq"></td>
									
	 								</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr class="jua">
							<td colspan="99">진행중인 게임이 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
	
	<div class="col-seven tab-full doHyeon">
		구매내역확인
		<table class="doHyeon">
			<thead class="doHyeon">
				<th>NO</th>
				<th>CHOICE</th>
				<th>BETTING</th>
			</thead>
			<tbody id="betCheck" class="jua">
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
				<tr><td><h4 class="jua">Money</h4></td> <td><input type="text" id="money" name="money" class="jua"></td></tr>
				
			</tbody>
		</table>
		<input type="submit" value="betting">
	</div>
	
</div>
	</form>
	
		<div class="form-inline text-center">
			<%=StringUtil.renderPaging(totalCnt, oPageNum, oPageSize, bottomCount, "view.do", "search_page") %>
		</div>
	
</section> <!-- s-content -->
</body>

<script>
	var varGameSeq = new Array();
	var finalNum = 1;
	var t1 = 0;
</script>

<script type="text/javascript">
	$(document).ready(function(){   
		
		$("#money").keyup(function(){
			t1 = $("#money").val();
			console.log(t1);
			if(t1>myPoint){
				alert("가지고 있는 포인트보다 많은 금액입니다.");
				$("input[type=text][name=money]").val("");
				return;
			}
			$("#sum").text(t1);
		});
	});
	
    function search_page(url,page_num){
   	 alert(url+":search_page:"+page_num);
   	 var frm = document.frm;
   	 frm.page_num.value = page_num;
   	 frm.action = url;
   	 frm.submit();
    }

	
    function doSearch(){
		var frm = document.frm;
		frm.page_num.value =1;
		frm.action = "view.do";
		frm.submit();
    }

	
	function clickGet(a){
		
		varName = a.name;
		varId = a.id;
		console.log(varName);
		console.log("varId = " + varId);
		
		console.log("a : "+a);
		
		varGameSeq.push(varName);
		for(var i = 0 ; i < varGameSeq.length-1; i++){
			//추가시킨 상태를 확인해서 중복되는게 있으면 뒤에 팝시킴
			if(varGameSeq[i]==varName){
				delete varGameSeq[i];
			}
		}
		
		console.log("varGameSeq : " + varGameSeq);
		console.log("val[] : " + varGameSeq[0]);
		console.log("val[] : " + varGameSeq[1]);
		console.log("length : " + varGameSeq.length);
		
		finalNum = finalNum * varId ;

		console.log("finalNum : " + finalNum);
		
/* 		first = first * radioPercent;

		
		console.log(first);
 		
 */		/* $("#totalBetCount").append("<tr><td>"+varName+"</td><td>"+varId+"</td><td>"+finalNum+"</td></tr>");
 		$("#sumPoint").append("<tr><td>"+finalNum +"</td></tr>"); */
		
 	}
	
	$("#betForm").on("submit",function(){
		t1 = $("#money").val();
		if(t1<1){
			alert("올바르지 않습니다.");
			return false;
		}

		
		for(var i = 0 ; i < varGameSeq.length;i++){
			$("#betSeq").append("<tr><td><input type=\"hidden\" name=\"varSeq\" value=\""+varGameSeq[i]+"\"></td></tr>");
			
		}
		$("#betSeq").append("<tr><td><input type=\"hidden\" name=\"finalbetPercent\" value=\""+finalNum+"\"></td></tr>");
	});

</script>

</html>