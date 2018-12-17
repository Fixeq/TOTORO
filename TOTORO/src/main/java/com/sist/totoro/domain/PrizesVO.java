package com.sist.totoro.domain;

import com.sist.totoro.common.DTO;

public class PrizesVO extends DTO{

	private String betwPrice;
	private String userId;
	private String betReturn;
	private String betSeq;
	

	
	public String getBetwPrice() {
		return betwPrice;
	}
	public void setBetwPrice(String betwPrice) {
		this.betwPrice = betwPrice;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBetReturn() {
		return betReturn;
	}
	public void setBetReturn(String betReturn) {
		this.betReturn = betReturn;
	}
	public String getBetSeq() {
		return betSeq;
	}
	public void setBetSeq(String betSeq) {
		this.betSeq = betSeq;
	}
	public PrizesVO(String betwPrice, String userId, String betReturn, String betSeq) {
		super();
		this.betwPrice = betwPrice;
		this.userId = userId;
		this.betReturn = betReturn;
		this.betSeq = betSeq;
	}
	@Override
	public String toString() {
		return "PrizesVO [betwPrice=" + betwPrice + ", userId=" + userId + ", betReturn=" + betReturn + ", betSeq="
				+ betSeq + "]";
	}

	public PrizesVO() {
		super();
	}
	
	
	
}
