package com.sist.totoro.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sist.totoro.common.DuplicateUserIdException;
import com.sist.totoro.common.SearchVO;
import com.sist.totoro.dao.CustomerDao;
import com.sist.totoro.domain.CustomerVO;




@Service
public class CustomerSvcImple implements CustomerSvc {
    private Logger log = LoggerFactory.getLogger(CustomerSvcImple.class);

	
	
	@Autowired
	private CustomerDao customerDao;
	
	
	//업그레이드 가능 확인 

	
	//레벨 업그래이드 실행
	/* (non-Javadoc)
	 * @see com.sist.hr.user.service.UserSvc#upgradeLevel(com.sist.hr.user.domain.UserVO)
	 */

	
	/* (non-Javadoc)
	 * @see com.sist.hr.user.service.UserSvc#delete(com.sist.hr.user.domain.UserVO)
	 */
	@Override
	public int delete(CustomerVO customerVO) throws SQLException{
		return customerDao.delete(customerVO);
	}
	
	/* (non-Javadoc)
	 * @see com.sist.hr.user.service.UserSvc#update(com.sist.hr.user.domain.UserVO)
	 */
	@Override
	public int update(CustomerVO customerVO) throws SQLException{
		return customerDao.update(customerVO);
	}
	
	/* (non-Javadoc)
	 * @see com.sist.hr.user.service.UserSvc#getCount(java.lang.String)
	 */
	@Override
	public int getCount(String userId) throws SQLException{
		return customerDao.getCount(userId);
	}



	/* (non-Javadoc)
	 * @see com.sist.hr.user.service.UserSvc#add(com.sist.hr.user.domain.UserVO)
	 */
	@Override
	public int add(CustomerVO customerVO) throws DuplicateUserIdException{
		//TODO: return 

		return customerDao.add(customerVO);
	}

	
	/* (non-Javadoc)
	 * @see com.sist.hr.user.service.UserSvc#do_retrieve(com.sist.hr.common.SearchVO)
	 */
	@Override
	public List<CustomerVO> do_retrieve(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException{
		return customerDao.do_retrieve(searchVO);
	}
	

	/* (non-Javadoc)
	 * @see com.sist.hr.user.service.UserSvc#get(com.sist.hr.user.domain.UserVO)
	 */
	@Override
	public CustomerVO get(CustomerVO customerVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException{
		return  customerDao.get(customerVO);
	}

	@Override
	public int do_deleteMulti(List<CustomerVO> list) throws RuntimeException, SQLException {
		int flag = 0;
		try {
			for(CustomerVO vo :list) {
				flag+=customerDao.delete(vo);
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



