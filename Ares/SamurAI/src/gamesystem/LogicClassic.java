package gamesystem;

import dto.GameDTO;
import util.Util;

/**
 * 经典模式调用的逻辑层，逻辑层的具体用法参见Logic类的注释
 * 
 * @author balck_cats
 *
 */
public class LogicClassic extends Logic {

	public LogicClassic(GameDTO dto) {
		super(dto);
	}

	public LogicClassic() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void ActionControl(String actions) {
		if (this.cureLeft > 0) {
			proAction = null;// ? 规则不清
			cureLeft--;
			return;
		}
		if (this.proAction != null) {
			int[] proActs = Util.toInts(this.proAction);
			Acts(proActs);
		}
		int[] acts = Util.toInts(actions);
		Acts(acts);
		this.turnsLeft--;
		// TODO 更新对当前武士来说可视的状态信息
		// TODO 更新对当前武士来说可视的地图信息
	}

	@Override
	protected void Acts(int[] acts) {
		for (int i = 0; i < acts.length; i++) {
			if (acts[i] == 0) {
				if (i != acts.length - 1)
					this.proAction = Util.toStr(acts, 0);
				else
					this.proAction = null;
				break;
			}
			if (1 <= acts[i] && acts[i] <= 10) {
				if (1 <= acts[i] && acts[i] <= 4) {
					this.cost += 4;
					if (this.cost <= Logic.COST_LIMIT)
						this.scoreNow = this.samurai.Occupy(gameMap, this.dto.getHomePosition(), this.positionsAll,
								this.position, this.dto.getSamuraiID(), acts[i]);
					else
						break;
				} else if (5 <= acts[i] && acts[i] <= 8) {
					this.cost += 2;
					if (this.samurai.canMove(gameMap, this.position, acts[i]) && this.cost <= Logic.COST_LIMIT) {
						this.samurai.Move(this.position, acts[i]);
						this.positionsAll[this.dto.getSamuraiID()] = this.position;
					} else
						break;
				} else if (acts[i] == 9) {
					this.cost += 1;
					if (this.samurai.canHide(gameMap, this.position, this.state) && this.cost <= Logic.COST_LIMIT)
						this.state = this.samurai.Hide();
					else
						break;
				} else if (acts[i] == 10) {
					this.cost += 1;
					if (this.samurai.canShow(this.dto.getSamuraiID(), this.positionsAll, this.position, this.statesAll,
							this.state) && this.cost <= Logic.COST_LIMIT)
						this.state = this.samurai.Show();
					else
						break;
				}
			}
		}

	}

//	public static void main(String[] args) {
//		Logic l = new LogicClassic();
//		l.proAction = null;
//		l.samurai = new SamuraiSpear();
//		l.cureLeft = 0;
//		l.ActionControl("1 9 0 8 9 0");
//		System.out.println();
//		l.cost = 0;
//		l.ActionControl("3 9 0");
//	}

}
