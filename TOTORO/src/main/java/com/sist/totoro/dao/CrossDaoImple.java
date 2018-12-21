package com.sist.totoro.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.totoro.common.DTO;
import com.sist.totoro.common.SearchVO;
import com.sist.totoro.common.WorkDiv;
import com.sist.totoro.domain.CrossVO;

@Repository
public class CrossDaoImple {
	
	Logger  log = LoggerFactory.getLogger(CrossDaoImple.class);
    
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NAME_SPACE = "com.sist.totoro.mappers.cross";
	
	
	public CrossVO do_ViewHp(CrossVO inVO){
		// 홈팀 배당률
		String statement = NAME_SPACE + ".do_ViewHp";
		
		log.debug("1.statement : \n"+statement);
		log.debug("2. param : \n"+inVO);

		return this.sqlSession.selectOne(statement,inVO);
	}
	
	public CrossVO do_ViewDp(CrossVO inVO){
		// 무승부 배당률
		String statement = NAME_SPACE + ".do_ViewDp";
		
		log.debug("1.statement : \n"+statement);
		log.debug("2. param : \n"+inVO);

		return this.sqlSession.selectOne(statement,inVO);
	}
	
	public CrossVO do_ViewAp(CrossVO inVO){
		// 원정팀 배당률 
		String statement = NAME_SPACE + ".do_ViewAp";
		
		log.debug("1.statement : \n"+statement);
		log.debug("2. param : \n"+inVO);

		return this.sqlSession.selectOne(statement,inVO);
	}

	
	
	public List<CrossVO> do_selectAll(){
		//접속자가 사용자면".do_selectUser"
		//접속자가 관리자면".do_selectAdmin"
		String statement = NAME_SPACE + ".do_selectAll";
		
		log.debug("1.statement : \n"+statement);
		//log.debug("2. param : \n"+userId);

		return this.sqlSession.selectList(statement);
	}

	
	/**
	 * 크로스 페이지 View
	 * @return
	 */
	public List<CrossVO> do_selectUser(SearchVO inVO){
		//접속자가 사용자면".do_selectUser"
		//접속자가 관리자면".do_selectAdmin"
		String statement = NAME_SPACE + ".do_selectUser";
		
		log.debug("1.statement : \n"+statement);
		log.debug("2. param : \n"+inVO);

		return this.sqlSession.selectList(statement,inVO);
	}
	
	public List<CrossVO> do_selectAdminNoResult(){
		//접속자가 사용자면".do_selectUser"
		//접속자가 관리자면".do_selectAdmin"
		String statement = NAME_SPACE + ".do_selectAdminNoResult";
		
		log.debug("1.statement : \n"+statement);
		//log.debug("2. param : \n"+userId);

		return this.sqlSession.selectList(statement);
	}

	public List<CrossVO> do_selectAdminYesResult(){
		//접속자가 사용자면".do_selectUser"
		//접속자가 관리자면".do_selectAdmin"
		String statement = NAME_SPACE + ".do_selectAdminYesResult";
		
		log.debug("1.statement : \n"+statement);
		//log.debug("2. param : \n"+userId);

		return this.sqlSession.selectList(statement);
	}
	
	public DTO do_selectOne(CrossVO crossVO) {
		//팀버튼을 선택하면 해당 경기의 gameSeq, 원정인지 홈인지를 구분해야함.
		//버튼을 클릭할때 어떻게 분별해낼것인가..
		//홈팀 승 선택 -> 버튼에서 홈팀 이름 가져와야함. 홈팀 이름 가져오면 무얼 기준으로 홈팀이름을 조회하는가.
		//홈팀 이름을 조회하기 위해서 1,2,3에 대응되는 값을 매칭.
		//팀이름으로 가져온다고 하면,
		
		// 이거 뷰단에서 정리해버리는게 더 쉬울수도.
		String statement = NAME_SPACE + ".do_selectOne";
		
		log.debug("1.statement : \n"+statement);
		log.debug("2. param : \n"+crossVO);

		return this.sqlSession.selectOne(statement);
	}

	/**
	 * 크로스 생성
	 * @param crossVO
	 * @return
	 */
	public int do_save(CrossVO crossVO) {
		String statement = NAME_SPACE + ".do_save";
		log.debug("1.statement : \n"+statement);
		log.debug("2. param : \n"+crossVO);
		return this.sqlSession.insert(statement,crossVO);
	}

	/**
	 * 크로스 경기 결과
	 * @param crossVO
	 * @return
	 */
	public int do_update(CrossVO crossVO) {
		//경기 결과 반영
		String statement = NAME_SPACE + ".do_update";
		log.debug("1.statement : \n"+statement);
		log.debug("2. param : \n"+crossVO);

		return this.sqlSession.update(statement, crossVO);
	}

	public int do_delete(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<?> do_retrieve(DTO dto) {
		
		return null;
	}

	public int do_excelDown(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
