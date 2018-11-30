<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<% String context =request.getContextPath(); %>

	<link href="<%=context%>/resources/css/bootstrap.min.css" rel="stylesheet">
	<script src="<%=context%>/resources/js/bootstrap.js"></script>
	<script src="<%=context%>/resources/js/jquery-1.12.4.js"></script>
</head>
<body>
		<div class="table-responsive" >
			<table id="listTable" class="table table-striped table-bordered table-hover">
				<thead class="bg-primary">
				    <tr>
				        <th class="text-center col-xs-1 col-sm-1 col-md-1 col-lg-1"">
				        	<input type="checkbox" id="checkAll" name="checkAll" onclick="checkAll();" >
				        </th> 
						<th class="text-center col-xs-1 col-sm-1 col-md-1 col-lg-1">경기일시</th>
						<th class="text-center col-xs-1 col-sm-1 col-md-1 col-lg-1">리그</th>
						<th class="text-center col-xs-2 col-sm-2 col-md-2 col-lg-2" colspan="2">승(홈팀)</th>
						<th class="text-center col-xs-3 col-sm-3 col-md-3 col-lg-3" colspan="2">무</th>
						<th class="text-center col-xs-2 col-sm-2 col-md-2 col-lg-2" colspan="2">패(원정팀)</th>
						<th class="text-center col-xs-1 col-sm-1 col-md-1 col-lg-1">점수</th>
						<th class="text-center col-xs-1 col-sm-1 col-md-1 col-lg-1">결과</th>
						
					</tr>
				</thead>
				<tbody>  
					<tr>
						<td class="text-center col-xs-1 col-sm-1 col-md-1 col-lg-1"><input type="checkbox" name="check" > </td>
						
						<td class="text-center col-xs-1 col-sm-1 col-md-1 col-lg-1">테이블에서 끌고온 경기 시간</td>
						<td class="text-center col-xs-1 col-sm-1 col-md-1 col-lg-1">테이블에서 끌고온 리그이름</td>
						
						<td class="text-center col-xs-1 col-sm-1 col-md-1 col-lg-1">홈팀이름</td>
						<td class="text-center col-xs-1 col-sm-1 col-md-1 col-lg-1">홈팀배당</td>
						
						<td class="text-center col-xs-1 col-sm-1 col-md-1 col-lg-1">무승부</td>
						<td class="text-center col-xs-1 col-sm-1 col-md-1 col-lg-1">무승부배당</td>
						
						<td class="text-center col-xs-1 col-sm-1 col-md-1 col-lg-1">원정팀이름</td>
						<td class="text-center col-xs-1 col-sm-1 col-md-1 col-lg-1">원정팀배당</td>
						
						
						<th class="text-center col-xs-1 col-sm-1 col-md-1 col-lg-1">점수</th>
						<th class="text-center col-xs-1 col-sm-1 col-md-1 col-lg-1">결과</th>
					</tr>
				</tbody>
			</table>
		</div>
		
	<script>
		function checkAll(){
			alert("checkAll!");
			
	       	 if($("#checkAll").is(':checked') == true  ){
	    		 $("input[name='check']").prop("checked",true);
	    	 }else{
	    		 $("input[name='check']").prop("checked",false);
	    	 }
		}
	</script>

</body>
</html>