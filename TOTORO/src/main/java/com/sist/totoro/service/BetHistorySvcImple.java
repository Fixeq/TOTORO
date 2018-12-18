package com.sist.totoro.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.totoro.dao.BetHistoryDaoimple;
import com.sist.totoro.domain.BetHistoryResultVO;
import com.sist.totoro.domain.BetHistoryVO;

@Service
public class BetHistorySvcImple {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BetHistoryDaoimple betHistoryDao;
	
	public int do_countSeq() {
		return betHistoryDao.do_countSeq();
	}
	
	public int do_makeUserBet(BetHistoryVO inVO) {
		return betHistoryDao.do_betInsert(inVO);
	}

	public List<BetHistoryResultVO> do_viewByBetSeq(BetHistoryVO inVO){
		return betHistoryDao.do_viewByBetSeq(inVO);
	}
	
	public List<BetHistoryVO> do_viewByUserId(String userId){
		return betHistoryDao.do_viewByUserId(userId);
	}
}
