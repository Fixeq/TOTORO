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
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>로그인</title>

	    <style type="text/css" media="screen">
			
			.login-block{
				background: #DE6262;  /* fallback for old browsers */
				background: -webkit-linear-gradient(to bottom, #FFB88C, #DE6262);  /* Chrome 10-25, Safari 5.1-6 */
				background: linear-gradient(to bottom, #FFB88C, #DE6262); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
				float:left;
				width:100%;
				padding : 50px 0;
			}
			
			.banner-sec{ min-height:500px; border-radius: 0 10px 10px 0; padding:0px 0px 0px 30px;}
			.container{background:#fff; border-radius: 10px; box-shadow:15px 20px 0px rgba(0,0,0,0.1);}
			.carousel-inner{border-radius:0 10px 10px 0;}
			.login-sec{padding: 50px 30px; position:relative;}
			.login-sec .copy-text{position:absolute; width:80%; bottom:20px; font-size:13px; text-align:center;}
			.login-sec .copy-text i{color:#FEB58A;}
			.login-sec .copy-text a{color:#E36262;}
			.login-sec h2{margin-bottom:30px; font-weight:800; font-size:30px; color: #DE6262;}
			.login-sec h2:after{content:" "; width:100px; height:5px; background:#FEB58A; display:block; margin-top:20px; border-radius:3px; margin-left:auto;margin-right:auto}
			
			.dohyeon {
				font-family: 'Do Hyeon', sans-serif;
				font-size: 30px;
			}
			
			.nanum{
				font-family: 'Nanum Gothic', sans-serif;
			}
	
	            	        
	        .s-styles { 
	            background: #f2f2f2;
	            padding-top: 12rem;
	            padding-bottom: 12rem;
	        }
	
	        .s-styles .section-intro h1 {
	            margin-top: 0;
	        }
			
			input[type=button] {
			    font-weight:600;
			    cursor:pointer;
				border:0 none;
			    border-radius: 10px;
			
				color:#DE6262;
			    background-color:rgba(255,255,255,1.0);
			}

			input[type=submit] {
			    font-weight:600;
			    cursor:pointer;
   				border:0 none;
			    border-radius: 10px;

				color:#DE6262;
			    background-color:rgba(255,255,255,1.0);
			}
			
 			input[type=button]:hover {
			    color:rgba(255,255,255,1.0);
			    background-color:#DE6262;
			}
 			input[type=submit]:hover {
			    color:rgba(255,255,255,1.0);
			    background-color:#DE6262;
			}			
			
	     </style> 
     
	</head>
	<body>
	
		<section class="login-block">
			<div class="container">
				<div class="row">
					<!------------------------------------ login area ------------------------------------>
					<div class="col-md-4 login-sec dohyeon">
					    <h2 class="text-center">로그인</h2>
					    <form class="login-form" action="<%=cPath%>/user/loginCheck.do" method="post">
		  					<div class="form-group">
							    <label for="userId" class="text-uppercase">id</label>
							    <input type="text"  id="userId" name="userId" class="form-control " />
		  					</div>
							<div class="form-group">
								<label for="userPw" class="text-uppercase">Password</label>
								<input type="password" id="userPw" name="userPw" class="form-control" />
							</div>
		    
							<div class="form-check">
								<input type="button" class="btn float-left dohyeon" value="회원가입" onclick="location.href='<%=cPath%>/user/join.do'"/> 
								<input type="submit" class="btn float-right dohyeon" value="로그인"/>
							</div>
						</form>
						<div class="copy-text nanum">평생을 당신과 같이 가겠습니다 <i class="fa fa-heart"></i></div>
					</div>
					<!------------------------------------ login area ------------------------------------>
					<!------------------------------------ banner ------------------------------------>
					<div class="col-md-8 banner-sec carousel-inner">
						<img class="d-block img-fluid" src="<%=cPath%>/resources/images/ban/로고.png">
					</div>
					<!------------------------------------ banner ------------------------------------>
				</div>
			</div>
		</section>
	</body>
</html>