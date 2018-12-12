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
	
	
	
	
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TOTORO 회원가입</title>

    <style type="text/css" media="screen">
        .s-styles { 
            background: #f2f2f2;
            padding-top: 12rem;
            padding-bottom: 12rem;
        }

        .s-styles .section-intro h1 {
            margin-top: 0;
        }
     </style> 

</head>
<body id="top">

<!-- styles
    ================================================== -->




    <section id="styles" class="s-styles">
        
        <div class="row narrow section-intro add-bottom text-center">
            <div class="col-twelve tab-full">
                <h1>회원가입</h1>
                <!-- TODO action 맞음? -->
                <form id="joinForm" action="<%=cPath%>/user/save.do" method="post">
                    <div>
                        <label for="userId" class="pull-left" >ID</label>
                        <input class="full-width" type="text"  id="userId" name="userId" required placeholder="숫자 영문 조합 8~15자 입력해주세요.">
                        <span id="id_check" class="pull-left" style="color:red"></span><br/>  
                    </div>
                    <div>
                        <label for="userPw" class="pull-left" >PassWord</label>
                        <input class="full-width" type="password"  id="userPw" name="userPw" required placeholder="숫자 영문 조합 8~14자 입력해주세요.">
                    </div>
                    <div>
                        <label for="userPw2" class="pull-left" >PW Confirm</label>
                        <input class="full-width" type="password"  id="userPw2" required placeholder="비밀번호를 한번 더 입력해주세요." >
                        <span id="pw_check" class="pull-left" style="color:red"></span><br/> 
                    </div>   
                            <!-- validation해야댐 이메일형식인지-->                     
                    <div>
                        <label for="userEmail" class="pull-left" >Email</label>
                        <input class="full-width" type="text"  id="userEmail" name="userEmail" required placeholder="이메일 인증 후 관리자 승인 후 로그인이 가능합니다." >>
                        <span id="email_check" class="pull-left" style="color:red"></span><br/>  
                    </div>
                             <!-- validation해야댐 번호 제대로 입력했나 저렇게 onlyNum-->           			
         			<div>
                        <label for="userTel" class="pull-left" >Cell Phone Number</label>
                        <input class="full-width" type="text"  id="userTel" name="userTel" required placeholder="(-)를 제외한 번호를 입력해주세요" >
                        <span id="tel_check" class="pull-left" style="color:red"></span><br/>  
                    </div>
                    <div>
                        <label for="userName" class="pull-left" >Account Holder</label>
                        <input class="full-width" type="text"  id="userName" name="userName" required placeholder="예금주" >
                    </div>
                    <div>
                        <label for="userBank" class="pull-left">Bank</label>
                        <div class="cl-custom-select">
							<%=StringUtil.makeSelectBox((List<CodeVO>)request.getAttribute("cdListC003"), "", "userBank", false) %>
                        </div>
                    </div>
                    <!-- validation해야댐 번호 제대로 입력했나 저렇게 onlyNum -->                              			
                    <div>
                        <label for="userAccount" class="pull-left" >Account Number</label>
                        <input class="full-width" type="text"  id="userAccount" name="userAccount" required placeholder="(-)를 제외한 번호를 입력해주세요" >
                        <span id="account_check" class="pull-left" style="color:red"></span><br/>  
                    </div>
                    <div>
                        <label for="userFindQ" class="pull-left">Password Find Question</label>
                        <div class="cl-custom-select">
                        	<%=StringUtil.makeSelectBox((List<CodeVO>)request.getAttribute("cdListC002"), "", "userFindQ", false) %>
                        </div>
                    </div>                                           
                    <div>
                        <label for="userFindA" class="pull-left" >Password Find Answer</label>
                        <input class="full-width" type="text"  id="userFindA" name="userFindA" required placeholder="기억할 수 있는 것으로 하세요.^^" >
                    </div>
                    <input class="btn--primary full-width" type="submit" value="Submit">
                </form>
            </div>
        </div>
    </section> <!-- end styles -->







</body>
</html>