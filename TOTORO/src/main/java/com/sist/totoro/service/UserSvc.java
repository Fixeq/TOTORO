package com.sist.totoro.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

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
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * ajax
	 * @throws SQLException 
	 */
	//아이디 중복검사
	public int idCheck(String userId) throws SQLException {
		return userDao.id_check(userId);
	}
	
	//이메일 중복검사
	public int emailCheck(String userEmail) throws SQLException {
		return userDao.email_check(userEmail);
	}
	
	//계좌번호 중복검사
	public int accountCheck(String userAccount) throws SQLException {
		return userDao.account_check(userAccount);
	}

	//전화번호 중복검사
	public int telCheck(String userTel) throws SQLException {
		return userDao.tel_check(userTel);
	}
	
	//밴유저 조회
	public int banUserCheck(DTO dto) throws SQLException {
		return userDao.ban_user_check(dto);
	}
	
	//회원가입(insert)
	//위에것들이 true 1만 반환해야함
	//ban user 체크
	//dto에러뜨면 uservo로 변경
	public int joinUser(DTO dto, HttpServletResponse response) throws IOException, SQLException {

		/*
		HttpServletResponse 객체									  
		클라이언트에 데이터를 전송하기 위하여 사용.
		이를 위하여 Response객체의 setContentType()과 getWriter()메소드를 이용한다.
		그 다음에 html을 작성하거나 다른 컨텐츠를 기록하거나 하는 I/O작업을 하면됨.
		이 외에도 헤더 정보를 설정하거나 ,오류를 발생시키거나, 쿠키를 추가할 때도 Response 객체를 사용한다.
		 */

		response.setContentType("text/html;charset=utf-8");
		//PrintWriter java에서 web으로 출력을 원할 시
		PrintWriter out = response.getWriter();
		
		UserVO inVO = (UserVO) dto;
		
		if(userDao.id_check(inVO.getUserId())>0) {
			out.println("<script>");
			out.println("alert('동일한 아이디가 있습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		} else if(userDao.email_check(inVO.getUserEmail())>0) {
			out.println("<script>");
			out.println("alert('동일한 이메일이 있습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		} else if(userDao.account_check(inVO.getUserAccount())>0) {
			out.println("<script>");
			out.println("alert('동일한 계좌번호가 있습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		}else if(userDao.tel_check(inVO.getUserTel())>0) {
			out.println("<script>");
			out.println("alert('동일한 전화번호가 있습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		}else if(userDao.ban_user_check(inVO) >0) {
			out.println("<script>");
			out.println("alert('당신은 졸업생입니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		}else{
//			userDao.do_save(inVO);
//			return 1;
			return userDao.do_save(inVO);
		}
	}
	
	
	
	//TODO메일보내기
	
}
