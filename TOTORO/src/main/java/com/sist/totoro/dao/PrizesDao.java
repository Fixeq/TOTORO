package com.sist.totoro.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.sist.totoro.common.SearchVO;
import com.sist.totoro.domain.PrizesVO;

public interface PrizesDao {
	
	//단건 수정
	int updateBetseq(PrizesVO prizesVO) throws SQLException;
	
	// 당첨금 지급 여부 수정
	int updateResult(PrizesVO prizesVO) throws SQLException;
	
	
	List<PrizesVO> do_retrieve(SearchVO searchVO) 
			throws ClassNotFoundException, SQLException, EmptyResultDataAccessException;
}
