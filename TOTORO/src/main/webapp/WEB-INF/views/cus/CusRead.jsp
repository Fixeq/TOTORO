<%@page import="com.sist.totoro.common.SearchVO"%>
<%@page import="java.util.List"%>
<%@page import="com.sist.totoro.code.CodeVO"%>
<%@page import="com.sist.totoro.domain.UserVO"%>
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
 
    <form name="frmSave" id="frmSave" method="post" action="updatepage.do">
    	<form  name="bofrm" id="bofrm" action="rwritepage.do" method="post" class="form-inline">
			<input type="hidden" name="cusSeq" id="cusSeq">
  		
                    <fieldset>

                     <section class	="s-content s-content--narrow">

        <div class="row">

            <div class="s-content__header col-full">
                <h1 class="s-content__header-title">
						<c:out value="${vo.cusTitle}"></c:out>
                </h1>
            </div> <!-- end s-content__header -->
    
            

            <div class="col-full s-content__main">

                <p class="lead"><c:out value="${vo.cusContent}"></c:out></p>
 			
                
                </div>
             	<table id="listTable" class="table table-striped table-bordered table-hover">
			
				<tbody>  
				<c:choose>
					<c:when test="${list.size()>0}">
						<c:forEach var="cusReplyVo" items="${list}">
							<tr>
								<td class="text-center"><c:out value="${cusReplyVo.crContent}"></c:out></td>
								<td class="text-center"><c:out value="${cusReplyVo.crregId}"></c:out></td>
								<td class="text-center"><c:out value="${cusReplyVo.crregDt}"></c:out></td>
							</tr>
						</c:forEach>
					</c:when>

				</c:choose>						
				</tbody>
			</table>


		<!--// Grid영역 ---------------------------------------------------->
		
		<!--pagenation ---------------------------------------------------->
		<div class="form-inline text-center">
			<%=StringUtil.renderPaging(totalCnt, oPageNum, oPageSize, bottomCount, "search.do", "search_page") %>
		</div>
                         </fieldset>
	 </form> <!-- end form -->
                        <button type="button" class="btn btn-default btn-sm" id="do_rwritepage" onclick="javascript:doWritePage();">댓글쓰기페이지</button>
						<button type="button" class="btn btn-default btn-sm" id="do_writepage" onclick="javascript:doUpdatePage();">수정페이지로</button>
						<button type="button" class="btn btn-default btn-sm" id="btnDelete" onclick="javascript:detail_delete();">삭제</button>
                   		
  </section>
  
  
   <% UserVO vo1 = (UserVO)session.getAttribute("UserId");%>
  
   <script type="text/javascript">

    
   function doUpdatePage(){
    	 var frm = document.frmSave;
    	 frm.action = "updatepage.do";
    	 frm.submit();
     }
    
   function doWritePage(){
  	 var frm = document.frmSave;
  	 frm.action = "rwritepage.do";
  	 frm.submit();
   }
   function detail_delete(){
  	 var frm = document.frmSave;
  	 frm.action = "detail_delete.do";
  	 frm.submit();
   }
   function search_page(url,page_num){
	   	 alert(url+":search_page:"+page_num);
	   	 var frm = document.frm;
	   	 frm.page_num.value = page_num;
	   	 frm.action = url;
	   	 frm.submit();
	   	 
	    }
			
			

</script>
</body>
</html>