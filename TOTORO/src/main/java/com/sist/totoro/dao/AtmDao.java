package com.sist.totoro.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.sist.totoro.common.DTO;
import com.sist.totoro.common.SearchVO;
import com.sist.totoro.domain.AtmVo;

@Repository
public class AtmDao {

	Logger  log = LoggerFactory.getLogger(AtmDao.class);
    
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NAME_SPACE ="com.sist.totoro.mappers.atm";


	public AtmDao() {
		
	}

	public List<AtmVo> do_retrieve(SearchVO searchVO)
			throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
		        
		String statement = NAME_SPACE+".do_retrieve";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+searchVO);
		List<AtmVo> list  = this.sqlSession.selectList(statement, searchVO);
		log.debug("*****************************");
		log.debug("3.list: "+list);
		log.debug("*****************************");
		return list;	
	}
	
	public int wiAdd(AtmVo atmVo) {
		String statement = NAME_SPACE+".wiAdd";

		log.debug("1. statement : "+statement);
		log.debug("2.param: "+atmVo);
		
		int flag = this.sqlSession.update(statement, atmVo);
		log.debug("3.flag: "+flag);

		return flag;
	}
	
	public int deAdd(AtmVo dto) {
		String statement = NAME_SPACE+".deAdd";
		AtmVo inVO = (AtmVo) dto;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+inVO);
		
		int flag = this.sqlSession.update(statement, inVO);
		log.debug("3.flag: "+flag);

		return flag;
	}
	
	/* (non-Javadoc)
	 * @see com.sist.hr.UserDaoI#getCount(java.lang.String)
	 */
	public int getCount(String userId) throws SQLException {
		int cnt = 0;
		String statement = NAME_SPACE+".getCount";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+userId);
		int flag  = this.sqlSession.selectOne(statement, userId);
		log.debug("3.flag: "+flag);

		return flag;
		
	}

}





