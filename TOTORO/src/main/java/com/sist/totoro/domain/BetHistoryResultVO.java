package com.sist.totoro.domain;

public class BetHistoryResultVO {
    private int gameSeq    ;
    private String userId     ;
    private int betSeq     ;
    private String gameHome   ;
    private String gameAway   ;
    private Double gameHp     ;
    private Double gameDp     ;
    private Double gameAp     ;
    private int betChoice  ;
    private int gameResult ;
    
    public BetHistoryResultVO() {}

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

	public BetHistoryResultVO(int gameSeq, String userId, int betSeq, String gameHome, String gameAway, Double gameHp,
			Double gameDp, Double gameAp, int betChoice, int gameResult) {
		super();
		this.gameSeq = gameSeq;
		this.userId = userId;
		this.betSeq = betSeq;
		this.gameHome = gameHome;
		this.gameAway = gameAway;
		this.gameHp = gameHp;
		this.gameDp = gameDp;
		this.gameAp = gameAp;
		this.betChoice = betChoice;
		this.gameResult = gameResult;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BetHistoryResultVO [gameSeq=" + gameSeq + ", userId=" + userId + ", betSeq=" + betSeq + ", gameHome="
				+ gameHome + ", gameAway=" + gameAway + ", gameHp=" + gameHp + ", gameDp=" + gameDp + ", gameAp="
				+ gameAp + ", betChoice=" + betChoice + ", gameResult=" + gameResult + "]";
	}
    
    
}
