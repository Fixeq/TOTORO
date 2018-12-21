<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String context = request.getContextPath();//context path
%>    
<%--
  /**
  * @Class Name : 
  * @Description : line_chart.jsp 화면
  * @Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2018.12.20            최초 생성
  *
  * author 실행환경 개발팀
  * since 2018.12.20
  *
  * Copyright (C) 2018 by KandJang  All right reserved.
  */
--%>
<html>
<head>

</head>
<body>

<section class="s-content">
	<br/><br/>
	<div align="center">
  <div align="center" id="line_top_x"  align="right" style="width: 1000px; height: 650px;"></div>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    google.charts.load('current', {'packages':['line']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

      var jsonData = $.ajax({
        url:"line.do",
        dataType:"html",// JSON
        data:{
        	
         },
        async: false
        
        }).responseText;
      
      var newArr = JSON.parse(jsonData);
    
    
      var data = new google.visualization.DataTable();
      data.addColumn('number', 'Day');
      data.addColumn('number', '홈팀');
      data.addColumn('number', '원정팀');
      data.addColumn('number', '무승부');

      //data영역
      for(var i=0;i<newArr.length;i++){
         data.addRow(newArr[i]);
       }

      var options = {
        chart: {
          title: '홈팀 원정팀 년도별 결과',
          subtitle: 'TOTORO of gameRate (USD)'
        },
        axes: {
          x: {
            0: {side: 'top'}
          }
        }
      };

      var chart = new google.charts.Line(document.getElementById('line_top_x'));

      chart.draw(data, google.charts.Line.convertOptions(options));
    }
  </script>
  </div>
  <br/><br/>
    </section>
    
</body>
</html>