package com.sist.totoro;



import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.SQLException;

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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.sist.totoro.common.SearchVO;
import com.sist.totoro.dao.AtmDao;
import com.sist.totoro.domain.AtmVo;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration  
//@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
//                                 ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"		                    
//})
@ContextConfiguration(locations = 
                          {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class AtmDaoTest {

	private final Logger LOG= LoggerFactory.getLogger(AtmDaoTest.class);
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Autowired
	private AtmDao atmDao;
	AtmVo  inVO1 = null;
	AtmVo  inVO2 = null;
	AtmVo  inVO3 = null;
	SearchVO searchVO = null;
	
	
	@Before
	public void setUp() {
		inVO1 = new AtmVo("11","tester3","10000","0","0","2018-12-12","2018-12-12");
		inVO2 = new AtmVo("12","tester3","0","20000","0","2018-12-12","2018-12-12");	
		inVO3 = new AtmVo("13","tester3","30000","0","0","2018-12-12","2018-12-12");	
	
		searchVO = new SearchVO(10,1,"","");
		
		LOG.info("context:"+context);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		LOG.info("mockMvc:"+mockMvc);
		LOG.info("atmDao:"+atmDao);
	}
	
	@Test
	@Ignore
	public void deAdd() throws SQLException, ClassNotFoundException {
		int flag = atmDao.deAdd(inVO1);
		LOG.info("flag111111111111111111111111111111111111111(1:성공) : "+flag);
	}
	
	@Test
	@Ignore
	public void wiAdd() throws SQLException, ClassNotFoundException {
		int flag = atmDao.wiAdd(inVO1);
		LOG.info("flag(1:성공) : "+flag);
	}	
	
	@Test
	@Ignore
	public void do_retrieve() throws SQLException, ClassNotFoundException {
		atmDao.do_retrieve(searchVO);
		LOG.info(" LIST : "+atmDao.do_retrieve(searchVO));
	}
	
	@Test
	public void setUpTest() {
		LOG.info("setUpTest:");
	}
	
	
}
