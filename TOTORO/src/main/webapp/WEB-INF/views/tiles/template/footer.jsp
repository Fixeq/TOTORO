<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String context = request.getContextPath(); %>

 <!-- s-footer
    ================================================== -->
    <footer class="s-footer">

        <div class="s-footer__main">
            <div class="row">
                
                <div class="col-two md-four mob-full s-footer__sitelinks">
                        
                    <h4>ATM</h4>

                    <ul class="s-footer__linklist">
                        <li><a href="<%=context%>/customerdeposit/customerdeposit.do">deposit</a></li>
                        <li><a href="<%=context%>/customerwithdraw/customerwithdraw.do">withdraw</a></li>
                    </ul>

                </div> <!-- end s-footer__sitelinks -->

                <div class="col-two md-four mob-full s-footer__archives">
                        
                    <h4>Cotegory</h4>

                    <ul class="s-footer__linklist">
                        <li><a href="<%=context%>/betresult/betresult.do">betResult</a></li>
                        <li><a href="<%=context%>/betrule/betrule.do">betRule</a></li>
                    </ul>

                </div> <!-- end s-footer__archives -->

                
                <div class="col-five md-full end s-footer__subscribe">
                        
                    <h4>고객센터 이용시간</h4>
                    <p>AM09:00 ~ PM18:00
                    </p>
                        
                    <h4>전용 계좌</h4>
                    <p>쌍용 1102-654-458859</p>

                </div> <!-- end s-footer__subscribe -->

            </div>
        </div> <!-- end s-footer__main -->

        <div class="s-footer__bottom">
            <div class="row">
                <div class="col-full">
                    <div class="s-footer__copyright">
                        <span>© Copyright Ssang-Young TOTORO 2018</span> 
                        <span>Team by <a href="https://colorlib.com/">TOTORO</a></span>
                    </div>

                    <div class="go-top">
                        <a class="smoothscroll" title="Back to Top" href="#top"></a>
                    </div>
                </div>
            </div>
        </div> <!-- end s-footer__bottom -->

    </footer> <!-- end s-footer -->
    
    <!-- preloader
    ================================================== -->
    <div id="preloader">
        <div id="loader">
            <div class="line-scale">
                <div></div>
                <div></div>
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
    </div>
    
    
    