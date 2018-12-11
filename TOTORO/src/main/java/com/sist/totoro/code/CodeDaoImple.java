/**
 * 
 */
package com.sist.totoro.code;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sist.totoro.common.DTO;



/**
 * @author sist1
 *
 */
@Repository
public class CodeDaoImple implements CodeDao {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<CodeVO> rowMapper = new RowMapper<CodeVO>() {

		@Override
		public CodeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			CodeVO  codeVO=new CodeVO();
			codeVO.setCd_id(rs.getString("cdid"));
			codeVO.setD_id(rs.getString("ddid"));
			codeVO.setD_nm(rs.getString("ddnm"));
			codeVO.setOrd_num(rs.getString("ordnum"));
			return codeVO;
		}
		
	};
	
	/* (non-Javadoc)
	 * @see com.sist.hr.common.WorkDiv#do_selectOne(com.sist.hr.common.DTO)
	 */
	@Override
	public DTO do_selectOne(DTO dto) {
		StringBuilder sb=new StringBuilder();
		sb.append(" SELECT t2.ddid,                   \n");
		sb.append("        t2.ddnm,                   \n");
		sb.append("        t2.ordnum,                \n");
		sb.append("        t1.cdid                   \n");
		sb.append("   FROM codem t1 join coded t2   \n");
		sb.append("     ON t1.cdid  = t2.cdid       \n");
		sb.append("  WHERE t2.cdid  = ?              \n");   
		sb.append("    AND t2.useyn = 1              \n");
		sb.append("  ORDER by t2.ordnum              \n");
		log.info("sql \n:"+sb.toString());
		CodeVO  invo = (CodeVO) dto;
		log.info("param :"+invo);
		CodeVO outVO = this.jdbcTemplate.queryForObject(sb.toString()
				, new Object[] {invo.getCd_id()}
				, this.rowMapper);
		return outVO;
	}

	/* (non-Javadoc)
	 * @see com.sist.hr.common.WorkDiv#do_save(com.sist.hr.common.DTO)
	 */
	@Override
	public int do_save(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.sist.hr.common.WorkDiv#do_update(com.sist.hr.common.DTO)
	 */
	@Override
	public int do_update(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.sist.hr.common.WorkDiv#do_delete(com.sist.hr.common.DTO)
	 */
	@Override
	public int do_delete(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.sist.hr.common.WorkDiv#do_retrieve(com.sist.hr.common.DTO)
	 */
	@Override
	public List<?> do_retrieve(DTO dto) {
		StringBuilder sb=new StringBuilder();
		sb.append(" SELECT t2.ddid,                   \n");
		sb.append("        t2.ddnm,                   \n");
		sb.append("        t2.ordnum,                \n");
		sb.append("        t1.cdid                   \n");
		sb.append("   FROM codem t1 join coded t2   \n");
		sb.append("     ON t1.cdid  = t2.cdid       \n");
		sb.append("  WHERE t2.cdid  = ?              \n");   
		sb.append("    AND t2.useyn = 1              \n");
		sb.append("  ORDER by t2.ordnum              \n");
		log.info("sql \n:"+sb.toString());
		CodeVO  invo = (CodeVO) dto;
		log.info("param :"+invo);
		
		List<CodeVO> list = this.jdbcTemplate.query(sb.toString()
				, new Object[] {invo.getCd_id()}
				, this.rowMapper);
		log.info("result :"+list);
		return list;
	}

	/* (non-Javadoc)
	 * @see com.sist.hr.common.WorkDiv#do_excelDown(com.sist.hr.common.DTO)
	 */
	@Override
	public int do_excelDown(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}


        

