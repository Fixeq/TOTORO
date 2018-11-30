package com.totoro.cross.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.totoro.common.DTO;
import com.totoro.cross.domain.CrossVO;

public class CrossDaoImple {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(DTO dto) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO cross ( \n");
		sb.append("    g_seq,          \n");
		sb.append("    g_home,         \n");
		sb.append("    g_away,         \n");
		sb.append("    g_hp,           \n");
		sb.append("    g_dp,           \n");
		sb.append("    g_ap,           \n");
		sb.append("    g_date,         \n");
		sb.append("    g_reg_id,       \n");
		sb.append("    g_reg_dt,       \n");
		sb.append("    g_mod_id,       \n");
		sb.append("    g_mod_dt        \n");
		sb.append(") VALUES (          \n");
		sb.append("    ?			   \n");
		sb.append("    ?			   \n");
		sb.append("    ?			   \n");
		sb.append("    ?			   \n");
		sb.append("    ?			   \n");
		sb.append("    ?			   \n");
		sb.append("    ?			   \n");
		sb.append("    ?			   \n");
		sb.append("    sysdate		   \n");
		sb.append("    ?			   \n");
		sb.append("    sysdate		   \n");
		sb.append(");                  \n");
		
		CrossVO crossVO = (CrossVO)dto;
		int flag = jdbcTemplate.update(sb.toString(), 
								1,
								crossVO.getG_HOME(),
								crossVO.getG_AWAY(),
								crossVO.getG_HP(),
								crossVO.getG_DP(),
								crossVO.getG_AP(),
								crossVO.getG_DATE(),
								crossVO.getG_REG_ID(),
								crossVO.getG_MOD_ID()
								);
		return flag;
	}
	//경기 베팅
}
