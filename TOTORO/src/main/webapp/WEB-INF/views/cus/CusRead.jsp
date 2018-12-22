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
		     
		 	String user = (String)session.getAttribute("userId");
			String admin = (String)session.getAttribute("userAdmin");

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
    			  <input type="hidden" name="cusSeq" id="cusSeq2" value="<c:out value="${vo.cusSeq}"></c:out>" />
    			  
                    <fieldset>
		
                    

        <div class="row">

            <div class="s-content__header col-full">
                <h1 class="s-content__header-title cusTitleValue">
						<c:out value="${vo.cusTitle}"></c:out>
                </h1>
            </div> <!-- end s-content__header -->
					<p class="cusContentValue"><c:out value="${vo.cusContent}"></c:out></p>
                <p class="rId"><c:out value="${vo.userId}"></c:out></p>
                </div>
                <br><br><br>



                 <div class="comments-wrap">

            <div id="comments" class="row">
                <div class="col-full">

                    

                    <!-- commentlist -->
                    <ol class="commentlist">
                    <c:choose>
				
					<c:when test="${list.size()>0}">
					
					<c:forEach var="cusReplyVo" items="${list}">

                        <li class="depth-1 comment"> <!-- 반복 -->

                            

                            <div class="comment__content">

                                <div class="comment__info">
                                    <cite >작성자 :<c:out value="${cusReplyVo.userId}"></c:out></cite>
                                    
                                    <div class="comment__meta">
                                        <time class="comment__time">작성일 : <c:out value="${cusReplyVo.crregDt}"></c:out></time>
                                        
                                        
                                        
                                        	<c:choose>
        			<c:when test="${userAdmin=='1'}">
        			<a class="doDelete" id ="<c:out value="${cusReplyVo.crSeq}"></c:out>" onclick=""  value="">댓글삭제</a>
        			</c:when>
        			
        			<c:when test="${userId==cusReplyVo.userId}">
        			<a class="doDelete" id ="<c:out value="${cusReplyVo.crSeq}"></c:out>" onclick=""  value="">댓글삭제</a>
        			</c:when>

			</c:choose>
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                        
                                    </div>
                                </div>

                                <div class="comment__text">
                                <p><c:out value="${cusReplyVo.crContent}"></c:out></p>
                                </div>

                            </div>

                        </li> <!-- 반복 -->

                       </c:forEach>
					</c:when>
					
				</c:choose>		

                    </ol> <!-- end commentlist -->


                    <!-- respond
                    ================================================== -->


                </div> <!-- end col-full -->

            </div> <!-- end row comments -->
        </div> <!-- end comments-wrap -->
			
			</div>


		<!--// Grid영역 ---------------------------------------------------->
		
		<!--pagenation ---------------------------------------------------->
		<div class="form-inline text-center">
			<%=StringUtil.renderPaging(totalCnt, oPageNum, oPageSize, bottomCount, "do_search_one.do", "search_page") %>
		</div>
                         </fieldset>
                          <input type="hidden" name="crSeq" id="crSeq" value="" />
                          
        
	 </form> <!-- end form -->
                     <div style="text-align:center;"> <button type="button" class="btn btn--primary btn-sm" id="do_rwritepage" onclick="javascript:doWritePage();">답글작성하기</button>   
						   <button type="button" class="btn btn-default btn-sm" id="do_writepage" onclick="javascript:doUpdatePage();">게시글 수정하기</button>   
						   <button type="button" class="btn btn--stroke" id="btnDelete" onclick="javascript:detail_delete();">삭제</button>  
						     </div>
                   		
  </section>
  

 
  
   <script type="text/javascript">

    //수정페이지로 이동 
   function doUpdatePage(){
	   var cusContent = $('.cusContentValue').text();

	   	 var cusTitle = $('.cusTitleValue').text();
	  
	   	var rId = $('.rId').text();
	   	var sessionid = <%="\""%><%=user%><%="\""%>;
		var adminid = <%="\""%><%=admin%><%="\""%>;

		
		
		
		if(rId == sessionid || adminid =='1'){
			var frm = document.bofrm;
	
	    	 frm.cusTitle.value = cusTitle;
	    	 frm.cusContent.value = cusContent;
	    	 
	    	 frm.action = "updatepage.do";
	    	 frm.submit();
			return;
		} else {
			alert('작성자 본인의 글만 수정 가능합니다.')
		}  
		
	
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
	   alert('삭제하시겠습니까?')

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
			
   
   //댓글삭제
   $(".doDelete").on("click",function(){
		alert('댓글삭제클릭');

		var crSeq = $(this).attr('id'); //버튼값의 아이디를 가져온다 .
		//애초에 세션의 비교없이 관리자 아이디가 아니면 삭제 버튼을 사라지게 한다 .
		alert(crSeq);
		
	  	var cusSeq = $("#cusSeq").val();
	  	
	  	var tr = $(this).parents(".trclass");
	  	
	  	//등록된 아이디 값 뽑아오는 방법!!
		var rid = $(this).attr('id');
	  	alert(rid)
		
		
		
		
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