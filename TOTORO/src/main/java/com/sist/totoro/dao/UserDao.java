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
import com.sist.totoro.common.WorkDiv;
import com.sist.totoro.domain.UserVO;

@Repository
public class UserDao implements WorkDiv {

	private final String NAME_SPACE="com.sist.totoro.mappers.user";
	private Logger log = LoggerFactory.getLogger(UserDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	
	public UserDao() {	}

	//TODO String으로 받을까?
	public int id_check(DTO dto) throws SQLException {
		String statement = NAME_SPACE+".id_check";
		UserVO inVO = (UserVO) dto;
		log.debug("1.statement : \n"+statement);
		log.debug("2.param"+inVO);
//		String testId = inVO.getUserId();
		int flag = this.sqlSession.selectOne(statement, inVO);
		
		return flag;
	}
	
	//TODO parameter 2갠데 map으로 받아야하나?
	public int pw_check(DTO dto) throws SQLException {
		String statement = NAME_SPACE+".pw_check";
		UserVO inVO = (UserVO) dto;
		log.debug("1.statement : \n"+statement);
		log.debug("2.param"+inVO);
		
//		String testId = inVO.getUserId();
//		String testPw = inVO.getUserPw();
		
		int flag = this.sqlSession.selectOne(statement, inVO);
		
		return flag;
	}	
	
	//TODO String으로 받을까?
	public int email_check(DTO dto) throws SQLException {
		String statement = NAME_SPACE+".email_check";
		UserVO inVO = (UserVO) dto;
		log.debug("1.statement : \n"+statement);
		log.debug("2.param"+inVO);
		
		int flag = this.sqlSession.selectOne(statement, inVO);
		
		return flag;
	}	
	
	@Override
	public int do_save(DTO dto) {
		String statement = NAME_SPACE+".do_save";
		UserVO inVO = (UserVO) dto;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+inVO);
		
		int flag = this.sqlSession.update(statement, inVO);
		log.debug("3.flag: "+flag);

		return flag;
	}		
	
	//TODO parameter 3갠데  무엇으로 받아야하나?
	public int ban_user_check(DTO dto) throws SQLException {
		String statement = NAME_SPACE+".ban_user_check";
		UserVO inVO = (UserVO) dto;
		log.debug("1.statement : \n"+statement);
		log.debug("2.param"+inVO);
		
		int flag = this.sqlSession.selectOne(statement, inVO);
		
		return flag;
	}	
	
	//TODO 파람 2개임 ...
	public int email_verify(DTO dto) {
		String statement = NAME_SPACE+".email_verify";
		UserVO inVO = (UserVO) dto;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+inVO);
		
		int flag = this.sqlSession.update(statement, inVO);
		log.debug("3.flag: "+flag);

		return flag;
	}		
	
	
	//TODO String?
	public int user_verify(DTO dto) {
		String statement = NAME_SPACE+".user_verify";
		UserVO inVO = (UserVO) dto;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+inVO);
		
		int flag = this.sqlSession.update(statement, inVO);
		log.debug("3.flag: "+flag);

		return flag;
	}		
	
	//TODO 이상해..ㅋㅋ resultType="DTO" 근데 return은 UserVO타입.
	//너무 내꼴리는대로 DTO받았나.. 테스트내일해봐야지..ㅠ
	public DTO id_find(DTO dto) throws ClassNotFoundException, SQLException,EmptyResultDataAccessException {
		
		String statement = NAME_SPACE+".id_find";
		UserVO inVO = (UserVO) dto;
		
		//이거 꼭 찾아가야함 못찾으면 쥐쥐...
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+inVO);
		//call하기
		UserVO outVO = this.sqlSession.selectOne(statement, inVO);
		log.debug("3.outVO: "+outVO);
		
		return outVO;
	}	
	
	public int pw_find(DTO dto) {
		String statement = NAME_SPACE+".pw_find";
		UserVO inVO = (UserVO) dto;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+inVO);
		
		int flag = this.sqlSession.selectOne(statement, inVO);
		log.debug("3.flag: "+flag);

		return flag;
	}			
	
	//TODO String 랜덤값 받아야 하는거 아니오? service에서
	//dao호출할때 랜덤 String uuid값 아니오?
	public int pw_random_update(DTO dto) {
		String statement = NAME_SPACE+".pw_random_update";
		UserVO inVO = (UserVO) dto;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+inVO);
		
		int flag = this.sqlSession.update(statement, inVO);
		log.debug("3.flag: "+flag);

		return flag;
	}	
	

	//param : string?
	@Override
	public DTO do_selectOne(DTO dto) {
		String statement = NAME_SPACE+".do_selectOne";
		UserVO inVO = (UserVO) dto;
		
		//이거 꼭 찾아가야함 못찾으면 쥐쥐...
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+inVO);
		//call하기
		UserVO outVO = this.sqlSession.selectOne(statement, inVO);
		log.debug("3.outVO: "+outVO);
		
		return outVO;
	}



	@Override
	public int do_update(DTO dto) {
		String statement = NAME_SPACE+".do_update";
		UserVO inVO = (UserVO) dto;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+inVO);
		
		int flag = this.sqlSession.update(statement, inVO);
		log.debug("3.flag: "+flag);

		return flag;
	}

	//param : STring?
	public DTO do_selectOne_admin(DTO dto) {
		String statement = NAME_SPACE+".do_selectOne_admin";
		UserVO inVO = (UserVO) dto;
		
		//이거 꼭 찾아가야함 못찾으면 쥐쥐...
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+inVO);
		//call하기
		UserVO outVO = this.sqlSession.selectOne(statement, inVO);
		log.debug("3.outVO: "+outVO);
		
		return outVO;
	}
	
	public int do_update_admin(DTO dto) {
		String statement = NAME_SPACE+".do_update_admin";
		UserVO inVO = (UserVO) dto;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+inVO);
		
		int flag = this.sqlSession.update(statement, inVO);
		log.debug("3.flag: "+flag);

		return flag;
	}
	
	@Override
	public int do_delete(DTO dto) {
		String statement = NAME_SPACE+".delete";
		UserVO inVO = (UserVO) dto;
		
		log.debug("1. statement : "+statement);
		log.debug("2.param: "+inVO);
		
		int flag = this.sqlSession.delete(statement, inVO);
		log.debug("3.flag: "+flag);
		
		return flag;
	}

	@Override
	public List<UserVO> do_retrieve(DTO dto) {
		String statement = NAME_SPACE+".do_retrieve";
		SearchVO inVO = (SearchVO) dto;
		
		log.debug("1. statement : "+statement);	
		log.debug("2.param: "+inVO);
		
		return this.sqlSession.selectList(statement, dto);
	}
	
	
	@Override
	public int do_excelDown(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
