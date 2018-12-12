package com.sist.totoro.domain;

import com.sist.totoro.common.DTO;

public class CustomerVO extends DTO{

	 private String cusSeq;
	 private String userId;
	 private String cusCat;
	 private String cusTitle;
	 private String cusContent;
	 private String cusRegDt;
	 private String cusModid;
	 private String cusModdt;
	 private String cusReply;
	 
 
	 public CustomerVO() {}


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


	public String getCusCat() {
		return cusCat;
	}


	public void setCusCat(String cusCat) {
		this.cusCat = cusCat;
	}


	public String getCusTitle() {
		return cusTitle;
	}


	public void setCusTitle(String cusTitle) {
		this.cusTitle = cusTitle;
	}


	public String getCusContent() {
		return cusContent;
	}


	public void setCusContent(String cusContent) {
		this.cusContent = cusContent;
	}


	public String getCusRegDt() {
		return cusRegDt;
	}


	public void setCusRegDt(String cusRegDt) {
		this.cusRegDt = cusRegDt;
	}


	public String getCusModid() {
		return cusModid;
	}


	public void setCusModid(String cusModid) {
		this.cusModid = cusModid;
	}


	public String getCusModdt() {
		return cusModdt;
	}


	public void setCusModdt(String cusModdt) {
		this.cusModdt = cusModdt;
	}


	public String getCusReply() {
		return cusReply;
	}


	public void setCusReply(String cusReply) {
		this.cusReply = cusReply;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cusCat == null) ? 0 : cusCat.hashCode());
		result = prime * result + ((cusContent == null) ? 0 : cusContent.hashCode());
		result = prime * result + ((cusModdt == null) ? 0 : cusModdt.hashCode());
		result = prime * result + ((cusModid == null) ? 0 : cusModid.hashCode());
		result = prime * result + ((cusRegDt == null) ? 0 : cusRegDt.hashCode());
		result = prime * result + ((cusReply == null) ? 0 : cusReply.hashCode());
		result = prime * result + ((cusSeq == null) ? 0 : cusSeq.hashCode());
		result = prime * result + ((cusTitle == null) ? 0 : cusTitle.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerVO other = (CustomerVO) obj;
		if (cusCat == null) {
			if (other.cusCat != null)
				return false;
		} else if (!cusCat.equals(other.cusCat))
			return false;
		if (cusContent == null) {
			if (other.cusContent != null)
				return false;
		} else if (!cusContent.equals(other.cusContent))
			return false;
		if (cusModdt == null) {
			if (other.cusModdt != null)
				return false;
		} else if (!cusModdt.equals(other.cusModdt))
			return false;
		if (cusModid == null) {
			if (other.cusModid != null)
				return false;
		} else if (!cusModid.equals(other.cusModid))
			return false;
		if (cusRegDt == null) {
			if (other.cusRegDt != null)
				return false;
		} else if (!cusRegDt.equals(other.cusRegDt))
			return false;
		if (cusReply == null) {
			if (other.cusReply != null)
				return false;
		} else if (!cusReply.equals(other.cusReply))
			return false;
		if (cusSeq == null) {
			if (other.cusSeq != null)
				return false;
		} else if (!cusSeq.equals(other.cusSeq))
			return false;
		if (cusTitle == null) {
			if (other.cusTitle != null)
				return false;
		} else if (!cusTitle.equals(other.cusTitle))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "UserVO [cusSeq=" + cusSeq + ", userId=" + userId + ", cusCat=" + cusCat + ", cusTitle=" + cusTitle
				+ ", cusContent=" + cusContent + ", cusRegDt=" + cusRegDt + ", cusModid=" + cusModid + ", cusModdt="
				+ cusModdt + ", cusReply=" + cusReply + "]";
	}


	public CustomerVO(String cusSeq, String userId, String cusCat, String cusTitle, String cusContent, String cusRegDt,
			String cusModid, String cusModdt, String cusReply) {
		this.cusSeq = cusSeq;
		this.userId = userId;
		this.cusCat = cusCat;
		this.cusTitle = cusTitle;
		this.cusContent = cusContent;
		this.cusRegDt = cusRegDt;
		this.cusModid = cusModid;
		this.cusModdt = cusModdt;
		this.cusReply = cusReply;
	}


	
	 
	 
	 
	 
}
