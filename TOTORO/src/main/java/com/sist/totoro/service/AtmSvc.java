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
import com.sist.totoro.dao.AtmDao;
import com.sist.totoro.domain.AtmVo;

@Service
public class AtmSvc{
    private Logger log = LoggerFactory.getLogger(AtmSvc.class);
	public static final int MIN_SILVER_LOGIN_COUNT   = 50;//BASIC->SILVER
	public static final int MIN_GOLD_RECOMMAND_COUNT = 30;//SILVER->GOLD
	
	
	@Autowired
	private AtmDao atmDao;
	
	
//	//업그레이드 가능 확인 
//	private boolean isCanUpgradeLevel(AtmVo user) {
//		//현제 Level
//		Level curLevel = user.getUserLevel();
//		switch(curLevel) {
//			case BASIC : return (user.getLogin()     >= MIN_SILVER_LOGIN_COUNT);
//			case SILVER: return (user.getRecommend() >= MIN_GOLD_RECOMMAND_COUNT);
//			case GOLD: return false;
//			default: throw new IllegalAccessError("Unknown Level:"+curLevel);
//		}
//	}
	
//	//레벨 업그래이드 실행
//	/* (non-Javadoc)
//	 * @see com.sist.hr.user.service.UserSvc#upgradeLevel(com.sist.hr.user.domain.AtmVo)
//	 */
//	public void upgradeLevel(AtmVo user) throws SQLException,RuntimeException {
//
//		user.upgradeLevel();
//		atmDao.update(user);
//	}
	
	/* (non-Javadoc)
	 * @see com.sist.hr.user.service.UserSvc#upgradeLevels()
	 */
	
//	public void upgradeLevels() throws EmptyResultDataAccessException, ClassNotFoundException, SQLException,RuntimeException {
//		//-------------------------------------------
//		//1.전체 사용자를 조회 한다.
//		//-------------------------------------------
//		List<AtmVo> list = atmDao.getAll();
//
//		int upLevelCnt = 0;
//		try {
//			for(AtmVo user:list) {
//				if("j04_115".equals(user.getUserId())) {		
//					throw new RuntimeException("레벨 업그래이드오류");
//				}
//				  
//				if(isCanUpgradeLevel(user) == true) {
//					upLevelCnt++;
//					upgradeLevel(user);
//				}
//			}//--for
//			
//		}catch(RuntimeException e) {
//			log.debug("========================");
//			log.debug("RuntimeException: "+e.getMessage());
//			log.debug("========================");
//
//			throw e;
//		}finally {
//			//TODO
//			//-----------------------------------
//			//자원반납
//			//-----------------------------------
//			
//			
//		}
//		//-------------------------------------------
//		//2.2. 트랜잭션처리:commit,rollback
//		//-------------------------------------------
//		
//		log.debug("========================");
//		log.debug("commit="+upLevelCnt);
//		log.debug("========================");
//	}
	
	/* (non-Javadoc)
	 * @see com.sist.hr.user.service.UserSvc#delete(com.sist.hr.domain.AtmVo)
	 */
	public int delete(AtmVo atmVo) throws SQLException{
		return atmDao.delete(atmVo);
	}
	
	
	/* (non-Javadoc)
	 * @see com.sist.hr.user.service.UserSvc#getCount(java.lang.String)
	 */
	public int getCount(String userId) throws SQLException{
		return atmDao.getCount(userId);
	}



	/* (non-Javadoc)
	 * @see com.sist.hr.user.service.UserSvc#add(com.sist.hr.user.domain.AtmVo)
	 */
	public int add(AtmVo atmVo) throws DuplicateUserIdException{
		//TODO: return 
		return atmDao.add(atmVo);
	}

	
	/* (non-Javadoc)
	 * @see com.sist.hr.user.service.UserSvc#do_retrieve(com.sist.hr.common.SearchVO)
	 */
	public List<AtmVo> do_retrieve(SearchVO searchVO) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException{
		return atmDao.do_retrieve(searchVO);
	}
	

	/* (non-Javadoc)
	 * @see com.sist.hr.user.service.UserSvc#get(com.sist.hr.user.domain.AtmVo)
	 */
	public AtmVo get(AtmVo atmVo) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException{
		return  atmDao.get(atmVo);
	}

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


}



