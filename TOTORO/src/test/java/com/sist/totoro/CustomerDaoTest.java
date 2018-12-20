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
import com.sist.totoro.dao.CustomerDao;
import com.sist.totoro.domain.CustomerVO;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration  
//@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
//                                 ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"		                    
//})
@ContextConfiguration( locations = 
                          {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class CustomerDaoTest {

	private final Logger LOG= LoggerFactory.getLogger(CustomerDaoTest.class);
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Autowired
	private CustomerDao customerDao;
	CustomerVO  inVO1 = null;
	CustomerVO  inVO2 = null;
	CustomerVO  inVO3 = null;
	SearchVO searchVO = null;
	

	@Before
	public void setUp() {
		inVO1 = new CustomerVO("", "tester1", "기타", "태건아", "fs", "", "", "", "");
		inVO2 = new CustomerVO("65", "sdfsdf", "sdfsdf", "sdfsd", "sdfs", "", "", "", "n");
		inVO3 = new CustomerVO("104", "", "", "", "", "", "", "", "");
	
		searchVO = new SearchVO(10,1,"","");
		  
		LOG.info("context:"+context);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		LOG.info("mockMvc:"+mockMvc);
		LOG.info("userDao:"+customerDao);
	}
	
	@Test
	@Ignore
	public void getAll() throws SQLException, ClassNotFoundException {
		assertThat(customerDao.getAll().size(),is(99967));
	}
	
	
	@Test
	@Ignore
	public void getCount() throws SQLException, ClassNotFoundException {
		assertThat(customerDao.getCount("j1"),is(11071));
	}
	
	@Test
	public void add_and_get() throws SQLException, ClassNotFoundException {

		
		//--------------------------------------------
		//1. 단건 추가
		//--------------------------------------------
		//customerDao.add(inVO1);
		//삭제
		//customerDao.delete(inVO1);
		
		//수정

		inVO1.setCusSeq("140");
		inVO1.setUserId("tester1");
		inVO1.setCusContent("가나다");
		inVO1.setCusModid("sd라f");
		inVO1.setCusCat("asdfasdf");
	
		inVO1.setCusTitle("asfsadf");
		inVO1.setCusReply("N");
////
//////	
		customerDao.update(inVO1);
		
//		//답변유무 수정
//		inVO3.setCusSeq("140");
//		inVO3.setUserId("tester1");
//		
		//customerDao.repupdate(inVO3);
		//단건조회
//		CustomerVO getVO = customerDao.get(inVO1);
//		LOG.info("getVO:"+getVO);


		//다건조회
//		List<CustomerVO> getVO2 = customerDao.do_retrieve(searchVO);
//		LOG.info("getVO2:"+getVO2);
	
	}
	
	
	

	private void checkSameUser(CustomerVO user01, CustomerVO user02) {
		assertThat(user01.getCusSeq(), is(user02.getCusSeq()));
		assertThat(user01.getUserId(), is(user02.getUserId()));
		assertThat(user01.getCusCat(), is(user02.getCusCat()));
		
		assertThat(user01.getCusTitle(), is(user02.getCusTitle()));
		assertThat(user01.getCusContent(), is(user02.getCusContent()));
		assertThat(user01.getCusReply(), is(user02.getCusReply()));
		
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
