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
                    <a class="logo" href="/totoro/mainpage/mainpage.do">
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
                        <li><a href="/totoro/mainpage/mainpage.do" title="">홈</a></li>
                        <li><a href="/totoro/cross/view.do" title="">크로스</a></li>
                        <li class="has-children">
                            <a href="#0" title="">입금/출금</a>
                            <ul class="sub-menu">
                            <li><a href="/totoro/customerdeposit/customerdeposit.do">입금</a></li>
                            <li><a href="/totoro/customerwithdraw/customerwithdraw.do">출금</a></li>
                            <li><a href="/totoro/admindeposit/admindeposit.do">관리자 입금</a></li>
                            <li><a href="/totoro/adminwithdraw/adminwithdraw.do">관리자 출금</a></li>
                            <li><a href="/totoro/givepay/givepay.do">당첨금 지급페이지</a></li>
                            </ul>
                        </li>
                        <li class="has-children current">
                            <a href="#0" title="">카테고리</a>
                            <ul class="sub-menu">
                            <li><a href="/totoro/bethistory/bethistory.do">배팅내역</a></li>
                            <li><a href="/totoro/betrule/betrule.do">배팅규정</a></li>
                            <li><a href="/totoro/betresult/betresult.do">경기결과</a></li>
                           
                            </ul>
                            
                        </li>
                        <li><a href="/totoro/board/board.do" title="">게시판</a></li>
                        <li><a href="/totoro/mypage/mypage.do" title="">마이페이지</a></li>
                    </ul> <!-- end header__nav -->

                    <a href="#0" title="Close Menu" class="header__overlay-close close-mobile-menu">Close</a>

                </nav> <!-- end header__nav-wrap -->

            </div> <!-- header-content -->
        </header> <!-- header -->

    </div> <!-- end s-pageheader -->
