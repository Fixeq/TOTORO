<%@page import="com.sist.totoro.common.SearchVO"%>
<%@page import="java.util.List"%>
<%@page import="com.sist.totoro.code.CodeVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.totoro.common.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="tiles"  
    uri="http://tiles.apache.org/tags-tiles" %>    
 
<%
	String context = request.getContextPath();//context path

%>
<!--글쓰기 - 해당 쓴 값을 디비로 넣어준다. 
수정 , 삭제  - 쓴값을 셋하여 바꿔준다. 
단건조회 -리스트에서 해당 글 눌렀을때 해당 글보기 페이지로 이동 하며 조회

댓글조회
댓글쓰기 
이프문으로 댓글쓸때 인서트문 n 같이 삽입 컬럼에 값이 0이상이면 삽입안하도록

관리자일때 전체조회
사용자일때 본인작성자로만 된것만 조회 가능 

세션 받기 


======
파일 업로드 다운로드 이미지 뿌리기 
  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <section class="s-content">
  onclick="javascript:do_save();
    <form name="cForm" id="cForm" method="get" action="save.do">
                    <fieldset>

                        <div class="form-field">
                            <input name="cName" type="text" id="cName" class="full-width" placeholder="Title" value="">
                        </div>

                        <div class="message form-field">
                        <textarea name="cMessage" id="cMessage" class="full-width" placeholder="voice of Customer" ></textarea>
                        </div>
                         </fieldset>
	 </form> <!-- end form -->
                        <input type="submit" class="submit btn btn--primary full-width" value="글작성하기" id="save_btn" onclick="javascript:do_save();"/>

                   
  </section>
    <script type="text/javascript">

	function do_save() {		
		if (false == confirm("저장 하시겠습니까?"))
			return;
		var frm = document.frm;
		frm.action = "save.do";
		frm.submit();
	}
 

    </script>
</body>
</html>