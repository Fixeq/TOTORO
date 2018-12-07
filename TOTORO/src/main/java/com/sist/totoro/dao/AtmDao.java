package com.sist.totoro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sist.totoro.common.DuplicateUserIdException;
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

	

	
	
	/* (non-Javadoc)
	 * @see com.sist.hr.UserDaoI#getAll()
	 */
	public List<AtmVo> getAll() throws ClassNotFoundException, SQLException,EmptyResultDataAccessException {
		
		String statement = NAME_SPACE+".getAll";
		log.debug("1.statement: "+statement);
		
		
		StringBuilder sb=new StringBuilder();		
		sb.append(" SELECT hr.*          \n"); 
		sb.append("   FROM hr_users hr   \n");
		sb.append("  ORDER by u_id       \n");

		return this.sqlSession.selectList(statement);				
	}
	

	/**
	 * 관리자 입금 요청 전체 조회
	 * mybatis:ok
	 */
	public int adReqDeAll(AtmVo atmVo) throws SQLException {
		String statement = NAME_SPACE+".adReqDeAll";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+atmVo);
		int flag  = this.sqlSession.update(statement, atmVo);
		log.debug("3.flag: "+flag);
		
		return flag;
	}
	
	/**
	 * 관리자 출금 요청 전체 조회 
	 * mybatis:ok
	 */
	public int adReqWiAll(AtmVo atmVo) throws SQLException {
		String statement = NAME_SPACE+".adReqWiAll";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+atmVo);
		int flag  = this.sqlSession.update(statement, atmVo);
		log.debug("3.flag: "+flag);
		
		return flag;
	}
	
	/**
	 * 관리자 입출금 요청 전체 조회
	 * mybatis:ok
	 */
	public int adReqDeWiAll(AtmVo atmVo) throws SQLException {
		String statement = NAME_SPACE+".adReqDeWiAll";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+atmVo);
		int flag  = this.sqlSession.update(statement, atmVo);
		log.debug("3.flag: "+flag);
		
		return flag;
	}
	
	/**
	 * 관리자 입금 확인 전체 조회
	 * mybatis:ok
	 */
	public int adPsDeAll(AtmVo atmVo) throws SQLException {
		String statement = NAME_SPACE+".adPsDeAll";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+atmVo);
		int flag  = this.sqlSession.update(statement, atmVo);
		log.debug("3.flag: "+flag);
		
		return flag;
	}
	
	/**
	 * 관리자 출금 확인 전체 조회
	 * mybatis:ok
	 */
	public int adPsWiAll(AtmVo atmVo) throws SQLException {
		String statement = NAME_SPACE+".adPsWiAll";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+atmVo);
		int flag  = this.sqlSession.update(statement, atmVo);
		log.debug("3.flag: "+flag);
		
		return flag;
	}
	
	/**
	 * 관리자 입금 요청 확인 처리
	 * mybatis:ok
	 */
	public int adReqDeGet(AtmVo atmVo) throws SQLException {
		String statement = NAME_SPACE+".adReqDeGet";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+atmVo);
		int flag  = this.sqlSession.update(statement, atmVo);
		log.debug("3.flag: "+flag);
		
		return flag;
	}
	
	/**
	 * 관리자 출금 요청 확인 처리
	 * mybatis:ok
	 */
	public int adReqWiGet(AtmVo atmVo) throws SQLException {
		String statement = NAME_SPACE+".adReqWiGet";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+atmVo);
		int flag  = this.sqlSession.update(statement, atmVo);
		log.debug("3.flag: "+flag);
		
		return flag;
	}
	
	/**
	 * 관리자 입금 처리
	 * mybatis:ok
	 */
	public int adDeGet(AtmVo atmVo) throws SQLException {
		String statement = NAME_SPACE+".adDeGet";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+atmVo);
		int flag  = this.sqlSession.update(statement, atmVo);
		log.debug("3.flag: "+flag);
		
		return flag;
	}
	
	/**
	 * 관리자 출금 처리
	 * mybatis:ok
	 */
	public int adWiGet(AtmVo atmVo) throws SQLException {
		String statement = NAME_SPACE+".adWiGet";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+atmVo);
		int flag  = this.sqlSession.update(statement, atmVo);
		log.debug("3.flag: "+flag);
		
		return flag;
	}
	
	
	/**
	 * 입출금 요청
	 * 
	 */
	
	public int add(AtmVo atmVo) throws DuplicateUserIdException {
		String statement = NAME_SPACE+".add";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+atmVo);
		int flag  = this.sqlSession.update(statement, atmVo);
		log.debug("3.flag: "+flag);
		
		return flag;
	}
	
	
    /**
      * 단건 조회
     * mybatis:ok
     */
	public AtmVo get(AtmVo atmVo) throws ClassNotFoundException, SQLException,EmptyResultDataAccessException {
		
		String statement = NAME_SPACE+".get";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+atmVo);
		AtmVo outVO = this.sqlSession.selectOne(statement, atmVo);
		log.debug("3.outVO: "+outVO);

		return outVO;
	}

	/**
	 * 단건 삭제!
	 * mybatis:ok
	 */
	public int delete(AtmVo atmVo) throws SQLException {
		String statement = NAME_SPACE+".delete";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+atmVo);
		int flag  = this.sqlSession.delete(statement, atmVo);
		log.debug("3.flag: "+flag);
		return flag;
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

}





