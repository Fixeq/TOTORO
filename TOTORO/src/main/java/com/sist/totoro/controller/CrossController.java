package com.sist.totoro.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sist.totoro.domain.BetHistoryVO;
import com.sist.totoro.domain.CrossVO;
import com.sist.totoro.service.BetHistorySvcImple;
import com.sist.totoro.service.CrossSvcImple;

@Controller
public class CrossController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CrossSvcImple crossSvc;
	@Autowired
	private BetHistorySvcImple betHistorySvc;
	
	@RequestMapping(value="/cross/makeUserBet.do")
	public String save(Model model,HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");
		//아이디 뽑아내기
		
		double finalPercent = Double.parseDouble(req.getParameter("finalbetPercent"));
		//배당률 뽑아내기
		String money = req.getParameter("money"); // 돈 얼마 걸었는
		//배당금 뽑아내기
		String[] gameSeq = req.getParameterValues("varSeq");
		//게임시퀀스[] 뽑아내기
		log.info("finalPercent : " + finalPercent);
		
		
		for(int i = 0 ; i < gameSeq.length;i++) {
			log.info("gameSeq : "+gameSeq);
		}
		log.info(money);
		
		int betSeq = betHistorySvc.do_countSeq();
		//베팅 시퀀스 증가시키기.
		
		
		betHistorySvc.do_makeUserBet(req, userId, finalPercent, money, gameSeq, betSeq);
		
		
/*		int count = 0;
		
		for(int i = 0 ; i < varSeq.length;i++) {
			log.info("varParse[i] : " + varSeq[i]); 
			
			String whichWinTeam = req.getParameter(varSeq[i]); // 시퀀스 번호로 승패 점수 얻어내기
			log.info(whichWinTeam);
			
			
			BetHistoryVO inVO = new BetHistoryVO();
			inVO.setBetSeq(betSeq);
			inVO.setGameSeq(Integer.parseInt(varSeq[i]));
			inVO.setBetCash(Integer.parseInt(money));
			inVO.setBetChoice(Integer.parseInt(whichWinTeam));
			inVO.setBetP(finalPercent);
			inVO.setUserId(userId);
			int flag = betHistorySvc.do_makeUserBet(inVO);
			count ++;
		}
		
		
		log.info(count+"개 생성하였습니다.");
*/		
		return "redirect:/cross/view.do";
	}

	
	
	@RequestMapping(value="/cross/close.do")
	public String close(Model model,HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String userId = (String) session.getAttribute("userId");
		
		String gameSeq = req.getParameter("gameSeq");
		String hscore = req.getParameter("homeScore");
		String ascore = req.getParameter("awayScore");
		int gs = Integer.parseInt(gameSeq);
		int hs = Integer.parseInt(hscore);
		int as = Integer.parseInt(ascore);
		
		CrossVO inVO = new CrossVO();
		inVO.setGameSeq(gs);
		inVO.setGameHs(hs);
		inVO.setGameAs(as);
		inVO.setGameModId(userId);
		crossSvc.do_update(inVO);
		return "redirect:/cross/view.do";
	}
	
	
	@RequestMapping(value="/cross/view.do")
	public String view(Model model,HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String userId = (String) session.getAttribute("userId");
		String userLevel = (String) session.getAttribute("userAdmin");
		
		String returnUrl = null;
		try {
			
			if(userLevel.equals("1")) {
				List<CrossVO> noList = crossSvc.do_selectNoResult();
				List<CrossVO> yesList = crossSvc.do_selectYesResult();
	
				model.addAttribute("noList", noList);
				model.addAttribute("yesList", yesList);
				
				returnUrl =  "/cross/admin";
			}else{
				List<CrossVO> list = crossSvc.do_selectLimit();
				model.addAttribute("list", list);
				returnUrl = "/cross/user";
			}
		}catch(NullPointerException npe) {
			returnUrl = "/user/login";
			
		}
		return returnUrl;
	}


	
	@RequestMapping(value="/cross/makeGame.do")
	public String view(HttpServletRequest req) {
		
		
		String returnUrl = "/cross/makeGame";
		
		HttpSession session = req.getSession(true);
		String userId = (String) session.getAttribute("userId");
		String userLevel = (String) session.getAttribute("userAdmin");

		if(userLevel.equals("0")) {
			returnUrl = "redirect:/cross/view.do";
		}
		
		return returnUrl;
	}
	
	@RequestMapping(value="/cross/makeGame.do",method=RequestMethod.POST)
	public String makeGame(HttpServletRequest req) {
		
		HttpSession session = req.getSession(true);
		String userId = (String) session.getAttribute("userId");
		String userLevel = (String) session.getAttribute("userAdmin");

		
		String gameHome =  req.getParameter("gameHome");
		String varHp =  req.getParameter("gameHp");
		Double gameHp = Double.parseDouble(varHp);
		
		String gameAway =  req.getParameter("gameAway");
		String varAp =  req.getParameter("gameAp");
		Double gameAp = Double.parseDouble(varAp);
		
		String varDp =  req.getParameter("gameDp");
		Double gameDp = Double.parseDouble(varDp);

		String gameDate =  req.getParameter("gameDate");
		
		CrossVO inVO = new CrossVO();
		inVO.setGameHome(gameHome);
		inVO.setGameHp(gameHp);
		inVO.setGameAway(gameAway);
		inVO.setGameAp(gameAp);
		inVO.setGameDp(gameDp);
		inVO.setGameDate(gameDate);
		
		int flag = crossSvc.do_insert(inVO);
		if(flag == 0) {
			
		}
		return "redirect:/cross/view.do";
		
	}


	@RequestMapping(value="/cross/check_byDate.do",method=RequestMethod.POST
	        ,produces="application/json;charset=utf8" )
	@ResponseBody
	public String chk_date(ServletRequest req) {
		
		String date = req.getParameter("gameDate");
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		String message = null;
		
		try {
			LocalDateTime dateTime = LocalDateTime.parse(date, pattern);
			message = "올바른 날짜/시간 형식입니다.";
		}catch (Exception e) {
			message = "날짜/시간 형식을 다시 작성해주세요";
		}
		return message;
		
	}
}
