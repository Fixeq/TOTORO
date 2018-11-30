package com.totoro.cross.domain;

import java.util.Date;

import com.totoro.common.DTO;

public class CrossVO extends DTO{
	
	private String G_SEQ		;//폴 시퀀스
	private String G_HOME		;//홈팀이름
	private String G_AWAY		;//원정팀이름
	private String G_HP         ;//홈배당률
	private String G_DP         ;//무승부배당률
	private String G_AP         ;//원정배당률
	private String G_DATE       ;//경기일자-시간
	private String G_RESULT     ;//경기결과
	private String G_HS         ;//홈팀 스코어
	private String G_AS         ;//원정팀 스코어
	private String G_REG_ID     ;//등록자
	private Date G_REG_DT       ;//등록일
	private String G_MOD_ID     ;//수정자
	private Date G_MOD_DT       ;//수정일
	
	/**
	 * @return the g_SEQ
	 */
	public String getG_SEQ() {
		return G_SEQ;
	}
	/**
	 * @param g_SEQ the g_SEQ to set
	 */
	public void setG_SEQ(String g_SEQ) {
		G_SEQ = g_SEQ;
	}
	/**
	 * @return the g_HOME
	 */
	public String getG_HOME() {
		return G_HOME;
	}
	/**
	 * @param g_HOME the g_HOME to set
	 */
	public void setG_HOME(String g_HOME) {
		G_HOME = g_HOME;
	}
	/**
	 * @return the g_AWAY
	 */
	public String getG_AWAY() {
		return G_AWAY;
	}
	/**
	 * @param g_AWAY the g_AWAY to set
	 */
	public void setG_AWAY(String g_AWAY) {
		G_AWAY = g_AWAY;
	}
	/**
	 * @return the g_HP
	 */
	public String getG_HP() {
		return G_HP;
	}
	/**
	 * @param g_HP the g_HP to set
	 */
	public void setG_HP(String g_HP) {
		G_HP = g_HP;
	}
	/**
	 * @return the g_DP
	 */
	public String getG_DP() {
		return G_DP;
	}
	/**
	 * @param g_DP the g_DP to set
	 */
	public void setG_DP(String g_DP) {
		G_DP = g_DP;
	}
	/**
	 * @return the g_AP
	 */
	public String getG_AP() {
		return G_AP;
	}
	/**
	 * @param g_AP the g_AP to set
	 */
	public void setG_AP(String g_AP) {
		G_AP = g_AP;
	}
	/**
	 * @return the g_DATE
	 */
	public String getG_DATE() {
		return G_DATE;
	}
	/**
	 * @param g_DATE the g_DATE to set
	 */
	public void setG_DATE(String g_DATE) {
		G_DATE = g_DATE;
	}
	/**
	 * @return the g_RESULT
	 */
	public String getG_RESULT() {
		return G_RESULT;
	}
	/**
	 * @param g_RESULT the g_RESULT to set
	 */
	public void setG_RESULT(String g_RESULT) {
		G_RESULT = g_RESULT;
	}
	/**
	 * @return the g_HS
	 */
	public String getG_HS() {
		return G_HS;
	}
	/**
	 * @param g_HS the g_HS to set
	 */
	public void setG_HS(String g_HS) {
		G_HS = g_HS;
	}
	/**
	 * @return the g_AS
	 */
	public String getG_AS() {
		return G_AS;
	}
	/**
	 * @param g_AS the g_AS to set
	 */
	public void setG_AS(String g_AS) {
		G_AS = g_AS;
	}
	/**
	 * @return the g_REG_ID
	 */
	public String getG_REG_ID() {
		return G_REG_ID;
	}
	/**
	 * @param g_REG_ID the g_REG_ID to set
	 */
	public void setG_REG_ID(String g_REG_ID) {
		G_REG_ID = g_REG_ID;
	}
	/**
	 * @return the g_REG_DT
	 */
	public Date getG_REG_DT() {
		return G_REG_DT;
	}
	/**
	 * @param g_REG_DT the g_REG_DT to set
	 */
	public void setG_REG_DT(Date g_REG_DT) {
		G_REG_DT = g_REG_DT;
	}
	/**
	 * @return the g_MOD_ID
	 */
	public String getG_MOD_ID() {
		return G_MOD_ID;
	}
	/**
	 * @param g_MOD_ID the g_MOD_ID to set
	 */
	public void setG_MOD_ID(String g_MOD_ID) {
		G_MOD_ID = g_MOD_ID;
	}
	/**
	 * @return the g_MOD_DT
	 */
	public Date getG_MOD_DT() {
		return G_MOD_DT;
	}
	/**
	 * @param g_MOD_DT the g_MOD_DT to set
	 */
	public void setG_MOD_DT(Date g_MOD_DT) {
		G_MOD_DT = g_MOD_DT;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CrossVO [G_SEQ=" + G_SEQ + ", G_HOME=" + G_HOME + ", G_AWAY=" + G_AWAY + ", G_HP=" + G_HP + ", G_DP="
				+ G_DP + ", G_AP=" + G_AP + ", G_DATE=" + G_DATE + ", G_RESULT=" + G_RESULT + ", G_HS=" + G_HS
				+ ", G_AS=" + G_AS + ", G_REG_ID=" + G_REG_ID + ", G_REG_DT=" + G_REG_DT + ", G_MOD_ID=" + G_MOD_ID
				+ ", G_MOD_DT=" + G_MOD_DT + "]";
	}
	
	public CrossVO() {
		// TODO Auto-generated constructor stub
	}
	public CrossVO(String g_SEQ, String g_HOME, String g_AWAY, String g_HP, String g_DP, String g_AP, String g_DATE,
			String g_RESULT, String g_HS, String g_AS, String g_REG_ID, Date g_REG_DT, String g_MOD_ID, Date g_MOD_DT) {
		super();
		G_SEQ = g_SEQ;
		G_HOME = g_HOME;
		G_AWAY = g_AWAY;
		G_HP = g_HP;
		G_DP = g_DP;
		G_AP = g_AP;
		G_DATE = g_DATE;
		G_RESULT = g_RESULT;
		G_HS = g_HS;
		G_AS = g_AS;
		G_REG_ID = g_REG_ID;
		G_REG_DT = g_REG_DT;
		G_MOD_ID = g_MOD_ID;
		G_MOD_DT = g_MOD_DT;
	}
	
	
	
}
