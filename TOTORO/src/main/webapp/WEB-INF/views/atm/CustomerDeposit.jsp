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

<style>
  table, th, td {
    border: 1px solid #bcbcbc;
  }
  table {
    width: auto;
  }
</style>



<table>
	고객 입금 신청 페이지
			<tr>
				<div class="form-group">	
				<td class="text-center"><input type="text" id="point" name="point" maxlength=8></td>
				<td class="text-center"><button type="button" id="do_save">요청</button></td>
				</div>	
			</tr>
			<tr>
				<div class="form-group">	
				<td class="text-center"><button type="button" onclick="javascript:doSearch();">조회</button>
					<button type="button" class="btn btn-default btn-sm" id="do_save">등록</button>
					<button type="button" class="btn btn-default btn-sm" id="do_update">수정</button>
					<button type="button" class="btn btn-default btn-sm" id="do_delete">삭제</button>
					<button type="button" class="btn btn-default btn-sm" id="do_excel">엑셀저장</button>
					</td>
				</div>	
			</tr>
			
			<!-- Grid영역 -->
				<div class="table-responsive" >
					<table id="listTable" class="table table-striped table-bordered table-hover">
						<thead class="bg-primary">
						    <tr>
						        <th class="text-center"><input type="checkbox" id="checkAll" name="checkAll" onclick="checkAll();" ></th> 
								 <th class="">번호</th>
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
								<c:forEach var="atmVo" items="${list}">
									<tr>
									   <td class="text-center"><input type="checkbox" id="check" name="check"></td>
										<td class="text-center"><c:out value="${AtmVo.no}"></c:out></td>
										<td class="text-left"><c:out value="${AtmVo.userId}"></c:out></td>
										<td class="text-left"><c:out value="${AtmVo.name}"></c:out></td>
										<td class="text-right"><c:out value="${AtmVo.userLevel}"></c:out></td>
										<td class="text-right"><c:out value="${AtmVo.recommend}"></c:out></td>
										<td class="text-center"><c:out value="${AtmVo.regDt}"></c:out></td>
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
		</table>
		</section>
		<script type="text/javascript">
    
    
         function search_page(url,page_num){
        	 //alert(url+":search_page:"+page_num);
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
        	 frm.action = "search.do";
        	 frm.submit();
         }
         
         
	</script>
</body>
</html>