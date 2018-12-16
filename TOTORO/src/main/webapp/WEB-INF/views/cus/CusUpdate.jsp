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
                            <input name="cusTitle" type="text" id="cusTitle" class="full-width"  value="<c:out value="${vo.cusTitle}"></c:out>">
                        </div>

                        <div class="form-field">
                            <input name="cusCat" type="text" id="cusCat" class="full-width" placeholder="분류" value="<c:out value="${vo.cusCat}"></c:out>">
                        </div>

                        <div class="form-field">
                            <input name="cusregid" type="text" id="cusregid" class="full-width" placeholder="등록"  value="">
                        </div>
                        <div class="form-field">
                            <input name="cusModid" type="text" id="cusModid" class="full-width" placeholder="수정자"  value="<c:out value="${vo.cusModid}"></c:out>">
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



    $(document).ready(function(){
        $("#btnUpdate").click(function(){
            //var title = document.form1.title.value; ==> name속성으로 처리할 경우
            //var content = document.form1.content.value;
            //var writer = document.form1.writer.value;
            var title = $("#cusTitle").val();
            var content = $("#cusContent").val();
            var userId = $("#cusModid").val();
            var cusCat = $("#cusCat").val();
            var cusReply = $("#cusReply").val();


           
            // 폼에 입력한 데이터를 서버로 전송
            document.form2.submit();
        });
    });
    </script>
</body>
</html>