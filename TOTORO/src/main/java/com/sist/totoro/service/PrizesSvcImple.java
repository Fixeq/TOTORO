package com.sist.totoro.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sist.totoro.common.SearchVO;
import com.sist.totoro.dao.PrizesDao;
import com.sist.totoro.domain.AtmVo;
import com.sist.totoro.domain.PrizesVO;

@Service
public class PrizesSvcImple implements PrizesSvc{

	@Autowired
	private PrizesDao prizesDao;

	//당첨여부 페이지 페이징 처리
	@Override
	public List<PrizesVO> do_retrieve(SearchVO searchVO)
			throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
		// TODO Auto-generated method stub
		return prizesDao.do_retrieve(searchVO);
	}
	
		//단건수정
		@Override
		public int updateBetseq(PrizesVO prizesVO) throws SQLException {
			// TODO Auto-generated method stub
			return prizesDao.updateResult(prizesVO);
		}
		
		//당첨 여부 수정
		@Override
		public int updateResult(PrizesVO prizesVO) throws SQLException {
			// TODO Auto-generated method stub
			return prizesDao.updateBetseq(prizesVO);
		}

		@Override
		public int do_GiveMulti(List<PrizesVO> list) throws RuntimeException, SQLException {
			int flag = 0;
			try {
				for(PrizesVO vo :list) {
					flag+=prizesDao.updateBetseq(vo);
					prizesDao.updateResult(vo);
					
				}
				
			}catch(RuntimeException e) {		
				throw e;
			}

			return flag;
		}
	}
