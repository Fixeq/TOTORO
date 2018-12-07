package com.sist.totoro.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AtmController {

	private static final Logger logger = LoggerFactory.getLogger(AtmController.class);

	@RequestMapping(value = "/customerdeposit/customerdeposit.do", method = RequestMethod.GET)
	public String customerdeposit(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "/atm/CustomerDeposit";
	}
	
	@RequestMapping(value = "/customerwithdraw/customerwithdraw.do", method = RequestMethod.GET)
	public String customerwithdraw(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "/atm/CustomerWithdraw";
	}
	
	@RequestMapping(value = "/admindeposit/admindeposit.do", method = RequestMethod.GET)
	public String admindeposit(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "/atm/AdminDeposit";
	}
	
	@RequestMapping(value = "/adminwithdraw/adminwithdraw.do", method = RequestMethod.GET)
	public String adminwithdraw(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

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
