package com.sist.totoro;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.sist.totoro.common.SearchVO;
import com.sist.totoro.dao.PrizesDao;
import com.sist.totoro.domain.PrizesVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration  
//@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
//                                 ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"		                    
//})
@ContextConfiguration(locations = 
                          {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class PrizesDaoTest {
	private final Logger LOG= LoggerFactory.getLogger(AtmDaoTest.class);
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Autowired
	private PrizesDao prizesDao;
	PrizesVO  inVO1 = null;
	PrizesVO  inVO2 = null;
	PrizesVO  inVO3 = null;
	
	
	SearchVO searchVO = null;
	
	
	@Before
	public void setUp() {
		inVO1 = new PrizesVO("6000","test6","0","1");
		
		
		searchVO = new SearchVO(10,1,"","");
		
		LOG.info("context:"+context);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		LOG.info("mockMvc:"+mockMvc);
		LOG.info("prizesDao:"+prizesDao);
	}
	
	/*@Test
	@Ignore
	public void wiAdd() throws SQLException, ClassNotFoundException {
		PrizesVO prizesVO = new PrizesVO();
		prizesVO.setUserId("dwtester3");
		prizesVO.setBetwPrice("10000");
		prizesVO.setBetSeq("1");
		int flag = prizesDao.updateBetseq(prizesVO);
		LOG.info("flag(1:성공) : "+flag);
	}*/
	
	/*@Test
	@Ignore
	public void updateResult() throws SQLException, ClassNotFoundException {
		PrizesVO prizesVO = new PrizesVO();
		prizesVO.setBetSeq("1");
		int flag = prizesDao.updateResult(prizesVO);
		LOG.info("flag(1!!!!!!!!!!!!!!!!!!!:성공) : "+flag);
	}*/
	
	@Test
	
	public void do_retrieve() throws SQLException, ClassNotFoundException {
		PrizesVO prizesVO = new PrizesVO();
		prizesVO.setBetReturn("1");
		prizesVO.setBetSeq("1");
		prizesVO.setBetReturn("1");
		prizesDao.do_retrieve(searchVO);
		LOG.info("flag(1!!!!!!!!!!!!!1:성공) : "+prizesDao.do_retrieve(searchVO));
	}
}
