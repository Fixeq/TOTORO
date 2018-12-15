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

                     <section class="s-content s-content--narrow">

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
                        <input type="submit" class="submit btn btn--primary full-width" value="답변작성하기" id="save_btn" onclick="javascript:do_save();"/>

                   		
  </section>
</body>
</html>