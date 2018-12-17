package com.sist.totoro.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sist.totoro.common.DTO;
import com.sist.totoro.common.SearchVO;
import com.sist.totoro.common.WorkDiv;
import com.sist.totoro.domain.UserVO;

@Repository
public class UserDao {

	private final String NAME_SPACE="com.sist.totoro.mappers.user";
	private Logger log = LoggerFactory.getLogger(UserDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	
	public UserDao() {	}

	public UserVO id_login(String userId) throws SQLException {
		String statement = NAME_SPACE+".id_login";
		log.debug("1.statement : \n"+statement);
		log.debug("2.param"+userId);
		return this.sqlSession.selectOne(statement, userId);
		
	}
	
	//TODO String으로 받을까?
	public int id_check(String userId) throws SQLException {
		String statement = NAME_SPACE+".id_check";
//		UserVO inVO = (UserVO) dto;
		log.debug("1.statement : \n"+statement);
		log.debug("2.param"+userId);
//		String testId = inVO.getUserId();
		int flag = this.sqlSession.selectOne(statement, userId);
		
		return flag;
	}
	
	//TODO parameter 2갠데 map으로 받아야하나?
	public int pw_check(UserVO userVO) throws SQLException {
		String statement = NAME_SPACE+".pw_check";
//		UserVO inVO = (UserVO) dto;
		log.debug("1.statement : \n"+statement);
		log.debug("2.param"+userVO);
		
//		String testId = inVO.getUserId();
//		String testPw = inVO.getUserPw();
		
		int flag = this.sqlSession.selectOne(statement, userVO);
		
		return flag;
	}	
	
	//TODO String으로 받을까?
	public int email_check(String userEmail) throws SQLException {
		String statement = NAME_SPACE+".email_check";
//		UserVO inVO = (UserVO) dto;
		log.debug("1.statement : \n"+statement);
		log.debug("2.param"+userEmail);
		
		int flag = this.sqlSession.selectOne(statement, userEmail);
		
		return flag;
	}	
	
	public int account_check(String userAccount) throws SQLException {
		String statement = NAME_SPACE+".account_check";
//		UserVO inVO = (UserVO) dto;
		log.debug("1.statement : \n"+statement);
		log.debug("2.param"+userAccount);
		
		int flag = this.sqlSession.selectOne(statement, userAccount);
		
		return flag;
	}	

	public int tel_check(String userTel) throws SQLException {
		String statement = NAME_SPACE+".tel_check";
//		UserVO inVO = (UserVO) dto;
		log.debug("1.statement : \n"+statement);
		log.debug("2.param"+userTel);
		
		int flag = this.sqlSession.selectOne(statement, userTel);
		
		return flag;
	}	
	
	@Transactional
	public int do_save(UserVO userVO) {
		String statement = NAME_SPACE+".do_save";
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+userVO);
		
		int flag = this.sqlSession.update(statement, userVO);
		log.debug("3.flag: "+flag);

		return flag;
	}		
	
	//TODO parameter 3갠데  무엇으로 받아야하나?
	public int ban_user_check(UserVO userVO) throws SQLException {
		String statement = NAME_SPACE+".ban_user_check";
//		UserVO inVO = (UserVO) dto;
		log.debug("1.statement : \n"+statement);
		log.debug("2.param"+userVO);
		
		int flag = this.sqlSession.selectOne(statement, userVO);
		
		return flag;
	}	
	
	//TODO 파람 2개임 ...
	@Transactional
	public int email_verify(UserVO userVO) {
		String statement = NAME_SPACE+".email_verify";
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+userVO);
		
		int flag = this.sqlSession.update(statement, userVO);
		log.debug("3.flag: "+flag);

		return flag;
	}		
	
	
	//TODO String?
	@Transactional
	public int user_verify(UserVO userVO) {
		String statement = NAME_SPACE+".user_verify";
//		UserVO inVO = (UserVO) dto;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+userVO);
		
		int flag = this.sqlSession.update(statement, userVO);
		log.debug("3.flag: "+flag);

		return flag;
	}		
	
	//TODO 이상해..ㅋㅋ resultType="DTO" 근데 return은 UserVO타입.
	//너무 내꼴리는대로 DTO받았나.. 테스트내일해봐야지..ㅠ
	public String id_find(String userEmail) throws ClassNotFoundException, SQLException,EmptyResultDataAccessException {
		
		String statement = NAME_SPACE+".id_find";
//		UserVO inVO = (UserVO) dto;
		
		//이거 꼭 찾아가야함 못찾으면 쥐쥐...
		log.debug("1. statement : "+statement);
//		log.debug("2.param: "+inVO);
		//call하기
		String userId = this.sqlSession.selectOne(statement, userEmail);
		log.debug("3.outVO: "+userId);
		
		return userId;
	}	
	
	public int pw_find(UserVO userVO) {
		String statement = NAME_SPACE+".pw_find";
//		UserVO inVO = (UserVO) dto;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+userVO);
		
		int flag = this.sqlSession.selectOne(statement, userVO);
		log.debug("3.flag: "+flag);

		return flag;
	}			
	
	//TODO String 랜덤값 받아야 하는거 아니오? service에서
	//dao호출할때 랜덤 String uuid값 아니오?
	@Transactional
	public int pw_random_update(UserVO userVO) {
		String statement = NAME_SPACE+".pw_random_update";
//		UserVO inVO = (UserVO) dto;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+userVO);
		
		int flag = this.sqlSession.update(statement, userVO);
		log.debug("3.flag: "+flag);

		return flag;
	}	
	

	//param : string?
	public UserVO do_selectOne(UserVO userVO) {
		String statement = NAME_SPACE+".do_selectOne";
//		UserVO inVO = (UserVO) dto;
		
		//이거 꼭 찾아가야함 못찾으면 쥐쥐...
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+userVO);
		//call하기
		UserVO outVO = this.sqlSession.selectOne(statement, userVO);
		log.debug("3.outVO: "+outVO);
		
		return outVO;
	}

	@Transactional
	public int do_update(UserVO userVO) {
		String statement = NAME_SPACE+".do_update";
//		UserVO inVO = (UserVO) dto;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+userVO);
		
		int flag = this.sqlSession.delete(statement, userVO);
		
		log.debug("3.flag: "+flag);

		return flag;
	}
	
	@Transactional
	public int do_update_admin(UserVO userVO) {
		String statement = NAME_SPACE+".do_update_admin";
//		UserVO inVO = (UserVO) dto;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+userVO);
		
		int flag = this.sqlSession.update(statement, userVO);
		log.debug("3.flag: "+flag);

		return flag;
	}
	
	public int do_delete(UserVO userVO) {
		String statement = NAME_SPACE+".do_delete";
//		UserVO inVO = (UserVO) dto;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+userVO);
		
		int flag = this.sqlSession.delete(statement, userVO);
		log.debug("3.flag: "+flag);
		
		return flag;
	}

	@Transactional
	public int user_ban(UserVO userVO) {
		String statement = NAME_SPACE+".user_ban";
//		UserVO inVO = (UserVO) dto;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+userVO);
		
		int flag = this.sqlSession.update(statement, userVO);
		log.debug("3.flag: "+flag);
		
		return flag;
	}

	
	public List<UserVO> do_retrieve(SearchVO searchVO) {
		String statement = NAME_SPACE+".do_retrieve";
//		SearchVO inVO = (SearchVO) dto;
		
		log.debug("1. statement : "+statement);	
		log.debug("2.param: "+searchVO);
		
		return this.sqlSession.selectList(statement, searchVO);
	}
	

}
