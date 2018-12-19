package com.sist.totoro.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.totoro.dao.BetHistoryDaoimple;
import com.sist.totoro.dao.UserDao;
import com.sist.totoro.domain.BetHistoryResultVO;
import com.sist.totoro.domain.BetHistoryVO;
import com.sist.totoro.domain.UserVO;

@Service
public class BetHistorySvcImple {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BetHistoryDaoimple betHistoryDao;
	@Autowired
	private UserDao userDao;
	
	public int do_updateUserPoint(UserVO inVO) {
		return betHistoryDao.do_updateUserPoint(inVO);
	}
	
	public int do_countSeq() {
		return betHistoryDao.do_countSeq();
	}
	
	public int do_makeUserBet(HttpServletRequest req, String userId, double percent, String money, String[] gameSeq, int betSeq) throws SQLException {
		
		UserVO inVO2 = new UserVO();
		inVO2.setUserId(userId);
		inVO2.setUserPoint(Integer.parseInt(money));
		this.do_updateUserPoint(inVO2);	
		
		int count = 0;
		
		for(int i = 0 ; i < gameSeq.length;i++) {
			//게임 시퀀스 받아온거만큼 돌림
			log.info("gameSeq[i] : " + gameSeq[i]); 
			
			String whichWinTeam = req.getParameter(gameSeq[i]); // 시퀀스 번호로 승패 점수 얻어내기
			log.info(whichWinTeam);
			
			
			BetHistoryVO inVO = new BetHistoryVO();
			inVO.setBetSeq(betSeq);
			inVO.setGameSeq(Integer.parseInt(gameSeq[i]));
			inVO.setBetCash(Integer.parseInt(money));
			inVO.setBetChoice(Integer.parseInt(whichWinTeam));
			inVO.setBetP(percent);
			inVO.setUserId(userId);
			
			count += betHistoryDao.do_betInsert(inVO);
			
		}
		userId = inVO2.getUserId();
		
		HttpSession session = req.getSession();
		session.setAttribute("userPoint", userDao.id_login(userId).getUserPoint());
		log.info(count+"개 생성하였습니다.");

		
		
		
		
		return count;
	}

	public List<BetHistoryResultVO> do_viewByBetSeq(BetHistoryVO inVO){
		return betHistoryDao.do_viewByBetSeq(inVO);
	}
	
	public List<BetHistoryVO> do_viewByUserId(String userId){
		return betHistoryDao.do_viewByUserId(userId);
	}
}
