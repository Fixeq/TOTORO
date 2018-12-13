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
	AtmVo  atmDe = new AtmVo();
	AtmVo  atmWi = new AtmVo();
	
	
	SearchVO searchVO = null;
	
	
	@Before
	public void setUp() {
		inVO1 = new AtmVo("tester1","tester1","10000",null,"0",null,null);
		inVO2 = new AtmVo("1","tester","1000",null,"0","2018-12-01 14:52:23",null);
		
		atmDe.setDwSeq("66");
		atmDe.setUserId("dwtester3");
		atmDe.setDePoint("1000");
		
		atmWi.setDwSeq("67");
		atmWi.setUserId("dwtester3");
		atmWi.setWiPoint("2000");
		
		searchVO = new SearchVO(10,1,"","");
		
		LOG.info("context:"+context);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		LOG.info("mockMvc:"+mockMvc);
		LOG.info("atmDao:"+atmDao);
	}

//	@Test
//	public void get() throws SQLException, ClassNotFoundException {
//		AtmVo atmVo = new AtmVo();
//		atmVo.setUserId("tester");
//		atmVo.setDwSeq("1");
//		AtmVo  outVO1 = null;
//		assertThat(atmDao.wiAdd(atmVo),is(1));
//	}
//	
//	@Test
//	public void deAdd() throws SQLException, ClassNotFoundException {
//		AtmVo atmVo = new AtmVo();
//		atmVo.setUserId("dwtester3");
//		atmVo.setDePoint("1000");
//		int flag = atmDao.deAdd(atmVo);
//		LOG.info("flag(1:성공) : "+flag);
//	}
//	
//	@Test
//	public void wiAdd() throws SQLException, ClassNotFoundException {
//		AtmVo atmVo = new AtmVo();
//		atmVo.setUserId("dwtester3");
//		atmVo.setWiPoint("2000");
//		int flag = atmDao.wiAdd(atmVo);
//		LOG.info("flag(1:성공) : "+flag);
//	}
	
//	@Test
//	public void adReqDeGet() throws SQLException, ClassNotFoundException {
//
//		int flag = atmDao.adReqDeGet(atmDe);
//		LOG.info("flag(1:성공) : "+flag);
//	}
//	
//	@Test
//	public void adReqWiGet() throws SQLException, ClassNotFoundException {
//	
//		int flag = atmDao.adReqWiGet(atmWi);
//		LOG.info("flag(1:성공) : "+flag);
//	}
	
	
//	@Test
//	public void adDeGet() throws SQLException, ClassNotFoundException {
//		
//		int flag = atmDao.adDeGet(atmDe);
//		LOG.info("flag(1:성공) : "+flag);
//	}

//	@Test
//	public void adWiGet() throws SQLException, ClassNotFoundException {
//		
//		int flag = atmDao.adWiGet(atmWi);
//		LOG.info("flag(1:성공) : "+flag);
//	}

//	@Test
//	public void delete() throws SQLException, ClassNotFoundException {
//		
//		int flag = atmDao.delete(atmDe);
//		LOG.info("flag(1:성공) : "+flag);
//	}
	
	
//	
//	@Test
//	public void dePs() throws SQLException, ClassNotFoundException {
//
//		//--------------------------------------------
//		//0.하나씩 처리
//		//--------------------------------------------
//		atmDao.adReqDeGet(atmDe);
//		atmDao.adDeGet(atmDe);
//		
//		
//	}
//	
//	@Test
//	public void wiPs() throws SQLException, ClassNotFoundException {
//
//		//--------------------------------------------
//		//0.하나씩 처리
//		//--------------------------------------------
//		atmDao.adReqWiGet(atmWi);
//		atmDao.adWiGet(atmWi);
//		
//	}
	
//	
//	
//	@Test
//	public void do_retrieve() throws SQLException, ClassNotFoundException {
//		atmDao.do_retrieve(searchVO);
//		LOG.info(" LIST : "+atmDao.do_retrieve(searchVO));
//	}
//
//	
//	@Test
//	public void adDeReqAll() throws SQLException, ClassNotFoundException {
//		atmDao.adDeReqAll(searchVO);
//		LOG.info(" LIST : "+atmDao.adDeReqAll(searchVO));
//	}
//	
//	@Test
//	public void adWiReqAll() throws SQLException, ClassNotFoundException {
//		atmDao.adWiReqAll(searchVO);
//		LOG.info(" LIST : "+atmDao.adDeReqAll(searchVO));
//	}
//	
//	@Test
//	public void adDePsAll() throws SQLException, ClassNotFoundException {
//		atmDao.adDePsAll(searchVO);
//		LOG.info(" LIST : "+atmDao.adDePsAll(searchVO));
//	}
//	
//	@Test
//	public void adWiPsAll() throws SQLException, ClassNotFoundException {
//		atmDao.adWiReqAll(searchVO);
//		LOG.info(" LIST : "+atmDao.adWiPsAll(searchVO));
//	}
//	
//	@Test
//	public void cusDeReqAll() throws SQLException, ClassNotFoundException {
//		searchVO.setSearch_word("dwtester3");
//		atmDao.adWiReqAll(searchVO);
//		LOG.info(" LIST : "+atmDao.cusDeReqAll(searchVO));
//	}
//	
//	@Test
//	public void cusWiReqAll() throws SQLException, ClassNotFoundException {
//		searchVO.setSearch_word("dwtester3");
//		atmDao.adWiReqAll(searchVO);
//		LOG.info(" LIST : "+atmDao.cusWiReqAll(searchVO));
//	}
//	
//	@Test
//	public void cusDePsAll() throws SQLException, ClassNotFoundException {
//		searchVO.setSearch_word("dwtester3");
//		atmDao.cusDePsAll(searchVO);
//		LOG.info(" LIST : "+atmDao.cusDePsAll(searchVO));
//	}
//	
//	@Test
//	public void cusWiPsAll() throws SQLException, ClassNotFoundException {
//		searchVO.setSearch_word("dwtester3");
//		atmDao.cusWiPsAll(searchVO);
//		LOG.info(" LIST : "+atmDao.cusWiPsAll(searchVO));
//	}
//	
//	@Test
//	public void cusDeAll() throws SQLException, ClassNotFoundException {
//		searchVO.setSearch_word("dwtester3");
//		atmDao.cusDeAll(searchVO);
//		LOG.info(" LIST : "+atmDao.cusDeAll(searchVO));
//	}
//	
//	@Test
//	public void cusWiAll() throws SQLException, ClassNotFoundException {
//		searchVO.setSearch_word("dwtester3");
//		atmDao.cusWiAll(searchVO);
//		LOG.info(" LIST : "+atmDao.cusWiAll(searchVO));
//	}
	
	@Test
	public void adDeAll() throws SQLException, ClassNotFoundException {
		atmDao.adDeAll(searchVO);
		LOG.info(" LIST : "+atmDao.adDeAll(searchVO));
	}
	
	@Test
	public void adWiAll() throws SQLException, ClassNotFoundException {
		atmDao.adWiAll(searchVO);
		LOG.info(" LIST : "+atmDao.adWiAll(searchVO));
	}
//	@Test
//	public void deleteReset() throws SQLException, ClassNotFoundException {
//
//		//--------------------------------------------
//		//0.모두삭제 : 건건이로 수정
//		//--------------------------------------------
//		atmDao.delete(atmDe);
//		atmDao.delete(atmWi);
//		
//	}
	
	
	
	
}
