package com.sist.totoro.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.sist.totoro.common.DuplicateUserIdException;
import com.sist.totoro.common.SearchVO;
import com.sist.totoro.domain.CusReplyVO;




public interface CusReplySvc {

	
	int do_deleteMulti(List<CusReplyVO> list) throws RuntimeException, SQLException;
	//레벨 업그래이드 실행
	
	/**
	 * 단건삭제
	 */
	int delete(CusReplyVO cusreplyVO) throws SQLException;

	/**
	 * 수정
	 */

	/** 추가:115
	 * @param userVO
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	int add(CusReplyVO cusreplyVO) throws DuplicateUserIdException;

	List<CusReplyVO> do_retrieve(CusReplyVO cusreplyvo)
			throws ClassNotFoundException, SQLException, EmptyResultDataAccessException;

	/**
	 * 단건조회
	 * @param userVO
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	CusReplyVO get(CusReplyVO cusreplyVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException;

}