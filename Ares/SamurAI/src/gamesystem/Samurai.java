package gamesystem;

import java.awt.Point;

public abstract class Samurai {

	protected boolean canMove(int[][] gameMap, Point position, int order) {
		Point temp = new Point();
		temp.x = position.x;
		temp.y = position.y;
		switch (order) {
		case 5:
			temp.y++;
			break;
		case 6:
			temp.x++;
			break;
		case 7:
			temp.y--;
			break;
		case 8:
			temp.x--;
			break;
		default:
			break;
		}
		if (!(0 <= temp.x && temp.x < gameMap.length && 0 <= temp.y && temp.y < gameMap[0].length))
			return false;
		else
			return true;
	}

	protected boolean canHide(int[][] gameMap, Point position, int state) {
		if (state != 0 && gameMap[position.x][position.y] >= 3)
			return false;
		else
			return true;
	}

	protected boolean canShow(int samuraiID, Point[] positionsAll, Point position, int[] statesAll, int state) {
		if (state != 0)
			return false;
		for (int i = 0; i < positionsAll.length; i++) {
			if (positionsAll[i].x == position.x && positionsAll[i].y == position.y) {
				if (i == samuraiID)
					continue;
				else if (statesAll[i] == 0)
					return false;
			}
		}
		return true;
	}

	protected void Move(Point position, int order){
		switch (order) {
		case 5:
			position.y++;
			break;
		case 6:
			position.x++;
			break;
		case 7:
			position.y--;
			break;
		case 8:
			position.x--;
			break;
		default:
			break;
		}
		
	}

	protected abstract int Occupy(int[][] gameMap,Point[] homePositions, Point[] positionsAll, Point position, int samuraiID, int order);

	protected int Hide() {
		System.out.println("hide");
		return 1;
	}

	protected int Show() {
		System.out.println("show");
		return 0;
	}
}
