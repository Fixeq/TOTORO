<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String context = request.getContextPath();//context path
%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=context%>/resources/css/main.css">
</head>
<body>

	<section class="s-content">

	
<br/><br/><br/>

       <p align="left">
       
    
          <a class="btn btn--primary full-width"  href="<%=context%>/mainpage/mainpage.do">홈</a><br/><br/>
          <a class="btn full-width" href="<%=context%>/cross/view.do">크로스</a><br/><br/>
           <a class="btn btn--primary full-width" href="<%=context%>/board/board.do">배팅내역</a><br/><br/>
           <a class="btn btn--stroke full-width" href="<%=context%>/mypage/mypage.do">마이페이지</a>
        	<a class="btn btn--primary full-width" href="<%=context%>/board/board.do">게시판</a><br/><br/>
       </p>
       
       
       
        <div class="row bottom tags-wrap">
            <div class="col-full tags">
                <h3>Tags</h3>

                <div class="tagcloud">
                    <a href="<%=context%>/customerdeposit/customerdeposit.do">입금내역</a>
                    <a href="<%=context%>/customerwithdraw/customerwithdraw.do">출금내역</a>
                    <a href="<%=context%>/betresult/betresult.do">경기결과</a>
                    <a href="<%=context%>/betrule/betrule.do">배팅규정</a>
                </div> <!-- end tagcloud -->
            </div> <!-- end tags -->
        </div> <!-- end tags-wrap -->
<br/><br/><br/>

	</section>
	<!-- s-content -->
	
</body>

<style type="text/css" media="screen">

.s-extra .tags {
   text-align: center;
}

.s-extra .tagcloud {
   padding-top: .6rem;
}

.s-extra .tagcloud a {
   display: inline-block;
   font-family: "metropolis-extrabold", sans-serif;
   font-size: 1.3rem;
   line-height: 3.6rem;
   text-transform: uppercase;
   letter-spacing: .2rem;
   padding: 0 2rem;
   margin: 0 1.2rem 1.5rem 0;
   border-radius: 3px;
   background: #e2e2e2;
   text-decoration: none;
   color: #333333;
   position: relative;
}

.s-extra .tagcloud a:hover, .s-extra .tagcloud a:focus {
   color: #FFFFFF;
   background: #151515;
}

</style>

</html>