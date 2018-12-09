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
import com.sist.totoro.dao.UserDao;
import com.sist.totoro.domain.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration  
@ContextConfiguration( locations = 
                          {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class UserDaoTest {

	private final Logger LOG= LoggerFactory.getLogger(UserDaoTest.class);
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Autowired
	private UserDao userDao;
	UserVO  inVO1 = null;
	UserVO  inVO2 = null;
	UserVO  inVO3 = null;
	UserVO  inVO4 = null;
	UserVO  inVO5 = null;
	UserVO  inVO6= null;
	SearchVO searchVO = null;
	
	
	@Before
	public void setUp() {
		inVO1 = new UserVO("test1","test1","test1@naver.com","김무혁","국민","0123456789","01012345678","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"18/12/07","","","true","");
		inVO2 = new UserVO("test2","test2","test2@naver.com","김무혁","국민","01234567890","01012345678","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"18/12/07","","","false","");	
		inVO3 = new UserVO("test3","test3","test3@naver.com","김무혁","국민","012345678901","01012345678","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"18/12/07","","","false","");
		inVO4 = new UserVO("test4","test4","test4@naver.com","김무혁","국민","0123456789012","01012345678","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"18/12/07","","","false","");
		inVO5 = new UserVO("admin","admin","angur1@naver.com","김무혁","국민","74890200048805","01072491580","ㅋㅋㅋ","ㅋㅋㅋ","1",0,"18/12/07","","","true","");
		
	
		searchVO = new SearchVO(10,1,"","");
		  
		LOG.info("context:"+context);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		LOG.info("mockMvc:"+mockMvc);
		LOG.info("userDao:"+userDao);
	}
	
	
	@Test
	public void getCount() throws SQLException, ClassNotFoundException {
//		assertThat(userDao.getCount("j1"),is(11077));
	}
	
	@Test(timeout=2000)
	@Ignore
	public void addAndGet() throws SQLException, ClassNotFoundException {

		//--------------------------------------------
		//0.모두삭제 : 건건이로 수정
		//--------------------------------------------
//		userDao.delete(inVO1);
//		userDao.delete(inVO2);
//		userDao.delete(inVO3);
		
		
		//--------------------------------------------
		//1. 단건 추가
		//--------------------------------------------
//		userDao.add(inVO1);
		
		//--------------------------------------------
		//1.1 Count
		//--------------------------------------------
//		assertThat(userDao.getCount("115"),is(1));
		
		//--------------------------------------------
		//2. 단건 조회
		//--------------------------------------------
//		UserVO getVO = userDao.get(inVO1);
		

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
