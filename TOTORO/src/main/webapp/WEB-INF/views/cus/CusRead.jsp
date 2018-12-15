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
 
    <form name="cForm" id="cForm" method="post" action="update.do">
    
                    <fieldset>

                        <div class="text">
                            <input name="cName" type="text" id="cusTitle" class="full-width" placeholder="Title" value="${customerVo.getCusSeq() }">
                        </div>
                        
                        

						   
						   
                        <div class="message form-field">
                        <textarea name="cMessage" id="cusContent" class="full-width" placeholder="voice of Customer" ></textarea>
                        </div>
                         </fieldset>
	 </form> <!-- end form -->
                        <input type="submit" class="submit btn btn--primary full-width" value="글작성하기" id="save_btn" onclick="javascript:do_save();"/>

                   		
  </section>
</body>
</html>