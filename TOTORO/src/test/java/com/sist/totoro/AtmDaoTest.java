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
@ContextConfiguration( locations = 
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
		inVO1 = new AtmVo("","tester3","10000","","0","","");
		inVO2 = new AtmVo("","tester3","","20000","0","","");	
		inVO3 = new AtmVo("","tester3","300000","","0","","");	
	
		searchVO = new SearchVO(10,1,"","");
		  
		LOG.info("context:"+context);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		LOG.info("mockMvc:"+mockMvc);
		LOG.info("atmDao:"+atmDao);
	}
	
	
	@Test
	@Ignore
	public void getCount() throws SQLException, ClassNotFoundException {
		assertThat(atmDao.getCount("j1"),is(11077));
	}
	
	@Test(timeout=2000)
	@Ignore
	public void addAndGet() throws SQLException, ClassNotFoundException {

		//--------------------------------------------
		//0.모두삭제 : 건건이로 수정
		//--------------------------------------------
		atmDao.delete(inVO1);
		atmDao.delete(inVO2);
		atmDao.delete(inVO3);
		
		
		//--------------------------------------------
		//1. 단건 추가
		//--------------------------------------------
		atmDao.add(inVO1);
		
		//--------------------------------------------
		//1.1 Count
		//--------------------------------------------
		assertThat(atmDao.getCount("115"),is(1));
		
		//--------------------------------------------
		//2. 단건 조회
		//--------------------------------------------
		AtmVo getVO = atmDao.get(inVO1);
		

	}
	
	
	@Test
	@Ignore
	public void get() throws Exception {
		LOG.info("1==========================");
		LOG.info("=get=");
		LOG.info("1==========================");
		
		MockHttpServletRequestBuilder createMessage =
				MockMvcRequestBuilders.get("/user/do_search_one.do")
				.param("u_id", "j01_115")
				;
		
		mockMvc.perform(createMessage)
		.andDo(print())
		.andExpect(status().is2xxSuccessful());
		
	}
	
	
	@Test
	public void setUpTest() {
		LOG.info("setUpTest:");
	}
	
	
	
	
}
