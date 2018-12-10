package com.sist.totoro;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.sist.totoro.common.SearchVO;
import com.sist.totoro.dao.BetResultDao;
import com.sist.totoro.domain.BetResultVO;




@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration  
//@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
//                                 ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"		                    
//})
@ContextConfiguration( locations = 
                          {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BetResultDaoTest {

	private final Logger LOG= LoggerFactory.getLogger(BetResultDaoTest.class);
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Autowired
	private BetResultDao betResultDao;
	BetResultVO  inVO1 = null;
	BetResultVO  inVO2 = null;
	BetResultVO  inVO3 = null;
	SearchVO searchVO = null;
	
	@Before
	public void setUp() {
		inVO1 = new BetResultVO("19/01/01","네덜란드","독일","2","4","원정승");
		
		inVO1.setPage_num(1);
		inVO1.setPage_size(10);
		
		LOG.info("context:"+context);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		LOG.info("mockMvc:"+mockMvc);
		LOG.info("betResultDao:"+betResultDao);
	}
	
	@Test
	public void select() throws EmptyResultDataAccessException, ClassNotFoundException, SQLException {
		LOG.info("inVO1:"+inVO1);
		LOG.info("page_num:"+inVO1.getPage_num());
		LOG.info("page_num:"+inVO1.getPage_size());
		List<BetResultVO> list = betResultDao.do_retrieve(inVO1);
		LOG.info("list:"+list);
	}
}