package com.sist.totoro.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;


import com.sist.totoro.domain.BetResultVO;

public interface BetResultSvc {
	List<BetResultVO> do_retrieve(BetResultVO betResultVO) 
			throws ClassNotFoundException, SQLException, EmptyResultDataAccessException;

}