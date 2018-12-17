package com.sist.totoro.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sist.totoro.common.SearchVO;
import com.sist.totoro.dao.AtmDao;
import com.sist.totoro.domain.AtmVo;

@Service
public class AtmSvcImple implements AtmSvc {
	private Logger log = LoggerFactory.getLogger(AtmSvcImple.class);

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
	
	
	@Override
	public int delete(AtmVo atmVo) {
	
		return atmDao.delete(atmVo);
	}
	
	@Override
	public int deAdd(AtmVo atmVo) {
		
		return atmDao.deAdd(atmVo);
	}
	
	@Override
	public int wiAdd(AtmVo atmVo) {
		
		return atmDao.wiAdd(atmVo);
	}
	
	@Override
	public int do_deleteMulti(List<AtmVo> list) throws RuntimeException, SQLException {
		int flag = 0;
		try {
			for(AtmVo vo :list) {
				flag+=atmDao.delete(vo);
			}
			
		}catch(RuntimeException e) {
			log.debug("========================");
			log.debug("RuntimeException: "+e.getMessage());
			log.debug("========================");			
			throw e;
		}
		log.debug("========================");
		log.debug("=flag="+flag);
		log.debug("========================");
		return flag;
	}

	@Override
	public int do_depositMulti(List<AtmVo> list) throws RuntimeException, SQLException {
		int flag = 0;
		try {
			for(AtmVo vo :list) {
				flag+=atmDao.adDeGet(vo);
				atmDao.adReqDeGet(vo);
				
			}
			
		}catch(RuntimeException e) {
			log.debug("========================");
			log.debug("RuntimeException: "+e.getMessage());
			log.debug("========================");			
			throw e;
		}
		log.debug("========================");
		log.debug("=flag="+flag);
		log.debug("========================");
		return flag;
	}

	
}
