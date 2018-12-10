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
import com.sist.totoro.dao.UserDao;
import com.sist.totoro.domain.UserVO;
import com.sist.totoro.common.*;




@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration  
//@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
//                                 ,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"		                    
//})
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
	UserVO  inVO6 = null;
	UserVO  inVO7 = null;
	UserVO  inVO8 = null;
	UserVO  inVO9 = null;
	UserVO  banVO01 = null;
	UserVO  banVO02 = null;
	UserVO  banVO03 = null;
	SearchVO searchVO = null;
	
	
	@Before
	public void setUp() {
		//기존 존재
		inVO1 = new UserVO("test1","test1","test1@naver.com","김무혁","국민","0123456789","01012345678","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"18/12/07","","","true","");
		inVO2 = new UserVO("test2","test2","test2@naver.com","김무혁","국민","01234567890","01012345678","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"18/12/07","","","wait","");	
		inVO3 = new UserVO("test3","test3","test3@naver.com","김무혁","국민","012345678901","01012345678","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"18/12/07","","","false","");
		inVO4 = new UserVO("test4","test4","test4@naver.com","김무혁","국민","0123456789012","01012345678","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"18/12/07","","","false","");
		inVO5 = new UserVO("admin","admin","angur1@naver.com","김무혁","국민","74890200048805","01072491580","ㅋㅋㅋ","ㅋㅋㅋ","1",0,"18/12/07","","","true","");
		
		//새로운 존재
		inVO6 = new UserVO("test5","test5","test5@naver.com","김무혁","국민","50123456789","01012345678","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"18/12/07","","","wait","");
		inVO7 = new UserVO("test6","test6","test6@naver.com","김무혁","국민","601234567890","01012345678","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"18/12/07","","","wait","");	
		inVO8 = new UserVO("test7","test7","test7@naver.com","김무혁","국민","7012345678901","01012345678","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"18/12/07","","","wait","");
		inVO9 = new UserVO("test8","test8","test8@naver.com","김무혁","국민","80123456789012","01012345678","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"18/12/07","","","wait","");
		
		//밴check
		banVO01 =new UserVO("test1b","test1","test1ban@naver.com","김무혁","국민","012345678999","0101234567888","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"18/12/07","","","ban","");   
		banVO02 =new UserVO("test2b","test2","test22@naver.com","김무혁","국민","01234567890ban","010123456788b","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"18/12/07","","","ban","");	
		banVO03 =new UserVO("test3b","test3","test33@naver.com","김무혁","국민","0123456789011","01012345678ban","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"18/12/07","","","ban","");
		
		searchVO = new SearchVO(10,1,"","");
		 
		LOG.info("context:"+context);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		LOG.info("mockMvc:"+mockMvc);
		LOG.info("userDao:"+userDao);
	}
	
	
	@Test
	@Ignore
	public void id_check() throws SQLException, ClassNotFoundException {
		assertThat(userDao.id_check(inVO1),is(1));
	}
	
	@Test
	@Ignore
	public void pw_check() throws SQLException, ClassNotFoundException {
		assertThat(userDao.pw_check(inVO1),is(1));
	}	
	
	
	@Test
	@Ignore
	public void email_check() throws SQLException, ClassNotFoundException {
		assertThat(userDao.email_check(inVO1),is(1));
	}		

		
	@Test
	@Ignore
	public void do_save() throws SQLException, ClassNotFoundException {
		assertThat(userDao.do_save(inVO1),is(1));
	}	
	
	
	@Test
	@Ignore
	public void ban_user_check() throws SQLException, ClassNotFoundException {
		assertThat(userDao.ban_user_check(banVO01),is(1));
		assertThat(userDao.ban_user_check(banVO02),is(1));
		assertThat(userDao.ban_user_check(banVO03),is(1));
		assertThat(userDao.ban_user_check(inVO1),is(0));
		
	}		
	
	@Test
	@Ignore
	public void email_verify() throws SQLException, ClassNotFoundException {
		int flag = userDao.email_verify(inVO3);
		LOG.info("flag(1:성공) : "+flag);
		
		int flag02 = userDao.email_verify(inVO2);
		LOG.info("flag02(0:성공) : "+flag02);
	}	
	
	@Test
	@Ignore
	public void user_verify() throws SQLException, ClassNotFoundException {
		int flag = userDao.user_verify(inVO4);
		LOG.info("flag(1:성공) : "+flag);
		
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
