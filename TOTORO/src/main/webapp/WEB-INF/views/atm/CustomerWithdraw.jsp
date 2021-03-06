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
	String search_url="";//url
	
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
	
%>
<%
	int myPoint = (Integer)session.getAttribute("userPoint");
%>
<script>
	var myPoint = <%=myPoint%>
</script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<section class="s-content">

	<div class="page-header">
	    		<h2 align="center"><mark>출금</mark> 신청 페이지</h2>
	</div>
	<form  name="frm" id="frm" action="customerdeposit.do" method="get" class="form-inline">
		<input type="hidden" name="page_num" id="page_num">
			<form action="#" class="form-inline">
				<div class="form-group">
					<%-- <%=StringUtil.makeSelectBox(code_page, page_size, "page_size", false) %> --%>
				</div>
				</form>
					<input type="hidden" name="page_num" id="page_num">
					<%-- <%=StringUtil.makeSelectBox(code_page, page_size, "page_size", false) %> --%>
					<div class="row half-bottom ">
						<div class="col-twelve" >
							<ul class="stats-tabs" >
								<li><label ><mark>출금</mark> 요청 금액 : </label></li>
                            <li><input type="Number" step=10000 min=0 max=1000000 name="dpoint" id="dpoint" placeholder="10000원 단위로" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" style="width:200px;"/></li>
                            <li><button type="button" class="btn btn--primary btn-sm" id="do_save">신청</button></li>
								<li><button type="button" class ="btn--stroke full-width" onclick="javascript:doSearch();"> 전체 조회</button></li>
								<li><button type="button" class="btn--stroke full-width" onclick="javascript:doReqSearch();">요청 조회</button></li>
								<li><button type="button" class="btn--stroke full-width" onclick="javascript:doPsSearch();">완료 조회</button></li>
								<li><button type="button" class="btn btn--primary btn-sm" id="do_delete">삭제</button></li>
							</ul>
						</div>	
					</div>

				<!-- Grid영역 -->
				<table id = "betTable">
						<thead>
							<tr>
									<th class="text-center"><input type="checkbox" id="checkAll" name="checkAll" onclick="checkAll();" ></th> 
									 <th class="text-center">번호</th>
									 <th class="text-center">요청번호</th>
									 <th class="text-center">ID</th>
									 <th class="text-center">신청 포인트</th>
									 <th class="text-center">신청날짜</th>
									 <th class="text-center">충전날짜</th>
									 <th class="text-center">처리상태</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${list.size()>0}">
									<c:forEach var="AtmVo" items="${list}">
										
										<tr>
										   <td class="text-center"><input type="checkbox" id="check" name="check"></td>
											<td class="text-center"><c:out value="${AtmVo.no}"></c:out></td>
											<td class="text-center"><c:out value="${AtmVo.dwSeq}"></c:out></td>
											<td class="text-center"><c:out value="${AtmVo.userId}"></c:out></td>
											<td class="text-center"><c:out value="${AtmVo.wiPoint}"></c:out></td>
											<td class="text-center"><c:out value="${AtmVo.dwReqday}"></c:out></td>
											<td class="text-center"><c:out value="${AtmVo.dwGetday}"></c:out></td>
											<td class="text-center"><c:out value="${AtmVo.dwPs}"></c:out></td>
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
	
					<div class="form-inline text-center">
						<%=StringUtil.renderPaging(totalCnt, oPageNum, oPageSize, bottomCount, search_url, "search_page") %>
					</div>
					
				</form>
			<!--// Grid영역 ---------------------------------------------------->
		</section>
		<script type="text/javascript">
    
		function search_page(url,page_num){
       	 //alert(url+":search_page:"+page_num);
       	 var frm = document.frm;
       	 frm.page_num.value = page_num;
       	 frm.action = url;
       	 frm.submit();
       	 
        }
        function doSearch(){
       	 var frm = document.frm;
       	 frm.page_num.value =1;
       	 frm.search_url ="customerwithdraw.do";
       	 frm.action = "customerwithdraw.do";
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
         
         function doReqSearch(){
        	 var frm = document.frm;
        	 frm.page_num.value =1;
        	 frm.search_url ="cuswithdrawreq.do";
        	 frm.action = "cuswithdrawreq.do";
        	 frm.submit();
         }
         
         function doPsSearch(){
        	 var frm = document.frm;
        	 frm.page_num.value =1;
        	 frm.search_url ="cuswithdrawps.do";
        	 frm.action = "cuswithdrawps.do";
        	 frm.submit();
         }
         
         $(document).ready(function(){   
				//alert("ready");
				
				//var items = [];
				//$('input:checkbox[type=checkbox]:checked').each(function () {
				//    items.push($(this).val());
				//});
				//do_save
				//등록

				
				$("#do_save").on("click",function(){
					//alert("do_save");
					
					 
					if(false==confirm("등록 하시겠습니까?"))return;
					
					t1 = $("#dpoint").val();
					console.log(t1);
					
					if(t1>myPoint){
						alert("가지고 있는 포인트보다 많은 금액입니다.");
						return;
					}
					
					if($("#dpoint").val()%10000>0){
						alert("1만원 단위로 입력해주세요")
						return;
					}
					 
					$.ajax({
				         type:"POST",
				         url:"wirequest.do",
				         dataType:"html",// JSON
				         data:{
				         	"dpoint": $("#dpoint").val(),
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
				
				
				$("#do_delete").on("click",function(){
					//alert("do_delete");
					
					var items = [];//var items=new Array(); 
					$( "input[name='check']:checked" ).each(function( index,row ) {
						console.log("index="+index);
						//console.log("row="+row);
						var record = $(row).parents("tr");
						var userId = $(record).find("td").eq(3).text();
						var dwseq = $(record).find("td").eq(2).text();
						console.log("userId="+userId);
						console.log("dwseq="+dwseq);
						
						items.push(dwseq);
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
				
				
         });
         
         
         
	</script>
</body>
</html>