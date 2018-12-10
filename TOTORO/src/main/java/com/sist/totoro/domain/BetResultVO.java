package com.sist.totoro.domain;

import com.sist.totoro.common.SearchVO;

public class BetResultVO extends SearchVO{

	private String gameDate;		//경기시간
    private String gameHome;	//홈팀
    private String gameAway;	//원정팀
    private String gameHs;		//홈점수
    private String gameAs;		//원정점수
    private String gameResult;	//경기경과
    
    public BetResultVO() {
    	
    }
    
	public String getGameDate() {
		return gameDate;
	}
	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}
	public String getGameHome() {
		return gameHome;
	}
	public void setGameHome(String gameHome) {
		this.gameHome = gameHome;
	}
	public String getGameAway() {
		return gameAway;
	}
	public void setGameAway(String gameAway) {
		this.gameAway = gameAway;
	}
	public String getGameHs() {
		return gameHs;
	}
	public void setGameHs(String gameHs) {
		this.gameHs = gameHs;
	}
	public String getGameAs() {
		return gameAs;
	}
	public void setGameAs(String gameAs) {
		this.gameAs = gameAs;
	}
	public String getGameResult() {
		return gameResult;
	}
	public void setGameResult(String gameResult) {
		this.gameResult = gameResult;
	}
	public BetResultVO(String gameDate, String gameHome, String gameAway, String gameHs, String gameAs,
			String gameResult) {
		super();
		this.gameDate = gameDate;
		this.gameHome = gameHome;
		this.gameAway = gameAway;
		this.gameHs = gameHs;
		this.gameAs = gameAs;
		this.gameResult = gameResult;
	}
	@Override
	public String toString() {
		return "BetResultVO [gameDate=" + gameDate + ", gameHome=" + gameHome + ", gameAway=" + gameAway + ", gameHs="
				+ gameHs + ", gameAs=" + gameAs + ", gameResult=" + gameResult + "]";
	}
	
   
	
    
}
