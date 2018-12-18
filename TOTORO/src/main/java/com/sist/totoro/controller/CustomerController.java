package com.sist.totoro.controller;


import java.sql.SQLException;
import java.util.ArrayList;
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
import com.sist.totoro.domain.CusReplyVO;
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
	

	
	//리스트조회
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
	
	
	//상세보기
	@RequestMapping(value="/cus/do_search_one.do",method=RequestMethod.POST)
	public String get(@ModelAttribute CusReplyVO invo,HttpServletRequest req,Model model) throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {
		
		log.info("search : "+invo);
		
		String cusSeq = req.getParameter("cusSeq");
		log.info("cusSeq : "+cusSeq);
		
		if(invo.getPage_size() == 0) {
			invo.setPage_size(5);
		}
		if(invo.getPage_num() == 0){
			invo.setPage_num(1);
		}
		if(null == invo.getSearch_div()) {
			invo.setSearch_div("");
		}
		if(null == invo.getSearch_word()) {
			invo.setSearch_word("");
		}
		model.addAttribute("param",invo);
		List<CusReplyVO> list = cusreplysvc.do_retrieve(invo);
		log.info("list size : "+list.size());
		model.addAttribute("list",list);
		int totalCnt = 0;
		if(null != list  &&  list.size()>0) {
			totalCnt = list.get(0).getTotalCnt();		
		}
		
		log.info("====================================");
		log.info("====================================");
		log.info("=====================================");
		log.info("totalCnt : "+totalCnt);
		log.info("====================================");
		log.info("====================================");
		log.info("====================================");
		
		CustomerVO customerVO = new CustomerVO();
		customerVO.setCusSeq(cusSeq);
		CustomerVO outVO = customerSvc.get(customerVO);
		
		model.addAttribute("vo",outVO);
		model.addAttribute("totalCnt",totalCnt);
	return "/cus/CusRead";
	}
	
	
	//다건삭제
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
	

	//상세페이지삭제
	 @RequestMapping(value="/cus/detail_delete.do", method=RequestMethod.POST)
	    public String delete(HttpServletRequest req,@ModelAttribute CustomerVO vo) throws Exception{
		 String cusSeq = req.getParameter("cusSeq");
			CustomerVO customerVO = new CustomerVO();
			customerVO.setCusSeq(cusSeq);
		 int list = customerSvc.delete(vo);
	        return "redirect:search.do";
	    }
	


	
	//글쓰기 
	 @RequestMapping(value="/cus/save.do", method=RequestMethod.POST)
	    public String insert(@ModelAttribute CustomerVO vo) throws Exception{
		 int list = customerSvc.add(vo);
	        return "redirect:search.do";
	    }
	 
	 
	//답변쓰기 
		 @RequestMapping(value="/cus/rsave.do", method=RequestMethod.POST)
		    public String insertReply(@ModelAttribute CusReplyVO invo,Model model) throws Exception{
			 log.info("=====================================");
			 log.info("=====================================");
			 log.info("=====================================");
			 log.info("=====================================");
			 log.info("=====================================");
			 log.info("=====================================");
			 
			 log.info("CusReplyVO:"+invo);
			 int list = cusreplysvc.add(invo);
			 model.addAttribute("vou", list);
		        return "redirect:search.do";
		    }
	 
	

	//수정
	 @RequestMapping(value="/cus/update.do", method=RequestMethod.POST)
	    public String update(@ModelAttribute CustomerVO vo,Model model) throws Exception{
		 int list = customerSvc.update(vo);
			model.addAttribute("vou", list);
	        return "redirect:search.do";
	    }
	
		//쓰기페이지이동
		
		@RequestMapping(value = "/cus/writepage.do", method = RequestMethod.POST)
		public String board(Locale locale, Model model) {
			log.info("Welcome home! The client locale is {}.", locale);

			
			
			

			return "/cus/CusWrite";
		}
		
		//답쓰기페이지이동
		
		@RequestMapping(value = "/cus/rwritepage.do", method = RequestMethod.POST)
		public String rwritepage(CusReplyVO vo,HttpServletRequest req,Model model) throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {
			String cusSeq = req.getParameter("cusSeq");
			CusReplyVO cusreplyVO = new CusReplyVO();
			cusreplyVO.setCusSeq(cusSeq);
			
			
			model.addAttribute("vo3",cusreplyVO);


			return "/cus/CusReplyWrite";
		}
	 
		//수정페이지이동
		@RequestMapping(value = "/cus/updatepage.do", method = RequestMethod.POST)
		public String updatepage(HttpServletRequest req,Model model)throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {
			
			String cusSeq = req.getParameter("cusSeq");

			CustomerVO customerVO=new CustomerVO();
			customerVO.setCusSeq(cusSeq);
			CustomerVO list = customerSvc.get(customerVO);
			
			
			model.addAttribute("vo", list);

			

			return "/cus/CusUpdate";
		}
		
	
	
}
