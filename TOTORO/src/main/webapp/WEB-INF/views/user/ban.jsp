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

<script>
	
	


</script>


<title>밴유저페이지</title>

    <style type="text/css" media="screen">

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
     </style> 




</head>
<body id="top">

<!-- styles
    ================================================== -->

    <section id="styles" class="s-styles">
        <div class="row narrow section-intro add-bottom text-center">
            <div class="col-twelve tab-full">
                <h1 class="dohyeon">당신은 졸업생 입니다^^</h1>
            </div>
        </div>
    </section> <!-- end styles -->

</body>
</html>