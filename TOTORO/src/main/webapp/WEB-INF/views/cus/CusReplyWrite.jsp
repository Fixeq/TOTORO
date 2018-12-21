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
	
	
	 
    <form name="bofrm" id="bofrm"  method="post" class="form-inline">
	<fieldset>
			
						<input type="hidden" name="cusSeq" id="cusSeq" value="<c:out value="${vo3.cusSeq}"></c:out>" />
						<input type="hidden" name="userId" id="userId" value="${userId}" />
						<input type="hidden" name="crregId" id="crregId" value="${userId}" />
                        <div class="crContent">
                        <textarea name="crContent" id="crContent" class="full-width" placeholder="내용을 입력하세요" ></textarea>
                        </div>

                      

                    </fieldset>
 
    

    <center>
        <button type="submit" class="btn btn--primary btn-sm" id="btnSave" >답글저장</button>
        <button type="submit" class="btn btn--stroke" onclick="javascript:readpage();">이전</button>
   </center>
</form>

                   		
  </section>
    <script type="text/javascript">
    function readpage(){
   	 var frm = document.bofrm;
   	 frm.action = "do_search_one.do";
   	 frm.submit();
    }
	

    /**function doReplyWrite(){
	
 	  	 var frm = document.bofrm;
     	 alert(frm.cusSeq.value);
     	 frm.action = "rsave.do";
     	 frm.submit();
      }*/

    $(document).ready(function(){
        $("#btnSave").click(function(){

   
  
        	if( $("#crContent").val() == ""){
        		alert(' 내용은 공란일수없습니다.')
           	return;
      
            
        	} else {
        		  // 폼에 입력한 데이터를 서버로 전송
        		   document.bofrm.action = "rsave.do";
        		 document.bofrm.submit();
        	}
        });
    });
    </script>
</body>
</html>