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
import com.sist.totoro.domain.AtmVo;

@Repository
public class AtmDao {

	Logger  log = LoggerFactory.getLogger(AtmDao.class);
    
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NAME_SPACE ="com.sist.totoro.mappers.atm";


	public AtmDao() {
		
	}

	public List<AtmVo> do_retrieve(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
		        
		String statement = NAME_SPACE+".do_retrieve";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+searchVO);
		List<AtmVo> list  = this.sqlSession.selectList(statement, searchVO);
		log.debug("*****************************");
		log.debug("3.list: "+list);
		log.debug("*****************************");
		return list;	
	}
	
	public List<AtmVo> adDeAll(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
        
		String statement = NAME_SPACE+".adDeAll";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+searchVO);
		List<AtmVo> list  = this.sqlSession.selectList(statement, searchVO);
		log.debug("*****************************");
		log.debug("3.list: "+list);
		log.debug("*****************************");
		return list;
	}
	
	public List<AtmVo> adWiAll(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
        
		String statement = NAME_SPACE+".adWiAll";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+searchVO);
		List<AtmVo> list  = this.sqlSession.selectList(statement, searchVO);
		log.debug("*****************************");
		log.debug("3.list: "+list);
		log.debug("*****************************");
		return list;
	}
	
	public List<AtmVo> adDeReqAll(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
        
		String statement = NAME_SPACE+".adDeReqAll";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+searchVO);
		List<AtmVo> list  = this.sqlSession.selectList(statement, searchVO);
		log.debug("*****************************");
		log.debug("3.list: "+list);
		log.debug("*****************************");
		return list;
	}
	
	public List<AtmVo> adWiReqAll(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
        
		String statement = NAME_SPACE+".adWiReqAll";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+searchVO);
		List<AtmVo> list  = this.sqlSession.selectList(statement, searchVO);
		log.debug("*****************************");
		log.debug("3.list: "+list);
		log.debug("*****************************");
		return list;	
	}
	
	public List<AtmVo> adDePsAll(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
        
		String statement = NAME_SPACE+".adDePsAll";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+searchVO);
		List<AtmVo> list  = this.sqlSession.selectList(statement, searchVO);
		log.debug("*****************************");
		log.debug("3.list: "+list);
		log.debug("*****************************");
		return list;	
	}
	
	public List<AtmVo> adWiPsAll(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
        
		String statement = NAME_SPACE+".adWiPsAll";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+searchVO);
		List<AtmVo> list  = this.sqlSession.selectList(statement, searchVO);
		log.debug("*****************************");
		log.debug("3.list: "+list);
		log.debug("*****************************");
		return list;	
	}
	
	public List<AtmVo> cusDeReqAll(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
        
		String statement = NAME_SPACE+".cusDeReqAll";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+searchVO);
		List<AtmVo> list  = this.sqlSession.selectList(statement, searchVO);
		log.debug("*****************************");
		log.debug("3.list: "+list);
		log.debug("*****************************");
		return list;	
	}
	
	public List<AtmVo> cusWiReqAll(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
        
		String statement = NAME_SPACE+".cusWiReqAll";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+searchVO);
		List<AtmVo> list  = this.sqlSession.selectList(statement, searchVO);
		log.debug("*****************************");
		log.debug("3.list: "+list);
		log.debug("*****************************");
		return list;	
	}
	
	public List<AtmVo> cusDePsAll(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
        
		String statement = NAME_SPACE+".cusDePsAll";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+searchVO);
		List<AtmVo> list  = this.sqlSession.selectList(statement, searchVO);
		log.debug("*****************************");
		log.debug("3.list: "+list);
		log.debug("*****************************");
		return list;	
	}
	
	public List<AtmVo> cusWiPsAll(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
        
		String statement = NAME_SPACE+".cusWiPsAll";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+searchVO);
		List<AtmVo> list  = this.sqlSession.selectList(statement, searchVO);
		log.debug("*****************************");
		log.debug("3.list: "+list);
		log.debug("*****************************");
		return list;	
	}
	
	public List<AtmVo> cusDeAll(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
        
		String statement = NAME_SPACE+".cusDeAll";
		log.debug("1.statement: "+statement);		
		log.debug("2.param: "+searchVO);
		List<AtmVo> list  = this.sqlSession.selectList(statement, searchVO);
		log.debug("*****************************");
		log.debug("3.list: "+list);
		log.debug("*****************************");
		return list;	
	}
	
	public List<AtmVo> cusWiAll(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
        
		String statement = NAME_SPACE+".cusWiAll";
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
		AtmVo inVO = (AtmVo) atmVo;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+inVO);
		
		int flag = this.sqlSession.update(statement, inVO);
		log.debug("3.flag: "+flag);

		return flag;
	}
	
	public int deAdd(AtmVo atmVo) {
		String statement = NAME_SPACE+".deAdd";
		AtmVo inVO = (AtmVo) atmVo;
		
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
	
	public AtmVo get(AtmVo atmVo) {
		String statement = NAME_SPACE+".do_selectOne";
		AtmVo inVO = (AtmVo) atmVo;
		
		//이거 꼭 찾아가야함 못찾으면 쥐쥐...
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+inVO);
		//call하기
		AtmVo outVo = this.sqlSession.selectOne(statement, inVO);
		log.debug("3.outVO: "+outVo);
		
		return outVo;
	}
	
	public int adReqDeGet(AtmVo atmVo) {
		String statement = NAME_SPACE+".adReqDeGet";
		AtmVo inVO = (AtmVo) atmVo;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+inVO);
		
		int flag = this.sqlSession.update(statement, inVO);
		log.debug("3.flag: "+flag);

		return flag;
	}
	
	public int adReqWiGet(AtmVo atmVo) {
		String statement = NAME_SPACE+".adReqWiGet";
		AtmVo inVO = (AtmVo) atmVo;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+inVO);
		
		int flag = this.sqlSession.update(statement, inVO);
		log.debug("3.flag: "+flag);

		return flag;
	}
	
	public int adDeGet(AtmVo atmVo) {
		String statement = NAME_SPACE+".adDeGet";
		AtmVo inVO = (AtmVo) atmVo;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+inVO);
		
		int flag = this.sqlSession.update(statement, inVO);
		log.debug("3.flag: "+flag);

		return flag;
	}
	
	public int adWiGet(AtmVo atmVo) {
		String statement = NAME_SPACE+".adWiGet";
		AtmVo inVO = (AtmVo) atmVo;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+inVO);
		
		int flag = this.sqlSession.update(statement, inVO);
		log.debug("3.flag: "+flag);

		return flag;
	}
	
	public int delete(AtmVo atmVo) {
		String statement = NAME_SPACE+".delete";
		AtmVo inVO = (AtmVo) atmVo;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+inVO);
		
		int flag = this.sqlSession.update(statement, inVO);
		log.debug("3.flag: "+flag);

		return flag;
	}
	
	
	
	
	

}





