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
	public void do_save() {
		crossVO.setGameSeq(2);
		crossVO.setGameHome("세비야");
		crossVO.setGameAway("발렌시아CF");
		crossVO.setGameHp(1.5);
		crossVO.setGameDp(2.5);
		crossVO.setGameAp(2.2);
		crossVO.setGameDate("2019-01-02 01:01:01");
		LOG.info("crossVO :" + crossVO);
		int flag = crossDao.do_save(crossVO);
		LOG.info("flag : "+flag);
		
	}
	
	
	@Test
	@Ignore
	public void do_update() {
		crossVO.setGameSeq(1);
		crossVO.setGameHs(2);
		crossVO.setGameAs(4);
		LOG.info("crossVO :" + crossVO);
		int flag = crossDao.do_update(crossVO);
		LOG.info("flag : "+flag);
	}

	
}
