<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.slf4j.Logger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core" %>
    

<% 
	String cPath = request.getContextPath();
	Logger log = LoggerFactory.getLogger(this.getClass());
	log.debug("cPath:"+cPath);
	//cPath : totoro
	

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>

             <div class="col-six tab-full"> 

                <p>
                    <a class="btn btn--primary full-width" href="#0">로그인</a>
                    <a class="btn btn--stroke full-width" href="<%=cPath%>/user/join.do">회원가입</a>
                </p>
                
		<div class="row top">

            <div class="col-nine md-six tab-full popular">

            </div> <!-- end popular -->
            
            <div class="col-three md-six tab-full about">
                <ul class="about__social">
                    <li>
                        <a href="#0"><i class="fa fa-facebook" aria-hidden="true"></i> 회원가입</a>
                    </li>
                    <br/>
                    <li>
                        <a href="#0"><i class="fa fa-google" aria-hidden="true"></i></a>
                    </li>
                </ul> <!-- end header__social -->
            </div> <!-- end about -->
        </div> <!-- end row -->

</section>
</body>
</html>