package com.sist.totoro.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.sist.totoro.common.SearchVO;
import com.sist.totoro.domain.AtmVo;
import com.sist.totoro.domain.UserVO;
import com.sist.totoro.service.AtmSvc;

@Controller
@SessionAttributes("userVO")
public class AtmController {

	private static final Logger logger = LoggerFactory.getLogger(AtmController.class);

	@Autowired
	private AtmSvc atmSvc;
	
	@RequestMapping(value = "/atm/customerdeposit.do", method = RequestMethod.GET)
	public String customerdeposit(HttpServletRequest req, @ModelAttribute SearchVO invo,Model model) throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {	
		logger.info("SearchVO: "+invo);
		//param -> view
		
		HttpSession session = req.getSession(true);
		String userId = (String) session.getAttribute("userId");
		
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
		
		invo.setSearch_word(userId);
		
		List<AtmVo> list = atmSvc.cusDeAll(invo);
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
	
	@RequestMapping(value = "/atm/cusdepositreq.do", method = RequestMethod.GET)
	public String cusdepositreq(HttpServletRequest req,@ModelAttribute SearchVO invo, Locale locale, Model model) throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		HttpSession session = req.getSession(true);
		String userId = (String) session.getAttribute("userId");
		
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
		
		invo.setSearch_word(userId);
		
		List<AtmVo> list = atmSvc.cusDeReqAll(invo);
		int total_cnt = 0;
		if(null != list && list.size()>0) {
			total_cnt = list.get(0).getTotalCnt();
		}
		
		model.addAttribute("total_cnt",total_cnt);
		model.addAttribute("list",list);
		model.addAttribute("list", list);

		model.addAttribute("serverTime", formattedDate);

		return "/atm/CustomerDeposit";
	}
	
	@RequestMapping(value = "/atm/cusdepositps.do", method = RequestMethod.GET)
	public String cusdepositps(HttpServletRequest req, @ModelAttribute SearchVO invo, Locale locale, Model model) throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		HttpSession session = req.getSession(true);
		String userId = (String) session.getAttribute("userId");
		
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
		
		invo.setSearch_word(userId);
		
		List<AtmVo> list = atmSvc.cusDePsAll(invo);
		int total_cnt = 0;
		if(null != list && list.size()>0) {
			total_cnt = list.get(0).getTotalCnt();
		}
		
		model.addAttribute("total_cnt",total_cnt);
		model.addAttribute("list",list);
		model.addAttribute("list", list);

		model.addAttribute("serverTime", formattedDate);

		return "/atm/CustomerDeposit";
	}
	
	
	@RequestMapping(value = "/atm/customerwithdraw.do", method = RequestMethod.GET)
	public String customerwithdraw(HttpServletRequest req, @ModelAttribute SearchVO invo,Model model) throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {	
		logger.info("SearchVO: "+invo);
		//param -> view
		
		HttpSession session = req.getSession(true);
		String userId = (String) session.getAttribute("userId");
		
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
		
		invo.setSearch_word(userId);
		
		List<AtmVo> list = atmSvc.cusWiAll(invo);
		logger.info("list: "+list);
		//총글수
		int total_cnt = 0;
		if(null != list && list.size()>0) {
			total_cnt = list.get(0).getTotalCnt();
			logger.info("total_cnt: "+total_cnt);
		}
		
		
		model.addAttribute("total_cnt",total_cnt);
		model.addAttribute("list",list);
		return "/atm/CustomerWithdraw";
	}
	
	@RequestMapping(value = "/atm/cuswithdrawreq.do", method = RequestMethod.GET)
	public String cuswithdrawreq(HttpServletRequest req, @ModelAttribute SearchVO invo, Locale locale, Model model) throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		HttpSession session = req.getSession(true);
		String userId = (String) session.getAttribute("userId");
		
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
		
		invo.setSearch_word(userId);
		
		List<AtmVo> list = atmSvc.cusWiReqAll(invo);
		int total_cnt = 0;
		if(null != list && list.size()>0) {
			total_cnt = list.get(0).getTotalCnt();
		}
		
		model.addAttribute("total_cnt",total_cnt);
		model.addAttribute("list",list);
		model.addAttribute("list", list);

		model.addAttribute("serverTime", formattedDate);

		return "/atm/CustomerWithdraw";
	}
	
	@RequestMapping(value = "/atm/cuswithdrawps.do", method = RequestMethod.GET)
	public String cuswithdrawps(@ModelAttribute SearchVO invo, Locale locale, Model model) throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {
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
		
		invo.setSearch_word("dwtester3");
		
		List<AtmVo> list = atmSvc.cusWiPsAll(invo);
		int total_cnt = 0;
		if(null != list && list.size()>0) {
			total_cnt = list.get(0).getTotalCnt();
		}
		
		model.addAttribute("total_cnt",total_cnt);
		model.addAttribute("list",list);
		model.addAttribute("list", list);

		model.addAttribute("serverTime", formattedDate);

		return "/atm/CustomerWithdraw";
	}
	
	@RequestMapping(value = "/atm/admindeposit.do", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "/atm/depositreq.do", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "/atm/depositps.do", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "/atm/adminwithdraw.do", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "/atm/withdrawreq.do", method = RequestMethod.GET)
	public String withdrawreq(@ModelAttribute SearchVO invo, Locale locale, Model model) throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {
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
		
		List<AtmVo> list = atmSvc.adWiReqAll(invo);
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
	
	@RequestMapping(value = "/atm/withdrawps.do", method = RequestMethod.GET)
	public String withdrawps(@ModelAttribute SearchVO invo, Locale locale, Model model) throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {
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
		
		List<AtmVo> list = atmSvc.adWiPsAll(invo);
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
	
	
	@RequestMapping(value="/atm/delete.do",method=RequestMethod.POST,consumes= {"text/plain", "application/*"},produces="application/json;charset=UTF-8")
	@ResponseBody
	public String delete(HttpServletRequest req,Model model) throws RuntimeException, SQLException{
		String uIdList = req.getParameter("userId_list");
		
		Gson gson=new Gson();
		List<String>  listParam = gson.fromJson(uIdList, List.class);
		
		List<AtmVo> paramList = new ArrayList<AtmVo>();
		for(int i=0;i<listParam.size();i=i+2) {
			AtmVo vo =new AtmVo();
			vo.setDwSeq(listParam.get(i));
			vo.setUserId(listParam.get(i+1));
			
			paramList.add(vo);
		}
		
		int flag = this.atmSvc.do_deleteMulti(paramList);
		
		JSONObject object=new JSONObject();
		
		if(flag>0) {
			object.put("flag", flag);
			object.put("message", "삭제 되었습니다.\n("+flag+"건 삭제.)");
		}else {
			object.put("flag", flag);
			object.put("message", "삭제 실패^^.");			
		}		
		String jsonData = object.toJSONString();
			
		return jsonData;
	}
	
	@RequestMapping(value="/atm/request.do",method=RequestMethod.POST,consumes= {"text/plain", "application/*"},produces="application/json;charset=UTF-8")
	@ResponseBody
	public String reqsave(HttpServletRequest req,Model model) throws RuntimeException, SQLException{
		String dePoint = req.getParameter("dpoint");
		
		HttpSession session = req.getSession(true);
		String userId = (String) session.getAttribute("userId");

		AtmVo vo =new AtmVo();
		vo.setUserId(userId);
		vo.setDePoint(dePoint);

		
		int flag = this.atmSvc.deAdd(vo);
		
		JSONObject object=new JSONObject();
		
		if(flag>0) {
			object.put("flag", flag);
			object.put("message", "요청 되었습니다.\n("+flag+"건 등록.)");
		}else {
			object.put("flag", flag);
			object.put("message", "요청 실패^^.");			
		}		
		String jsonData = object.toJSONString();
			
		return jsonData;
	}
	
	@RequestMapping(value="/atm/wirequest.do",method=RequestMethod.POST,consumes= {"text/plain", "application/*"},produces="application/json;charset=UTF-8")
	@ResponseBody
	public String wirequest(HttpServletRequest req,Model model) throws RuntimeException, SQLException{
		String wiPoint = req.getParameter("dpoint");
		
		HttpSession session = req.getSession(true);
		String userId = (String) session.getAttribute("userId");
		
		AtmVo vo =new AtmVo();
		vo.setUserId(userId);
		vo.setWiPoint(wiPoint);

		
		int flag = this.atmSvc.wiAdd(vo);
		
		JSONObject object=new JSONObject();
		
		if(flag>0) {
			object.put("flag", flag);
			object.put("message", "요청 되었습니다.\n("+flag+"건 등록.)");
		}else {
			object.put("flag", flag);
			object.put("message", "요청 실패^^.");			
		}		
		String jsonData = object.toJSONString();
			
		return jsonData;
	}
	
	@RequestMapping(value="/atm/deposit.do",method=RequestMethod.POST,consumes= {"text/plain", "application/*"},produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deposit(HttpServletRequest req,Model model) throws RuntimeException, SQLException{
		String uIdList = req.getParameter("userId_list");
		
		Gson gson=new Gson();
		List<String>  listParam = gson.fromJson(uIdList, List.class);
		
		List<AtmVo> paramList = new ArrayList<AtmVo>();
		for(int i=0;i<listParam.size();i=i+3) {
			AtmVo vo =new AtmVo();
			vo.setDwSeq(listParam.get(i));
			vo.setUserId(listParam.get(i+1));
			vo.setDePoint(listParam.get(i+2));
			
			paramList.add(vo);
		}
		
		int flag = this.atmSvc.do_depositMulti(paramList);
		
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
	
	@RequestMapping(value="/atm/withdraw.do",method=RequestMethod.POST,consumes= {"text/plain", "application/*"},produces="application/json;charset=UTF-8")
	@ResponseBody
	public String withdraw(HttpServletRequest req,Model model) throws RuntimeException, SQLException{
		String uIdList = req.getParameter("userId_list");
		
		Gson gson=new Gson();
		List<String>  listParam = gson.fromJson(uIdList, List.class);
		
		List<AtmVo> paramList = new ArrayList<AtmVo>();
		for(int i=0;i<listParam.size();i=i+3) {
			AtmVo vo =new AtmVo();
			vo.setDwSeq(listParam.get(i));
			vo.setUserId(listParam.get(i+1));
			vo.setWiPoint(listParam.get(i+2));
			
			paramList.add(vo);
		}
		
		int flag = this.atmSvc.do_withdrawMulti(paramList);
		
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
