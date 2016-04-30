package dto;

import java.awt.Point;

/**
 * 游戏数据传输层 由控制器负责对它进行初始化（调用initDTO方法），在调用DTO里的数据前必须对它进行初始化
 * 需要注意的是，DTO里的数据都是该种数据的全貌，而参赛者有时是无法得知所有的信息的，此时提供给参赛者的数据应该从逻辑层中获得
 * 
 * @author balck_cats
 *
 */
public class GameDTO {

	/**
	 * 游戏地图
	 */
	private int[][] gameMap;

	/**
	 * 总回合数
	 */
	private int turnsAll;

	/**
	 * 剩余回合数
	 */
	private int turnsLeft;

	/**
	 * 武士所在阵营的编号
	 */
	private int[] armyIDs;

	/**
	 * 武士的编号
	 */
	private int[] samuraiIDs;
	
	/**
	 * 武器编号
	 */
	private int[] weaponIDs;

	/**
	 * 治愈所需的总回合数
	 */
	private int cureAll;

	/**
	 * 治愈剩下的回合数
	 */
	private int[] cureLefts;

	/**
	 * 家的地点
	 */
	private Point[] homePositions;

	/**
	 * 武士的排名
	 */
	private int[] ranks;

	/**
	 * 武士在本场game中的的得分
	 */
	private int[] scoresNow;

	/**
	 * 武士的总得分
	 */
	private int[] scoresSum;

	/**
	 * 上回合剩余的动作
	 */
	private String[] proActions;

	/**
	 * 武士的位置
	 */
	private Point[] positions;

	/**
	 * 获得所有武士的位置
	 * @return 所有武士的位置
	 */
	public Point[] getPositions() {
		return positions;
	}

	/**
	 * 武士的状态
	 */
	private int[] states;

	public GameDTO() {
		super();
	}

	public void initDTO(int turnsAll, int w, int h, int cureAll, Point[] homePositions) {
		this.armyIDs = new int[] { 1, 2 };
		this.cureAll = cureAll;
		this.cureLefts = new int[] { 0, 0, 0, 0, 0, 0 };
		this.gameMap = new int[w][h];
		for (int i = 0; i < this.gameMap.length; i++) {
			for (int j = 0; j < this.gameMap[i].length; j++) {
				this.gameMap[i][j] = 8;
			}
		}
		this.homePositions = homePositions;
		this.positions = new Point[6];
		for (int i = 0; i < this.positions.length; i++) {
			positions[i].x = this.homePositions[i].x;
			positions[i].y = this.homePositions[i].y;
		}
		this.proActions = new String[] { null, null, null, null, null, null };
		this.ranks = new int[] { 0, 0, 0, 0, 0, 0 };
		this.samuraiIDs = new int[] { 0, 1, 2 , 3, 4, 5};
		this.scoresNow = new int[] { 0, 0, 0, 0, 0, 0 };
		// TODO 这是不好的初始化方式
		this.scoresSum = new int[] { 0, 0, 0, 0, 0, 0 };
		this.states = new int[] { 0, 0, 0, 0, 0, 0 };
		this.turnsAll = turnsAll;
		this.turnsLeft = turnsAll;
		this.weaponIDs = new int[]{0, 1, 2};

	}

	/**
	 * 获得当前武士的位置
	 * 
	 * @return 当前武士的位置
	 */
	public Point getPosition() {
		Point position;
		position = this.positions[(this.turnsAll - this.turnsLeft) % 6];
		return position;
	}

	/**
	 * 设置当前武士的位置
	 * 
	 * @param position
	 *            设置当前武士的位置
	 */
	public void setPosition(Point position) {
		this.positions[(this.turnsAll - this.turnsLeft) % 6] = position;
	}

	/**
	 * 获得当前武士的状态
	 * 
	 * @return 当前武士的状态
	 */
	public int getState() {
		int state;
		state = this.states[(this.turnsAll - this.turnsLeft) % 6];
		return state;
	}

	/**
	 * 设置所有武士的位置
	 * @param positions 所有武士的位置
	 */
	public void setPositions(Point[] positions) {
		this.positions = positions;
	}

	/**
	 * 设置当前武士的状态
	 * 
	 * @param state
	 *            当前武士的状态
	 */
	public void setState(int state) {
		this.states[(this.turnsAll - this.turnsLeft) % 6] = state;
	}

	/**
	 * 获得游戏地图，这里的游戏地图是全貌，不能直接提供给参赛者
	 * 
	 * @return 游戏地图全貌
	 */
	public int[][] getGameMap() {
		return gameMap;
	}

	/**
	 * 获得总回合数
	 * 
	 * @return 总回合数
	 */
	public int getTurnsAll() {
		return turnsAll;
	}

	/**
	 * 获得剩余的回合数
	 * 
	 * @return 剩余回合数
	 */
	public int getTurnsLeft() {
		return turnsLeft;
	}

	/**
	 * 设置剩余回合数
	 * 
	 * @param turnsLeft
	 *            剩余回合数
	 */
	public void setTurnsLeft(int turnsLeft) {
		this.turnsLeft = turnsLeft;
	}

	/**
	 * 获得阵营编号
	 * 
	 * @return 阵营编号
	 */
	public int getArmyID() {
		int armyID;
		armyID = armyIDs[(this.turnsAll - this.turnsLeft) % 2];
		return armyID;
	}

	/**
	 * 获得当前武士编号
	 * 
	 * @return 当前武士编号
	 */
	public int getSamuraiID() {
		int samuraiID;
		samuraiID = samuraiIDs[(this.turnsAll - this.turnsLeft) % 3];
		return samuraiID;
	}

	/**
	 * 获得治愈所需的总回合数
	 * 
	 * @return 治愈所需回合数
	 */
	public int getCureAll() {
		return cureAll;
	}

	/**
	 * 获得所有武士的状态，注意这里的状态是全貌，不能直接提供给参赛者
	 * 
	 * @return 所有武士的状态
	 */
	public int[] getStates() {
		return states;
	}

	/**
	 * 获得当前武士治愈剩下的回合数
	 * 
	 * @return 当前武士治愈剩下的回合数
	 */
	public int getCureLeft() {
		int cureLeft;
		cureLeft = this.cureLefts[(this.turnsAll - this.turnsLeft) % 6];
		return cureLeft;
	}

	/**
	 * 设置当前武士治愈剩下的回合数
	 * 
	 * @param cureLeft
	 *            当前武士治愈剩下的回合数
	 */
	public void setCureLeft(int cureLeft) {
		this.cureLefts[(this.turnsAll - this.turnsLeft) % 6] = cureLeft;
	}

	/**
	 * 获得所有武士的家的地址
	 * 
	 * @return 所有武士的家的地址
	 */
	public Point[] getHomePosition() {
		return homePositions;
	}

	/**
	 * 获得当前武士的排名
	 * 
	 * @return 当前武士排名
	 */
	public int getRank() {
		int rank;
		rank = this.ranks[(this.turnsAll - this.turnsLeft) % 6];
		return rank;
	}

	/**
	 * 获得当前武士在本场game中的得分
	 * 
	 * @return 当前武士在本场game中的得分
	 */
	public int getScoreNow() {
		int scoreNow;
		scoreNow = this.scoresNow[(this.turnsAll - this.turnsLeft) % 6];
		return scoreNow;
	}

	/**
	 * 设置当前武士在本场game中的得分
	 * 
	 * @param scoreNow
	 *            当前武士在本场game中的得分
	 */
	public void setScoreNow(int scoreNow) {
		this.scoresNow[(this.turnsAll - this.turnsLeft) % 6] = scoreNow;
	}

	/**
	 * 获得当前武士的总得分
	 * 
	 * @return 当前武士的总得分
	 */
	public int getScoreSum() {
		int scoreSum;
		scoreSum = this.scoresSum[(this.turnsAll - this.turnsLeft) % 6];
		return scoreSum;
	}

	/**
	 * 设置当前武士的总得分
	 * 
	 * @param scoreSum
	 *            当前武士的总得分
	 */
	public void setScoreSum(int scoreSum) {
		this.scoresSum[(this.turnsAll - this.turnsLeft) % 6] = scoreSum;
	}

	/**
	 * 获得当前武士上回合未完成的行动
	 * 
	 * @return 当前武士上回合未完成的行动
	 */
	public String getProAction() {
		String proAction = this.proActions[(this.turnsAll - this.turnsLeft) % 6];
		return proAction;
	}

	/**
	 * 设置当前武士上回合未完成的行动
	 * 
	 * @param proAction
	 *            当前武士上回合未完成的行动
	 */
	public void setProAction(String proAction) {
		this.proActions[(this.turnsAll - this.turnsLeft) % 6] = proAction;
	}

	/**
	 * 获得所有武士排名
	 * @return 所有武士排名
	 */
	public int[] getRanks() {
		return ranks;
	}

	/**
	 * 设置武士排名
	 * @param rank 当前武士排名
	 */
	public void setRanks(int rank) {
		this.ranks[(this.turnsAll - this.turnsLeft) % 6] = rank;
	}

	/**
	 * 获得所有武士得分
	 * @return 所有武士得分
	 */
	public int[] getScoresSum() {
		return scoresSum;
	}

	/**
	 * 获得武器编号
	 * @return 武器编号
	 */
	public int getWeaponID() {
		int weaponID = this.weaponIDs[(this.turnsAll - this.turnsLeft) % 3];
		return weaponID;
	}

	
}
