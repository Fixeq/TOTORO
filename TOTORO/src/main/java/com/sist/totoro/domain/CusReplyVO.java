package com.sist.totoro.domain;

import com.sist.totoro.common.SearchVO;

public class CusReplyVO extends SearchVO{

	private String crSeq	;	//답글번호
	private String cusSeq	;	//글번호
	private String userId	;	//글등록자
	private String crContent;		//답글내용
	private String crregId	;	//등록자아이디
	private String crregDt	;	//등록일
	 
 
	 public CusReplyVO() {}


	public String getCrSeq() {
		return crSeq;
	}


	public void setCrSeq(String crSeq) {
		this.crSeq = crSeq;
	}


	public String getCusSeq() {
		return cusSeq;
	}


	public void setCusSeq(String cusSeq) {
		this.cusSeq = cusSeq;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getCrContent() {
		return crContent;
	}


	public void setCrContent(String crContent) {
		this.crContent = crContent;
	}


	public String getCrregId() {
		return crregId;
	}


	public void setCrregId(String crregId) {
		this.crregId = crregId;
	}


	public String getCrregDt() {
		return crregDt;
	}


	public void setCrregDt(String crregDt) {
		this.crregDt = crregDt;
	}


	@Override
	public String toString() {
		return "CusReplyVO [crSeq=" + crSeq + ", cusSeq=" + cusSeq + ", userId=" + userId + ", crContent=" + crContent
				+ ", crregId=" + crregId + ", crregDt=" + crregDt + "]";
	}


	public CusReplyVO(String crSeq, String cusSeq, String userId, String crContent, String crregId, String crregDt) {
		super();
		this.crSeq = crSeq;
		this.cusSeq = cusSeq;
		this.userId = userId;
		this.crContent = crContent;
		this.crregId = crregId;
		this.crregDt = crregDt;
	}
	 


	 
}
