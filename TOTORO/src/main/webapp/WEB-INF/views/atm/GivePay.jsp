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
	
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<section class="s-content">

<!-- <style>
  table, th, td {
    border: 1px solid #bcbcbc;
  }
  table {
    width: auto;
  }
</style> -->
	<div class="page-header">
	    		<h2 align="center">관리자 <mark>당첨금 처리</mark> 페이지</h2>
	</div>
	<form  name="frm" id="frm" action="givepay.do" method="get" class="form-inline">
		<input type="hidden" name="page_num" id="page_num">
			<form action="#" class="form-inline">
				<div class="form-group">
<%-- 						<%=StringUtil.makeSelectBox(code_page, page_size, "page_size", false) %> --%>
				</div>
				</form>
				<table align="center">
				<tr >
					<!-- 
					<div class="form-group">
						<label class="col-lg-4">입금 요청 금액 : </label>
						<div>
							<input type="Number" name="dpoint" id="dpoint" placeholder="1000원 단위로"/>
							<button type="button" class="btn btn-default btn-sm" id="do_save">등록</button>
						</div>
					</div> 
					-->
					
					<input type="hidden" name="page_num" id="page_num">
<%-- 					<%=StringUtil.makeSelectBox(code_page, page_size, "page_size", false) %> --%>
						<td class="text-center" >
							<button type="button" onclick="javascript:doSearch();"> 전체 조회</button>
							<button type="button" class="btn btn--primary btn-sm" id="give">당청금 지급</button>
						</td>
				</tr>
				</table>
				<!-- Grid영역 -->
				<table id = "betTable">
						<thead>
							<tr>
									<th class="text-center"><input type="checkbox" id="checkAll" name="checkAll" onclick="checkAll();" ></th> 
									 <th class="text-center">번호</th>
									 <th class="text-center">배팅 번호</th>
									 <th class="text-center">ID</th>
									 <th class="text-center">당첨금</th>
									 <th class="text-center">상첨처리</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${list.size()>0}">
									<c:forEach var="PrizesVO" items="${list}">
										
										<tr>
										   <td class="text-center"><input type="checkbox" id="check" name="check"></td>
											<td class="text-center"><c:out value="${PrizesVO.no}"></c:out></td>
											<td class="text-center"><c:out value="${PrizesVO.betSeq}"></c:out></td>
											<td class="text-center"><c:out value="${PrizesVO.userId}"></c:out></td>
											<td class="text-center"><c:out value="${PrizesVO.betwPrice}"></c:out></td>
											<td class="text-center"><c:out value="${PrizesVO.betReturn}"></c:out></td>
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
	
					<div class="text-center">
						<%=StringUtil.renderPaging(totalCnt, oPageNum, oPageSize, bottomCount, "givepay.do", "search_page") %>
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
       	 frm.action = "givepay.do";
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
         
         
         $(document).ready(function(){   
				//alert("ready");
				
				//var items = [];
				//$('input:checkbox[type=checkbox]:checked').each(function () {
				//    items.push($(this).val());
				//});
				//do_save
				//등록
				
				
					$("#give").on("click",function(){
					//alert("do_delete");
					
					var items = [];//var items=new Array()

					$( "input[name='check']:checked" ).each(function( index,row ) {
						console.log("index="+index);
						//console.log("row="+row);
						var record = $(row).parents("tr");
						var userId = $(record).find("td").eq(3).text();
						var betwSeq = $(record).find("td").eq(2).text();
						var betwPrice = $(record).find("td").eq(4).text();
						
			
						console.log("userId="+userId);
						console.log("betwSeq="+betwSeq);
						console.log("betwPrice="+betwPrice);
						
						items.push(betwSeq);
						items.push(userId);
						items.push(betwPrice);
					});
					
					console.log("items.length="+items.length);
					if(items.length<=0){
						alert("데이터를 선택 하세요.")
						return;
					}
					
					if(false==confirm("지급 하시겠습니까?"))return;
					
					var jsonIdList = JSON.stringify(items);
					//jsonIdList=["107","108"]
					console.log("jsonIdList="+jsonIdList);
					
			        $.ajax({
			            type:"POST",
			            url:"give.do",
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
					
				});//--deposit 지급 출
				
         });
         
         
         
	</script>
</body>
</html>