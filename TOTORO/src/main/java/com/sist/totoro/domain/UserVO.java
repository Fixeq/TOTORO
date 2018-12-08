package com.sist.totoro.domain;

import com.sist.totoro.common.DTO;

public class UserVO extends DTO{

	private String userId        ;/*아이디           	*/ 
	private String userPw        ;/*비밀번호          	*/ 
	private String userEmail     ;/*이메일            	*/ 
	private String userName      ;/*예금주            	*/ 
	private String userBank      ;/*계좌은행          	*/ 
	private String userAccount   ;/*계좌번호          	*/ 
	private String userTel       ;/*전화번호          	*/ 
	private String userFindQ     ;/*비밀번호찾기질문  	*/ 
	private String userFindA     ;/*비밀번호찾기정답  	*/ 
	private String userAdmin     ;/*관리자유무		*/
	private String userPoint     ;/*현재포인트		*/ 
	private String userRegDt     ;/*가입일			*/ 
	private String userModId     ;/*수정자			*/ 
	private String userModDt     ;/*수정일            	*/ 
	private String userAppStt    ;/*인증여부          	*/ 
	private String userAppKey    ;/*인증키            	*/
	
	public UserVO() {	}

	public UserVO(String userId, String userPw, String userEmail, String userName, String userBank, String userAccount,
			String userTel, String userFindQ, String userFindA, String userAdmin, String userPoint, String userRegDt,
			String userModId, String userModDt, String userAppStt, String userAppKey) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userEmail = userEmail;
		this.userName = userName;
		this.userBank = userBank;
		this.userAccount = userAccount;
		this.userTel = userTel;
		this.userFindQ = userFindQ;
		this.userFindA = userFindA;
		this.userAdmin = userAdmin;
		this.userPoint = userPoint;
		this.userRegDt = userRegDt;
		this.userModId = userModId;
		this.userModDt = userModDt;
		this.userAppStt = userAppStt;
		this.userAppKey = userAppKey;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPw=" + userPw + ", userEmail=" + userEmail + ", userName=" + userName
				+ ", userBank=" + userBank + ", userAccount=" + userAccount + ", userTel=" + userTel + ", userFindQ="
				+ userFindQ + ", userFindA=" + userFindA + ", userAdmin=" + userAdmin + ", userPoint=" + userPoint
				+ ", userRegDt=" + userRegDt + ", userModId=" + userModId + ", userModDt=" + userModDt + ", userAppStt="
				+ userAppStt + ", userAppKey=" + userAppKey + "]";
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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

	public String getUserFindQ() {
		return userFindQ;
	}

	public void setUserFindQ(String userFindQ) {
		this.userFindQ = userFindQ;
	}

	public String getUserFindA() {
		return userFindA;
	}

	public void setUserFindA(String userFindA) {
		this.userFindA = userFindA;
	}

	public String getUserAdmin() {
		return userAdmin;
	}

	public void setUserAdmin(String userAdmin) {
		this.userAdmin = userAdmin;
	}

	public String getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(String userPoint) {
		this.userPoint = userPoint;
	}

	public String getUserRegDt() {
		return userRegDt;
	}

	public void setUserRegDt(String userRegDt) {
		this.userRegDt = userRegDt;
	}

	public String getUserModId() {
		return userModId;
	}

	public void setUserModId(String userModId) {
		this.userModId = userModId;
	}

	public String getUserModDt() {
		return userModDt;
	}

	public void setUserModDt(String userModDt) {
		this.userModDt = userModDt;
	}

	public String getUserAppStt() {
		return userAppStt;
	}

	public void setUserAppStt(String userAppStt) {
		this.userAppStt = userAppStt;
	}

	public String getUserAppKey() {
		return userAppKey;
	}

	public void setUserAppKey(String userAppKey) {
		this.userAppKey = userAppKey;
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
		if (userAppKey == null) {
			if (other.userAppKey != null)
				return false;
		} else if (!userAppKey.equals(other.userAppKey))
			return false;
		if (userAppStt == null) {
			if (other.userAppStt != null)
				return false;
		} else if (!userAppStt.equals(other.userAppStt))
			return false;
		if (userBank == null) {
			if (other.userBank != null)
				return false;
		} else if (!userBank.equals(other.userBank))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userFindA == null) {
			if (other.userFindA != null)
				return false;
		} else if (!userFindA.equals(other.userFindA))
			return false;
		if (userFindQ == null) {
			if (other.userFindQ != null)
				return false;
		} else if (!userFindQ.equals(other.userFindQ))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userModDt == null) {
			if (other.userModDt != null)
				return false;
		} else if (!userModDt.equals(other.userModDt))
			return false;
		if (userModId == null) {
			if (other.userModId != null)
				return false;
		} else if (!userModId.equals(other.userModId))
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
		if (userRegDt == null) {
			if (other.userRegDt != null)
				return false;
		} else if (!userRegDt.equals(other.userRegDt))
			return false;
		if (userTel == null) {
			if (other.userTel != null)
				return false;
		} else if (!userTel.equals(other.userTel))
			return false;
		return true;
	}

	
	
	
	
}