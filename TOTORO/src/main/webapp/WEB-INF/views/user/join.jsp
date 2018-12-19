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

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>



<style>
	body
	{
	    background-color: #1b1b1b;
	    padding-top: 40px;
	}
	.form-signin {
	    max-width: 800px;
	    padding: 15px;
	    margin:100px;
	    margin-top:10px;
	  }
	
	.input-group-addon
	{
	    background-color: #DE6262;
	    border-color: #C90000;
	    color: rgb(255, 255, 255);
	}
	.form-control:focus
	{
	    background-color: #DE6262;
	    border-color: #C90000;
	    color: #FFFFFF;
	}
	.panel-default {
	opacity: 0.93;
	/*margin-top:30px;*/
	}
	.form-signup input[type="text"],.form-signup input[type="password"] { border: 1px solid #DE6262; }
	.fullscreen_bg {
	    /* position: fixed; */
	    top: 0;
	    right: 0;
	    bottom: 0;
	    left: 0;
	    background-size: cover;
	    background-position: 50% 50%;
	    background-image: url('<%=cPath%>/resources/images/ban/join.jpg');
	    background-repeat:repeat;
	  }
	  
	  
	.dohyeon {
		font-family: 'Do Hyeon', sans-serif;
		font-size: 30px;
	}
	
	.dohyeonForCheck {
		font-family: 'Do Hyeon', sans-serif;
		font-size: 16px;
		
	}
	
	input[type="text"]:focus,input[type="password"]:focus,input[type="email"]:focus{
	    color: #FFFFFF;
	}	

	.nanum{
		font-family: 'Nanum Gothic', sans-serif;
	}	  
  
	  
</style>

<script>
	
	function pw_check(){
		var userPw = $('#userPw').val();
		var userPwCF=$('#userPwCF').val();
		
		if(userPwCF =="") {
			$("#joinBtn").attr("disabled", "disabled");
		}else if(userPw != userPwCF){
			$("#pw_check").css("color", "red");
			$("#pw_check").html('<span class="glyphicon glyphicon-remove"></span>'+" 동일한 비밀번호를 입력해주세요..");
			$("#joinBtn").attr("disabled", "disabled");
		}else if(userPw = userPwCF){
			$("#pw_check").css("color", "#6DD66D");
			$("#pw_check").html('<span class="glyphicon glyphicon-ok"></span>'+" 확인되었습니다.");
			$("#joinBtn").removeAttr("disabled");
		}else if(userPwCF ==""){
			$("#joinBtn").attr("disabled", "disabled");
		}
	}
	
	$(document).ready(function(){
		//alert("ready");
	       
		//숫자만 입력
        $(".onlynum").keyup(function(){
			$(this).val( $(this).val().replace(/[^0-9]/g,"") );
		});//--onlynum 
		       
		//영문자 입력
		$(".onlyeng").keyup(function(){
			$(this).val( $(this).val().replace(/[^A-z]/g,"") );
		});//--onlynum 
		
		//소문자, 숫자만 입력
		$(".onlynumeng").keyup(function(){
			$(this).val( $(this).val().replace(/[^a-z0-9]/g,"") );
		});//--onlynumeng
		       
		//아이디 중복검사 및 6~12자 입력확인
		$("#userId").keyup(function() {
			$.ajax({
				url : "<%=cPath%>/user/check_id.do",
				type : "POST",
				data : {
					userId : $("#userId").val()
				},
				success : function(result) {
					if (result > 0) {
						$("#id_check").css("color", "red");
						$("#id_check").html('<span class="fa fa-warning"></span>'+" 이미 사용중이거나 탈퇴한 아이디입니다.");
						$("#joinBtn").attr("disabled", "disabled");
					}else if( (0<=$("#userId").val().length && $("#userId").val().length<6) 
							|| $("#userId").val().length>12){
						$("#id_check").css("color", "red");
						$("#id_check").html('<span class="glyphicon glyphicon-remove"></span>'+" 6~12자를 입력해주세요.");
						$("#joinBtn").attr("disabled", "disabled");
					}else if(result ==0 && $("#userId").val().length !=0) {
						$("#id_check").css("color", "#6DD66D");
						$("#id_check").html('<span class="glyphicon glyphicon-ok"></span>'+" 멋진 아이디네요!");
						$("#joinBtn").removeAttr("disabled");
					}
				},
			})
		});

		//이메일 중복검사
		$("#userEmail").keyup(function() {
			$.ajax({
				url : "<%=cPath%>/user/check_email.do",
				type : "POST",
				data : {
					userEmail : $("#userEmail").val()
				},
				success : function(result) {
					if (result > 0) {
						$("#email_check").css("color", "red");
						$("#email_check").html('<span class="fa fa-warning"></span>'+" 이미 사용되고 있는 이메일입니다.");
						$("#joinBtn").attr("disabled", "disabled");
					}else if(result ==0 && $("#userEmail").val().length !=0) {
						$("#email_check").html("");
						$("#joinBtn").removeAttr("disabled");
					}
				},
			})
		});

		//전화번호 중복검사
		$("#userTel").keyup(function() {
			$.ajax({
				url : "<%=cPath%>/user/check_tel.do",
				type : "POST",
				data : {
					userTel : $("#userTel").val()
				},
				success : function(result) {
					if (result > 0) {
						$("#tel_check").css("color", "red");
						$("#tel_check").html('<span class="fa fa-warning"></span>'+"이미 사용되고 있는 전화번호입니다..");
						$("#joinBtn").attr("disabled", "disabled");
					}else if(result ==0 && $("#userTel").val().length>10) {
						$("#tel_check").css("color", "#6DD66D");
						$("#tel_check").html('<span class="glyphicon glyphicon-ok"></span>'+"사용가능한 전화번호입니다.");
						$("#joinBtn").removeAttr("disabled");
					}
				},
			})
		});
		
		//계좌번호 중복검사
		$("#userAccount").keyup(function() {
			$.ajax({
				url : "<%=cPath%>/user/check_account.do",
				type : "POST",
				data : {
					userAccount : $("#userAccount").val()
				},
				success : function(result) {
					if (result > 0) {
						$("#account_check").css("color", "red");
						$("#account_check").html('<span class="fa fa-warning"></span>'+"중복된 계좌번호가 있습니다.");
						$("#joinBtn").attr("disabled", "disabled");
					}else if(result ==0 && $("#userAccount").val().length !=0) {
						$("#account_check").html("");
						$("#joinBtn").removeAttr("disabled");
					}
				},
			})
		});
		
	});

</script>

<title>TOTORO 회원가입</title>

</head>
<body style="overflow:scroll;" >

<!-- styles
    ================================================== -->


<div id="fullscreen_bg" class="fullscreen_bg"/>
	<div class="form-signin" >
		<div class="container" >
	    	<div class="row">
	        	<div class="col-md-6 col-md-offset-6">
	            	<div class="panel panel-default">
	                	<div class="panel-body">
	                    	<h3 class="text-center dohyeon">
	                        	회원가입</h3>
                        	<form id="joinForm" action="<%=cPath%>/user/save.do" class="form form-signup" method="post">
								<div class="form-group">
									<div class="input-group">
										<span class="input-group-addon">
											<span class="glyphicon glyphicon-user"></span>
										</span>
										<input class="form-control onlynumeng " type="text"  id="userId" name="userId" 
										required placeholder="아이디 (숫자 영문 조합 6~12자 입력해주세요)">
									</div>
									<span id="id_check" class="pull-right dohyeonForCheck" ></span><br/>
								</div>
		                    
								<div class="form-group">
									<div class="input-group">
										<span class="input-group-addon">
											<span class="glyphicon glyphicon-lock"></span>
										</span>
										<input class="form-control userPw " type="password"  id="userPw" name="userPw" 
			                        	required placeholder="비밀번호 (8~15자 영문 대 소문자,숫자,특수문자를 사용하세요)" oninput="pw_check()">
									</div>
									<br/>
								</div>
								
								<div class="form-group">
									<div class="input-group">
										<span class="input-group-addon">
											<span class="glyphicon glyphicon-lock"></span>
										</span>
										<input class="form-control userPw " type="password"  id="userPwCF"  
			                        	required placeholder="비밀번호를 한번 더 입력해주세요." oninput="pw_check()">
									</div>
									<span id="pw_check" class="pull-right dohyeonForCheck" ></span><br/>
								</div>								
								
								<div class="form-group">
									<div class="input-group">
										<span class="input-group-addon">
											<span class="glyphicon glyphicon-envelope"></span>
										</span>
										<input type="email" id="userEmail" name="userEmail" class="form-control" placeholder="이메일 (관리자 승인 후 로그인이 가능합니다)" />
									</div>
									<span id="email_check" class="pull-right dohyeonForCheck" ></span><br/>
								</div>
		                    
								<div class="form-group">
									<div class="input-group">
										<span class="input-group-addon">
											<span class="glyphicon glyphicon-earphone"></span>
										</span>
		                            	<input type="text" class="form-control onlynum" id="userTel" name="userTel" required placeholder="휴대폰 (숫자만 입력가능합니다)"  />
									</div>
									<span id="tel_check" class="pull-right dohyeonForCheck" style="color:red"></span><br/> 
								</div>
		                    
								<div class="form-group">
									<div class="input-group">
										<span class="input-group-addon">
											<span class="glyphicon glyphicon-home"></span>
										</span>
										<input type="text" class="form-control"  id="userName" name="userName" required placeholder="예금주" />
									</div>
									<br/>
								</div>

								<div class="form-group">
									<div class="input-group">
										<span class="input-group-addon">
											<span class="fa fa-dollar"></span>
										</span>
										<%=StringUtil.makeSelectBox((List<CodeVO>)request.getAttribute("cdListC003"), "", "userBank", false) %>
									</div>
									<br/>
								</div>
               
								<div class="form-group">
									<div class="input-group">
										<span class="input-group-addon">
											<span class="glyphicon glyphicon-usd"></span>
										</span>
										<input type="text" class="form-control onlynum"  id="userAccount" name="userAccount" required placeholder="계좌번호(숫자만 입력가능합니다)" />
									</div>
									<span id="account_check" class="pull-right dohyeonForCheck" style="color:red"></span><br/>
								</div>
								
 								
								<div class="form-group">
									<div class="input-group">
										<span class="input-group-addon">
											<span class="fa fa-question"></span>
										</span>
										<%=StringUtil.makeSelectBox((List<CodeVO>)request.getAttribute("cdListC002"), "", "userFindQ", false) %>
									</div>
								</div>		
								
																						
								<div class="form-group">
									<div class="input-group">
										<span class="input-group-addon">
											<span class="glyphicon glyphicon-heart-empty"></span>
										</span>
										<input type="text" class="form-control"   id="userFindA" name="userFindA" required placeholder="기억할 수 있는 것으로 하세요.^^" />
									</div>
								</div>                                       
								<input class="btn--primary full-width" type="submit" value="Submit" id="joinBtn">
							</form>
						</div>
					</div>
				</div>
			</div>R
		</div>
	</div>
</body>
</html>



