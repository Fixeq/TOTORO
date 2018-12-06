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
public class CrossDaoImple implements WorkDiv{
	
	Logger  log = LoggerFactory.getLogger(CrossDaoImple.class);
    
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NAME_SPACE = "com.sist.totoro.mappers.cross";

	public List<CrossVO> do_selectAll(){
		String statement = NAME_SPACE + ".do_selectAll";
		log.debug("1.statement : \n"+statement);
		//log.debug("2. param : \n"+userId);

		return this.sqlSession.selectList(statement);
	}
	
	@Override
	public DTO do_selectOne(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int do_save(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int do_update(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int do_delete(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<?> do_retrieve(DTO dto) {
		
		return null;
	}

	@Override
	public int do_excelDown(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
