package com.sist.totoro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sist.totoro.domain.BetHistoryResultVO;
import com.sist.totoro.domain.BetHistoryVO;
import com.sist.totoro.service.BetHistorySvcImple;

@Controller
public class BetHistoryController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BetHistorySvcImple betHistorySvc;
	
	@RequestMapping(value="do_search_byGameSeq.do",method=RequestMethod.POST
	        ,produces="application/json;charset=utf8"  
	)
	@ResponseBody
	public String getBySeq(HttpServletRequest req,Model model) {
		HttpSession session = req.getSession(true);
		String userId = (String) session.getAttribute("userId");
		String userLevel = (String) session.getAttribute("userAdmin");
		

		int gameSeq = Integer.parseInt(req.getParameter("ajgameSeq"));
		
		log.info("2========================");
		log.info("getBySeq=");
		log.info("2========================");	
		
		BetHistoryVO inVO = new BetHistoryVO();
		inVO.setUserId(userId);
		inVO.setBetSeq(gameSeq);
		
		List<BetHistoryResultVO> list = betHistorySvc.do_viewByBetSeq(inVO);

		
/*		Gson gson = new Gson();
		String json = gson.toJson(list);
		
*/		
		JSONArray array = new JSONArray();
        
            for(int i = 0 ; i < list.size();i++){
                JSONObject sObject = new JSONObject();//배열 내에 들어갈 json
                sObject.put("gameSeq", list.get(i).getGameSeq());
                sObject.put("getBetSeq", list.get(i).getBetSeq());
                sObject.put("getBetChoice", list.get(i).getBetChoice());
                sObject.put("getGameHome", list.get(i).getGameHome());
                sObject.put("getGameAway", list.get(i).getGameAway());
                sObject.put("getGameHp", list.get(i).getGameHp());
                sObject.put("getGameDp", list.get(i).getGameDp());
                sObject.put("getGameAp", list.get(i).getGameAp());
                sObject.put("getGameResult", list.get(i).getGameResult());
                array.add(sObject);
            }
            String jsonData = array.toJSONString();
        
		
/*			JSONArray array = new JSONArray();
			array.addAll(list);
*/			
		
    		log.debug("3========================");
    		log.debug("jsonData="+jsonData);
    		log.debug("3========================");			
    		
    		return jsonData;
	}
	
	@RequestMapping(value="/betHistory.do")
	public String myBet(Model model , HttpServletRequest req) {
		HttpSession session = req.getSession(true);
		String userId = (String) session.getAttribute("userId");
		String userLevel = (String) session.getAttribute("userAdmin");
		
		List<BetHistoryVO> list = betHistorySvc.do_viewByUserId(userId) ;
		model.addAttribute("list", list);
		
		return "/betHistroy/myBet";
	}
}
