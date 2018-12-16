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
    	<input type="hidden" name="cusSeq"  id="cusSeq" value="<c:out value="${vo.cusSeq}"></c:out>">
    	<input type="hidden" name="cusTitle" id="cusTitle" value="<c:out value="${vo.cusTitle}"></c:out>">
    	<input type="hidden" name="cusContent" id="cusContent"  value="<c:out value="${vo.cusContent}"></c:out>">
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
                         </fieldset>
	 </form> <!-- end form -->
                        
						<button type="button" class="btn btn-default btn-sm" id="do_writepage" onclick="javascript:doUpdatePage();">수정페이지로</button>
						<button type="button" class="btn btn-default btn-sm" id="btnDelete" onclick="javascript:detail_delete();">삭제</button>
                   		
  </section>
  
  
  
  
   <script type="text/javascript">

    
   function doUpdatePage(){
    	 var frm = document.frmSave;
    	 frm.action = "updatepage.do";
    	 frm.submit();
     }
    

   function detail_delete(){
  	 var frm = document.frmSave;
  	 frm.action = "detail_delete.do";
  	 frm.submit();
   }
  
			
			

</script>
</body>
</html>