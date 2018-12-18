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

	 
    <form name="form2" method="post" action="update.do">
   
<fieldset><input type="hidden" name="cusSeq"  id="cusSeq" value="<c:out value="${vo.cusSeq}"></c:out>">
    	
    	

                        <div class="form-field">
                            <input name="cusTitle" type="text" id="cusTitle" class="full-width" placeholder="제목" value="<c:out value="${vo.cusTitle}"></c:out>">
                        </div>

                        <div class="form-field">
                            <input name="cusCat" type="text" id="cusCat" class="full-width" placeholder="분류" value="<c:out value="${vo.cusCat}"></c:out>">
                        </div>

                        <div class="form-field">
                            <input name="cusregid" type="text" id="cususerId" class="full-width" placeholder="등목록"  value="">
                        </div>


                        <div class="message form-field">
                        <textarea name="cusContent" id="cusContent" class="full-width"  value=""><c:out value="${vo.cusContent}"></c:out></textarea>
                        </div>

                      

                    </fieldset>
 
    

    <div style="width:650px; text-align: center;">
        <button type="submit" class="submit btn btn--primary full-width" id="btnUpdate">수정</button>
        <button type="reset">취소</button>
    </div>
</form>

                   		
  </section>
    <script type="text/javascript">



    function update(){
	   	 var cusContent = $('.lead').text();
	   	 alert(cusContent);
	   	 var cusTitle = $('.cusTitleValue').text();
	   	 alert(cusTitle);
	   	 
	  	 var frm = document.bofrm;
   	 alert(frm.cusSeq.value);
   	 alert(frm.userId.value);
   	 frm.cusTitle.value = cusTitle;
   	 frm.cusContent.value = cusContent;
   	 
   	 frm.action = "update.do";
   	 frm.submit();
    }
    </script>
</body>
</html>