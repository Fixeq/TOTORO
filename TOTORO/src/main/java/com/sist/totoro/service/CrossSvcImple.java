package com.sist.totoro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.totoro.common.SearchVO;
import com.sist.totoro.dao.BetHistoryDaoimple;
import com.sist.totoro.dao.CrossDaoImple;
import com.sist.totoro.domain.CrossVO;

@Service
public class CrossSvcImple {

	@Autowired
	private CrossDaoImple crossDao; 
	
	@Autowired
	private BetHistoryDaoimple betHistoryDao;
	
	public List<CrossVO> do_selectAll(){
		return crossDao.do_selectAll();
	}

	public List<CrossVO> do_selectNoResult(){
		return crossDao.do_selectAdminNoResult();
	}

	public List<CrossVO> do_selectYesResult(){
		return crossDao.do_selectAdminYesResult();
	}

	
	public List<CrossVO> do_selectLimit(SearchVO inVO){
		return crossDao.do_selectUser(inVO);
	}
	
	public int do_insert(CrossVO inVO) {
		return crossDao.do_save(inVO);
	}
	
	public void do_update(CrossVO inVO) {
		crossDao.do_update(inVO);
		//크로스의 번호가 바뀜.
		int gameSeq = inVO.getGameSeq();
		betHistoryDao.do_betUpdate(gameSeq);
		//베팅내역의 경기결과

	}
}
