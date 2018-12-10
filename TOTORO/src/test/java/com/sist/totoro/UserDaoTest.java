package com.sist.totoro;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

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
//	UserVO selectVO01=null;
	SearchVO searchVO = null;
	
	
	@Before
	public void setUp() {
		//기존 존재
		inVO1 = new UserVO("test1","test1","test1@naver.com","김무혁","국민","0123456789","01012345678","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"2018-12-07",null,null,"true",null);
		inVO2 = new UserVO("test2","test2","test2@naver.com","김무혁","국민","01234567890","01012345678","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"2018-12-07",null,null,"wait",null);	
		inVO3 = new UserVO("test3","test3","test3@naver.com","김무혁","국민","012345678901","01012345678","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"2018-12-07",null,null,"false",null);
		inVO4 = new UserVO("test4","test4","test4@naver.com","김무혁","국민","0123456789012","01012345678","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"2018-12-07",null,null,"false",null);
		inVO5 = new UserVO("admin","admin","angur1@naver.com","김무혁","국민","74890200048805","01072491580","ㅋㅋㅋ","ㅋㅋㅋ","1",0,"2018-12-07",null,null,"true",null);
		
		//새로운 존재
		inVO6 = new UserVO("test5","test5","test5@naver.com","김무혁","국민","50123456789","01012345678","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"2018-12-07",null,null,"wait",null);
		inVO7 = new UserVO("test6","test6","test6@naver.com","김무혁","국민","601234567890","01012345678","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"2018-12-07",null,null,"wait",null);	
		inVO8 = new UserVO("test7","test7","test7@naver.com","김무혁","국민","7012345678901","01012345678","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"2018-12-07",null,null,"wait",null);
		inVO9 = new UserVO("test8","test8","test8@naver.com","김무혁","국민","80123456789012","01012345678","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"2018-12-07",null,null,"wait",null);
		
		//밴check
		banVO01 =new UserVO("test1b","test1","test1ban@naver.com","김무혁","국민","012345678999","0101234567888","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"2018-12-07",null,null,"ban",null);   
		banVO02 =new UserVO("test2b","test2","test22@naver.com","김무혁","국민","01234567890ban","010123456788b","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"2018-12-07",null,null,"ban",null);	
		banVO03 =new UserVO("test3b","test3","test33@naver.com","김무혁","국민","0123456789011","01012345678ban","ㅋㅋㅋ","ㅋㅋㅋ","0",0,"2018-12-07",null,null,"ban",null);
		
		//일반회원 selectOne check
//		selectVO01 = new UserVO("test1","test1","test1@naver.com","김무혁","국민","0123456789","01012345678","ㅋㅋㅋ","ㅋㅋㅋ","",0,"","","","","");
		
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
	
	@Test
	@Ignore
	public void id_find() throws SQLException, ClassNotFoundException {
		assertThat(userDao.id_find(inVO1),is(inVO1.getUserId()));
	}		
	
	@Test
	@Ignore
	public void pw_find() throws SQLException, ClassNotFoundException {
		assertThat(userDao.pw_find(inVO1),is(1));
	}		
		
	
	@Test
	@Ignore
	public void pw_random_update() throws SQLException, ClassNotFoundException {
		String uuid = UUID.randomUUID().toString().replaceAll("-", ""); // '-' 제거 
        uuid = uuid.substring(0, 10); //uuid를 앞에서부터 10자리 잘라줌. 
		inVO1.setUserPw(uuid);
		int flag =userDao.pw_random_update(inVO1);
		LOG.info("flag(1:성공) : "+flag);
	}	
	
	@Test
	@Ignore
	public void do_selectOne() throws SQLException, ClassNotFoundException {
		assertThat(userDao.do_selectOne(inVO1),is(inVO1));
	}			
	
	@Test
	@Ignore
	public void do_update() throws SQLException, ClassNotFoundException {
		inVO1.setUserPw("updatePw");
		inVO1.setUserTel("updateTel");
		inVO1.setUserFindQ("updateQ");
		userDao.do_update(inVO1);
	}		
	

	@Test
	@Ignore
	public void do_update_admin() throws SQLException, ClassNotFoundException {
		inVO1.setUserPw("updatePw");
		inVO1.setUserTel("updateTel");
		inVO1.setUserFindQ("updateQ");
		userDao.do_update_admin(inVO1);
	}		
	
	@Test
	@Ignore
	public void do_delete() throws SQLException, ClassNotFoundException {
		int flag = userDao.do_delete(inVO1);
		LOG.info("flag(1:성공) : "+flag);
	}			

	@Test
	@Ignore
	public void user_ban() throws SQLException, ClassNotFoundException {
		int flag = userDao.user_ban(inVO1);
		LOG.info("flag(1:성공) : "+flag);
	}	
	
	@Test
	public void do_retrieve() throws SQLException, ClassNotFoundException {
		userDao.do_retrieve(searchVO);
		LOG.info(" LIST : "+userDao.do_retrieve(searchVO));
	}	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	