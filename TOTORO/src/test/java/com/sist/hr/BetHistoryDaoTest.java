package com.sist.hr;

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
import org.springframework.web.context.WebApplicationContext;

import com.sist.totoro.dao.BetHistoryDaoimple;

import com.sist.totoro.domain.BetHistoryVO;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BetHistoryDaoTest {

		private final Logger LOG = LoggerFactory.getLogger(this.getClass());
		
		@Autowired
		private WebApplicationContext context;
		
		@Autowired
		BetHistoryDaoimple betHistoryDao = new BetHistoryDaoimple();
		BetHistoryVO betHistoryVO = null;
		@Before
		public void setUp() {
			 betHistoryVO = new BetHistoryVO();
		}
		
		
		@Test
		@Ignore
		public void do_viewByUserId() {
			//베팅내역 페이지 접근시 회원 아이디를 가지고 조회할 폴더번호를 받아옴
			
			List<BetHistoryVO> list = betHistoryDao.do_viewByUserId("nununanana");
			LOG.info("list : "+ list);
		}

		
		
		@Test
		public void do_viewByBetSeq() {
			//각각의 폴더번호를 얻어온 사용자의 폴더별 내역 조회
			betHistoryVO.setBetSeq(1);
			betHistoryVO.setUserId("nununanana");
			
			List<BetHistoryVO> list = betHistoryDao.do_viewByBetSeq(betHistoryVO);
			LOG.info("list : "+ list);
		}

		
		
		
		@Test
		@Ignore
		public void do_insertBetHistory() {
			//베팅내역에 추가 성공
			betHistoryVO.setGameSeq(4256);
			betHistoryVO.setUserId("nununanana");
			betHistoryVO.setBetSeq(1);
			betHistoryVO.setBetChoice(2);
			betHistoryVO.setBetP(10);
			betHistoryVO.setBetCash(1000);
			betHistoryVO.setBetWprice(10000);
			betHistoryVO.setBetReturn(0);
			
			int flag = betHistoryDao.do_betInsert(betHistoryVO);
			LOG.info("flag : "+ flag);
		}

	
}
