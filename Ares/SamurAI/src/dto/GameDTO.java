package dto;

import java.awt.Point;

/**
 * ��Ϸ���ݴ���� �ɿ���������������г�ʼ��������initDTO���������ڵ���DTO�������ǰ����������г�ʼ��
 * ��Ҫע����ǣ�DTO������ݶ��Ǹ������ݵ�ȫò������������ʱ���޷���֪���е���Ϣ�ģ���ʱ�ṩ�������ߵ�����Ӧ�ô��߼����л��
 * 
 * @author balck_cats
 *
 */
public class GameDTO {

	/**
	 * ��Ϸ��ͼ
	 */
	private int[][] gameMap;

	/**
	 * �ܻغ���
	 */
	private int turnsAll;

	/**
	 * ʣ��غ���
	 */
	private int turnsLeft;

	/**
	 * ��ʿ������Ӫ�ı��
	 */
	private int[] armyIDs;

	/**
	 * ��ʿ�ı��
	 */
	private int[] samuraiIDs;
	
	/**
	 * �������
	 */
	private int[] weaponIDs;

	/**
	 * ����������ܻغ���
	 */
	private int cureAll;

	/**
	 * ����ʣ�µĻغ���
	 */
	private int[] cureLefts;

	/**
	 * �ҵĵص�
	 */
	private Point[] homePositions;

	/**
	 * ��ʿ������
	 */
	private int[] ranks;

	/**
	 * ��ʿ�ڱ���game�еĵĵ÷�
	 */
	private int[] scoresNow;

	/**
	 * ��ʿ���ܵ÷�
	 */
	private int[] scoresSum;

	/**
	 * �ϻغ�ʣ��Ķ���
	 */
	private String[] proActions;

	/**
	 * ��ʿ��λ��
	 */
	private Point[] positions;

	/**
	 * ���������ʿ��λ��
	 * @return ������ʿ��λ��
	 */
	public Point[] getPositions() {
		return positions;
	}

	/**
	 * ��ʿ��״̬
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
		// TODO ���ǲ��õĳ�ʼ����ʽ
		this.scoresSum = new int[] { 0, 0, 0, 0, 0, 0 };
		this.states = new int[] { 0, 0, 0, 0, 0, 0 };
		this.turnsAll = turnsAll;
		this.turnsLeft = turnsAll;
		this.weaponIDs = new int[]{0, 1, 2};

	}

	/**
	 * ��õ�ǰ��ʿ��λ��
	 * 
	 * @return ��ǰ��ʿ��λ��
	 */
	public Point getPosition() {
		Point position;
		position = this.positions[(this.turnsAll - this.turnsLeft) % 6];
		return position;
	}

	/**
	 * ���õ�ǰ��ʿ��λ��
	 * 
	 * @param position
	 *            ���õ�ǰ��ʿ��λ��
	 */
	public void setPosition(Point position) {
		this.positions[(this.turnsAll - this.turnsLeft) % 6] = position;
	}

	/**
	 * ��õ�ǰ��ʿ��״̬
	 * 
	 * @return ��ǰ��ʿ��״̬
	 */
	public int getState() {
		int state;
		state = this.states[(this.turnsAll - this.turnsLeft) % 6];
		return state;
	}

	/**
	 * ����������ʿ��λ��
	 * @param positions ������ʿ��λ��
	 */
	public void setPositions(Point[] positions) {
		this.positions = positions;
	}

	/**
	 * ���õ�ǰ��ʿ��״̬
	 * 
	 * @param state
	 *            ��ǰ��ʿ��״̬
	 */
	public void setState(int state) {
		this.states[(this.turnsAll - this.turnsLeft) % 6] = state;
	}

	/**
	 * �����Ϸ��ͼ���������Ϸ��ͼ��ȫò������ֱ���ṩ��������
	 * 
	 * @return ��Ϸ��ͼȫò
	 */
	public int[][] getGameMap() {
		return gameMap;
	}

	/**
	 * ����ܻغ���
	 * 
	 * @return �ܻغ���
	 */
	public int getTurnsAll() {
		return turnsAll;
	}

	/**
	 * ���ʣ��Ļغ���
	 * 
	 * @return ʣ��غ���
	 */
	public int getTurnsLeft() {
		return turnsLeft;
	}

	/**
	 * ����ʣ��غ���
	 * 
	 * @param turnsLeft
	 *            ʣ��غ���
	 */
	public void setTurnsLeft(int turnsLeft) {
		this.turnsLeft = turnsLeft;
	}

	/**
	 * �����Ӫ���
	 * 
	 * @return ��Ӫ���
	 */
	public int getArmyID() {
		int armyID;
		armyID = armyIDs[(this.turnsAll - this.turnsLeft) % 2];
		return armyID;
	}

	/**
	 * ��õ�ǰ��ʿ���
	 * 
	 * @return ��ǰ��ʿ���
	 */
	public int getSamuraiID() {
		int samuraiID;
		samuraiID = samuraiIDs[(this.turnsAll - this.turnsLeft) % 3];
		return samuraiID;
	}

	/**
	 * �������������ܻغ���
	 * 
	 * @return ��������غ���
	 */
	public int getCureAll() {
		return cureAll;
	}

	/**
	 * ���������ʿ��״̬��ע�������״̬��ȫò������ֱ���ṩ��������
	 * 
	 * @return ������ʿ��״̬
	 */
	public int[] getStates() {
		return states;
	}

	/**
	 * ��õ�ǰ��ʿ����ʣ�µĻغ���
	 * 
	 * @return ��ǰ��ʿ����ʣ�µĻغ���
	 */
	public int getCureLeft() {
		int cureLeft;
		cureLeft = this.cureLefts[(this.turnsAll - this.turnsLeft) % 6];
		return cureLeft;
	}

	/**
	 * ���õ�ǰ��ʿ����ʣ�µĻغ���
	 * 
	 * @param cureLeft
	 *            ��ǰ��ʿ����ʣ�µĻغ���
	 */
	public void setCureLeft(int cureLeft) {
		this.cureLefts[(this.turnsAll - this.turnsLeft) % 6] = cureLeft;
	}

	/**
	 * ���������ʿ�ļҵĵ�ַ
	 * 
	 * @return ������ʿ�ļҵĵ�ַ
	 */
	public Point[] getHomePosition() {
		return homePositions;
	}

	/**
	 * ��õ�ǰ��ʿ������
	 * 
	 * @return ��ǰ��ʿ����
	 */
	public int getRank() {
		int rank;
		rank = this.ranks[(this.turnsAll - this.turnsLeft) % 6];
		return rank;
	}

	/**
	 * ��õ�ǰ��ʿ�ڱ���game�еĵ÷�
	 * 
	 * @return ��ǰ��ʿ�ڱ���game�еĵ÷�
	 */
	public int getScoreNow() {
		int scoreNow;
		scoreNow = this.scoresNow[(this.turnsAll - this.turnsLeft) % 6];
		return scoreNow;
	}

	/**
	 * ���õ�ǰ��ʿ�ڱ���game�еĵ÷�
	 * 
	 * @param scoreNow
	 *            ��ǰ��ʿ�ڱ���game�еĵ÷�
	 */
	public void setScoreNow(int scoreNow) {
		this.scoresNow[(this.turnsAll - this.turnsLeft) % 6] = scoreNow;
	}

	/**
	 * ��õ�ǰ��ʿ���ܵ÷�
	 * 
	 * @return ��ǰ��ʿ���ܵ÷�
	 */
	public int getScoreSum() {
		int scoreSum;
		scoreSum = this.scoresSum[(this.turnsAll - this.turnsLeft) % 6];
		return scoreSum;
	}

	/**
	 * ���õ�ǰ��ʿ���ܵ÷�
	 * 
	 * @param scoreSum
	 *            ��ǰ��ʿ���ܵ÷�
	 */
	public void setScoreSum(int scoreSum) {
		this.scoresSum[(this.turnsAll - this.turnsLeft) % 6] = scoreSum;
	}

	/**
	 * ��õ�ǰ��ʿ�ϻغ�δ��ɵ��ж�
	 * 
	 * @return ��ǰ��ʿ�ϻغ�δ��ɵ��ж�
	 */
	public String getProAction() {
		String proAction = this.proActions[(this.turnsAll - this.turnsLeft) % 6];
		return proAction;
	}

	/**
	 * ���õ�ǰ��ʿ�ϻغ�δ��ɵ��ж�
	 * 
	 * @param proAction
	 *            ��ǰ��ʿ�ϻغ�δ��ɵ��ж�
	 */
	public void setProAction(String proAction) {
		this.proActions[(this.turnsAll - this.turnsLeft) % 6] = proAction;
	}

	/**
	 * ���������ʿ����
	 * @return ������ʿ����
	 */
	public int[] getRanks() {
		return ranks;
	}

	/**
	 * ������ʿ����
	 * @param rank ��ǰ��ʿ����
	 */
	public void setRanks(int rank) {
		this.ranks[(this.turnsAll - this.turnsLeft) % 6] = rank;
	}

	/**
	 * ���������ʿ�÷�
	 * @return ������ʿ�÷�
	 */
	public int[] getScoresSum() {
		return scoresSum;
	}

	/**
	 * ����������
	 * @return �������
	 */
	public int getWeaponID() {
		int weaponID = this.weaponIDs[(this.turnsAll - this.turnsLeft) % 3];
		return weaponID;
	}

	
}
