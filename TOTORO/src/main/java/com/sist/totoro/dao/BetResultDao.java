package com.sist.totoro.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.sist.totoro.domain.BetResultVO;




public interface BetResultDao {
	
	List<BetResultVO> do_retrieve(BetResultVO betResultVO) 
			throws ClassNotFoundException, SQLException, EmptyResultDataAccessException;

}