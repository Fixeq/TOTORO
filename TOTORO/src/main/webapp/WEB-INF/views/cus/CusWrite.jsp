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

	 
    <form name="form1" method="post" >
<fieldset>

                        <div class="form-field">
                            <input name="cusTitle" type="text" id="cusTitle" class="full-width" placeholder="제목을 입력하세요" value="">
                        </div>

                        <div class="form-field">
                        		<input name="userId" type="hidden" id="userId" class="full-width" placeholder="아이디" value="${userId}">
                            <!-- <input name="userId" type="text" id="userId" class="full-width" placeholder="아이디" value=""> -->
                        </div>

                        <div>
								<label>분류&nbsp;</label><select name="cusCat" id="cusCat">
									<option value="입출금" selected="selected">입출금</option>
									<option value="배팅">배팅</option>
									<option value="기타">기타</option>
								</select>
							</div>


                        <div class="message form-field">
                        <textarea name="cusContent" id="cusContent" class="full-width" placeholder="내용을 입력하세요" ></textarea>
                        </div>

                      

                    </fieldset>
 
    						

    <div style="width:650px; text-align: center;">
        <button type="submit" class="submit btn btn--primary full-width" id="btnSave">저장</button>
        <button type="submit" class="submit btn btn--primary full-width" onclick="javascript:doListPage();">이전</button>
    </div>
</form>

                   		
  </section>
    <script type="text/javascript">
    
    function doListPage(){
     	 var frm = document.form1;
     	 frm.action = "search.do";
     	 frm.submit();
      }


    $(document).ready(function(){
        $("#btnSave").click(function(){

   
  
        	if($("#cusTitle").val() == "" || $("#cusContent").val() == ""){
        		alert('제목이나 내용은 공란일수없습니다.')
           	return;
      
            
        	} else {
        		  // 폼에 입력한 데이터를 서버로 전송
        		   document.form1.action = "save.do";
        		 document.form1.submit();
        	}
        });
    });
    </script>
</body>
</html>