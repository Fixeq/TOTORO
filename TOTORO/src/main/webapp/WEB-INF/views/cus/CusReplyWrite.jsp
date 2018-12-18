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
	
	
	 
    <form name="bofrm" id="bofrm" action="rsave.do" method="post" class="form-inline">
	<fieldset>
			
						<input type="hidden" name="cusSeq" id="cusSeq" value="<c:out value="${vo3.cusSeq}"></c:out>" />
						<input type="hidden" name="userId" id="userId" value="${userId}" />
						<input type="hidden" name="crregId" id="crregId" value="${userId}" />
                        <div class="crContent">
                        <textarea name="crContent" id="crContent" class="full-width" placeholder="내용을 입력하세요" ></textarea>
                        </div>

                      

                    </fieldset>
 
    

    <div style="width:650px; text-align: center;">
        <button type="submit" class="submit btn btn--primary full-width" id="btnSave" onclick="javascript:doReplyWrite();">저장</button>
        <button type="reset">취소</button>
    </div>
</form>

                   		
  </section>
    <script type="text/javascript">

	

    function doReplyWrite(){
	
 	  	 var frm = document.bofrm;
     	 alert(frm.cusSeq.value);
     	 frm.action = "rsave.do";
     	 frm.submit();
      }
    </script>
</body>
</html>