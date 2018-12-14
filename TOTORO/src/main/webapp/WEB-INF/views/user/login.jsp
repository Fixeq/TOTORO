<%@page import="java.util.List"%>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.slf4j.Logger"%>
<%@ page import="com.sist.totoro.domain.UserVO"%>
<%@ page import="com.sist.totoro.code.CodeVO" %>
<%@ page import="com.sist.totoro.common.StringUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String cPath = request.getContextPath(); //totoro
    Logger log = LoggerFactory.getLogger(this.getClass());
    log.info("cPath:"+cPath);

%>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>

    <style type="text/css" media="screen">

		.dohyeon {
			font-family: 'Do Hyeon', sans-serif;
			font-size: 30px;
		}
		
		.nanum{
			font-family: 'Nanum Gothic', sans-serif;
		}

            	        
		/* -------------------------------------------------------------------
		 * ## subscribe form
		 * ------------------------------------------------------------------- */
		.s-footer__subscribe .subscribe-form {
		   margin: 0;
		   padding: 0;
/* 		   position: relative; */
		}
		
		.s-footer__subscribe #mc-form {
		   width: 100%;
		}
		
		.s-footer__subscribe #mc-form input[type="email"] {
		   width: 100%;
		   height: 5.4rem;
		   font-size: 1.5rem;
		   padding: 1.2rem 100px 1.2rem 60px;
		   background: url(../images/icons/icon-mail.svg) 20px center no-repeat, rgba(0, 0, 0, 0.1);
		   background-size: 24px 16px, auto;
		   margin-bottom: 1.8rem;
		   color: rgba(255, 255, 255, 0.5);
		   border-radius: 3px;
		   border: none;
		}
		
		.s-footer__subscribe #mc-form input[type="email"]:hover, 
		.s-footer__subscribe #mc-form input[type="email"]:focus {
		   color: #FFFFFF;
		}
		
		.s-footer__subscribe #mc-form input[type="email"]::-webkit-input-placeholder {
		   color: rgba(255, 255, 255, 0.2);
		}
		
		.s-footer__subscribe #mc-form input[type="email"]:-moz-placeholder {
		   color: rgba(255, 255, 255, 0.2);  /* Firefox 18- */
		}
		
		.s-footer__subscribe #mc-form input[type="email"]::-moz-placeholder {
		   color: rgba(255, 255, 255, 0.2);  /* Firefox 19+ */
		}
		
		.s-footer__subscribe #mc-form input[type="email"]:-ms-input-placeholder {
		   color: rgba(255, 255, 255, 0.2);
		}
		
		.s-footer__subscribe #mc-form input[type="email"].placeholder {
		   color: rgba(255, 255, 255, 0.2) !important;
		}
		
		.s-footer__subscribe #mc-form input[type=submit] {
		   /* position: absolute; */
		   top: 0;
		   right: 0;
		   color: #FFFFFF;
		   background: #0054a5;
		   border-color: #0054a5;
		   padding: 0 15px;
		   border-radius: 0 3px 3px 0;
		}
		
		.s-footer__subscribe #mc-form label {
		   color: #FFFFFF;
		   font-family: "metropolis-regular", sans-serif, sans-serif;
		   font-size: 1.3rem;
		   padding: 0 2rem;
		}
		
		.s-footer__subscribe #mc-form label i {
		   padding-right: 6px;
		}
		
		.login-vertical {
			vertical-align: middle;
		}
		
     </style> 
     
</head>
<body>
 <!-- pageheader
    ================================================== -->
    

    <!-- s-footer
    ================================================== -->
    <div class="s-footer login-vertical">
    	<div class ="row narrow section-intro add-bottom text-center login-vertical">
			<div class="col-twelve tab-full md-full end s-footer__subscribe login-vertical"> 
				<div class="subscribe-form login-vertical">
				    <br/><br/><br/><br/><br/>
				    <form id="mc-form" class="group" novalidate="true">
				
				        <input type="email" name="EMAIL" class="email" id="mc-email" placeholder="Email Address" required="">
						<input type="text" name="userId" class="userId" id="userId" placeholder="아이디" required="">	
				
				        <label for="mc-email" class="subscribe-message"></label>
				        <input type="submit" name="subscribe" value="로그인">
				
				    </form>
				</div>					
				<p>
				    <a class="btn btn--primary full-width" href="#0">로그인</a>
				    <a class="btn btn--stroke full-width" href="<%=cPath%>/user/join.do">회원가입</a>
				</p>
			</div>
		</div>
        


    </div> <!-- end s-footer -->

                


</body>
</html>