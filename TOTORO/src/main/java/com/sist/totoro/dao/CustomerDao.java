package com.sist.totoro.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.sist.totoro.common.DuplicateUserIdException;
import com.sist.totoro.common.SearchVO;
import com.sist.totoro.domain.CustomerVO;



public interface CustomerDao { 

	/**
	 * 단건삭제
	 */
	int delete(CustomerVO customerVO) throws SQLException;
	
	/**
	 * 수정
	 */
	int update(CustomerVO customerVO) throws SQLException;
	
	/**
	 * 조회 COUNT
	 * @throws SQLException 
	 */
	int getCount(String customerVO) throws SQLException;
   

	/**
	 * 추가:115
	 * @param userVO
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */

	int add(CustomerVO customerVO) throws DuplicateUserIdException;

	List<CustomerVO> getAll() throws ClassNotFoundException, SQLException, EmptyResultDataAccessException;
	List<CustomerVO> do_retrieve(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException;
	

	/**
	 * 단건조회
	 * @param userVO
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	CustomerVO get(CustomerVO customerVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException;

}