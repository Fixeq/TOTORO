<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="tiles"  
    uri="http://tiles.apache.org/tags-tiles" %>    
 
<%
	String context = request.getContextPath();//context path
	
%>

    <!-- pageheader
    ================================================== -->
    <div class="s-pageheader">

        <header class="header">
            <div class="header__content row">

                <div class="header__logo">
                    <a class="logo" href="index.html">
                        <img src="<%=context%>/resources/images/logo.svg" alt="Homepage">
                    </a>
                </div> <!-- end header__logo -->

                <ul class="header__social">
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

                <a class="header__search-trigger" href="#0"></a>

                <div class="header__search">

                    <form role="search" method="get" class="header__search-form" action="#">
                        <label>
                            <span class="hide-content">Search for:</span>
                            <input type="search" class="search-field" placeholder="Type Keywords" value="" name="s" title="Search for:" autocomplete="off">
                        </label>
                        <input type="submit" class="search-submit" value="Search">
                    </form>
        
                    <a href="#0" title="Close Search" class="header__overlay-close">Close</a>

                </div>  <!-- end header__search -->


                <a class="header__toggle-menu" href="#0" title="Menu"><span>Menu</span></a>

                <nav class="header__nav-wrap">

                    <h2 class="header__nav-heading h6">Site Navigation</h2>

                    <ul class="header__nav">
                        <li><a href="index.html" title="">홈</a></li>
                        <li><a href="cross.do" title="">크로스</a></li>
                        <li class="has-children">
                            <a href="#0" title="">입금/출금</a>
                            <ul class="sub-menu">
                            <li><a href="dodo.do">dodo</a></li>
                            <li><a href="category.html">입금</a></li>
                            <li><a href="category.html">출금</a></li>
                            <li><a href="category.html">관리자 입금</a></li>
                            <li><a href="category.html">관리자 출금</a></li>
                            <li><a href="category.html">관리자 출금확인</a></li>
                            </ul>
                        </li>
                        <li class="has-children current">
                            <a href="#0" title="">카테고리</a>
                            <ul class="sub-menu">
                            <li><a href="single-video.html">배팅내역</a></li>
                            <li><a href="single-audio.html">배팅규정</a></li>
                            <li><a href="single-gallery.html"></a></li>
                            <li><a href="single-standard.html">Standard Post</a></li>
                            </ul>
                        </li>
                        <li><a href="contact.html" title="">배팅내역</a></li>
                        <li><a href="about.html" title="">게시판</a></li>
                        <li><a href="about.html" title="">마이페이지</a></li>
                    </ul> <!-- end header__nav -->

                    <a href="#0" title="Close Menu" class="header__overlay-close close-mobile-menu">Close</a>

                </nav> <!-- end header__nav-wrap -->

            </div> <!-- header-content -->
        </header> <!-- header -->

    </div> <!-- end s-pageheader -->

