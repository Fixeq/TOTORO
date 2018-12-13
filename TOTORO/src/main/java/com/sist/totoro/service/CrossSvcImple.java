package com.sist.totoro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.totoro.dao.CrossDaoImple;
import com.sist.totoro.domain.CrossVO;

@Service
public class CrossSvcImple {

	@Autowired
	private CrossDaoImple crossDao; 
	
	public List<CrossVO> do_selectAll(){
		return crossDao.do_selectAll();
	}

	public List<CrossVO> do_selectNoResult(){
		return crossDao.do_selectAdminNoResult();
	}

	public List<CrossVO> do_selectYesResult(){
		return crossDao.do_selectAdminYesResult();
	}

	
	public List<CrossVO> do_selectLimit(){
		return crossDao.do_selectUser();
	}
	
	public int do_insert(CrossVO inVO) {
		return crossDao.do_save(inVO);
	}
}
