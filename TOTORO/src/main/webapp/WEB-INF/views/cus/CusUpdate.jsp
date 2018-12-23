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

	 
    <form name="form2" method="post" >
   
<fieldset><input type="hidden" name="cusSeq"  id="cusSeq" value="<c:out value="${vo.cusSeq}"></c:out>">

                        <div class="titleform">
                            <input name="cusTitle" type="text" id="cusTitle" class="full-width" value="<c:out value="${vo.cusTitle}"></c:out>"></input>
                        </div>

                       <div>
								<label>분류&nbsp;</label><select name="cusCat" id="cusCat">
									<option value="입출금" selected="selected">입출금</option>
									<option value="배팅" <c:if test="${vo.cusCat == '1'}" >selected='selected'</c:if> >배팅</option>
									<option value="기타" <c:if test="${vo.cusCat == '1'}" >selected='selected'</c:if> >기타</option>
								</select>
							</div>

                        <div class="contentform">
                        <textarea name="cusContent" id="cusContent" class="full-width" ><c:out value="${vo.cusContent}"></c:out></textarea>
                        </div>

                      

                    </fieldset>

    

   <div style="text-align:center;">
        <button type="submit" class="btn btn--primary btn-sm" id="btnUpdate" >수정</button>
        <button type="submit" class="btn btn--stroke" onclick="javascript:readpage();">이전</button>
    </div>
</form>

                   		
  </section>
    <script type="text/javascript">
    function readpage(){
    	 var frm = document.form2;
    	 frm.action = "do_search_one.do";
    	 frm.submit();
     }


    /**function update(){ 	 
	  	 var form2 = document.form2;


   	 
   	form2.action = "update.do";
   	form2.submit();
    }*/
    
    
    
    
    
    
    
    $(document).ready(function(){
        $("#btnUpdate").click(function(){
				
  			 if(false==confirm("수정 하시겠습니까?"))return;
  
        	if($("#cusTitle").val() == "" || $("#cusContent").val() == ""){
        		alert('제목이나 내용은 공란일수없습니다.')
           	return;
      
            
        	} else {
        		  // 폼에 입력한 데이터를 서버로 전송
        		   document.form2.action = "update.do";
        		 document.form2.submit();
        	}
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
    	$("#cusContent").keydown(function(key) {
    		if (key.keyCode == 13) {
    		
    		if(false==confirm("수정 하시겠습니까?"))return;
    		   
    		  
        	if($("#cusTitle").val() == "" || $("#cusContent").val() == ""){
        		alert('제목이나 내용은 공란일수없습니다.')
           	return;
      
            
        	} else {
        		  // 폼에 입력한 데이터를 서버로 전송
        		   document.form2.action = "update.do";
        		 document.form2.submit();
        	}
        	
    		}
    	});
        
    });
    </script>
</body>
</html>