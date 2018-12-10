package com.sist.totoro.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sist.totoro.dao.BetResultDao;
import com.sist.totoro.dao.BetResultDaoImple;
import com.sist.totoro.domain.BetResultVO;

@Service
public class BetResultSvcImple implements BetResultSvc{

	Logger  log = LoggerFactory.getLogger(BetResultSvcImple.class);
	
	@Autowired
	private BetResultDao betResultDao;
	
	public List<BetResultVO> do_retrieve(BetResultVO betResultVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException{
		
		log.info("betResultDao111111111111111111111111"+betResultDao);
		log.info("betResultVO1111111111111111111111111"+betResultVO);
		
		return betResultDao.do_retrieve(betResultVO);
		
	}
}
