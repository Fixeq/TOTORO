package com.sist.totoro.domain;

import java.util.Date;

import com.sist.totoro.common.DTO;

public class CrossVO extends DTO {

	private int gameSeq     ;//게임번호
	private String gameHome    ;//홈팀이름
	private String gameAway    ;//원정팀이름
	private Double gameHp      ;//홈팀배당률
	private Double gameDp      ;//무승부배당률
	private Double gameAp      ;//원정팀배당률
	private String gameDate    ;//경기시작시간
	private int gameResult  ;//경기결과
	private int gameHs      ;//홈팀점수
	private int gameAs      ;//원정팀점수
	private String gameRegId   ;//등록자id
	private String gameRegDt   ;//등록일
	private String gameModId   ;//수정자id
	private String gameModDt   ;//수정일

	public CrossVO() {}

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
	 * @return the gameHome
	 */
	public String getGameHome() {
		return gameHome;
	}

	/**
	 * @param gameHome the gameHome to set
	 */
	public void setGameHome(String gameHome) {
		this.gameHome = gameHome;
	}

	/**
	 * @return the gameAway
	 */
	public String getGameAway() {
		return gameAway;
	}

	/**
	 * @param gameAway the gameAway to set
	 */
	public void setGameAway(String gameAway) {
		this.gameAway = gameAway;
	}

	/**
	 * @return the gameHp
	 */
	public Double getGameHp() {
		return gameHp;
	}

	/**
	 * @param gameHp the gameHp to set
	 */
	public void setGameHp(Double gameHp) {
		this.gameHp = gameHp;
	}

	/**
	 * @return the gameDp
	 */
	public Double getGameDp() {
		return gameDp;
	}

	/**
	 * @param gameDp the gameDp to set
	 */
	public void setGameDp(Double gameDp) {
		this.gameDp = gameDp;
	}

	/**
	 * @return the gameAp
	 */
	public Double getGameAp() {
		return gameAp;
	}

	/**
	 * @param gameAp the gameAp to set
	 */
	public void setGameAp(Double gameAp) {
		this.gameAp = gameAp;
	}

	/**
	 * @return the gameDate
	 */
	public String getGameDate() {
		return gameDate;
	}

	/**
	 * @param gameDate the gameDate to set
	 */
	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
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
	 * @return the gameHs
	 */
	public int getGameHs() {
		return gameHs;
	}

	/**
	 * @param gameHs the gameHs to set
	 */
	public void setGameHs(int gameHs) {
		this.gameHs = gameHs;
	}

	/**
	 * @return the gameAs
	 */
	public int getGameAs() {
		return gameAs;
	}

	/**
	 * @param gameAs the gameAs to set
	 */
	public void setGameAs(int gameAs) {
		this.gameAs = gameAs;
	}

	/**
	 * @return the gameRegId
	 */
	public String getGameRegId() {
		return gameRegId;
	}

	/**
	 * @param gameRegId the gameRegId to set
	 */
	public void setGameRegId(String gameRegId) {
		this.gameRegId = gameRegId;
	}

	/**
	 * @return the gameRegDt
	 */
	public String getGameRegDt() {
		return gameRegDt;
	}

	/**
	 * @param gameRegDt the gameRegDt to set
	 */
	public void setGameRegDt(String gameRegDt) {
		this.gameRegDt = gameRegDt;
	}

	/**
	 * @return the gameModId
	 */
	public String getGameModId() {
		return gameModId;
	}

	/**
	 * @param gameModId the gameModId to set
	 */
	public void setGameModId(String gameModId) {
		this.gameModId = gameModId;
	}

	/**
	 * @return the gameModDt
	 */
	public String getGameModDt() {
		return gameModDt;
	}

	/**
	 * @param gameModDt the gameModDt to set
	 */
	public void setGameModDt(String gameModDt) {
		this.gameModDt = gameModDt;
	}

	public CrossVO(int gameSeq, String gameHome, String gameAway, Double gameHp, Double gameDp, Double gameAp,
			String gameDate, int gameResult, int gameHs, int gameAs, String gameRegId, String gameRegDt,
			String gameModId, String gameModDt) {
		super();
		this.gameSeq = gameSeq;
		this.gameHome = gameHome;
		this.gameAway = gameAway;
		this.gameHp = gameHp;
		this.gameDp = gameDp;
		this.gameAp = gameAp;
		this.gameDate = gameDate;
		this.gameResult = gameResult;
		this.gameHs = gameHs;
		this.gameAs = gameAs;
		this.gameRegId = gameRegId;
		this.gameRegDt = gameRegDt;
		this.gameModId = gameModId;
		this.gameModDt = gameModDt;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CrossVO [gameSeq=" + gameSeq + ", gameHome=" + gameHome + ", gameAway=" + gameAway + ", gameHp="
				+ gameHp + ", gameDp=" + gameDp + ", gameAp=" + gameAp + ", gameDate=" + gameDate + ", gameResult="
				+ gameResult + ", gameHs=" + gameHs + ", gameAs=" + gameAs + ", gameRegId=" + gameRegId + ", gameRegDt="
				+ gameRegDt + ", gameModId=" + gameModId + ", gameModDt=" + gameModDt + "]";
	}


	

}
