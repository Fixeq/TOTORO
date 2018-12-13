package com.sist.totoro.controller;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.totoro.domain.CrossVO;
import com.sist.totoro.service.CrossSvcImple;

@Controller
public class CrossController {

	@Autowired
	private CrossSvcImple crossSvc;
	
	@RequestMapping(value="/cross/view.do")
	public String view(Model model) {
		List<CrossVO> list = crossSvc.do_selectAll();
		model.addAttribute("list", list);
		return "/cross/view";
	}
	
	@RequestMapping(value="/cross/makeGame.do")
	public String view(ServletRequest req) {
		return "/cross/makeGame";
		
	}
}
