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

import com.sist.totoro.common.SearchVO;
import com.sist.totoro.domain.AtmVo;
import com.sist.totoro.service.AtmSvc;

@Controller
public class AtmController {

	private static final Logger logger = LoggerFactory.getLogger(AtmController.class);

	@Autowired
	private AtmSvc atmSvc;
	
	@RequestMapping(value = "/customerdeposit/customerdeposit.do", method = RequestMethod.GET)
	public String customerdeposit(@ModelAttribute SearchVO invo,Model model) throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {	
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
		
		List<AtmVo> list = atmSvc.do_retrieve(invo);
		logger.info("list: "+list);
		//총글수
		int total_cnt = 0;
		if(null != list && list.size()>0) {
			total_cnt = list.get(0).getTotalCnt();
			logger.info("total_cnt: "+total_cnt);
		}
		
		
		model.addAttribute("total_cnt",total_cnt);
		model.addAttribute("list",list);
		return "/atm/CustomerDeposit";
	}
	
	@RequestMapping(value = "/customerwithdraw/customerwithdraw.do", method = RequestMethod.GET)
	public String customerwithdraw(@ModelAttribute SearchVO invo, Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "/atm/CustomerWithdraw";
	}
	
	@RequestMapping(value = "/admindeposit/admindeposit.do", method = RequestMethod.GET)
	public String admindeposit(@ModelAttribute SearchVO invo, Locale locale, Model model) throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		
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
		
		List<AtmVo> list = atmSvc.adDeAll(invo);
		int total_cnt = 0;
		if(null != list && list.size()>0) {
			total_cnt = list.get(0).getTotalCnt();
		}
		
		model.addAttribute("total_cnt",total_cnt);
		model.addAttribute("list",list);
		model.addAttribute("list", list);

		model.addAttribute("serverTime", formattedDate);

		return "/atm/AdminDeposit";
	}
	
	@RequestMapping(value = "/admindeposit/depositreq.do", method = RequestMethod.GET)
	public String depositreq(@ModelAttribute SearchVO invo, Locale locale, Model model) throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		
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
		
		List<AtmVo> list = atmSvc.adDeReqAll(invo);
		int total_cnt = 0;
		if(null != list && list.size()>0) {
			total_cnt = list.get(0).getTotalCnt();
		}
		
		model.addAttribute("total_cnt",total_cnt);
		model.addAttribute("list",list);
		model.addAttribute("list", list);

		model.addAttribute("serverTime", formattedDate);

		return "/atm/AdminDeposit";
	}
	
	@RequestMapping(value = "/admindeposit/depositps.do", method = RequestMethod.GET)
	public String depositps(@ModelAttribute SearchVO invo, Locale locale, Model model) throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		
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
		
		List<AtmVo> list = atmSvc.adDePsAll(invo);
		int total_cnt = 0;
		if(null != list && list.size()>0) {
			total_cnt = list.get(0).getTotalCnt();
		}
		
		model.addAttribute("total_cnt",total_cnt);
		model.addAttribute("list",list);
		model.addAttribute("list", list);

		model.addAttribute("serverTime", formattedDate);

		return "/atm/AdminDeposit";
	}
	
	@RequestMapping(value = "/adminwithdraw/adminwithdraw.do", method = RequestMethod.GET)
	public String adminwithdraw(@ModelAttribute SearchVO invo, Locale locale, Model model) throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		
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
		
		List<AtmVo> list = atmSvc.adWiAll(invo);
		int total_cnt = 0;
		if(null != list && list.size()>0) {
			total_cnt = list.get(0).getTotalCnt();
		}
		
		model.addAttribute("total_cnt",total_cnt);
		model.addAttribute("list",list);
		model.addAttribute("list", list);

		model.addAttribute("serverTime", formattedDate);

		return "/atm/AdminWithdraw";
	}
	
	@RequestMapping(value = "/givepay/givepay.do", method = RequestMethod.GET)
	public String givepay(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "/atm/GivePay";
	}
}
