package com.sist.totoro.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.sist.totoro.common.DuplicateUserIdException;
import com.sist.totoro.common.SearchVO;
import com.sist.totoro.domain.CusReplyVO;
import com.sist.totoro.domain.CustomerVO;


public interface CusReplyDao { 

	/**
	 * 단건삭제
	 */
	int delete(CusReplyVO cusreplyVO) throws SQLException;
	
	/**
	 * 수정
	 */
	
	/**
	 * 추가:115
	 * @param userVO
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */

	int add(CusReplyVO cusreplyVO) throws DuplicateUserIdException;

	List<CusReplyVO> getAll() throws ClassNotFoundException, SQLException, EmptyResultDataAccessException;
	List<CusReplyVO> do_retrieve(CusReplyVO cusreplyVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException;
	

	/**
	 * 단건조회
	 * @param userVO
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	CusReplyVO get(CusReplyVO cusreplyVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException;

}