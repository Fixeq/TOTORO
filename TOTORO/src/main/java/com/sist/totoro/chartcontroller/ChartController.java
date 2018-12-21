package com.sist.totoro.chartcontroller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.sist.totoro.common.LineVO;

@Controller
public class ChartController {
	private Logger LOG = LoggerFactory.getLogger(ChartController.class);
	private static final String VIEW_LINE="/chart/line_chart";
	  
	
	@RequestMapping(value="/chart/line_view.do")	
	public String doLineChart() throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {	
		return VIEW_LINE;
	}	
	
	@RequestMapping(value="/chart/line.do",method=RequestMethod.GET
			,consumes= {"text/plain", "application/*"}
			,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String doLineChart(HttpServletRequest req ,Model model) throws Exception {	
		 LOG.info("doLineChart: ");
	     LOG.debug("3.2=ctr_lineChart=");
 

	     List<LineVO> list=new ArrayList<LineVO>();
	     /**
	      *    [1,  37.8, 80.8, 41.8],
	           [2,  30.9, 69.5, 32.4],
	           [3,  25.4,   57, 25.7],
	           [4,  11.7, 18.8, 10.5],
	           [5,  11.9, 17.6, 10.4],
	           [6,   8.8, 13.6,  7.7],
	           [7,   7.6, 12.3,  9.6],
	      */
	     LineVO outVO01 = new LineVO(2018, 33, 50, 52);
	     LineVO outVO02 = new LineVO(2019, 61, 58, 20);
	     LineVO outVO03 = new LineVO(2020, 44, 75, 30);
	     LineVO outVO04 = new LineVO(2021, 44, 95, 25);
	     LineVO outVO05 = new LineVO(2022, 34, 23, 48);
	     LineVO outVO06 = new LineVO(2023, 44, 44, 10);
	     LineVO outVO07 = new LineVO(2024, 44, 100,50);
	     LineVO outVO08 = new LineVO(2025, 44, 10, 30);
	     LineVO outVO09 = new LineVO(2026, 44, 30, 19);
	     LineVO outVO10 = new LineVO(2027, 44, 85, 90);
	     LineVO outVO11 = new LineVO(2028, 44, 56, 180);
	     LineVO outVO12 = new LineVO(2029, 44, 91, 100);
	     
	     
	     
	     list.add(outVO01);
	     list.add(outVO02);
	     list.add(outVO03);
	     list.add(outVO04);
	     list.add(outVO05);
	     list.add(outVO06);
	     list.add(outVO07);
	     list.add(outVO08);
	     list.add(outVO09);
	     list.add(outVO10);
	     list.add(outVO11);
	     list.add(outVO12);
	    
	     
	     
	  Gson  gson=new Gson();     
	  JsonArray jArray = new JsonArray();//배열이 필요할때  
	    
	  for (int i = 0; i < list.size(); i++)//배열
	  {
	   JsonArray sArray = new JsonArray();//배열 내에 들어갈 j
	   sArray.add(list.get(i).getDay());
	   sArray.add(list.get(i).getEarning01());
	   sArray.add(list.get(i).getEarning02());
	   sArray.add(list.get(i).getEarning03());
	   
	   
	   jArray.add(sArray);
	  }	
	  
	  LOG.debug("3.2=result11111111111111111111111="+jArray.toString());
	  
	  return jArray.toString();
	  
	}
	
	
}
