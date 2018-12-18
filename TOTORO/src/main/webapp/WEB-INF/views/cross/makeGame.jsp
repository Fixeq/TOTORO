<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon&amp;subset=korean" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Jua&amp;subset=korean" rel="stylesheet">
<style>
.doHyeon{
	font-family: 'Do Hyeon', sans-serif;
}

.jua{
font-family: 'Jua', sans-serif;
}

</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<section class="s-content jua">

		<form action="/totoro/cross/makeGame.do" method="post">
	        <div class="col-six">
		        <label for="gameHome" class="pull-left" >홈 팀명</label>
	    	    <input class="full-width" type="text"  id="gameHome" maxlength="30" name="gameHome" required placeholder="최대 입력 글자수는 30자입니다">
	        </div>
		
	        <div class="col-six">
	        	<label for="gameHp">홈 배당률</label>
	        	<input class="full-width" type="text" placeholder="3.15"  name=gameHp id="gameHp" maxlength="5">
	        </div>
			
	        <div class="col-six">
		        <label for="gameAway" class="pull-left" >원정 팀명</label>
	    	    <input class="full-width onlynumeng" type="text"  id="gameAway" maxlength="30" name="gameAway" required placeholder="최대 입력 글자수는 30자입니다">
	        </div>
	        
	        <div class="col-six">
	        	<label for="gameAp">원정 배당률</label>
	        	<input class="full-width" type="text" placeholder="2.5"  name="gameAp" id="gameAp" maxlength="5">
	        </div>
	
	
	        <div class="col-six">
	        	<label for="gameDp">무 배당률</label>
	        	<input class="full-width" type="text" placeholder="2.8" name="gameDp" id="gameDp" maxlength="5">
	        </div>
	
	
	        <div class="col-six">
	        	<label for="gameDate">경기 시작 일자/시간</label>
	        	<input class="full-width" type="text" placeholder="2018-12-13 13:00:00" name="gameDate" id="gameDate">
                <span id="dateChk" class="pull-left" style="color:red"></span><br/>  
	        </div>
	
	
			<div>
				<input class="btn btn--primary full-width" type="submit"  value="생성">	
			</div>
		</form>
		
		
</section> <!-- s-content -->

</body>

<script type="text/javascript">
	$(document).ready(function(){
		alert("makeGame");
		
		$("#gameHp").keyup(function(){
			var gameHp = $("#gameHp").val();
			console.log(gameHp);
			
 	        if(isNaN(gameHp)){
 	        	alert("숫자값만 입력이 가능합니다");
 	        	$("#gameHp").val("");
	        }else{
	        	console.log("숫자");
	        }
 			
		});
		
		$("#gameAp").keyup(function(){
			var gameAp = $("#gameAp").val();
			console.log(gameHp);
			
 	        if(isNaN(gameAp)){
 	        	alert("숫자값만 입력이 가능합니다");
 	        	$("#gameAp").val("");
	        }else{
	        	console.log("숫자");
	        }
 			
		});
		
		$("#gameDp").keyup(function(){
			var gameHp = $("#gameHp").val();
			console.log(gameHp);
			
 	        if(isNaN(gameHp)){
 	        	alert("숫자값만 입력이 가능합니다");
 	        	$("#gameHp").val("");
	        }else{
	        	console.log("숫자");
	        }
 			
		});

		
		$("#gameDate").keyup(function(){
			var gameDate = $("#gameDate").val();
			
			console.log(gameDate);
							
 			//ajax 통신
	        $.ajax({
		            type:"POST",
		            url:"check_byDate.do",
		            dataType:"html",// JSON
		            data:{
		            "gameDate": gameDate
		            },	
		            success: function(message){//통신이 성공적으로 이루어 졌을때 받을 함수
						console.log(message);
		            	$("#dateChk").html(message);
		            	
			       },
			       complete: function(data){//무조건 수행
			             
			       },
			       error: function(xhr,status,error){
		             
		           }
		       }); //--ajax

 				
		});


			
	});
</script>
</html>