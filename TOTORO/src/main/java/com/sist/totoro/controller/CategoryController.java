package com.sist.totoro.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sist.totoro.code.CodeSvc;
import com.sist.totoro.code.CodeVO;
import com.sist.totoro.domain.BetResultVO;
import com.sist.totoro.service.BetResultSvc;

@Controller
public class CategoryController {

	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private BetResultSvc betResultSvc;
	
	@Autowired
	private CodeSvc codeSvc;	
	
	
	
	@RequestMapping(value = "/betresult/betresult.do", method = RequestMethod.GET)
	public String betresult(@ModelAttribute BetResultVO invo,Model model) throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {
		logger.info("BetResultVO: "+invo);
		//param -> view
		
		if(invo.getPage_size() == 0) {
			invo.setPage_size(5);
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
		
		List<BetResultVO> list = betResultSvc.do_retrieve(invo);
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
		
		return "/category/BetResult";
	}
	
	@RequestMapping(value = "/betrule/betrule.do", method = RequestMethod.GET)
	public String betrule(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "/category/BetRule";
	}
	
}
