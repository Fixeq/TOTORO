<%@page import="com.sist.totoro.common.SearchVO"%>
<%@page import="java.util.List"%>
<%@page import="com.sist.totoro.code.CodeVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.totoro.common.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
<%
	String context = request.getContextPath();//context path
	
	String page_size ="5";//page_size
	String page_num  ="1";//page_num
	String search_div ="";//검색구분
	String search_word="";//검색어
	
	int totalCnt      =0;
	int bottomCount   =5;
    
	SearchVO vo =  (SearchVO)request.getAttribute("param");
	
	if(null !=vo ){
		search_div  = StringUtil.nvl(vo.getSearch_div(), ""); 
		search_word = StringUtil.nvl(vo.getSearch_word(), ""); 
		page_size   = StringUtil.nvl(vo.getPage_size(), "5"); 
		page_num   = StringUtil.nvl(vo.getPage_num(), "1"); 
	}else{ 
		search_div  = StringUtil.nvl(request.getParameter("search_div"), ""); 
		search_word = StringUtil.nvl(request.getParameter("search_word"), "");
		page_size = StringUtil.nvl(request.getParameter("page_size"), "5");
		page_num = StringUtil.nvl(request.getParameter("page_num"), "1");
	}
	
	
	int oPageSize = Integer.parseInt(page_size);
	int oPageNum  = Integer.parseInt(page_num);
	
	String iTotalCnt = (null == request.getAttribute("total_cnt"))?"0":request.getAttribute("total_cnt").toString();
	totalCnt = Integer.parseInt(iTotalCnt);
	
	List<CodeVO> code_page = (null == request.getAttribute("code_page"))
			     ?new ArrayList<CodeVO>():(List<CodeVO>)request.getAttribute("code_page");
	
%>    

<%-- 
  /**
  * @Class Name  : user.jsp
  * @Description : 사용자관리 화면
  * @Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2018.11.22             최초 생성
  *
  * author HR 개발팀
  * since 2018.11.22
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%> 
    
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <title>부트스트랩 리스트 템플릿</title>

    <!-- 부트스트랩 -->
    <link href="<%=context%>/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
    <!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- CSS ================================================== -->
    <link rel="stylesheet" href="<%=context%>/resources/css/base.css">
    <link rel="stylesheet" href="<%=context%>/resources/css/vendor.css">
    <link rel="stylesheet" href="<%=context%>/resources/css/main.css">

    <script src="<%=context%>/resources/js/jquery-3.2.1.min.js"></script>
    <script src="<%=context%>/resources/js/plugins.js"></script>
    <script src="<%=context%>/resources/js/main.js"></script>
    
      <!-- Java Script
    ================================================== -->
    <script src="<%=context%>/resources/js/jquery-3.2.1.min.js"></script>
    <script src="<%=context%>/resources/js/plugins.js"></script>
    <script src="<%=context%>/resources/js/main.js"></script>
    
    
  </head>
  <body>
  <section class="s-content">
    <!-- contents -------------------------------------------------------->
    <div class="container-fluid">
    	<!-- Title영역 -->
    	<div class="page-header">
    		<h1>경기결과</h1>
    	</div>
    	<!--// Title영역 -->
        <form  name="frm" id="frm" action="betresult.do" method="get" class="form-inline">
     	 <input type="hidden" name="page_num" id="page_num">
    	<!--// Title영역 -->
        <!-- 검색영역 -->
		<div class="row">
		  <div class="text-right col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="form-group">
					<select name="search_div" id="search_div" class="form-control input-sm">
					    <option value="" >::전체::</option>
						<option value="10" <%if(search_div.equals("10"))out.print("selected='selected'"); %> >홈팀</option>
						<option value="20" <%if(search_div.equals("20"))out.print("selected='selected'"); %> >원정팀</option>					
					</select>
					<input type="text" name="search_word" id="search_word" value="${param.search_word}"  class="form-control input-sm" placeholder="검색어" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="button" class="btn btn-default btn-sm" onclick="javascript:doSearch();">조회</button>
				</div>					
			
		  </div>	
		</div>
		<!--// 검색영역----------------------------------------------------->
		
		
		
		
		<!-- Grid영역 -->
		<table id = "betTable">
		<thead>
			<tr>
					<td class="text-center">경기시간</td>
					<td class="text-center">홈팀</td>
					<td class="text-center"></td>
					<td class="text-right">원정팀</td>
					<td class="text-center">홈스코어</td>
					<td class="text-center"></td>
					<td class="text-center">원정스코어</td>
					<td class="text-center">경기결과</td>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${list.size()>0}">
					<c:forEach items="${list}" var="betResultVo">
								<tr>
									<td class="text-center"><c:out value="${betResultVo.gameDate}"></c:out></td>
									<td class="text-center"><c:out value="${betResultVo.gameHome}"></c:out></td>
									<td class="text-center">VS</td>
									<td class="text-right"><c:out value="${betResultVo.gameAway}"></c:out></td>
									<td class="text-center"><c:out value="${betResultVo.gameHs}"></c:out></td>
									<td class="text-center">:</td>
									<td class="text-center"><c:out value="${betResultVo.gameAs}"></c:out></td>
									<td class="text-center"><c:out value="${betResultVo.gameResult}"></c:out></td>
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

		<!--// Grid영역 ---------------------------------------------------->
		
		<!--pagenation ---------------------------------------------------->
		
		<!--// pagenation영역 ----------------------------------------------->
	</form>
	<div class="row">
            <div class="col-full">
                <nav class="pgn">
                <ul>
			<%=StringUtil.renderPaging(totalCnt, oPageNum, oPageSize, bottomCount, "betresult.do", "search_page") %>
		</ul>
		</nav>
		</div>
		</div>
		<!-- 입력 Form영역---- ----------------------------------------------->
		
		<!--// 입력 Form영역---- ----------------------------------------------->				  
	</div>

	<!--// contents ------------------------------------------------------>

    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    
    
    <script src="<%=context%>/resources/js/jquery.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="<%=context%>/resources/js/bootstrap.min.js"></script>
   <script type="text/javascript">
    
    
         function search_page(url,page_num){
        	 alert(url+":search_page:"+page_num);
        	 var frm = document.frm;
        	 frm.page_num.value = page_num;
        	 frm.action = url;
        	 frm.submit();
        	 
         }
    
         function onReset(){
        	 $("#upsert_div").val("save");
        	 $("#userId").prop("disabled",false);
        	 
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
        	 alert("ready");
        	 var frm = document.frm;
        	 console.log("search_word111111111111111111111111111111="+search_word);
        	 frm.page_num.value =1;
        	 frm.action = "betresult.do";
        	 frm.submit();
         }
    
	     $(document).ready(function(){   
				//alert("ready");
				
				//var items = [];
				//$('input:checkbox[type=checkbox]:checked').each(function () {
				//    items.push($(this).val());
				//});
				
				$("#do_delete").on("click",function(){
					//alert("do_delete");
					
					var items = [];//var items=new Array(); 
					$( "input[name='check']:checked" ).each(function( index,row ) {
						console.log("index="+index);
						//console.log("row="+row);
						var record = $(row).parents("tr");
						var userId = $(record).find("td").eq(2).text()
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
			            	"userId_list": jsonIdList
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
				
				//do_save
				//등록
				$("#do_save").on("click",function(){
					//alert("do_save");
					var upsert_div = $("#upsert_div").val();
					console.log("upsert_div:"+upsert_div);
					var tmpLevel = "BASIC";
					 
					if($("#userIntLevel").val()=="1"){
					     tmpLevel = "BASIC";
					}else if($("#userIntLevel").val()=="2"){
					     tmpLevel = "SILVER";
					}else if($("#userIntLevel").val()=="3"){
						 tmpLevel = "GOLD";
					}
					 
					if(false==confirm("등록 하시겠습니까?"))return;
					 
					$.ajax({
				         type:"POST",
				         url:"update.do",
				         dataType:"html",// JSON
				         data:{
				         	"upsert_div": upsert_div,
				         	"userId": $("#userId").val(),
				         	"name": $("#name").val(),
				         	"password": $("#password").val(),
				         	"userIntLevel": $("#userIntLevel").val(),
				         	"login": $("#login").val(),
				         	"recommend": $("#recommend").val(),
				         	"email": $("#email").val()
				         },
				         success: function(data){//통신이 성공적으로 이루어 졌을때 받을 함수
				             var parseData = $.parseJSON(data);
				         	 if(parseData.flag=="1"){
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
					
				});//--do_save
				
				
				$("#do_update").on("click",function(){
					 if(false==confirm("수정 하시겠습니까?"))return;
					  
					 var upsert_div = $("#upsert_div").val();
					 upsert_div = (upsert_div == "")?"update":"";
					 console.log("upsert_div:"+upsert_div);
					 var tmpLevel = "BASIC";
					 
					 if($("#userIntLevel").val()=="1"){
						 tmpLevel = "BASIC";
					 }else if($("#userIntLevel").val()=="2"){
						 tmpLevel = "SILVER";
					 }else if($("#userIntLevel").val()=="3"){
						 tmpLevel = "GOLD";
					 }
					 
					 
					 
				     $.ajax({
				         type:"POST",
				         url:"update.do",
				         dataType:"html",// JSON
				         data:{
				         	"upsert_div": upsert_div,
				         	"userId": $("#userId").val(),
				         	"name": $("#name").val(),
				         	"password": $("#password").val(),
				         	"userIntLevel": $("#userIntLevel").val(),
				         	"login": $("#login").val(),
				         	"recommend": $("#recommend").val(),
				         	"email": $("#email").val()
				         },
				         success: function(data){//통신이 성공적으로 이루어 졌을때 받을 함수
				             var parseData = $.parseJSON(data);
				         	 if(parseData.flag=="1"){
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
					
					
				});//--do_update
				
				
				$("#listTable>tbody").on("click","tr",function(){
					console.log("1 #listTable>tbody");
					
					var tr = $(this);
					var td = tr.children();
					var userId = td.eq(2).text();
					console.log("2 userId="+userId);
					
					if(""==userId)return;
					
			        $.ajax({
			            type:"POST",
			            url:"do_search_one.do",
			            dataType:"html",// JSON
			            data:{
			            "userId": userId
			            },
			            success: function(data){//통신이 성공적으로 이루어 졌을때 받을 함수
			              var parseData = $.parseJSON(data);
			              /* console.log("3 parseData.userId="+parseData.userId);
			              console.log("3 parseData.name="+parseData.name);
			              console.log("3 parseData.password="+parseData.password);
			              console.log("3 parseData.login="+parseData.login);
			              console.log("3 parseData.recommend="+parseData.recommend);
			              console.log("3 parseData.email="+parseData.email);
			              console.log("3 parseData.userIntLevel="+parseData.userIntLevel);
			              console.log("3 parseData.regDt="+parseData.regDt); */
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
					
				});//--#listTable>tbody
				
				
				
	     });  
	</script>
	</section>
  </body>
</html>