package com.sist.totoro.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.totoro.code.CodeDao;
import com.sist.totoro.code.CodeSvc;
import com.sist.totoro.code.CodeVO;
import com.sist.totoro.common.DTO;
import com.sist.totoro.domain.UserVO;
import com.sist.totoro.service.UserSvc;



@Controller
public class UserController {

	private  Logger log = LoggerFactory.getLogger(UserController.class);
	
	
	@Autowired
	private UserSvc userSvc;
	
	@Autowired
	private CodeSvc codeSvc;
//	priavte CodeSvcImple codeSvc;
	
	@RequestMapping(value = "/user/login.do", method = RequestMethod.GET)
	public String moveLogin() {

		return "/user/login";
	}

	@RequestMapping(value = "/user/join.do", method = RequestMethod.GET)
	public String moveJoin(HttpServletRequest req) {
		CodeVO  codeVO2=new CodeVO();		
		CodeVO  codeVO3=new CodeVO();		
		codeVO2.setCd_id("C002");
		codeVO3.setCd_id("C003");
		//지네릭 이상할 수도 있음.
		List<CodeVO> cdListC002 = (List<CodeVO>) codeSvc.do_retrieve(codeVO2);
		List<CodeVO> cdListC003 = (List<CodeVO>) codeSvc.do_retrieve(codeVO3);
		//codeVO 쓸것들 할당 필요
		//C002	비밀번호찾기질문
		//C003	은행명
		//근데 호일이형이만든거 한번 물어봐야할듯.
		
		req.setAttribute("cdListC002", cdListC002);
		req.setAttribute("cdListC003", cdListC003);
		
		return "/user/join";
	}
	
	@RequestMapping(value = "/user/find.do", method = RequestMethod.GET)
	public String moveFind() {

		return "/user/find";
	}
	
	
	//중복 검사(AJAX)
	@RequestMapping(value = "/user/check_id.do", method = RequestMethod.POST)
	public void check_id(@RequestParam("userId") String userId, HttpServletResponse response) throws Exception{
		userSvc.idCheck(userId, response);
	}
	@RequestMapping(value = "/user/check_email.do", method = RequestMethod.POST)
	public void check_email(@RequestParam("userEmail") String userEmail, HttpServletResponse response) throws Exception{
		userSvc.emailCheck(userEmail, response);
	}
	@RequestMapping(value = "/user/check_tel.do", method = RequestMethod.POST)
	public void check_tel(@RequestParam("userTel") String userTel, HttpServletResponse response) throws Exception{
		userSvc.telCheck(userTel, response);
	}
	@RequestMapping(value = "/user/check_account.do", method = RequestMethod.POST)
	public void check_account(@RequestParam("userAccount") String userAccount, HttpServletResponse response) throws Exception{
		userSvc.accountCheck(userAccount, response);
	}
	
	
	@RequestMapping(value="/user/save.do", method=RequestMethod.POST)
	public String joinUser(@ModelAttribute UserVO userVO, 
			RedirectAttributes rttr, HttpServletResponse response
			)throws EmptyResultDataAccessException, ClassNotFoundException, SQLException, IOException {
		
		log.info("UserController>joinUser>param UserVO userVO : "+userVO);
		rttr.addFlashAttribute("result", userSvc.joinUser(userVO, response));
		
		
		//TODO 위치확인, user/login.do
		return "redircet:/user/join.do";
	}
	
}
