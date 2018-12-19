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

String page_size ="5";//page_size
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

String iTotalCnt = (null == request.getAttribute("totalCnt"))?"0":request.getAttribute("totalCnt").toString();
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
  <!-- 히든으로 값을 받아서 넘겨주기 -->
  <form name="bofrm" id="bofrm" action="rwritepage.do" method="post" class="form-inline">
		 <input type="hidden" name="cusSeq" id="cusSeq" value="<c:out value="${vo.cusSeq}"></c:out>" />
		 <input type="hidden" name="cusTitle" id="cusTitle" />
		 <input type="hidden" name="cusContent" id="cusContent" />
		  <input type="hidden" name="userId" id="userId" value="${userId}" />
	</form>

    <form name="frmSave" id="frmSave" method="post" action="update.do">
    	<input type="hidden" name="page_num" id="page_num">
    			 
                    <fieldset>
		
                    

        <div class="row">

            <div class="s-content__header col-full">
                <h1 class="s-content__header-title cusTitleValue">
						<c:out value="${vo.cusTitle}"></c:out>
                </h1>
            </div> <!-- end s-content__header -->
					<p class="cusContentValue"><c:out value="${vo.cusContent}"></c:out></p>
                
                </div>
             	<table id="listTable" class="table table-striped table-bordered table-hover">
			
				<tbody>  
				<c:choose>
					<c:when test="${list.size()>0}">
						<c:forEach var="cusReplyVo" items="${list}">
							<tr>
								<td class="text-center"><c:out value="${cusReplyVo.crContent}"></c:out></td>
								<td class="text-center"><c:out value="${cusReplyVo.userId}"></c:out></td>
								<td class="text-center"><c:out value="${cusReplyVo.crregDt}"></c:out></td>
								<td class="text-center"><button type="button" class="doDelete btn btn-danger btn-sm" value="${cusReplyVo.crSeq}">삭제하기</button></td>
							</tr>
						</c:forEach>
					</c:when>

				</c:choose>						
				</tbody>
			</table>


		<!--// Grid영역 ---------------------------------------------------->
		
		<!--pagenation ---------------------------------------------------->
		<div class="form-inline text-center">
			<%=StringUtil.renderPaging(totalCnt, oPageNum, oPageSize, bottomCount, "do_search_one.do", "search_page") %>
		</div>
                         </fieldset>
                          <input type="hidden" name="crSeq" id="crSeq" value="" />
	 </form> <!-- end form -->
                        <button type="button" class="btn btn-default btn-sm" id="do_rwritepage" onclick="javascript:doWritePage();">댓글쓰기페이지</button>
						<button type="button" class="btn btn-default btn-sm" id="do_writepage" onclick="javascript:doUpdatePage();">수정페이지로</button>
						<button type="button" class="btn btn-default btn-sm" id="btnDelete" onclick="javascript:detail_delete();">삭제</button>
                   		
  </section>
  

 
  
   <script type="text/javascript">

    //수정페이지로 이동 
   function doUpdatePage(){
	   var cusContent = $('.cusContentValue').text();
	   	 alert(cusContent);
	   	 var cusTitle = $('.cusTitleValue').text();
	   	 alert(cusTitle);
	   	 
	  	 var frm = document.bofrm;
    	 alert(frm.cusSeq.value);
    	 alert(frm.userId.value);
    	 frm.cusTitle.value = cusTitle;
    	 frm.cusContent.value = cusContent;
    	 
    	 frm.action = "updatepage.do";
    	 frm.submit();
     }
    
   // 댓글쓰기 페이지로 이동 
   function doWritePage(){
  	 var frm = document.bofrm;
  	 frm.cusSeq.value = $("#cusSeq").val();
  	 frm.action = "rwritepage.do";
  	 frm.submit();
   }
   
   
   // 상세페이지에서 삭제 
   function detail_delete(){
  	 var frm = document.bofrm;
  	 frm.action = "detail_delete.do";
  	 frm.submit();
   }
   
   function search_page(url,page_num){
	   	 alert(url+":search_page:"+page_num);
	   	 var frm = document.frmSave;
	   	 frm.page_num.value = page_num;
	   	 frm.action = url;
	   	 frm.submit();
	   	 
	    }
			
   $(".doDelete").on("click",function(){
				
		var crSeq = $(this).val();
	  	var cusSeq = $("#cusSeq").val();
	  	
	  	alert(cusSeq);
		alert(crSeq);
		
		if(false==confirm("삭제 하시겠습니까?"))return;

        $.ajax({
            type:"POST",
            url:"rdelete.do",
            dataType:"json",// JSON
            data:{
            "crSeq": crSeq,
            "cusSeq":cusSeq
            },
            success: function(data){//통신이 성공적으로 이루어 졌을때 받을 함수

            },
            complete: function(data){//무조건 수행
             
            },
            error: function(xhr,status,error){
             
            }
            
       }); //--ajax
       
        alert('삭제성공');
      	 var frm = document.bofrm;
     	 	     frm.cusSeq.value = $("#cusSeq").val();
     		 	  frm.action = "do_search_one.do";
     	 	     frm.submit();
		
	});//--do_delete
</script>
</body>
</html>