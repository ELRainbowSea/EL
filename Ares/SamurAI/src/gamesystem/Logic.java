package gamesystem;

import java.awt.Point;

import dto.GameDTO;

/**
 * ��Ϸ�߼���ĸ��� 
 * 
 * ����Ĺ�������Ҫ�Ĳ���Ϊһ��GameDTO����
 * 
 * �������ڵ��ø���ʱ��Ҫ���Ĳ�������ÿ�غϿ�ʼǰˢ�¸��ࣨ����refresh������
 * 
 * ��������Ҫ���������ݣ���Ӧ�ô�DTO�л��
 * 
 * ��AI�ṩ��AI����ĵ�GameInfo��TurnInfo����UI�ṩ���в����ߣ����������AI����λ�ã�
 * ״̬�������Ƿ�hide���Ƿ�disqualified���� ��ǰ��ͼ��ռ��״̬�����Ա���ҿ����ĵ�ͼ״̬����ʿ����Ϣ
 * ��Ҫ��DTO�л����Ϸ��ͼ��С��������λ�ã��ܻغ�������ǰ��ArmyID��SamuraiID����ǰ��ʿ��������÷�,��ǰ��ʿ��״̬��λ�ã��Ƿ����أ���
 * ��Ҫ�ӿ������л�������׼����ɵ���Ϣ�������Ĳ����� ��Ҫ��AI�л�ø�AI��׼����ɵ���Ϣ�������Ĳ���
 * 
 * @author balck_cats
 *
 */
public abstract class Logic {
	
	//TODO ���panel����
	
	/**
	 * ÿ�غϿ�������������
	 */
	protected static final int COST_LIMIT = 7;
	
	/**
	 * ��ǰ����������
	 */
	protected int cost;

	/**
	 * �����Ϸ���ݶ���
	 */
	protected GameDTO dto;

	/**
	 * ��Ϸ��ͼ����DTO�л�ã��������и��£����������ý���DTO��
	 */
	protected int[][] gameMap;

	/**
	 * ʣ��غ�������DTO�л�ã��������и��£����������ý���DTO��
	 */
	protected int turnsLeft;

	/**
	 * ����ʣ�µĻغ�������DTO�л�ã��������и��£����������ý���DTO��
	 */
	protected int cureLeft;

	/**
	 * ��ǰ��ʿ�ڱ���game�еĵĵ÷֣���DTO�л�ã��������и��£����������ý���DTO��
	 */
	protected int scoreNow;

	/**
	 * ��ǰ��ʿ���ܵ÷֣���DTO�л�ã��ڱ���game�����������и��£����������ý���DTO��
	 */
	protected int scoreSum;

	/**
	 * ������ʿ����
	 */
	protected Samurai samurai;

	/**
	 * �ϻغ�ʣ��Ķ�����Ĭ��Ϊnull����DTO�л�ã��������и��£����������ý���DTO��
	 */
	protected String proAction;
	
	/**
	 * ��ǰ��ʿ��λ��
	 */
	protected Point position;
	
	/**
	 * ��ǰ��ʿ��״̬
	 */
	protected int state;
	
	/**
	 * ������ʿ��״̬
	 */
	protected int[] statesAll;
	
	/**
	 * ������ʿ��λ��
	 */
	protected Point[] positionsAll;
	
	/**
	 * ��ǰ��ʿ�ɼ��������˵�״̬
	 */
	protected int[] statesVisible;
	
	/**
	 * ��ǰ��ʿ�ɼ�����Ϸ��ͼ
	 */
	protected int[][] visibleMap;
	
	/**
	 * ����Ϊ���ڲ���ʱ������ָ���쳣��д�Ŀղ���������
	 */
	public Logic(){};
	
	/**
	 * ������ ���GameDTO���󣬲��Կ��ӵ�ͼ���г�ʼ��
	 * @param dto ���ݴ������
	 */
	public Logic(GameDTO dto){
		this.dto = dto;
		this.visibleMap = new int[this.dto.getGameMap().length][this.dto.getGameMap()[0].length];
	}

	/**
	 * ͳ��GameSystem�������֮��Ľ���
	 */
	public void Communication() {
		// TODO ����������
	}

	/**
	 * �Ը���ʿ�ṩ���ж����д���
	 * 
	 * @param actions
	 *            �ж�ָ���һ��������ɣ�����֮���ÿո����
	 */
	protected abstract void ActionControl(String actions);
	
	protected abstract void Acts(int[] acts);

	/**
	 * ˢ���������GameSystem��ʼͳ��ĻغϵĽ������÷���Ӧ��ÿ�غϿ�ʼ֮ǰ�ɿ���������
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
	 * ��GameDTO�е����ݽ��и���
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
