package com.sist.hr;

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
import org.springframework.web.context.WebApplicationContext;

import com.sist.totoro.dao.CrossDaoImple;
import com.sist.totoro.domain.CrossVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class CrossDaoTest {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	CrossDaoImple crossDao;
	CrossVO crossVO = null;
	
	@Before
	public void setUp() {
		crossVO= new CrossVO();
	}
	
	@Test
	public void do_selectUser() {
		
		LOG.info("cross 결과값 : "+crossDao.do_selectUser());
		
	}

	@Test
	public void do_selectAdmin() {
		
		LOG.info("cross 결과값 : "+crossDao.do_selectAdmin());
	}
	
	@Test
	public void do_save() {
		LOG.info("cross 초기값 : "+crossDao.do_selectAll());
		
		crossVO.setGameSeq(3);
		crossVO.setGameHome("리버풀");
		crossVO.setGameAway("나폴리");
		crossVO.setGameHp(4.0);
		crossVO.setGameDp(2.8);
		crossVO.setGameAp(1.2);
		crossVO.setGameDate("2019-12-25 11:59:59");
		
		LOG.info("crossVO :" + crossVO);
		int flag = crossDao.do_save(crossVO);
		LOG.info("flag : "+flag);
		
		LOG.info("cross 결과값 : "+crossDao.do_selectAll());
		
	}
	
	
	@Test
	public void do_update() {
		LOG.info("cross 초기값 : "+crossDao.do_selectAll());

		crossVO.setGameSeq(2);
		crossVO.setGameHs(1);
		crossVO.setGameAs(0);
		LOG.info("crossVO :" + crossVO);
		int flag = crossDao.do_update(crossVO);
		
		LOG.info("cross 결과값 : "+crossDao.do_selectAll());
	}

	
}
