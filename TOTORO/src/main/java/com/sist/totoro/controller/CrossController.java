package com.sist.totoro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
