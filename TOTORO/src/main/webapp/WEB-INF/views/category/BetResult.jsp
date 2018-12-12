<%@page import="com.sist.totoro.common.SearchVO"%>
<%@page import="java.util.List"%>
<%@page import="com.sist.totoro.code.CodeVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.totoro.common.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String context = request.getContextPath();//context path
	
	String page_size ="2";//page_size
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
		page_size   = StringUtil.nvl(vo.getPage_size(), "2"); 
		page_num   = StringUtil.nvl(vo.getPage_num(), "1"); 
	}else{ 
		search_div  = StringUtil.nvl(request.getParameter("search_div"), ""); 
		search_word = StringUtil.nvl(request.getParameter("search_word"), "");
		page_size = StringUtil.nvl(request.getParameter("page_size"), "2");
		page_num = StringUtil.nvl(request.getParameter("page_num"), "1");
	}
	
	out.print("page_size:"+page_size);
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

	
	<form  name="frm" id="frm" action="betresult.do" method="get" class="form-inline">
    <input type="hidden" name="page_num" id="page_num">
	<div class="row">
		  <div class="text-right col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<form action="#" class="form-inline">
				<div class="form-group">
					<%=StringUtil.makeSelectBox(code_page, page_size, "page_size", false) %>
				</div>
				<div class="form-group">
					<select name="search_div" id="search_div" class="form-control input-sm">
					    <option value="" >::전체::</option>
						<option value="10" <%if(search_div.equals("10"))out.print("selected='selected'"); %> >홈팀</option>
						<option value="20" <%if(search_div.equals("20"))out.print("selected='selected'"); %> >원정</option>					
					</select>
					<input type="text" name="search_word" id="search_word" value="${param.search_word}"  class="form-control input-sm" placeholder="검색어" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="button" class="btn btn-default btn-sm" onclick="javascript:doSearch();">조회</button>
					
				</div>					
			</form>
		  </div>	
		</div>
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
									<td class="text-center"><c:out value="${betResultVo.gameHs}"></c:out></button></td>
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
	<!--pagenation ---------------------------------------------------->
		<div class="form-inline text-center">
			<%=StringUtil.renderPaging(totalCnt, oPageNum, oPageSize, bottomCount, "betresult.do", "search_page") %>
		</div>
		<!--// pagenation영역 ----------------------------------------------->
		</form>
		
</section> <!-- s-content -->
	


</body>

<script type="text/javascript">
	$(document).ready(function(){   
	
	});
	
	
	
	$("#betTable>tbody>tr").on("click","#home",function(){
		alert("home click!");
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
    	 frm.action = "betresult.do";
    	 frm.submit();
     }
	
	
</script>

</html>