<%@page import="com.sist.totoro.common.SearchVO"%>
<%@page import="java.util.List"%>
<%@page import="com.sist.totoro.code.CodeVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.totoro.common.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="tiles"  
    uri="http://tiles.apache.org/tags-tiles" %>    
 
<%
	String context = request.getContextPath();//context path
	
	String page_size ="10";//page_size
	String page_num  ="1";//page_num
	String search_div ="";//검색구분
	String search_word="";//검색어
	
	int totalCnt      =0;
	int bottomCount   =10;
    
	SearchVO vo =  (SearchVO)request.getAttribute("param");
	//out.print("vo:"+vo);
	
	if(null !=vo ){
		search_div  = StringUtil.nvl(vo.getSearch_div(), ""); 
		search_word = StringUtil.nvl(vo.getSearch_word(), ""); 
		page_size   = StringUtil.nvl(vo.getPage_size(), "10"); 
		page_num   = StringUtil.nvl(vo.getPage_num(), "1"); 
	}else{ 
		search_div  = StringUtil.nvl(request.getParameter("search_div"), ""); 
		search_word = StringUtil.nvl(request.getParameter("search_word"), "");
		page_size = StringUtil.nvl(request.getParameter("page_size"), "10");
		page_num = StringUtil.nvl(request.getParameter("page_num"), "1");
	}
	

	
	int oPageSize = Integer.parseInt(page_size);
	int oPageNum  = Integer.parseInt(page_num);
	
	String iTotalCnt = (null == request.getAttribute("total_cnt"))?"0":request.getAttribute("total_cnt").toString();
	totalCnt = Integer.parseInt(iTotalCnt);
	
	List<CodeVO> code_page = (null == request.getAttribute("code_page"))
			     ?new ArrayList<CodeVO>():(List<CodeVO>)request.getAttribute("code_page");
	String user = (String)session.getAttribute("userId");
	String admin = (String)session.getAttribute("userAdmin");
%>    
<%-- 
  /**
  * @Class Name  : user.jsp
  * @Description : 사용자관리 화면
  * @Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    -----------------------R---
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
    <title><tiles:putAttribute name="title"></tiles:putAttribute></title>


    

  </head>
  <body>
  <section class="s-content">


    <!-- contents -------------------------------------------------------->
    <div class="container-fluid">
    	<!-- Title영역 -->
    		<div class="page-header">
	    		<h2 align="center">고객 문의사항 페이지</h2>
			</div>
    	<!--// Title영역 -->
        <form  name="frm" id="frm" action="search.do" method="post" class="form-inline">
     	 <input type="hidden" name="page_num" id="page_num">
		<!-- 검색영역 -->
	
		<div class="row">
		  <div class="text-right col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<form action="#" class="form-inline">
			
					<%=StringUtil.makeSelectBox(code_page, page_size, "page_size", false) %>
				
				
					<select name="search_div" id="search_div" class="form-control input-sm">
					    <option value="" >::전체::</option>
						<option value="10" <%if(search_div.equals("10"))out.print("selected='selected'"); %> >등록자</option>
						<option value="20" <%if(search_div.equals("20"))out.print("selected='selected'"); %> >분류</option>	
						<option value="30" <%if(search_div.equals("30"))out.print("selected='selected'"); %> >제목</option>								
					</select>
					
				
									
					
					<input  type="text-center" name="search_word" id="search_word" value="${param.search_word}"  class="form-control input-sm" placeholder="검색어" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="button" class="btn btn-default btn-sm" onclick="javascript:doSearch();">조회</button>
					<button type="button" class="btn btn--primary btn-sm" id="do_writepage" onclick="javascript:doWritePage();">문의사항 작성 페이지로</button>
			<c:choose>
        			<c:when test="${userAdmin=='1'}">
        			<button type="button" class="btn btn--stroke" id="do_delete">삭제</button>
        			</c:when>
        			
        			<c:otherwise>
					</c:otherwise>

			</c:choose>
					
					
					
					
					
					
					
			</form>
		  </div>	
		</div>
	
		<form  name="bofrm" id="bofrm" action="do_search_one.do" method="post" class="form-inline">
			<input type="hidden" name="cusSeq" id="cusSeq">
		</form>
		
		
		<!-- Grid영역 -->
		<div class="table-responsive" >
			<table id="listTable" class="table table-striped table-bordered table-hover">
				<thead class="bg-primary">
				    <tr>
				        <th class="text-center"><input type="checkbox" id="checkAll" name="checkAll" onclick="checkAll();" ></th> 
						<th class="text-center">번호</th>
						<th class="text-center">등록자</th>
						<th class="text-center">분류</th>
						<th class="text-center">제목</th>
						<th class="text-center">답변여부</th>
						<th class="text-center">날짜</th>
					</tr>
				</thead>
				<tbody>  
				<c:choose>
					<c:when test="${list.size()>0}">
						<c:forEach var="customerVo" items="${list}">
							<tr>
							    <td class="text-center"><input type="checkbox" id="check" name="check" onclick='event.cancelBubble=true;'​></td>
								<td class="text-center"><c:out value="${customerVo.cusSeq}"></c:out></td>
								<td class="text-center" value="${customerVo.userId}"><c:out value="${customerVo.userId}"></c:out></td>
								<td class="text-center"><c:out value="${customerVo.cusCat}"></c:out></td>
								<td class="text-center"><c:out value="${customerVo.cusTitle}"></c:out></td>
								<td class="text-center"><c:out value="${customerVo.cusReply}"></c:out></td>
								<td class="text-center"><c:out value="${customerVo.cusRegDt}"></c:out></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
						    <td class="text-center" colspan="99">등록된 게시글이 없습니다.</td>
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
    
	 //검색
    function doSearch(){

   	 var frm = document.frm;
   	 frm.page_num.value =1;
   	 frm.action = "search.do";
   	 frm.submit();

    }
    
    //글쓰기 페이지 이동 
    function doWritePage(){
      	 var frm = document.frm;
      	 frm.page_num.value =1;
      	 frm.action = "writepage.do";
      	 frm.submit();
       }
    
 

     $(document).ready(function(){   
	
	
	//검색영역 엔터키 이벤트 처리
	$("#search_word").keydown(function(key) {
		if (key.keyCode == 13) {
			doSearch();
		}
	});
		
			
		$("#do_delete").on("click",function(){
			
			
					
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
					//
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
				         		//alert(parseData.message);
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
				var rid = td.eq(2).text();
				var sessionid = <%="\""%><%=user%><%="\""%>;
				var adminid = <%="\""%><%=admin%><%="\""%>;
				console.log("cusSeq ; "+cusSeq);
				console.log("id ; "+rid);
				console.log("id ; "+sessionid);
				if(""==cusSeq)return;

				
				
 				if(rid == sessionid || adminid =='1'){
 					 var frm = document.bofrm;
 			     	 frm.cusSeq.value = cusSeq;
 			     	 frm.action = "do_search_one.do";
 			     	 frm.submit();
					return;
				} else {
					alert('작성자 본인의 글만 조회가 가능합니다.')
				}  
				
/*   		     	 var frm = document.bofrm;
		     	 frm.cusSeq.value = cusSeq;
		     	 frm.action = "do_search_one.do";
		     	 frm.submit();
		     	 alert('전송');  
		     	 */
				
			});//--#listTable>tbody
			
			
			
    });  
</script>
</body>
</html>