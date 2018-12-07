package com.sist.totoro.domain;

import com.sist.totoro.common.DTO;

public class AtmVo extends DTO {
	
	private String dwSeq    ;//입출금 시퀀스
	private String userId   ;//아이디
	private String dePoint  ;//입금 포인트
	private String wiPoint  ;//출금 포인트
	private String dwPs     ;//처리상태
	private String dwReqday ;//신청날짜
	private String dwGetday ;//충전날짜
	
	public AtmVo(String string, String string2, String string3, String string4, String string5, String string6,
			String string7) {
		// TODO Auto-generated constructor stub
	}
	public String getDwSeq() {
		return dwSeq;
	}
	public void setDwSeq(String dwSeq) {
		this.dwSeq = dwSeq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDePoint() {
		return dePoint;
	}
	public void setDePoint(String dePoint) {
		this.dePoint = dePoint;
	}
	public String getWiPoint() {
		return wiPoint;
	}
	public void setWiPoint(String wiPoint) {
		this.wiPoint = wiPoint;
	}
	public String getDwPs() {
		return dwPs;
	}
	public void setDwPs(String dwPs) {
		this.dwPs = dwPs;
	}
	public String getDwReqday() {
		return dwReqday;
	}
	public void setDwReqday(String dwReqday) {
		this.dwReqday = dwReqday;
	}
	public String getDwGetday() {
		return dwGetday;
	}
	public void setDwGetday(String dwGetday) {
		this.dwGetday = dwGetday;
	}
	
	@Override
	public String toString() {
		return "atmVO [dwSeq=" + dwSeq + ", userId=" + userId + ", dePoint=" + dePoint + ", wiPoint=" + wiPoint
				+ ", dwPs=" + dwPs + ", dwReqday=" + dwReqday + ", dwGetday=" + dwGetday + "]";
	}
	
	

}
