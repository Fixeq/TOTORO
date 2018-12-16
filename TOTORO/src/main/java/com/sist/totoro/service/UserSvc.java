package com.sist.totoro.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.totoro.common.DTO;
import com.sist.totoro.dao.UserDao;
import com.sist.totoro.domain.UserVO;

@Service
public class UserSvc {

	private Logger log = LoggerFactory.getLogger(UserSvc.class);
	private final int RANDOM_LENGTH = 10;

	@Autowired
	private UserDao userDao;

	// -------------------------------------------------회원가입---------------------------------------------------
	public String create_key() {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, RANDOM_LENGTH);
	}

	/**
	 * ajax
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	// 아이디 중복검사
	public void idCheck(String userId, HttpServletResponse response) throws SQLException, IOException {
		PrintWriter out = response.getWriter();
		out.println(userDao.id_check(userId));
		out.close();
	}

	// 이메일 중복검사
	public void emailCheck(String userEmail, HttpServletResponse response) throws SQLException, IOException {
		PrintWriter out = response.getWriter();
		out.println(userDao.email_check(userEmail));
		out.close();
	}

	// 계좌번호 중복검사
	public void accountCheck(String userAccount, HttpServletResponse response) throws SQLException, IOException {
		PrintWriter out = response.getWriter();
		out.println(userDao.account_check(userAccount));
		out.close();
	}

	// 전화번호 중복검사
	public void telCheck(String userTel, HttpServletResponse response) throws SQLException, IOException {
		PrintWriter out = response.getWriter();
		out.println(userDao.tel_check(userTel));
		out.close();
	}

	// 밴유저 조회
	public int banUserCheck(UserVO userVO) throws SQLException {
		return userDao.ban_user_check(userVO);
	}

	// 회원가입(insert)
	// 위에것들이 true 1만 반환해야함
	// ban user 체크
	// dto에러뜨면 uservo로 변경
	public int joinUser(UserVO userVO, HttpServletResponse response) throws IOException, SQLException {

		/*
		 * HttpServletResponse 객체 클라이언트에 데이터를 전송하기 위하여 사용. 이를 위하여 Response객체의
		 * setContentType()과 getWriter()메소드를 이용한다. 그 다음에 html을 작성하거나 다른 컨텐츠를 기록하거나 하는
		 * I/O작업을 하면됨. 이 외에도 헤더 정보를 설정하거나 ,오류를 발생시키거나, 쿠키를 추가할 때도 Response 객체를 사용한다.
		 */

		response.setContentType("text/html;charset=utf-8");
		// PrintWriter java에서 web으로 출력을 원할 시
		PrintWriter out = response.getWriter();

		if (userDao.id_check(userVO.getUserId()) > 0) {
			out.println("<script>");
			out.println("alert('동일한 아이디가 있습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		} else if (userDao.email_check(userVO.getUserEmail()) > 0) {
			out.println("<script>");
			out.println("alert('동일한 이메일이 있습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		} else if (userDao.account_check(userVO.getUserAccount()) > 0) {
			out.println("<script>");
			out.println("alert('동일한 계좌번호가 있습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		} else if (userDao.tel_check(userVO.getUserTel()) > 0) {
			out.println("<script>");
			out.println("alert('동일한 전화번호가 있습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		} else if (userDao.ban_user_check(userVO) > 0) {
			out.println("<script>");
			out.println("alert('당신은 졸업생입니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		} else {
			userVO.setUserAppKey(create_key());
			userDao.do_save(userVO);
			sendEmail(userVO,"join");

			out.println("<script>");
			out.println("alert('회원가입이 완료되었습니다.');");
			out.println("alert('가입시 입력했던 메일로 인증해주시기 바랍니다.');");
			out.println("location.href='http://www.naver.com';");
			out.println("</script>");

			return 1;
		}
	}

	// TODO메일보내기
	public void sendEmail(UserVO userVO, String workDiv) {
		// Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.naver.com";
		String hostSMTPid = "jackpot1224bytotoro";
		String hostSMTPpwd = "totoro1224";
//		jackpot1224bytotoro
		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "jackpot1224bytotoro@naver.com";
		String fromName = "ADMIN MH";
		String subject = "";
		String msg = "";

		
		if(workDiv.equals("join")) {
		// 회원가입 메일 내용
			
			subject = "TOTORO world 회원가입 인증입니다.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += userVO.getUserId() + "님 회원가입을 환영합니다.</h3>";
			msg += "<h3 style='color: black;'>";
			msg += "언제나 토토로월드에 기부천사를 맡고있는 박태건입니다! <br>";
			msg += "매일 자정에 인증 확인을 하오니 참고바랍니다.</h3>";
			msg += "<div style='font-size: 130%'>";
			msg += "하단의 인증 버튼 클릭 시 정상적으로 회원가입이 완료됩니다.</div><br/>";
			msg += "<form method='post' action='http://localhost:8080/totoro/user/email_verify.do'>";
			msg += "<input type='hidden' name='userEmail' value='" + userVO.getUserEmail() + "'>";
			msg += "<input type='hidden' name='userAppKey' value='" + userVO.getUserAppKey() + "'>";
			msg += "<input type='submit' value='인증'></form><br/></div>";
		}else if(workDiv.equals("findPw")) {
			subject = "TOTORO world 임시 비밀번호 입니다.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += userVO.getUserId() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
			msg += "<p>임시 비밀번호 : ";
			msg += userVO.getUserPw() + "</p></div>";
			msg += "<h3 style='color: black;'>";
			msg += "태건이처럼 비밀번호 까먹지 마시고 꼭 기억해주세요! <br>";
		}

		
		// 받는 사람 E-Mail 주소
		String mail = userVO.getUserEmail();
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(587);

			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
		} catch (Exception e) {
			System.out.println("메일발송 실패 : " + e);
		}
	}// send mail

	public void email_verify(UserVO userVO, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (userDao.email_verify(userVO) == 0) { // 이메일 인증에 실패하였을 경우
			out.println("<script>");
			out.println("alert('잘못된 접근입니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
		} else { // 이메일 인증을 성공하였을 경우
			out.println("<script>");
			out.println("alert('인증이 완료되었습니다. 관리자 승인 후 로그인이 가능합니다.');");
			out.println("alert('매일 00시에 인증이 완료되오니 참고바랍니다.');");
			out.println("location.href='http://localhost:8080/totoro/user/login.do';");
			out.println("</script>");
			out.close();
		}

	}
	// -------------------------------------------------회원가입---------------------------------------------------

	// -------------------------------------------------로그인---------------------------------------------------
	public UserVO loginCheck(UserVO userVO, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 등록된 아이디가 없으면
		if (userDao.id_check(userVO.getUserId()) == 0) {
			out.println("<script>");
			out.println("alert('등록된 아이디가 없습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
		} else {
			String pw = userVO.getUserPw();
			userVO = userDao.id_login(userVO.getUserId());
			
			// 비밀번호가 다를 경우
			if (!userVO.getUserPw().equals(pw)) {
				out.println("<script>");
				out.println("alert('비밀번호를 잘못 입력하셨습니다.');");
				out.println("history.go(-1);");
				out.println("</script>");
				out.close();
				return null;
				// 이메일 인증을 하지 않은 경우
			} else if (userVO.getUserAppStt().equals("false")) {
				out.println("<script>");
				out.println("alert('이메일 인증 후 로그인 하세요.');");
				out.println("history.go(-1);");
				out.println("</script>");
				out.close();
				return null;
				// 관리자가 승인을 아직 안한경우
			} else if (userVO.getUserAppStt().equals("wait")) {
				out.println("<script>");
				out.println("alert('인증은 매일 자정에 업데이트 됩니다.');");
				out.println("history.go(-1);");
				out.println("</script>");
				out.close();
				return null;
			} else if (userVO.getUserAppStt().equals("ban")) {
				out.println("<script>");
				out.println("location.href='http://localhost:8080/totoro/user/ban.do';");
				out.println("</script>");
				out.close();
				return null;
			} else {
				out.println("<script>");
				out.println("alert('TOTORO WORLD에 오신걸 환영합니다.');");
				out.println("</script>");
				return userVO;
			}
		} // else
	}// loginCheck()

	public void logout(HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("location.href=document.referrer;");
		out.println("</script>");
		out.close();
	}	
	
	public String findId(String userEmail) throws Exception{
		return userDao.id_find(userEmail);
	}
	
	public void findPw(HttpServletResponse response, UserVO userVO) throws Exception {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 아이디가 없으면
		if(userDao.id_check(userVO.getUserId()) == 0) {
			out.print("아이디를 확인해주세요.");
			out.close();
		}
		// 가입에 사용한 이메일이 아니면
		else if(!userVO.getUserFindQ().equals(userDao.id_login(userVO.getUserId()).getUserFindQ())
				||!userVO.getUserFindA().equals(userDao.id_login(userVO.getUserId()).getUserFindA())){ 
			out.print("등록하신 질문, 답변이 아닙니다.");
			out.close();
		}else {
			// 임시 비밀번호 생성
			String tmpPw = create_key();
			userVO.setUserPw(tmpPw);
			// 비밀번호 변경
			userDao.pw_random_update(userVO);
			
			//온전한 userVO얻어오기
			userVO = userDao.id_login(userVO.getUserId());
			// 비밀번호 변경 메일 발송
			sendEmail(userVO, "findPw");
			
			out.println("이메일로 비밀번호를 발송하였습니다.");
		}
		
	}
	
	
	
	
	
	
	
	
	
}// UserSvc class
