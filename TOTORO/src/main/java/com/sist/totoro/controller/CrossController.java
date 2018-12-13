package com.sist.totoro.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.servlet.ServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sist.totoro.domain.CrossVO;
import com.sist.totoro.service.CrossSvcImple;

@Controller
public class CrossController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CrossSvcImple crossSvc;
	
	/*@RequestMapping(value="/cross/userView.do")
	public String userView(Model model) {
		List<CrossVO> list = crossSvc.do_selectAll();
		model.addAttribute("list", list);
		return "/cross/userView";
	}
	
	@RequestMapping(value="/cross/adminView.do")
	public String adminView(Model model) {
		List<CrossVO> list = crossSvc.do_selectAll();
		model.addAttribute("list", list);
		return "/cross/adminView";
	}
*/	
	@RequestMapping(value="/cross/view.do")
	public String view(Model model,ServletRequest req) {
		String connLevel = req.getParameter("level");
		String returnUrl = null;
		if(connLevel.equals("1")) {
			List<CrossVO> noList = crossSvc.do_selectNoResult();
			List<CrossVO> yesList = crossSvc.do_selectYesResult();

			model.addAttribute("noList", noList);
			model.addAttribute("yesList", yesList);
			
			returnUrl =  "/cross/adminView";
		}else {
			List<CrossVO> list = crossSvc.do_selectLimit();
			model.addAttribute("list", list);
			returnUrl = "/cross/userView";
		}
		return returnUrl;
	}


	
	@RequestMapping(value="/cross/makeGame.do")
	public String view(ServletRequest req) {
		return "/cross/makeGame";
		
	}
	
	@RequestMapping(value="/cross/makeGame.do",method=RequestMethod.POST)
	public String makeGame(ServletRequest req) {
		String returnPage = "/cross/view";
		
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
		return "redirect:/cross/adminView.do";
		
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
