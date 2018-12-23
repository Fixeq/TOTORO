<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String context = request.getContextPath();//context path
%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=context%>/resources/css/main.css">
<!-- 



 -->
 
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-moo">
 <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<script src="main.js"></script>
<style>
 	.moo-style{
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%, -50%);
		margin: 0;
		padding: 0;
		display: flex;
	}
	.moo-style li{
		list-style: none;
		margin: 0 40px;
	}
	.moo-style li .fa{
		font-size: 40px;
		color: #262626;
		line-height: 80px;
		transition: .5s;
	}
	.moo-style li a{
		position: relative;
		display: block;
		width: 80px;
		height: 80px;
		background-color: #fff;
		text-align: center;
		transform: perspective(100px) rotate(-30deg) skew(25deg) translate(0,0);
		transition: .5s;
		box-shadow: -20px 20px 10px rgb(0, 0, 0, 0.5);
	}
	.moo-style li a::before{
		content: "";
		position: absolute;
		top: 10px;
		left: -20px;
		height: 100%;
		width: 20px;
		background: #b1b1b1;
		transition: .5s;
		transform: rotate(0deg) skewY(-45deg);
	}
	.moo-style li a::after{
		content: "";
		position: absolute;
		top: 80px;
		left: -11px;
		height: 20px;
		width: 100%;
		background: #b1b1b1;
		transition: .5s;
		transform: rotate(0deg) skewX(-45deg);
	}
	.moo-style li a:hover{
		transform: perspective(1000px) rotate(-30deg) skew(25deg) translate(20px, -20px);
		box-shadow: -50px 50px 50px rgb(0, 0, 0, 0.5);
	}
	.moo-style li:hover .fa{
		color: #fff;
	}
	.moo-style li a:hover{
		transform: perspective(1000px) rotate(-30deg) skew(25deg) translate(20px, -20px);
		box-shadow: -50px 50px 50px rgb(0, 0, 0, 0.5);
	}
	.moo-style li:hover:nth-child(1) a{
		background: #3b5999;
	}
	
	.moo-style li:hover:nth-child(1) a:before{
		background: #2e4a86;
	}
	.moo-style li:hover:nth-child(1) a:after{
		background: #4a69ad;
	}
	.moo-style li:hover:nth-child(2) a{
		background: #55acee;
	}
	.moo-style li:hover:nth-child(2) a:before{
		background: #4184b7;
	}
	.moo-style li:hover:nth-child(2) a:after{
		background: #4d9fde;
	}
	.moo-style li:hover:nth-child(3) a{
		background: #dd4b39;
	}
	
	.moo-style li:hover:nth-child(3) a:before{
		background: #c13929;
	}
	.moo-style li:hover:nth-child(3) a:after{
		background: #e83322;
	}
	
	.moo-style li:hover:nth-child(4) a{
		background: #0077B5;
	}
	
	.moo-style li:hover:nth-child(4) a:before{
		background: #036aa0;
	}
	.moo-style li:hover:nth-child(4) a:after{
		background: #0d82bf;
	}
	
	.moo-style li:hover:nth-child(5) a{
		background: linear-gradient(#400080, transparent), linear-gradient(200deg, #d047d1, #ff0000, #ffff00);
	}
	
	.moo-style li:hover:nth-child(5) a:before{
		background: linear-gradient(#400080, transparent), linear-gradient(200deg, #d047d1, #ff0000, #ffff00);
	}
	.moo-style li:hover:nth-child(5) a:after{
		background: linear-gradient(#400080, transparent), linear-gradient(200deg, #d047d1, #ff0000, #ffff00);
	}

 



</style>
</head>

<body>

	<section class="s-content">

<div class="row narrow section-intro add-bottom text-center">
			<div class="col-twelve tab-full">
 				<ul class="moo-style">
					<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
					<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
					<li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
					<li><a href="#/"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
					<li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
				</ul>
			</div>
            <div class="col-twelve tab-full">
                <h1>TOTORO</h1>
				
                <blockquote cite="http://where-i-got-my-info-from.com">쌍용최고의 신규 배팅사이트 토토로 입니다. 신규 사이트 현재 다량의 축구경기를 보여주고 있습니다. 다른 사이트에서는 볼수 없는 높은 배당률과 100% 신용도 많은 이용 부탁드립니다.
                (Ssangyong is the best new betting site Totoro. The new site is currently showing a large number of soccer games. Please use the high dividend rate and 100% credit that other sites can not see.)
           		<cite align="left">
                		<a>"TOTORO운영진"</a>
            		</cite>
                </blockquote>
            </div>
            
            

        </div>
        </section>
<br/><br/>
       <p align="left">
          <a class="btn btn--primary full-width"   href="<%=context%>/mainpage/mainpage.do">홈</a><br/><br/>
          <a class="btn btn--primary full-width"  href="<%=context%>/cross/view.do">크로스</a><br/><br/>
          <a class="btn btn--primary full-width" href="<%=context%>/board/board.do">배팅내역</a><br/><br/>
          <a class="btn btn--primary full-width" href="<%=context%>/mypage/mypage.do">마이페이지</a><br/><br/>
          <a class="btn btn--primary full-width" href="<%=context%>/board/board.do">게시판</a><br/><br/>
       </p>
       
       <section class="s-extra">

        <div class="row top">

            <div class="col-eight md-six tab-full popular">
                <h3>Popular Posts</h3>

                <div class="block-1-2 block-m-full popular__posts">
                    <article class="col-block popular__post">
                        <a href="#0" class="popular__thumb">
                            <img src="<%=context%>/resources/images/thumbs/small/wheel-150.jpg" alt="">
                        </a>
                        <h5><a href="#0">Visiting Theme Parks Improves Your Health.</a></h5>
                        <section class="popular__meta">
                                <span class="popular__author"><span>By</span> <a href="#0"> John Doe</a></span>
                            <span class="popular__date"><span>on</span> <time datetime="2017-12-19">Dec 19, 2017</time></span>
                        </section>
                    </article>
                    <article class="col-block popular__post">
                        <a href="#0" class="popular__thumb">
                            <img src="<%=context%>/resources/images/thumbs/small/shutterbug-150.jpg" alt="">
                        </a>
                        <h5><a href="#0">Key Benefits Of Family Photography.</a></h5>
                        <section class="popular__meta">
                            <span class="popular__author"><span>By</span> <a href="#0"> John Doe</a></span>
                            <span class="popular__date"><span>on</span> <time datetime="2017-12-18">Dec 18, 2017</time></span>
                        </section>
                    </article>
                    <article class="col-block popular__post">
                        <a href="#0" class="popular__thumb">
                            <img src="<%=context%>/resources/images/thumbs/small/cookies-150.jpg" alt="">
                        </a>
                        <h5><a href="#0">Absolutely No Sugar Oatmeal Cookies.</a></h5>
                        <section class="popular__meta">
                                <span class="popular__author"><span>By</span> <a href="#0"> John Doe</a></span>
                            <span class="popular__date"><span>on</span> <time datetime="2017-12-16">Dec 16, 2017</time></span>
                        </section>
                    </article>
                    <article class="col-block popular__post">
                        <a href="#0" class="popular__thumb">
                            <img src="<%=context%>/resources/images/thumbs/small/beetle-150.jpg" alt="">
                        </a>
                        <h5><a href="#0">Throwback To The Good Old Days.</a></h5>
                        <section class="popular__meta">
                            <span class="popular__author"><span>By</span> <a href="#0"> John Doe</a></span>
                            <span class="popular__date"><span>on</span> <time datetime="2017-12-16">Dec 16, 2017</time></span>
                        </section>
                    </article>
                    <article class="col-block popular__post">
                        <a href="#0" class="popular__thumb">
                            <img src="<%=context%>/resources/images/thumbs/small/tulips-150.jpg" alt="">
                        </a>
                        <h5><a href="#0">10 Interesting Facts About Caffeine.</a></h5>
                        <section class="popular__meta">
                            <span class="popular__author"><span>By</span> <a href="#0"> John Doe</a></span>
                            <span class="popular__date"><span>on</span> <time datetime="2017-12-14">Dec 14, 2017</time></span>
                        </section>
                    </article>
                </div> <!-- end popular_posts -->
            </div> <!-- end popular -->
            
            <div class="col-four md-six tab-full about">
                <h3>About Philosophy</h3>

                <p>
                Donec sollicitudin molestie malesuada. Nulla quis lorem ut libero malesuada feugiat. Pellentesque in ipsum id orci porta dapibus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula. Quisque velit nisi, pretium ut lacinia in, elementum id enim. Donec sollicitudin molestie malesuada.
                </p>

                <ul class="about__social">
                    <li>
                        <a href="#0"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                    </li>
                    <li>
                        <a href="#0"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                    </li>
                    <li>
                        <a href="#0"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                    </li>
                    <li>
                        <a href="#0"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
                    </li>
                </ul> <!-- end header__social -->
            </div> <!-- end about -->
       <div class="row bottom tags-wrap">
            <div class="col-full tags" align="center">
                <h3>- 최선을다하겠습니다-</h3>
            </div> <!-- end tags -->
        </div> <!-- end tags-wrap -->
        </div> <!-- end row -->
        </section>
       
 


	
	<!-- s-content -->
	
</body>

</html>