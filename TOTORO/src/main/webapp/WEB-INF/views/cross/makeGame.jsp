<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<section class="s-content">

	<form action="/totoro/cross/makeGame.do" method="post">
        <div>
	        <label for="gameHome" class="pull-left" >홈 팀명</label>
    	    <input class="full-width onlynumeng" type="text"  id="gameHome" name="gameHome" required placeholder="최대 입력가능 글자수는 30자입니">
        </div>
	
		
		<input type="text" value="홈팀이름" maxlength="30">
		홈 배당률
		<input type="text" value="홈팀배당률">
		원정 팀명
		<input type="text" value="원정팀이름" maxlength="30">
		원정 배당률
		<input type="text" value="원정팀배당률">
		무 배당률
		<input type="text" value="무배당률">
		경기 시작 일자/시간
		<input type="text" value="경기시작 일자/시간">
		
		
		
	</form>
	
</section> <!-- s-content -->

</body>
</html>