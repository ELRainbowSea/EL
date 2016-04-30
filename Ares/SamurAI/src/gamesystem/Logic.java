package gamesystem;

import java.awt.Point;

import dto.GameDTO;

/**
 * 游戏逻辑层的父类 
 * 
 * 该类的构造器需要的参数为一个GameDTO对象
 * 
 * 控制器在调用该类时需要做的操作：在每回合开始前刷新该类（调用refresh方法）
 * 
 * 控制器需要的其他数据，则应该从DTO中获得
 * 
 * 向AI提供该AI所需的的GameInfo与TurnInfo；向UI提供所有参赛者（包括玩家与AI）的位置，
 * 状态（包括是否hide与是否disqualified）， 当前地图的占领状态，可以被玩家看见的地图状态和武士的信息
 * 需要从DTO中获得游戏地图大小，出生点位置，总回合数，当前的ArmyID与SamuraiID，当前武士的排名与得分,当前武士的状态（位置，是否隐藏）；
 * 需要从控制器中获得玩家已准备完成的信息与所做的操作； 需要从AI中获得该AI已准备完成的信息与所做的操作
 * 
 * @author balck_cats
 *
 */
public abstract class Logic {
	
	//TODO 获得panel对象
	
	/**
	 * 每回合可做出的总消费
	 */
	protected static final int COST_LIMIT = 7;
	
	/**
	 * 当前做出的消费
	 */
	protected int cost;

	/**
	 * 获得游戏数据对象
	 */
	protected GameDTO dto;

	/**
	 * 游戏地图，从DTO中获得，对它进行更新，并重新设置进回DTO中
	 */
	protected int[][] gameMap;

	/**
	 * 剩余回合数，从DTO中获得，对它进行更新，并重新设置进回DTO中
	 */
	protected int turnsLeft;

	/**
	 * 治愈剩下的回合数，从DTO中获得，对它进行更新，并重新设置进回DTO中
	 */
	protected int cureLeft;

	/**
	 * 当前武士在本场game中的的得分，从DTO中获得，对它进行更新，并重新设置进回DTO中
	 */
	protected int scoreNow;

	/**
	 * 当前武士的总得分，从DTO中获得，在本场game的最后对它进行更新，并重新设置进回DTO中
	 */
	protected int scoreSum;

	/**
	 * 建立武士对象
	 */
	protected Samurai samurai;

	/**
	 * 上回合剩余的动作，默认为null，从DTO中获得，对它进行更新，并重新设置进回DTO中
	 */
	protected String proAction;
	
	/**
	 * 当前武士的位置
	 */
	protected Point position;
	
	/**
	 * 当前武士的状态
	 */
	protected int state;
	
	/**
	 * 所有武士的状态
	 */
	protected int[] statesAll;
	
	/**
	 * 所有武士的位置
	 */
	protected Point[] positionsAll;
	
	/**
	 * 当前武士可见的所有人的状态
	 */
	protected int[] statesVisible;
	
	/**
	 * 当前武士可见的游戏地图
	 */
	protected int[][] visibleMap;
	
	/**
	 * 这是为了在测试时不报空指针异常而写的空参数构造器
	 */
	public Logic(){};
	
	/**
	 * 构造器 获得GameDTO对象，并对可视地图进行初始化
	 * @param dto 数据传输对象
	 */
	public Logic(GameDTO dto){
		this.dto = dto;
		this.visibleMap = new int[this.dto.getGameMap().length][this.dto.getGameMap()[0].length];
	}

	/**
	 * 统筹GameSystem与参赛方之间的交流
	 */
	public void Communication() {
		// TODO 交流的流程
	}

	/**
	 * 对该武士提供的行动进行处理
	 * 
	 * @param actions
	 *            行动指令，由一串整数组成，整数之间用空格隔开
	 */
	protected abstract void ActionControl(String actions);
	
	protected abstract void Acts(int[] acts);

	/**
	 * 刷新组件并让GameSystem开始统筹改回合的交流，该方法应在每回合开始之前由控制器调用
	 */
	public void refresh() {
		
		this.cost = 0;
		
		this.cureLeft = this.dto.getCureLeft();
		this.gameMap = this.dto.getGameMap();
		this.proAction = this.dto.getProAction();
		this.scoreNow = this.dto.getScoreNow();
		this.scoreSum = this.dto.getScoreSum();
		this.turnsLeft = this.dto.getTurnsLeft();
		this.positionsAll = this.dto.getPositions();
		this.position = this.dto.getPosition();
		this.state = this.dto.getState();
		this.statesAll = this.dto.getStates();
		
		if(this.dto.getSamuraiID() == 0)
			this.samurai = new SamuraiSpear();
		else if(this.dto.getSamuraiID() == 1)
			this.samurai = new SamuraiSword();
		else
			this.samurai = new SamuraiBattleax();
		
		this.Communication();
	}
	
	/**
	 * 对GameDTO中的数据进行更新
	 */
	protected void ReSetDTO(){
		this.dto.setTurnsLeft(turnsLeft);
		this.dto.setScoreNow(scoreNow);
		this.dto.setProAction(proAction);
		this.dto.setCureLeft(cureLeft);
		this.dto.setPositions(positionsAll);
		this.dto.setPosition(position);
		this.dto.setState(state);
		if(this.turnsLeft < 6)
			this.dto.setScoreSum(scoreSum + scoreNow);
	}

	public int[] getstatesVisible() {
		return statesVisible;
	}

	public int[][] getVisibleMap() {
		return visibleMap;
	}

}
