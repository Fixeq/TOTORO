package com.sist.totoro.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.sist.totoro.common.DuplicateUserIdException;
import com.sist.totoro.common.SearchVO;
import com.sist.totoro.domain.CustomerVO;



public interface CustomerSvc {

	
	int do_deleteMulti(List<CustomerVO> list) throws RuntimeException, SQLException;
	//레벨 업그래이드 실행
	
	/**
	 * 단건삭제
	 */
	int delete(CustomerVO userVO) throws SQLException;

	/**
	 * 수정
	 */
	int update(CustomerVO userVO) throws SQLException;

	/**
	 * 조회 COUNT
	 * @throws SQLException 
	 */
	int getCount(String userId) throws SQLException;

	/**
	 * 추가:115
	 * @param userVO
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	int add(CustomerVO userVO) throws DuplicateUserIdException;

	List<CustomerVO> do_retrieve(SearchVO searchVO)
			throws ClassNotFoundException, SQLException, EmptyResultDataAccessException;

	/**
	 * 단건조회
	 * @param userVO
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	CustomerVO get(CustomerVO userVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException;

}