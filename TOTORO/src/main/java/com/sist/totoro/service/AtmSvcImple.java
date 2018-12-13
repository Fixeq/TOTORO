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
	
	@Override
	public List<AtmVo> adWiAll(SearchVO searchVO)
			throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {

		return atmDao.adWiAll(searchVO);
	}
	
	@Override
	public List<AtmVo> adDeAll(SearchVO searchVO)
			throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {

		return atmDao.adDeAll(searchVO);
	}
	
	@Override
	public List<AtmVo> adDeReqAll(SearchVO searchVO)
			throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {

		return atmDao.adDeReqAll(searchVO);
	}

	@Override
	public List<AtmVo> adDePsAll(SearchVO searchVO)
			throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {

		return atmDao.adDePsAll(searchVO);
	}
}
