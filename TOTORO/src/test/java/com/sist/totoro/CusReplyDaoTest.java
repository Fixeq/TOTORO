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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.sist.totoro.common.SearchVO;
import com.sist.totoro.dao.CusReplyDao;
import com.sist.totoro.domain.CusReplyVO;





@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration  
//@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
//                                 ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"		                    
//})
@ContextConfiguration( locations = 
                          {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class CusReplyDaoTest {

	private final Logger LOG= LoggerFactory.getLogger(CusReplyDaoTest.class);
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Autowired
	private CusReplyDao cusreplyDao;
	CusReplyVO  inVO1 = new CusReplyVO("", "140","sdf","sdf","sdfsdf","");
	CusReplyVO  inVO2 = null;
	CusReplyVO  inVO3 = null;
	SearchVO searchVO = null;
	
	

	@Before
	public void setUp() {
		//searchVO = new SearchVO(10,1,"","");
		inVO1.setPage_num(1); 
		inVO1.setPage_size(10);
		LOG.info("context:"+context);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		LOG.info("mockMvc:"+mockMvc);
		LOG.info("userDao:"+cusreplyDao);
	}
	
	@Test
	@Ignore
	public void getAll() throws SQLException, ClassNotFoundException {
		assertThat(cusreplyDao.getAll().size(),is(99967));
	}
	
	

	
	@Test
	public void add_andget() throws SQLException, ClassNotFoundException {

		
		//--------------------------------------------
		//1. 단건 추가
		//--------------------------------------------
		cusreplyDao.add(inVO1);
		//삭제
		//cusreplyDao.delete(inVO1);
		
		

		


		//다건조회
		inVO1.setCusSeq("28");
		List<CusReplyVO> getVO2 = cusreplyDao.do_retrieve(inVO1);
		
		LOG.info("getVO2:"+getVO2);
	}
	


	private void checkSameUser(CusReplyVO user01, CusReplyVO user02) {
/*		assertThat(user01.getCRSEQ(), is(user02.getCRSEQ()));
		assertThat(user01.getUSERID(), is(user02.getUSERID()));
		
		assertThat(user01.getCRCONTENT(), is(user02.getCRCONTENT()));
		assertThat(user01.getCRREGID(), is(user02.getCRREGID()));
		assertThat(user01.getCRREGDT(), is(user02.getCRREGDT()));*/
		
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
	
	
//	@Test
//	public void setUpTest() {
//		LOG.info("setUpTest:");
//	}
	
	
	
	
}
