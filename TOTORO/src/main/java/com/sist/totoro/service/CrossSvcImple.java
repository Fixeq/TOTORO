package com.sist.totoro.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	public Double do_ViewPoint(String[] gameSeq,HttpServletRequest req) {
		double finalBetPoint = 1;
		CrossVO newVO = new CrossVO();
		for(int i = 0 ; i < gameSeq.length; i++) {
			int whichTeam = Integer.parseInt(req.getParameter(gameSeq[i]));
			//사용자 승무패 예측값 1,2,3
			switch(whichTeam) {
				case 1 :
					//홈팀 배당률을 출력
					newVO.setGameSeq(Integer.parseInt(gameSeq[i]));
					finalBetPoint *= crossDao.do_ViewHp(newVO).getGameHp();
					break;
				case 2 :
					//무승부 배당률을 출력
					newVO.setGameSeq(Integer.parseInt(gameSeq[i]));
					finalBetPoint *= crossDao.do_ViewDp(newVO).getGameDp();
					break;
				case 3 :
					//원정 배당률을 출력
					newVO.setGameSeq(Integer.parseInt(gameSeq[i]));
					finalBetPoint *= crossDao.do_ViewAp(newVO).getGameAp();
					break;
				default :
					break;
			}
			
			
		}
		return finalBetPoint;
	}

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
