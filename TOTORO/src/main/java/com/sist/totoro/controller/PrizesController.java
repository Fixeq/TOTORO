package com.sist.totoro.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sist.totoro.code.CodeSvc;
import com.sist.totoro.code.CodeVO;
import com.sist.totoro.common.SearchVO;
import com.sist.totoro.domain.AtmVo;
import com.sist.totoro.domain.PrizesVO;
import com.sist.totoro.service.PrizesSvc;

@Controller
public class PrizesController {

	private static final Logger logger = LoggerFactory.getLogger(PrizesController.class);

	
	@Autowired
	private PrizesSvc userSvc;
    
	@Autowired
	private CodeSvc codeSvc;	
	
	@RequestMapping(value = "/atm/givepay.do", method = RequestMethod.GET)
	public String mainpage(@ModelAttribute SearchVO invo,Model model) throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {
		logger.info("SearchVO: "+invo);
		//param -> view
		
		if(invo.getPage_size() == 0) {
			invo.setPage_size(10);
		}
		
		if(invo.getPage_num() == 0) {
			invo.setPage_num(1);
		}
		
		if(null == invo.getSearch_div()) {
			invo.setSearch_div("");
		}
		
		if(null == invo.getSearch_word()) {
			invo.setSearch_word("");
		}		
		
		
		model.addAttribute("param",invo);
		
		List<PrizesVO> list = userSvc.do_retrieve(invo);
		logger.info("list: "+list);
		//총글수
		int total_cnt = 0;
		if(null != list && list.size()>0) {
			total_cnt = list.get(0).getTotalCnt();
			logger.info("total_cnt: "+total_cnt);
		}
		
		CodeVO codePage=new CodeVO();
		codePage.setCd_id("C_001");
		
		model.addAttribute("code_page",codeSvc.do_retrieve(codePage));
		model.addAttribute("total_cnt",total_cnt);
		model.addAttribute("list",list);

		return "/atm/GivePay";
	}
	
	@RequestMapping(value="/atm/give.do",method=RequestMethod.POST,consumes= {"text/plain", "application/*"},produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deposit(HttpServletRequest req,Model model) throws RuntimeException, SQLException{
		String uIdList = req.getParameter("userId_list");
		
		Gson gson=new Gson();
		List<String>  listParam = gson.fromJson(uIdList, List.class);
		
		List<PrizesVO> paramList = new ArrayList<PrizesVO>();
		for(int i=0;i<listParam.size();i=i+3) {
			PrizesVO vo =new PrizesVO();
			vo.setBetSeq(listParam.get(i));
			vo.setUserId(listParam.get(i+1));
			vo.setBetwPrice(listParam.get(i+2));
			
			paramList.add(vo);
		}
		
		int flag = this.userSvc.do_GiveMulti(paramList);
		
		JSONObject object=new JSONObject();
		
		if(flag>0) {
			object.put("flag", flag);
			object.put("message", "처리 되었습니다.\n("+flag+"건 처리.)");
		}else {
			object.put("flag", flag);
			object.put("message", "처리 실패^^.");			
		}		
		String jsonData = object.toJSONString();
			
		return jsonData;
	}
	
	
}
