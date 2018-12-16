package com.sist.totoro.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.sist.totoro.common.DuplicateUserIdException;
import com.sist.totoro.common.SearchVO;
import com.sist.totoro.domain.CusReplyVO;

@Repository
public class CusReplyDaoImple implements CusReplyDao {

	Logger  log = LoggerFactory.getLogger(CusReplyDaoImple.class);
    
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NAME_SPACE ="com.sist.totoro.mappers.cusreply";


	public CusReplyDaoImple() {
		
	}

	/* (non-Javadoc)
	 * @see com.sist.hr.UserDaoI#getCount(java.lang.String)
	 */
	public int getCount(String cusseq) throws SQLException {
		int cnt = 0;
		String statement = NAME_SPACE+".getCount";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+cusseq);
		int flag  = this.sqlSession.selectOne(statement, cusseq);
		log.debug("3.flag: "+flag);

		return flag;
		
	}

	

	public int add(CusReplyVO cusreplyVO) throws DuplicateUserIdException {
		String statement = NAME_SPACE+".add";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+cusreplyVO);
		int flag  = this.sqlSession.update(statement, cusreplyVO);
		log.debug("3.flag: "+flag);
		
		return flag;
	}
	
	/* (non-Javadoc)
	 * @see com.sist.hr.UserDaoI#getAll()
	 */
	public List<CusReplyVO> getAll() throws ClassNotFoundException, SQLException,EmptyResultDataAccessException {
		
		String statement = NAME_SPACE+".getAll";
		log.debug("1.statement: "+statement);
		
		
		StringBuilder sb=new StringBuilder();		
		sb.append(" SELECT cs.*          \n"); 
		sb.append("   FROM cus_service cs   \n");
		sb.append("  ORDER by cusseq       \n");

		return this.sqlSession.selectList(statement);				
	}
	
    /**
     * mybatis:ok
     */
	public CusReplyVO get(CusReplyVO cusreplyVO) throws ClassNotFoundException, SQLException,EmptyResultDataAccessException {
		
		String statement = NAME_SPACE+".get";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+cusreplyVO);
		CusReplyVO outVO = this.sqlSession.selectOne(statement, cusreplyVO);
		log.debug("3.outVO: "+outVO);

		return outVO;
		
	}

	/**
	 * mybatis:ok
	 */
	public int update(CusReplyVO cusreplyVO) throws SQLException {
		String statement = NAME_SPACE+".update";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+cusreplyVO);
		int flag  = this.sqlSession.update(statement, cusreplyVO);
		log.debug("3.flag: "+flag);
		
		return flag;
	}

	/**
	 * 단건 삭제!
	 * mybatis:ok
	 */
	public int delete(CusReplyVO cusreplyVO) throws SQLException {
		String statement = NAME_SPACE+".delete";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+cusreplyVO);
		int flag  = this.sqlSession.delete(statement, cusreplyVO);
		log.debug("3.flag: "+flag);
		return flag;
	}


	public List<CusReplyVO> do_retrieve(CusReplyVO cusreplyvo)
			throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
		        
		String statement = NAME_SPACE+".do_retrieve";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+cusreplyvo);
		List<CusReplyVO> list  = this.sqlSession.selectList(statement, cusreplyvo);
		log.debug("*****************************");
		log.debug("3.list: "+list);
		log.debug("*****************************");
		return list;	
	}


	

}





