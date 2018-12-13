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
import com.sist.totoro.domain.CustomerVO;
import com.sist.totoro.service.CusReplySvc;
import com.sist.totoro.service.CustomerSvc;




@Controller
public class CustomerController {

	Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerSvc customerSvc;
	
	@Autowired
	private CusReplySvc cusreplysvc;
    
	@Autowired
	private CodeSvc codeSvc;	
	
	
	private static final String VIEW_NAME="/user/user";
	
	
	@RequestMapping(value="/cus/search.do")	
	public String do_search(@ModelAttribute SearchVO invo,Model model) throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {	
		log.info("SearchVO: "+invo);
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
		
		List<CustomerVO> list = customerSvc.do_retrieve(invo);
		log.info("list: "+list);
		//총글수
		int total_cnt = 0;
		if(null != list && list.size()>0) {
			total_cnt = list.get(0).getTotalCnt();
			log.info("total_cnt: "+total_cnt);
		}
		
		CodeVO codePage=new CodeVO();
		codePage.setCd_id("C001");
		
		model.addAttribute("code_page",codeSvc.do_retrieve(codePage));
		model.addAttribute("total_cnt",total_cnt);
		model.addAttribute("list",list);
		return "/cus/CusList";  
	}
	
	@RequestMapping(value="/cus/delete.do",method=RequestMethod.POST
			,consumes= {"text/plain", "application/*"}
			,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String delete(HttpServletRequest req,Model model) throws RuntimeException, SQLException{
		String cusSeq = req.getParameter("cusSeq");
		log.info("cusSeq: "+cusSeq);
		String cusSeq1 = req.getParameter("cusSeq");
		
		Gson gson=new Gson();
		List<String>  listParam = gson.fromJson(cusSeq, List.class);
		log.info("uIdList: "+cusSeq1);
		
		List<CustomerVO> paramList = new ArrayList<CustomerVO>();
		for(int i=0;i<listParam.size();i++) {
			CustomerVO vo =new CustomerVO();
			vo.setCusSeq(listParam.get(i));
			
			paramList.add(vo);
		}
		log.info("paramList: "+paramList);
		
		int flag = this.customerSvc.do_deleteMulti(paramList);
		
		JSONObject object=new JSONObject();
		
		if(flag>0) {
			object.put("flag", flag);
			object.put("message", "삭제 되었습니다.\n("+flag+"건 삭제.)");
		}else {
			object.put("flag", flag);
			object.put("message", "삭제 실패^^.");			
		}		
		String jsonData = object.toJSONString();
		
		log.info("3========================");
		log.info("jsonData="+jsonData);
		log.info("3========================");			
		return jsonData;
	}
	
	
	@RequestMapping(value="/cus/update.do",method=RequestMethod.POST
	        ,produces="application/json;charset=utf8"  
	)
	@ResponseBody
	public String update(@ModelAttribute CustomerVO invo,HttpServletRequest req,Model model) throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {
		String upsert_div = req.getParameter("upsert_div");
		
		log.info("2========================");
		log.info("invo="+invo);
		log.info("upsert_div="+upsert_div);
		
		log.info("2========================");	
		
		int flag = 0;
		//수정
		
		//등록
		if("update".equals(upsert_div)) {
			flag = customerSvc.update(invo);
			log.info("3update=================");	
		}else {
			flag = customerSvc.add(invo);
			log.info("3add=================");	
		}
		
		 
		JSONObject object=new JSONObject();
		
		if(flag>0) {
			object.put("flag", flag);
			object.put("message", "등록 되었습니다.");
		}else {
			object.put("flag", flag);
			object.put("message", "등록 실패^^.");			
		}
		
		String jsonData = object.toJSONString();
		
		log.info("3========================");
		log.info("jsonData="+jsonData);
		log.info("3========================");			
		return jsonData;
	}	 
	

	
	@RequestMapping(value="/cus/do_search_one.do",method=RequestMethod.POST
	        ,produces="application/json;charset=utf8"  
	)
			@ResponseBody
			public String get(HttpServletRequest req,Model model) throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {
			String cusSeq = req.getParameter("cusSeq");
			log.info("2========================");
			log.info("get=");
			log.info("2========================");	
			CustomerVO customerVO=new CustomerVO();
			customerVO.setCusSeq(cusSeq);
			
			//JSON Convertor
			CustomerVO outVO = customerSvc.get(customerVO);
			JSONObject object=new JSONObject();   
			object.put("cusSeq", outVO.getCusSeq());
			object.put("userId", outVO.getUserId());
			object.put("cusCat", outVO.getCusCat());
			object.put("cusTitle", outVO.getCusTitle());   
			object.put("cusContent", outVO.getCusContent());
			object.put("cusRegDt", outVO.getCusRegDt());
			object.put("cusReply", outVO.getCusReply());

			 
			String jsonData = object.toJSONString();
			
			log.info("3========================");
			log.info("jsonData="+jsonData);
			log.info("3========================");			
			model.addAttribute("vo", customerSvc.get(customerVO));
			return jsonData;
			}
	
	
	@RequestMapping(value = "/cus/writepage.do", method = RequestMethod.GET)
	public String board(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);

		
		
		

		return "/cus/CusWrite";
	}
	
	
	
	@RequestMapping(value="/cus/save.do")	
	public String do_save(@ModelAttribute SearchVO invo,Model model) throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {	
		log.info("SearchVO: "+invo);
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
		
		List<CustomerVO> list = customerSvc.do_retrieve(invo);
		log.info("list: "+list);
		//총글수
		int total_cnt = 0;
		if(null != list && list.size()>0) {
			total_cnt = list.get(0).getTotalCnt();
			log.info("total_cnt: "+total_cnt);
		}
		
		CodeVO codePage=new CodeVO();
		codePage.setCd_id("C001");
		
		model.addAttribute("code_page",codeSvc.do_retrieve(codePage));
		model.addAttribute("total_cnt",total_cnt);
		model.addAttribute("list",list);
		return "/cus/CusList";  
	}

}
