package com.sist.totoro.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.sist.totoro.common.SearchVO;
import com.sist.totoro.domain.PrizesVO;

@Repository
public class PrizesDaoImple implements PrizesDao{

		Logger  log = LoggerFactory.getLogger(PrizesDaoImple.class);
	    
		@Autowired
		private SqlSessionTemplate sqlSession;
		
		private final String NAME_SPACE ="com.sist.totoro.mappers.prizes";


		public PrizesDaoImple() {
			
		}
		
		public PrizesDaoImple(Logger log, SqlSessionTemplate sqlSession) {
			super();
			this.log = log;
			this.sqlSession = sqlSession;
		}

		public List<PrizesVO> do_retrieve(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
	        
			String statement = NAME_SPACE+".do_retrieve";
			log.debug("1.statement: "+statement);		
			log.debug("2.param: "+searchVO);
			List<PrizesVO> list  = this.sqlSession.selectList(statement, searchVO);
			log.debug("*****************************");
			log.debug("3.list: "+list);
			log.debug("*****************************");
			return list;	
		}
		
		public int updateBetseq(PrizesVO prizesVO) {
			String statement = NAME_SPACE+".updateBetseq";
			PrizesVO inVO = (PrizesVO) prizesVO;
			
			log.debug("1. statement : "+statement);
			log.debug("2.param: "+inVO);
			
			int flag = this.sqlSession.update(statement, inVO);
			log.debug("3.flag: "+flag);

			return flag;
		}
		
		public int updateResult(PrizesVO prizesVO) {
			String statement = NAME_SPACE+".updateResult";
			PrizesVO inVO = (PrizesVO) prizesVO;
			
			log.debug("1. statement : "+statement);
			log.debug("2.param: "+inVO);
			
			int flag = this.sqlSession.update(statement, inVO);
			log.debug("3.flag: "+flag);

			return flag;
		}
}
	

