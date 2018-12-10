package com.sist.totoro.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sist.totoro.common.SearchVO;
import com.sist.totoro.dao.AtmDao;
import com.sist.totoro.domain.AtmVo;

@Service
public class AtmSvcImple implements AtmSvc {

	@Autowired AtmDao atmDao;
	
	@Override
	public List<AtmVo> do_retrieve(SearchVO searchVO)
			throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {

		return atmDao.do_retrieve(searchVO);
	}

}
