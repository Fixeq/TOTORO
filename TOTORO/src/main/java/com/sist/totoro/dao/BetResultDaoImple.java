package com.sist.totoro.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.sist.totoro.domain.BetResultVO;




@Repository
public class BetResultDaoImple implements BetResultDao{
	
Logger  log = LoggerFactory.getLogger(BetResultDaoImple.class);
    
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NAME_SPACE ="com.sist.totoro.mappers.betresult";


	public BetResultDaoImple() {
		
	}
	
	public List<BetResultVO> do_retrieve(BetResultVO userVO)
			throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
		        
		String statement = NAME_SPACE+".do_retrieve";
		log.debug("1.statement: "+statement);		
		List<BetResultVO> list  = this.sqlSession.selectList(statement);
		log.debug("*****************************");
		log.debug("3.list: "+list);
		log.debug("*****************************");
		return list;
	}
}
