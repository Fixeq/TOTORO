package com.totoro.cross.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.totoro.cross.service.CrossSvcImple;

@Controller
public class CrossController {

	@Autowired
	private CrossSvcImple svc;
}
