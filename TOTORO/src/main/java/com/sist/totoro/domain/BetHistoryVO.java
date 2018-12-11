package com.sist.totoro.domain;

import org.springframework.stereotype.Repository;

@Repository
public class BetHistoryVO {
	int gameSeq; 	//폴번호
	String userId;	//사용자아이디
	int betSeq;		//폴더번호
	int betChoice;	//사용자선택
	String betDate;	//베팅시간
	int betCash;	//베팅금액
	double betP;	//배당률	
	int betWprice;	//반환금액
	String betResultString;	//전체 결과 출력할때 사용
	int betReulstNum; //전체결과 입력할때 사용
	int gameResult;	//한폴의 결과
	int betReturn;  //베팅 반환 횟수 : 1을 넘기면 안됨.
	
	public BetHistoryVO() {}

	/**
	 * @return the gameSeq
	 */
	public int getGameSeq() {
		return gameSeq;
	}

	/**
	 * @param gameSeq the gameSeq to set
	 */
	public void setGameSeq(int gameSeq) {
		this.gameSeq = gameSeq;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the betSeq
	 */
	public int getBetSeq() {
		return betSeq;
	}

	/**
	 * @param betSeq the betSeq to set
	 */
	public void setBetSeq(int betSeq) {
		this.betSeq = betSeq;
	}

	/**
	 * @return the betChoice
	 */
	public int getBetChoice() {
		return betChoice;
	}

	/**
	 * @param betChoice the betChoice to set
	 */
	public void setBetChoice(int betChoice) {
		this.betChoice = betChoice;
	}

	/**
	 * @return the betDate
	 */
	public String getBetDate() {
		return betDate;
	}

	/**
	 * @param betDate the betDate to set
	 */
	public void setBetDate(String betDate) {
		this.betDate = betDate;
	}

	/**
	 * @return the betCash
	 */
	public int getBetCash() {
		return betCash;
	}

	/**
	 * @param betCash the betCash to set
	 */
	public void setBetCash(int betCash) {
		this.betCash = betCash;
	}

	/**
	 * @return the betP
	 */
	public double getBetP() {
		return betP;
	}

	/**
	 * @param betP the betP to set
	 */
	public void setBetP(double betP) {
		this.betP = betP;
	}

	/**
	 * @return the betWprice
	 */
	public int getBetWprice() {
		return betWprice;
	}

	/**
	 * @param betWprice the betWprice to set
	 */
	public void setBetWprice(int betWprice) {
		this.betWprice = betWprice;
	}

	/**
	 * @return the betResultString
	 */
	public String getBetResultString() {
		return betResultString;
	}

	/**
	 * @param betResultString the betResultString to set
	 */
	public void setBetResultString(String betResultString) {
		this.betResultString = betResultString;
	}

	/**
	 * @return the betReulstNum
	 */
	public int getBetReulstNum() {
		return betReulstNum;
	}

	/**
	 * @param betReulstNum the betReulstNum to set
	 */
	public void setBetReulstNum(int betReulstNum) {
		this.betReulstNum = betReulstNum;
	}

	/**
	 * @return the gameResult
	 */
	public int getGameResult() {
		return gameResult;
	}

	/**
	 * @param gameResult the gameResult to set
	 */
	public void setGameResult(int gameResult) {
		this.gameResult = gameResult;
	}

	/**
	 * @return the betReturn
	 */
	public int getBetReturn() {
		return betReturn;
	}

	/**
	 * @param betReturn the betReturn to set
	 */
	public void setBetReturn(int betReturn) {
		this.betReturn = betReturn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BetHistoryVO [gameSeq=" + gameSeq + ", userId=" + userId + ", betSeq=" + betSeq + ", betChoice="
				+ betChoice + ", betDate=" + betDate + ", betCash=" + betCash + ", betP=" + betP + ", betWprice="
				+ betWprice + ", betResultString=" + betResultString + ", betReulstNum=" + betReulstNum
				+ ", gameResult=" + gameResult + ", betReturn=" + betReturn + "]";
	}

	public BetHistoryVO(int gameSeq, String userId, int betSeq, int betChoice, String betDate, int betCash, double betP,
			int betWprice, String betResultString, int betReulstNum, int gameResult, int betReturn) {
		super();
		this.gameSeq = gameSeq;
		this.userId = userId;
		this.betSeq = betSeq;
		this.betChoice = betChoice;
		this.betDate = betDate;
		this.betCash = betCash;
		this.betP = betP;
		this.betWprice = betWprice;
		this.betResultString = betResultString;
		this.betReulstNum = betReulstNum;
		this.gameResult = gameResult;
		this.betReturn = betReturn;
	}

	
}
