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

	 
    <form name="form1" method="post" action="rsave.do">
<fieldset>

                        <div class="form-field">
                            <input name="cusSeq" type="text" id="cusSeq" class="full-width" placeholder="게시글 번호" value="">
                        </div>

                        <div class="form-field">
                        		<input name="userId" type="hidden" id="userId" class="full-width" placeholder="아이디" value="${userId}">
                            <!-- <input name="userId" type="text" id="userId" class="full-width" placeholder="아이디" value=""> -->
                        </div>

                        <div class="form-field">용
                            <input name="crContent" type="text" id="crContent" class="full-width" placeholder="댓글내용"  value="">
                        </div>
                
                          <div class="form-field">
                            <input name="crregId" type="hidden" id="crregId" class="full-width" placeholder="등록자"  value="${userId}">
                        </div>
                        <div class="form-field">
                            <input name="crregDt" type="hidden" id="crregDt" class="full-width" placeholder="댓글등록일"  value="">
                        </div>

                        <div class="message form-field">
                        <textarea name="cusContent" id="cusContent" class="full-width" placeholder="내용을 입력하세요" ></textarea>
                        </div>

                      

                    </fieldset>
 
    

    <div style="width:650px; text-align: center;">
        <button type="submit" class="submit btn btn--primary full-width" id="btnSave">저장</button>
        <button type="reset">취소</button>
    </div>
</form>

                   		
  </section>
    <script type="text/javascript">



    $(document).ready(function(){
        $("#btnSave").click(function(){

        	var cusSeq = $("#cusSeq").val();
            var crSeq = $("#crSeq").val();
            
            var userId = $("#userId").val();
            var crContent = $("#crContent").val();
            var crregId = $("#crregId").val();
            var crregDt = $("#crregDt").val();

           
            // 폼에 입력한 데이터를 서버로 전송
            document.form1.submit();
        });
    });
    </script>
</body>
</html>