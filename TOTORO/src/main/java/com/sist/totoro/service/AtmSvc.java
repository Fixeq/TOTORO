package com.sist.totoro.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sist.totoro.common.SearchVO;
import com.sist.totoro.domain.AtmVo;



public interface AtmSvc{
   
	/* (non-Javadoc)
	 * @see com.sist.hr.user.service.UserSvc#do_retrieve(com.sist.hr.common.SearchVO)
	 */
	List<AtmVo> do_retrieve(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException;

	List<AtmVo> adWiAll(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException;

	List<AtmVo> adDeAll(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException;

	List<AtmVo> adDeReqAll(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException;
	
	List<AtmVo> adDePsAll(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException;

}



