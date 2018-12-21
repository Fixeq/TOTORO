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
	
    UserVO userVO1 = (UserVO)(request.getAttribute("userVO1"));
    String userBank = userVO1.getUserBank();
    String userAppStt = userVO1.getUserAppStt();
    String userFindQ = userVO1.getUserFindQ();
    String userAdmin = userVO1.getUserAdmin();
    log.info("userSelectOne.jsp > userVO1 get : "+userVO1);
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




<style>

    .s-styles { 
        background: #f2f2f2;
        padding-bottom: 12rem;
    }

    .s-styles .section-intro h1 {
        margin-top: 0;
    }


	.dohyeonForCheck {
		font-family: 'Do Hyeon', sans-serif;
		font-size: 20px;
		
	}

	h3.dohyeonForCheck {
		font-size: 30px;
		
	}
	.nanum{
		font-family: 'Nanum Gothic', sans-serif;
	}	  
  
	  
</style>

<script>
	
	function pw_check(){
		var userPw = $('#userPw1').val();
		var userPwCF=$('#userPwCF').val();
		
		if(userPwCF =="") {
			$("#joinBtn").attr("disabled", "disabled");
		}else if(userPw != userPwCF){
			$("#pw_check").css("color", "red");
			$("#pw_check").html(" 동일한 비밀번호를 입력해주세요..");
			$("#joinBtn").attr("disabled", "disabled");
		}else if(userPw == userPwCF){
			$("#pw_check").css("color", "#6DD66D");
			$("#pw_check").html(" 확인되었습니다.");
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
		       

		//이메일 중복검사
		$("#userEmail").keyup(function() {
			var reqEmail = <%="\""%><%=userVO1.getUserEmail()%><%="\""%>;
			$.ajax({
				url : "<%=cPath%>/user/check_email.do",
				type : "POST",
				data : {
					userEmail : $("#userEmail").val()
				},
				success : function(result) {
					if (result > 0) {
						if($("#userEmail").val()==reqEmail){
							$("#joinBtn").removeAttr("disabled");
						}else{
							$("#email_check").css("color", "red");
							$("#email_check").html(" 이미 사용되고 있는 이메일입니다.");
							$("#joinBtn").attr("disabled", "disabled");
						}
					}else if(result ==0) {
						$("#email_check").html("");
						$("#joinBtn").removeAttr("disabled");
					}
				},
			})
		});

		//전화번호 중복검사
		$("#userTel").keyup(function() {
			var reqTel = <%="\""%><%=userVO1.getUserTel()%><%="\""%>;
			$.ajax({
				url : "<%=cPath%>/user/check_tel.do",
				type : "POST",
				data : {
					userTel : $("#userTel").val()
				},
				success : function(result) {
					if (result > 0) {
						if($("#userTel").val()==reqTel){
							$("#joinBtn").removeAttr("disabled");							
						}else{
							$("#tel_check").css("color", "red");
							$("#tel_check").html("이미 사용되고 있는 전화번호입니다..");
							$("#joinBtn").attr("disabled", "disabled");
						}
					}else if(result ==0 && $("#userTel").val().length>10) {
						$("#tel_check").css("color", "#6DD66D");
						$("#tel_check").html("사용가능한 전화번호입니다.");
						$("#joinBtn").removeAttr("disabled");
					}
				},
			})
		});
		
		//계좌번호 중복검사
		$("#userAccount").keyup(function() {
			var reqAccount = <%="\""%><%=userVO1.getUserAccount()%><%="\""%>;
			$.ajax({
				url : "<%=cPath%>/user/check_account.do",
				type : "POST",
				data : {
					userAccount : $("#userAccount").val()
				},
				success : function(result) {
					if (result > 0) {
						if($("#userAccount").val()==reqAccount){
							$("#joinBtn").removeAttr("disabled");							
						}else{						
							$("#account_check").css("color", "red");
							$("#account_check").html("중복된 계좌번호가 있습니다.");
							$("#joinBtn").attr("disabled", "disabled");
						}
					}else if(result ==0 && $("#userAccount").val().length !=0) {
						$("#account_check").html("");
						$("#joinBtn").removeAttr("disabled");
					}
				},
			})
		});
		
	});

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TOTORO 회원가입</title>

</head>
<body style="overflow:scroll;" >

<!-- styles
    ================================================== -->
   <section id="styles" class="s-styles">
        <div class="row narrow section-intro add-bottom">
            <div class="col-twelve tab-full">
                <h3 class="add-bottom dohyeonForCheck">회원정보 수정</h3>
                <form action="<%=cPath%>/mypage/userUpdate.do" method="post">
                    <div>
                        <label for="userId01" class="dohyeonForCheck">아이디</label>
                        <input class="full-width" type="text"  id="userId01"  name="userId" value="${userVO1.userId}" readonly="readonly">
                        <br>
                    </div>
                    <div>
                        <label for="sampleInput" class="dohyeonForCheck">비밀번호</label>
                        <input class="full-width userPw" type="password"  id="userPw1" name="userPw" 
			                        	required placeholder="비밀번호 (8~15자 영문 대 소문자,숫자,특수문자를 사용하세요)" oninput="pw_check()">
                        <br>
                    </div>
                    <div>
                        <label for="sampleInput" class="dohyeonForCheck">비밀번호 확인</label>
                        <input class="full-width userPw" type="password" id="userPwCF"  
			                        	required placeholder="비밀번호를 한번 더 입력해주세요." oninput="pw_check()">
                        <span id="pw_check" class="pull-right dohyeonForCheck" ></span><br/>
                    </div>
                    <div>
                        <label for="userEmail" class="dohyeonForCheck">이메일</label>
                        <input class="full-width" type="email" id="userEmail" name="userEmail" value="${userVO1.userEmail}">
                        <span id="email_check" class="pull-right dohyeonForCheck" ></span><br/>
                    </div>
                    <div>
                        <label for="userPoint" class="dohyeonForCheck">포인트</label>
                        <input type="Number"  class="full-width" min=0 max=1000000 name="userPoint" id="userPoint" 
                        value="${userVO1.userPoint}" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
                        <br>
                    </div>
                    <div>
                        <label for="userName" class="dohyeonForCheck">예금주</label>
                        <input class="full-width" type="text" id="userName" name="userName" value="${userVO1.userName}">
                        <br>
                    </div>
                    <div>
                        <label for="userBank" class="dohyeonForCheck">은행</label>
                         <%=StringUtil.makeSelectBox(bank_list, userBank, "userBank", false) %> 
                        <br>
                    </div>
                    <div>
                        <label for="userAccount" class="dohyeonForCheck">계좌번호</label>
                        <input class="full-width" type="text" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" 
                         value="${userVO1.userAccount}" id="userAccount" name="userAccount">
                        <span id="account_check" class="pull-right dohyeonForCheck" style="color:red"></span><br/>
                    </div>
                    <div>
                        <label for="userTel" class="dohyeonForCheck">핸드폰 번호</label>
                        <input class="full-width" type="text" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"
                        value="${userVO1.userTel}" id="userTel" name="userTel" >
                        <span id="tel_check" class="pull-right dohyeonForCheck" style="color:red"></span><br/>
                        <br>
                    </div>
                    <div>
                        <label for="userFindQ" class="dohyeonForCheck">비밀번호 찾기 질문</label>
                        <%=StringUtil.makeSelectBox(find_pw, userFindQ, "userFindQ", false) %>
                        <br>
                    </div>
                    <div>
                        <label for="userFindA" class="dohyeonForCheck">비밀번호 찾기 정답</label>
                        <input class="full-width" type="text"  id="userFindA" name="userFindA" value="${userVO1.userFindA}">
                        <br>
                    </div>
                    <div>
                        <label for="userAppStt" class="dohyeonForCheck">인증상태</label>
						<%=StringUtil.makeSelectBox(user_status, userAppStt, "userAppStt", false) %>
                        <br>
                    </div>
                    <div>
                        <label for="userAdmin" class="dohyeonForCheck">관리자 여부</label>
                        <%=StringUtil.makeSelectBox(admin_list, userAdmin, "userAdmin", false) %>
                        <br>
                    </div>
                    <div>
                        <label for="userModId" class="dohyeonForCheck">수정자</label>
                        <input class="full-width" type="text"  id="userModId" name="userModId" value="${userVO1.userModId}">
                        <br>
                    </div>
                    <div>
                        <label for="userAppKey" class="dohyeonForCheck">인증키</label>
                        <input class="full-width" type="text"  id="userAppKey" name="userAppKey" value="${userVO1.userAppKey}" readonly="readonly">
                        <br>
                    </div>
                    <input class="btn--primary full-width" id="joinBtn" type="submit" value="수정">
                    <input class="btn--stroke full-width" id="back" type="button" value="취소" onclick="history.go(-1);">
                </form>

            </div>
		</div>
	</section>





</body>
</html>



