package com.sist.totoro.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.sist.totoro.common.SearchVO;
import com.sist.totoro.domain.AtmVo;
import com.sist.totoro.domain.PrizesVO;

public interface PrizesSvc {

	//단건수정
	int updateBetseq(PrizesVO prizesVO) throws SQLException;
	
	//당첨 여부 수정
	int updateResult(PrizesVO prizesVO) throws SQLException;
	
	//당첨여부 페이지 페이징 처리
	List<PrizesVO> do_retrieve(SearchVO searchVO) 
			throws ClassNotFoundException, SQLException, EmptyResultDataAccessException;

	int do_GiveMulti(List<PrizesVO> list) throws RuntimeException, SQLException;

}
