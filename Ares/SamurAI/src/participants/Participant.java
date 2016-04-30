package participants;

import java.awt.Point;

public abstract class Participant {
	protected int turnsAll;
	protected int armyID;
	protected int samuraiID;
	protected int[] mapSize;
	protected int curePeriod;
	protected Point[] homePositions;
	protected int[] ranks;
	protected int[] scores;

	protected int turnNum;
	protected int cureLeft;
	protected Point[] positions;
	protected int[] statesVisible;
	protected int[][] mapVisible;

	public abstract int Init(int turnsAll, int armyID, int samuraiID, int[] mapSize, int curePeriod,
			Point[] homePositions, int[] ranks, int[] scores);

	public abstract String TurnControl();
	
	protected void SetGameInfo(int turnsAll, int armyID, int samuraiID, int[] mapSize, int curePeriod,
			Point[] homePositions, int[] ranks, int[] scores) {
		this.setTurnsAll(turnsAll);
		this.setArmyID(armyID);
		this.setSamuraiID(samuraiID);
		this.setMapSize(mapSize);
		this.setMapSize(mapSize);
		this.setCurePeriod(curePeriod);
		this.setHomePositions(homePositions);
		this.setRanks(ranks);
		this.setScores(scores);

	}

	protected void SetTurnInfo(int turnNum, int cureLeft, Point[] positions, int[] statesVisible, int[][] mapVisible) {
		this.setTurnNum(turnNum);
		this.setCureLeft(cureLeft);
		this.setPositions(homePositions);
		this.setStatesVisible(statesVisible);
		this.setMapVisible(mapVisible);

	}

	protected void setTurnsAll(int turnsAll) {
		this.turnsAll = turnsAll;
	}

	protected void setArmyID(int armyID) {
		this.armyID = armyID;
	}

	protected void setSamuraiID(int samuraiID) {
		this.samuraiID = samuraiID;
	}

	protected void setMapSize(int[] mapSize) {
		this.mapSize = mapSize;
	}

	protected void setCurePeriod(int curePeriod) {
		this.curePeriod = curePeriod;
	}

	protected void setHomePositions(Point[] homePositions) {
		this.homePositions = homePositions;
	}

	protected void setRanks(int[] ranks) {
		this.ranks = ranks;
	}

	protected void setScores(int[] scores) {
		this.scores = scores;
	}

	protected void setTurnNum(int turnNum) {
		this.turnNum = turnNum;
	}

	protected void setCureLeft(int cureLeft) {
		this.cureLeft = cureLeft;
	}

	protected void setPositions(Point[] positions) {
		this.positions = positions;
	}

	protected void setStatesVisible(int[] statesVisible) {
		this.statesVisible = statesVisible;
	}

	protected void setMapVisible(int[][] mapVisible) {
		this.mapVisible = mapVisible;
	}

}
