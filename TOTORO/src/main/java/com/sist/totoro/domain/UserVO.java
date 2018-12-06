package com.sist.totoro.domain;

import com.sist.totoro.common.DTO;

public class UserVO extends DTO{

	private String userId      ;/*아이디			*/
	private String userPw      ;/*비밀번호		*/
	private String userAccount ;/*계좌번호		*/
	private String userTel     ;/*전화번호		*/
	private String userPoint   ;/*현재포인트		*/
	private String userAdmin   ;/*관리자유무		*/
	private String userFindq   ;/*비밀번호찾기질문	*/
	private String userFinda   ;/*비밀번호찾기정답	*/
	private String userName    ;/*예금주			*/
	private String userBank    ;/*계좌은행		*/
	private String userModid   ;/*수정자			*/
	private String userModdt   ;/*수정일			*/
	
	
	
	
	public UserVO() {
	}

	public UserVO(String userId, String userPw, String userAccount, String userTel, String userPoint, String userAdmin,
			String userFindq, String userFinda, String userName, String userBank, String userModid, String userModdt) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userAccount = userAccount;
		this.userTel = userTel;
		this.userPoint = userPoint;
		this.userAdmin = userAdmin;
		this.userFindq = userFindq;
		this.userFinda = userFinda;
		this.userName = userName;
		this.userBank = userBank;
		this.userModid = userModid;
		this.userModdt = userModdt;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPw=" + userPw + ", userAccount=" + userAccount + ", userTel="
				+ userTel + ", userPoint=" + userPoint + ", userAdmin=" + userAdmin + ", userFindq=" + userFindq
				+ ", userFinda=" + userFinda + ", userName=" + userName + ", userBank=" + userBank + ", userModid="
				+ userModid + ", userModdt=" + userModdt + "]";
	}

	public String getUserId() {
		return userId;
	}




	public void setUserId(String userId) {
		this.userId = userId;
	}




	public String getUserPw() {
		return userPw;
	}




	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}




	public String getUserAccount() {
		return userAccount;
	}




	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}




	public String getUserTel() {
		return userTel;
	}




	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}




	public String getUserPoint() {
		return userPoint;
	}




	public void setUserPoint(String userPoint) {
		this.userPoint = userPoint;
	}




	public String getUserAdmin() {
		return userAdmin;
	}




	public void setUserAdmin(String userAdmin) {
		this.userAdmin = userAdmin;
	}




	public String getUserFindq() {
		return userFindq;
	}




	public void setUserFindq(String userFindq) {
		this.userFindq = userFindq;
	}




	public String getUserFinda() {
		return userFinda;
	}




	public void setUserFinda(String userFinda) {
		this.userFinda = userFinda;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getUserBank() {
		return userBank;
	}




	public void setUserBank(String userBank) {
		this.userBank = userBank;
	}




	public String getUserModid() {
		return userModid;
	}




	public void setUserModid(String userModid) {
		this.userModid = userModid;
	}




	public String getUserModdt() {
		return userModdt;
	}




	public void setUserModdt(String userModdt) {
		this.userModdt = userModdt;
	}
	                                              

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserVO other = (UserVO) obj;
		if (userAccount == null) {
			if (other.userAccount != null)
				return false;
		} else if (!userAccount.equals(other.userAccount))
			return false;
		if (userAdmin == null) {
			if (other.userAdmin != null)
				return false;
		} else if (!userAdmin.equals(other.userAdmin))
			return false;
		if (userBank == null) {
			if (other.userBank != null)
				return false;
		} else if (!userBank.equals(other.userBank))
			return false;
		if (userFinda == null) {
			if (other.userFinda != null)
				return false;
		} else if (!userFinda.equals(other.userFinda))
			return false;
		if (userFindq == null) {
			if (other.userFindq != null)
				return false;
		} else if (!userFindq.equals(other.userFindq))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userModdt == null) {
			if (other.userModdt != null)
				return false;
		} else if (!userModdt.equals(other.userModdt))
			return false;
		if (userModid == null) {
			if (other.userModid != null)
				return false;
		} else if (!userModid.equals(other.userModid))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPoint == null) {
			if (other.userPoint != null)
				return false;
		} else if (!userPoint.equals(other.userPoint))
			return false;
		if (userPw == null) {
			if (other.userPw != null)
				return false;
		} else if (!userPw.equals(other.userPw))
			return false;
		if (userTel == null) {
			if (other.userTel != null)
				return false;
		} else if (!userTel.equals(other.userTel))
			return false;
		return true;
	}

	
}
