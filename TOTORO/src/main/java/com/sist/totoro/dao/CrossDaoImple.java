package com.sist.totoro.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.totoro.common.DTO;
import com.sist.totoro.common.WorkDiv;
import com.sist.totoro.domain.CrossVO;

@Repository
public class CrossDaoImple {
	
	Logger  log = LoggerFactory.getLogger(CrossDaoImple.class);
    
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NAME_SPACE = "com.sist.totoro.mappers.cross";

	public List<CrossVO> do_selectUser(){
		//접속자가 사용자면".do_selectUser"
		//접속자가 관리자면".do_selectAdmin"
		String statement = NAME_SPACE + ".do_selectUser";
		
		log.debug("1.statement : \n"+statement);
		//log.debug("2. param : \n"+userId);

		return this.sqlSession.selectList(statement);
	}
	
	public DTO do_selectOne(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public int do_save(CrossVO crossVO) {
		String statement = NAME_SPACE + ".do_save";
		log.debug("1.statement : \n"+statement);
		log.debug("2. param : \n"+crossVO);
		return this.sqlSession.insert(statement,crossVO);
	}

	public int do_update(CrossVO crossVO) {
		//경기 결과 반영
		String statement = NAME_SPACE + ".do_update";
		log.debug("1.statement : \n"+statement);
		log.debug("2. param : \n"+crossVO);

		return this.sqlSession.update(statement, crossVO);
	}

	public int do_delete(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<?> do_retrieve(DTO dto) {
		
		return null;
	}

	public int do_excelDown(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
