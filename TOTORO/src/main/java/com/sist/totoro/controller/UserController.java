package com.sist.totoro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.totoro.code.CodeSvc;
import com.sist.totoro.code.CodeVO;
import com.sist.totoro.domain.UserVO;
import com.sist.totoro.service.UserSvc;



@Controller
public class UserController {

	private  Logger log = LoggerFactory.getLogger(UserController.class);
	
	
	@Autowired
	private UserSvc userSvc;
	
	@Autowired
	private CodeSvc codeSvc;
//	private CodeSvcImple codeSvc;
	
	//회원가입 화면 이동
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
		
		req.setAttribute("cdListC002", cdListC002);
		req.setAttribute("cdListC003", cdListC003);
		
		return "/user/join";
	}

	
	//아이디,비밀번호 화면 이동
	@RequestMapping(value = "/user/find.do", method = RequestMethod.GET)
	public String moveFind(HttpServletRequest req) {
		
		CodeVO  codeVO2=new CodeVO();		
		codeVO2.setCd_id("C002");
		//지네릭 이상할 수도 있음.
		List<CodeVO> cdListC002 = (List<CodeVO>) codeSvc.do_retrieve(codeVO2);
		//codeVO 쓸것들 할당 필요
		//C002	비밀번호찾기질문
		
		req.setAttribute("cdListC002", cdListC002);
		
		return "/user/find";
	}

	//로그인 화면으로 이동
	@RequestMapping(value = "/user/login.do", method = RequestMethod.GET)
	public String moveLogin() {
		return "/user/login";
	}
	
	//밴유저 밴화면으로 이동
	@RequestMapping(value = "/user/ban.do", method = RequestMethod.GET)
	public String moveBan() {
		return "/user/ban";
	}
	
	
	//회원가입 중복 검사(AJAX)
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
	
	
	
	//이메일 확인 인증
	@RequestMapping(value="/user/email_verify.do", method = RequestMethod.POST)
	public void email_verify(@ModelAttribute UserVO userVO, HttpServletResponse response) throws IOException {
		userSvc.email_verify(userVO, response);
	}
	
	//회원가입하기.
	@RequestMapping(value="/user/save.do", method=RequestMethod.POST)
	public void joinUser(@ModelAttribute UserVO userVO, 
			RedirectAttributes rttr, HttpServletResponse response
			)throws EmptyResultDataAccessException, ClassNotFoundException, SQLException, IOException {
		
		log.info("UserController>joinUser>param UserVO userVO : "+userVO);
		rttr.addFlashAttribute("result", userSvc.joinUser(userVO, response));
		
	}
	

	
	//로그인하기 : 세션부여
	@RequestMapping(value = "/user/loginCheck.do", method = RequestMethod.POST)
	public String loginCheck(@ModelAttribute UserVO userVO, HttpSession session, HttpServletResponse response) throws Exception{
		userVO = userSvc.loginCheck(userVO, response);
		
		if(null == userVO) {
			return "";
		}else {
			session.setAttribute("userVO", userVO);
			session.setAttribute("userId",userVO.getUserId());
			session.setAttribute("userAdmin",userVO.getUserAdmin());
			session.setAttribute("userPoint",userVO.getUserPoint());
		}
		return "redirect:/mainpage/mainpage.do";
	}
	
	//로그아웃하기 : 세션 삭제
	@RequestMapping(value = "/user/logout.do", method = RequestMethod.GET)
	public String logOut(HttpSession session, HttpServletResponse response) throws Exception{
		session.invalidate();
		return "redirect:/user/login.do";
//		return "/user/login";
	}
	
	
	//아이디찾기
	@RequestMapping(value = "/user/find_id.do", method = RequestMethod.POST
			,produces="application/json;charset=utf8")
	@ResponseBody
	public String findId(HttpServletRequest req ) throws Exception {
		
		
		String userEmail = req.getParameter("userEmail");
		log.info("controller userEmail not yet into service : "+userEmail);
		
		String userId = userSvc.findId(userEmail);
		log.info("controller userId into service return userId: "+userId);
		
		JSONObject object = new JSONObject();
		
		if(null!=userId) {
			object.put("userId", userId);
			object.put("message", "찾기완료.");
		}else {
			object.put("userId", userId);
			object.put("message", "찾기 실패^^.");			
		}		
		
		String jsonData = object.toJSONString();	
		return jsonData;
	}	

	//비밀번호 찾기
	@RequestMapping(value = "/user/find_pw.do", method = RequestMethod.POST)
	public void findPw(@ModelAttribute UserVO userVO, HttpServletResponse res) throws Exception {
		
		
		log.info("controller userVO not yet into service : "+userVO);
		log.info("controller userId not yet into service : "+userVO.getUserId());
		log.info("controller getUserFindA not yet into service : "+userVO.getUserFindA());
		log.info("controller getUserFindQ not yet into service : "+userVO.getUserFindQ());
		
		userSvc.findPw(res, userVO);
		
	}
	
	//본인인증
	@RequestMapping(value = "/user/check_pw.do", method = RequestMethod.POST)
	public void pwCheck(@ModelAttribute UserVO userVO, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception{
		
		session = request.getSession(true);
		userVO.setUserId((String)session.getAttribute("userId"));

		log.info("controller userVO not yet into service : "+userVO);
		userSvc.checkPw(response, userVO);
		
/*		return "redirect:/mainpage/mainpage.do";*/
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}















