<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.totoro.code.CodeVO"%>
<%@page import="java.util.List"%>
<%@page import="com.sist.totoro.common.StringUtil"%>
<%@page import="com.sist.totoro.common.SearchVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="tiles"  
    uri="http://tiles.apache.org/tags-tiles" %>   	
<%@taglib prefix="tiles"  
    uri="http://tiles.apache.org/tags-tiles" %>    	
	
	
<%

	String cPath = request.getContextPath();//TOTORO
	
	String page_size ="10";//page_size
	String page_num  ="1";//page_num
	String search_div ="";//검색구분
	String search_word="";//검색어
	
	int totalCnt      =0;
	int bottomCount   =10;
	
	SearchVO searchVO =  (SearchVO)request.getAttribute("param");
	//out.print("vo:"+vo);
	
	if(null !=searchVO ){
		search_div  = StringUtil.nvl(searchVO.getSearch_div(), ""); 
		search_word = StringUtil.nvl(searchVO.getSearch_word(), ""); 
		page_size   = StringUtil.nvl(searchVO.getPage_size(), "10"); 
		page_num	= StringUtil.nvl(searchVO.getPage_num(), "1"); 
	}else{ 
		search_div  = StringUtil.nvl(request.getParameter("search_div"), ""); 
		search_word = StringUtil.nvl(request.getParameter("search_word"), "");
		page_size	= StringUtil.nvl(request.getParameter("page_size"), "10");
		page_num	= StringUtil.nvl(request.getParameter("page_num"), "1");
	}
	
	int oPageSize = Integer.parseInt(page_size);
	int oPageNum  = Integer.parseInt(page_num);
	
	String iTotalCnt = (null == request.getAttribute("total_cnt"))?"0":request.getAttribute("total_cnt").toString();
	totalCnt = Integer.parseInt(iTotalCnt);
	
	List<CodeVO> code_page = (null == request.getAttribute("code_page"))
			     ?new ArrayList<CodeVO>():(List<CodeVO>)request.getAttribute("code_page");
	List<CodeVO> user_info = (null == request.getAttribute("user_info"))
			     ?new ArrayList<CodeVO>():(List<CodeVO>)request.getAttribute("user_info");
			     
%>
<!DOCTYPE html>
<html>
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

	<style type="text/css">
			
		body {
			font-family: 'Open Sans', sans-serif;
			color: #353535;
		}
		.content h1 {
			text-align: center;
		}
		.content .content-footer p {
			color: #6d6d6d;
		    font-size: 12px;
		    text-align: center;
		}
		.content .content-footer p a {
			color: inherit;
			font-weight: bold;
		}
		
		/*	--------------------------------------------------
			:: Table Filter
			-------------------------------------------------- */
		.panel {
			border: 1px solid #ddd;
			background-color: #fcfcfc;
		}
		.panel .btn-group {
			margin: 15px 0 30px;
		}
		.panel .btn-group .btn {
			transition: background-color .3s ease;
		}
		.table-filter {
			background-color: #fff;
			border-bottom: 1px solid #eee;
		}
		.table-filter tbody tr:hover {
			cursor: pointer;
			background-color: #eee;
		}
		.table-filter tbody tr td {
			padding: 10px;
			vertical-align: middle;
			border-top-color: #eee;
		}
		.table-filter tbody tr.selected td {
			background-color: #eee;
		}
		.table-filter tr td:first-child {
			width: 38px;
		}
		.table-filter tr td:nth-child(2) {
			width: 35px;
		}
		.ckbox {
			position: relative;
		}
		.ckbox input[type="checkbox"] {
			opacity: 0;
		}
		.ckbox label {
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			user-select: none;
		}
		.ckbox label:before {
			content: '';
			top: 1px;
			left: 0;
			width: 18px;
			height: 18px;
			display: block;
			position: absolute;
			border-radius: 2px;
			border: 1px solid #bbb;
			background-color: #fff;
		}
		.ckbox input[type="checkbox"]:checked + label:before {
			border-color: #2BBCDE;
			background-color: #2BBCDE;
		}
		.ckbox input[type="checkbox"]:checked + label:after {
			top: 3px;
			left: 3.5px;
			content: '\e013';
			color: #fff;
			font-size: 11px;
			font-family: 'Glyphicons Halflings';
			position: absolute;
		}
		.table-filter .star {
			color: #ccc;
			text-align: center;
			display: block;
		}
		.table-filter .star.star-checked {
			color: #F0AD4E;
		}
		.table-filter .star:hover {
			color: #ccc;
		}
		.table-filter .star.star-checked:hover {
			color: #F0AD4E;
		}
		.table-filter .media-photo {
			width: 35px;
		}
		.table-filter .media-body {
		    display: block;
		    /* Had to use this style to force the div to expand (wasn't necessary with my bootstrap version 3.3.6) */
		}
		.table-filter .media-meta {
			font-size: 11px;
			color: #999;
		}
		.table-filter .media .title {
			color: #2BBCDE;
			font-size: 14px;
			font-weight: bold;
			line-height: normal;
			margin: 0;
		}
		.table-filter .media .title span {
			font-size: .8em;
			margin-right: 20px;
		}
		.table-filter .media .title span.pagado {
			color: #5cb85c;
		}
		.table-filter .media .title span.pendiente {
			color: #f0ad4e;
		}
		.table-filter .media .title span.cancelado {
			color: #d9534f;
		}
		.table-filter .media .summary {
			font-size: 14px;
		}	
	
	
	
	
	
	
	
	
	</style>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
</head>
<body>
	<section class="s-content">
    	<!-- contents -------------------------------------------------------->
    	<div class="container-fluid">
   			<!-- Title영역 -->
    		<div class="page-header">
    			<h1>유저목록</h1>
    		</div>
			<!--// Title영역 -->
			<form  name="frm" id="frm" action="<%=cPath%>/mypage/userList.do" method="post" class="form-inline">
				<input type="hidden" name="page_num" id="page_num">
				<!-- 검색영역 -->
				<div class="row">
					<div class="text-right col-xs-12 col-sm-12 col-md-12 col-lg-12">
						<!-- <form action="#" class="form-inline"> -->
							<div class="form-group">
								<%=StringUtil.makeSelectBox(code_page, page_size, "page_size", false) %>
							</div>
							<div class="form-group">
								<%=StringUtil.makeSelectBox(user_info, "", "search_div", false) %>
								<input type="text-center" name="search_word" id="search_word" value="${param.search_word}"  class="form-control input-sm" placeholder="검색어" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<button type="button" class="btn btn-default btn-sm" onclick="javascript:doSearch();">조회</button>
							</div>					
						<!-- </form> -->
					</div>	
				</div>
<!-- 				<form  name="bofrm" id="bofrm" action="do_search_one.do" method="post" class="form-inline">
					<input type="hidden" name="cusSeq" id="cusSeq">
				</form> -->
		
		
				<!-- Grid영역 -->
				<div class="table-responsive" >
					<table id="listTable" class="table table-striped table-bordered table-hover">
						<thead class="bg-primary">
						
						    <tr>
						        <th class="text-center"><input type="checkbox" id="checkAll" name="checkAll" onclick="checkAll();" ></th> 
								<th class="text-center">아이디</th>
								<th class="text-center">이메일</th>
								<th class="text-center">예금주</th>
								<th class="text-center">상태</th>
								<th class="text-center">포인트</th>
								<th class="text-center">가입일</th>
							</tr>
						</thead>
						<tbody>  
							<c:choose>
								<c:when test="${list.size()>0}">
									<c:forEach var="userVO" items="${list}">
										<tr>
										    <td class="text-center"><input type="checkbox" id="check" name="check"></td>
											<td class="text-center"><c:out value="${userVO.userId}"></c:out></td>
											<td class="text-center"><c:out value="${userVO.userEmail}"></c:out></td>
											<td class="text-center"><c:out value="${userVO.userName}"></c:out></td>
											<td class="text-center"><c:out value="${userVO.userAppStt}"></c:out></td>
											<td class="text-center"><c:out value="${userVO.userPoint}"></c:out></td>
											<td class="text-center"><c:out value="${userVO.userRegDt}"></c:out></td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
									    <td class="text-center" colspan="99">회원이 없습니다.ㅠㅠ 분발합시다</td>
									</tr>					
								</c:otherwise>
							</c:choose>						
						</tbody>
					</table>
				</div>
				<!--// Grid영역 ---------------------------------------------------->
			
			
				<!--pagenation ---------------------------------------------------->
				<div class="form-inline text-center">
					<%=StringUtil.renderPaging(totalCnt, oPageNum, oPageSize, bottomCount, "search.do", "search_page") %>
				</div>
				<!--// pagenation영역 ----------------------------------------------->
			</form>	
		</div>
	</section>
	
    
<script type="text/javascript">

    
	function search_page(url,page_num){
		alert(url+":search_page:"+page_num);
		var frm = document.frm;
		frm.page_num.value = page_num;
		frm.action = url;
		frm.submit();
	}

 
	 //check 전체 선택
	function checkAll(){
		//alert("checkAll");
		if($("#checkAll").is(':checked') == true  ){
			$("input[name='check']").prop("checked",true);
		}else{
			$("input[name='check']").prop("checked",false);
		}
   
	}

	function doSearch(){
		var frm = document.frm;
		frm.page_num.value =1;
		frm.action = "<%=cPath%>/mypage/userList.do";
		frm.submit();
	}

	function doWritePage(){
		var frm = document.frm;
		frm.page_num.value =1;
		/* frm.action = "writepage.do"; */
		frm.submit();
	}
	
/* 
$(document).ready(function () {

		$('.star').on('click', function () {
	      $(this).toggleClass('star-checked');
	    });

	    $('.ckbox label').on('click', function () {
	      $(this).parents('tr').toggleClass('selected');
	    });

	    $('.btn-filter').on('click', function () {
	      var $target = $(this).data('target');
	      if ($target != 'all') {
	        $('.table tr').css('display', 'none');
	        $('.table tr[data-status="' + $target + '"]').fadeIn('slow');
	      } else {
	        $('.table tr').css('display', 'none').fadeIn('slow');
	      }
	    });

	 });
*/
 	$(document).ready(function(){   
		$("#do_delete").on("click",function(){
			//alert("do_delete");
				
			var items = [];//var items=new Array(); 
			$( "input[name='check']:checked" ).each(function( index,row ) {
				console.log("index="+index);
				//console.log("row="+row);
				var record = $(row).parents("tr");
				var userId = $(record).find("td").eq(1).text()
				console.log("userId="+userId);
				items.push(userId);
			});
			
			console.log("items.length="+items.length);
			if(items.length<=0){
				alert("삭제할 데이터를 선택 하세요.")
				return;
			}
				
			if(false==confirm("삭제 하시겠습니까?"))return;
				
			var jsonIdList = JSON.stringify(items);
			//jsonIdList=["107","108"]
			console.log("jsonIdList="+jsonIdList);
				
	        $.ajax({
	            type:"POST",
	            url:"delete.do",
	            dataType:"html",
	            data:{
	            	"cusSeq": jsonIdList
	            },
	            success: function(data){//통신이 성공적으로 이루어 졌을때 받을 함수
		             var parseData = $.parseJSON(data);
	                 console.log("parseData.flag="+parseData.flag);
	                 console.log("parseData.message="+parseData.message);
		         	 if(parseData.flag > 0){
		         		alert(parseData.message);
		         		doSearch();
		         	 }else{
		         		alert(parseData.message);
		         		
		         	 }				             
	            },
	            complete: function(data){//무조건 수행
	             
	            },
	            error: function(xhr,status,error){
	             
				}
			});//--ajax
				
		});//--do_delete
		

		$("#listTable>tbody").on("click","tr",function(){
			console.log("1 #listTable>tbody");
			
			var tr = $(this);
			var td = tr.children();
			var cusSeq = td.eq(1).text();
			
			if(""==cusSeq)return;
			
			var frm = document.bofrm;
	     	frm.cusSeq.value = cusSeq;
	     	frm.action = "do_search_one.do";
	     	frm.submit();
	     	alert('전송');
		});//--#listTable>tbody
		
		
		
});  
</script>
</body>
</html>