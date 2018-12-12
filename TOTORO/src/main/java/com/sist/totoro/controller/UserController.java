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
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/user/login.do", method = RequestMethod.GET)
	public String customerdeposit(Locale locale, Model model) {

		return "/user/login";
	}

	@RequestMapping(value = "/user/join.do", method = RequestMethod.GET)
	public String join(Locale locale, Model model) {

		return "/user/join";
	}
	
	@RequestMapping(value = "/user/find.do", method = RequestMethod.GET)
	public String abc(Locale locale, Model model) {

		return "/user/find";
	}
}
