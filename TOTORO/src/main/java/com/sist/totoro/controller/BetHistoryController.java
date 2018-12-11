package com.sist.totoro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sist.totoro.domain.BetHistoryVO;
import com.sist.totoro.service.BetHistorySvcImple;

@Controller
public class BetHistoryController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BetHistorySvcImple betHistorySvc;
	
	@RequestMapping(value="/betHistory/do_search_byGameSeq.do",method=RequestMethod.POST
	        ,produces="application/json;charset=utf8"  
	)
	@ResponseBody
	public String getBySeq(HttpServletRequest req,Model model) {
		String userId = "nununanana";
		int gameSeq = Integer.parseInt(req.getParameter("ajgameSeq"));
		
		log.info("2========================");
		log.info("getBySeq=");
		log.info("2========================");	
		
		BetHistoryVO inVO = new BetHistoryVO();
		inVO.setBetSeq(gameSeq);
		List<BetHistoryVO> list = betHistorySvc.do_viewByBetSeq(inVO);

		
		return null;
	}
	
	@RequestMapping(value="/betHistory.do")
	public String myBet(Model model) {
		String userId = "nununanana";
		
		List<BetHistoryVO> list = betHistorySvc.do_viewByUserId(userId) ;
		model.addAttribute("list", list);
		
		return "/betHistroy/myBet";
	}
}
