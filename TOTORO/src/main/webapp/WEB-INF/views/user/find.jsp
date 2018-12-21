<%@page import="java.util.ArrayList"%>
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
    
	List<CodeVO> user_status = (null == request.getAttribute("user_status"))
		     ?new ArrayList<CodeVO>():(List<CodeVO>)request.getAttribute("user_status");
	List<CodeVO> find_pw = (null == request.getAttribute("find_pw"))
		     ?new ArrayList<CodeVO>():(List<CodeVO>)request.getAttribute("find_pw");
	List<CodeVO> bank_list = (null == request.getAttribute("bank_list"))
		     ?new ArrayList<CodeVO>():(List<CodeVO>)request.getAttribute("bank_list");
    List<CodeVO> admin_list = (null == request.getAttribute("admin_list"))
		     ?new ArrayList<CodeVO>():(List<CodeVO>)request.getAttribute("admin_list");    
%>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>아이디,비밀번호 찾기</title>
	
	<style type="text/css" media="screen">

		.dohyeon {
			font-family: 'Do Hyeon', sans-serif;
			font-size: 30px;
		}
		
		.nanum{
			font-family: 'Nanum Gothic', sans-serif;
		}
		
		.container {
			padding:5% 0px 0px 0px;
		}


		.login-find-id-pw {
			padding: 0 0 25px;
		}

		.btn-success-moo {
			background: #DE6262;
			border-radius:0;
			border: 2px solid #DE6262;
			webkit-transition: all 400ms cubic-bezier(.4,0,.2,1);
			transition: all 400ms cubic-bezier(.4,0,.2,1);
			padding: 0, 0, 20%, 0;
		}
		
		.btn-success-moo:hover,.btn-success-moo:focus {
			background: rgba(26, 161, 157, 0);
			border: 2px solid #DE6262;
			webkit-transition: all 400ms cubic-bezier(.4,0,.2,1);
			transition: all 400ms cubic-bezier(.4,0,.2,1);
			color: #DE6262;
		}
		
		

		input[type=submit] {
		    font-weight:600;
		    cursor:pointer;  
		    background: #DE6262;
			border-radius:0;
			border: 2px solid #DE6262;
			webkit-transition: all 400ms cubic-bezier(.4,0,.2,1);
			transition: all 400ms cubic-bezier(.4,0,.2,1);
		    
		}
		
		input[type=submit]:hover,input[type=submit]:focus {
			background: rgba(26, 161, 157, 0);
			border: 2px solid #DE6262;
			webkit-transition: all 400ms cubic-bezier(.4,0,.2,1);
			transition: all 400ms cubic-bezier(.4,0,.2,1);
			color: #DE6262;
		}		
		
		a {
			color: #DE6262;
		}
		
		ul {
			list-style-type: none;
		}
		
		article[role="find"] {
			background: #fff;
			box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
			-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 10px rgba(0, 0, 0, 0.24);
			webkit-transition: all 400ms cubic-bezier(0.4, 0, 0.2, 1);
			transition: all 400ms cubic-bezier(0.4, 0, 0.2, 1);
			padding: 30px 50px;
			margin-bottom: 20px;
		}
		
		article[role="find"] input[type="submit"] {
			padding: 10px 15px;
			font-size: 16px;
		}
		
		article[role="find"]:hover {
			box-shadow: 0 10px 20px rgba(0, 0, 0, 0.19), 0 6px 6px rgba(0, 0, 0, 0.23);
			-webkit-box-shadow: 0 10px 20px rgba(0, 0, 0, 0.19), 0 1px 15px rgba(0, 0, 0, 0.23);
			webkit-transition: all 400ms cubic-bezier(0.4, 0, 0.2, 1);
			transition: all 400ms cubic-bezier(0.4, 0, 0.2, 1);
		}
		
		article[role="find"] h3 {
			font-size: 26px;
			font-weight: 300;
			color: #DE6262;
			margin-bottom: 20px;
		}
		
		article[role="find"] p {
			font-size: 16px;
			padding: 5px 15px;
		}
		
		.nav-tab-holder {
			padding: 0 0 0 30px;
			float: left;
		}
		
		.nav-tab-holder .nav-tabs {
			border: 0;
			float: none;
			display: table;
			table-layout: fixed;
			width: 100%;
		}
		
		.nav-tab-holder .nav-tabs > li {
			margin-bottom: -3px;
			text-align: center;
			padding: 0;
			display: table-cell;
			float: none;
			padding: 0;
		}
		
		.nav-tab-holder .nav-tabs > li > a {
			background: #d9d9d9;
			color: #6c6c6c;
			margin: 0;
			font-size: 18px;
			font-weight: 300;
		}
		
		.nav-tab-holder .nav-tabs > li.active > a, .nav-tabs > li.active > a:hover, .nav-tabs > li.active > a:focus {
			color: #FFF;
			background-color: #DE6262;
			border: 0;
			border-radius: 0;
		}
		
		.mobile-pull {
			float: left;
		}
		
		article[role="manufacturer"] {
			box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
			-webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 10px rgba(0, 0, 0, 0.24);
			padding: 0 0 40px;
			max-width: 420px;
			margin: -45px auto 0;
		}
		
		article[role="manufacturer"] header {
			background: #DE6262;
			color: #fff;
			padding: 10px;
			font-size: 18px;
			font-weight: 300;
		}
		
		article[role="manufacturer"] h1 {
			font-size: 26px;
			font-weight: 300;
			border-bottom: 1px solid #f2f2f2;
			padding: 25px 15px;
		}
		
		article[role="manufacturer"] ul {
			padding: 0 25px;
		}
		
		article[role="manufacturer"] ul li {
			font-size: 16px;
			border-bottom: 1px solid #eaeaea;
			padding: 20px 15px;
			color:#404040;
		}
		
		article[role="manufacturer"] ul li i {
			color: #DE6262;
		}
		
		.find-id-pw {
			padding: 0 0 25px;
		}
		
		@media only screen and (max-width: 767px) {
			.mobile-pull {
				float: none;
			}
		
			.nav-tab-holder {
				float: none;
				overflow: hidden;
			}

			.nav-tabs > li > a {
				font-size: 13px;
				font-weight: 600;
				padding: 10px 5px;
				overflow: hidden;
				text-overflow: ellipsis;
			}

			.nav-tabs > li {
				width: 50%;
			}
		}
		
		
		
	</style>
	
	<script type="text/javascript">
	
	$(document).ready(function(){
		//alert("i\'m ready");
		document.getElementById("id_found").style.visibility = "hidden";
		$("#findId").on("click",function(){
			
			if(""==$("#userEmailForFindId").val()){
				alert("이메일을 입력해주세요.");
				return;
			}
			$.ajax({
				url : "<%=cPath%>/user/find_id.do",
				type : "POST",
				dataType:"html",// JSON
				data : {
					"userEmail" : $("#userEmailForFindId").val()
				},
				success : function(data) {
					var parseData = $.parseJSON(data);
					if(null != parseData.userId){
						document.getElementById("id_found").style.visibility = "visible";
						$("#showId").html(parseData.userId);
					}else{
						alert("등록된 아이디가 없습니다.");
					}
				},
			})
		});
		
		
		$("#findPw").on("click",function(){
					
					if(""==$("#userIdForFindPw").val()){
						alert("아이디를 입력해주세요.");
						return;
					}
					if(""==$("#userFindAForFindPw").val()){
						alert("비밀번호 찾기 답변을 입력해주세요.");
						return;
					}
					$.ajax({
						url : "<%=cPath%>/user/find_pw.do",
						type : "POST",
						data : {
							userId : $("#userIdForFindPw").val(),
							userFindQ : $("#userFindQ option:selected").val(),
							userFindA : $("#userFindAForFindPw").val()
						},
						success : function(result) {
							alert(result);
						},
					})
				});
		//ajax
	});
	//document()
	</script>
	
</head>
<body>
	<div class="container">
		<div class="find-id-pw">
			<div class="row">
				<div class="col-sm-6 nav-tab-holder">
					<ul class="nav nav-tabs row" role="tablist">
						<li role="presentation" class="active col-sm-6"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">ID</a></li>
						<li role="presentation" class="col-sm-6"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">PASSWORD</a></li>
					</ul>
				</div>
			</div>
			
			
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="home">
					<div class="row">
						<div class="col-sm-6 mobile-pull">
							
 							<article role="find">
								<h3 class="text-center dohyeon"><i class="fa fa-lock"></i>  아이디</h3>
								<br/><br/>
								<div class="form-group">
                       				<label for="userEmailForFindId" class="pull-left nanum"><i class="fa fa-check"></i>Email</label>
									<input class="form-control" type="email" id="userEmailForFindId" name="userEmailForFindId" >
								</div>

								<div class="form-group">
									<a id="findId" class="btn btn-success-moo dohyeon">아이디 찾기</a>
								</div>
							</article> 							
							
						</div>

						<div class="col-sm-6">
							<article role="manufacturer"  class="text-center">
								<header class="dohyeon">
								아이디 찾기
								</header>
								<div id="id_found">
								 <!-- style="visibility: hidden;" -->
									<h3 class="text-center dohyeon"><i class="fa fa-unlock"></i>아이디</h3>
									<ul class="text-left">
										<li><i class="fa fa-check"></i> <span id="showId"></span><br/></li>
									</ul>
									<a href="<%=cPath%>/user/login.do" class="btn btn-success-moo dohyeon">로그인 하러가기.</a>
								</div>
							</article>
						</div>
					</div>
					<!-- end of row -->
				</div>
				<!-- end of home -->

				<div role="tabpanel" class="tab-pane" id="profile">
					<div class="row">
						<div class="col-sm-6 mobile-pull">
							<article role="find">
								<h3 class="text-center dohyeon"><i class="fa fa-lock"></i> 비밀번호</h3>
								
								<!-- 찾았을때 변경?  -->
								<!-- <h3 class="text-center"><i class="fa fa-unlock"></i> 비밀번호</h3> -->
								<br/><br/>
																
								<div class="form-group">
                       				<label for="userIdForFindPw" class="pull-left nanum"><i class="fa fa-check"></i>ID</label>
									<input class="form-control" type="text" id="userIdForFindPw" name="userIdForFindPw" placeholder="ID">
								</div>
								<br/>
								
								<div class="form-group">
                       				<label class="pull-left nanum"><i class="fa fa-check"></i>Question</label>
                       				<div class="cl-custom-select nanum">
                       					<%=StringUtil.makeSelectBox((List<CodeVO>)request.getAttribute("cdListC002"), "", "userFindQ", false) %>
                       				</div>
                      				</div>
                      				<br/>
                      				
                   				<div class="form-group">
									<label for="userFindAForFindPw" class="pull-left" ><i class="fa fa-check"></i>Answer</label>
                      					<input class="full-width nanum" type="text"  id="userFindAForFindPw" name="userFindAForFindPw" required>
								</div>
								<div class="form-group">
									<a id="findPw" class="btn btn-success-moo dohyeon">비밀번호 찾기</a>
								</div>
							</article>
						</div>

						<div class="col-sm-6">
							<article role="manufacturer"  class="text-center">
								<header class="dohyeon">
								비밀번호 찾기
								</header>
								<div id="pw_found">
								 <!-- style="visibility: hidden;" -->
									<h3 class="text-center dohyeon"><i class="fa fa-unlock"></i>비밀번호</h3>
									<ul class="text-left">
										<li><i class="fa fa-check"></i> 왼쪽의 정보를 입력하시면 이메일로 임시 비밀번호가 발송 됩니다. :)<br/></li>
									</ul>
									<a href="<%=cPath%>/user/login.do" class="btn btn-success-moo dohyeon">로그인 하러가기.</a>
								</div>
							</article>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>