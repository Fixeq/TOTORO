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
    	
    	

                        <div class="titleform">
                            <input name="cusTitle" type="text" id="cusTitle" class="full-width" placeholder="<c:out value="${vo.cusTitle}"></c:out>" value=""></input>
                        </div>

                        <div class="catfrom">
                            <input name="cusCat" type="text" id="cusCat" class="full-width" placeholder="<c:out value="${vo.cusCat}"></c:out>" value=""></input>
                        </div>

                       


                        <div class="contentform">
                        <textarea name="cusContent" id="cusContent" class="full-width"  placeholder="<c:out value="${vo.cusContent}"></c:out>" value=""></textarea>
                        </div>

                      

                    </fieldset>
 
    

    <div style="width:650px; text-align: center;">
        <button type="submit" class="submit btn btn--primary full-width" id="btnUpdate" onclick="javascript:update();">수정</button>
        <button type="submit" class="submit btn btn--primary full-width" onclick="javascript:readpage();">이전</button>
    </div>
</form>

                   		
  </section>
    <script type="text/javascript">
    function readpage(){
    	 var frm = document.form2;
    	 frm.action = "do_search_one.do";
    	 frm.submit();
     }


    function update(){ 	 
	  	 var form2 = document.form2;


   	 
   	form2.action = "update.do";
   	form2.submit();
    }
    </script>
</body>
</html>