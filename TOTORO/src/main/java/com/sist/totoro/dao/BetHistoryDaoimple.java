package com.sist.totoro.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.totoro.domain.BetHistoryVO;


@Controller
public class BetHistoryDaoimple {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAME_SPACE = "com.sist.totoro.mappers.betHistory";
	
	@RequestMapping(value="/bet_history/viewById")
	public List<BetHistoryVO> do_viewByUserId(String userId) {
		//아이디 값을 가지고  betSeq 값을 얻어와야함. 그 값을 가지고 계속 돌려야함.
		
		String statement = NAME_SPACE + ".do_viewByUserId";
		
		log.debug("1.statement : \n"+statement);
		log.debug("2. param : \n"+userId);

		return this.sqlSession.selectList(statement, userId);
	}
	
	@RequestMapping(value="/bet_history/viewByBetSeq")
	public List<BetHistoryVO> do_viewByBetSeq(BetHistoryVO bet_HistoryVO){
		//리스트의 사이즈만큼 반복시키면서 다시 수행해야함.
		String statement = NAME_SPACE + ".do_viewByBetSeq";
		
		log.debug("1.statement : \n"+statement);
		log.debug("2. param : \n"+bet_HistoryVO);

		return this.sqlSession.selectList(statement, bet_HistoryVO);
	}

	@RequestMapping(value="/bet_history/insert")
	public int do_betInsert(BetHistoryVO bet_HistoryVO){
		//리스트의 사이즈만큼 반복시키면서 다시 수행해야함.
		String statement = NAME_SPACE + ".do_betInsert";
		
		log.debug("1.statement : \n"+statement);
		log.debug("2. param : \n"+bet_HistoryVO);

		return this.sqlSession.insert(statement, bet_HistoryVO);
	}
	
	
	
	@RequestMapping(value="/bet_history/delete")
	public String do_deleteFolder(BetHistoryVO bet_HistoryVO){
		//사용자가 각 폴더를 삭제하더라도 관리자의 테이블에선 데이터를 유지하고 있어야함.
		


		return null;
	}

}
