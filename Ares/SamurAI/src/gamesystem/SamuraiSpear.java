package gamesystem;

import java.awt.Point;

public class SamuraiSpear extends Samurai {

	@Override
	protected int Occupy(int[][] gameMap,Point[] homePositions, Point[] positionsAll, Point position, int samuraiID, int order) {
		
		switch (order) {
		case 1:
			if(position.y + 1 < gameMap[0].length)
				gameMap[position.x][position.y + 1] = samuraiID;
			if(position.y + 2 < gameMap[0].length)
				gameMap[position.x][position.y + 2] = samuraiID;
			if(position.y + 3 < gameMap[0].length)
				gameMap[position.x][position.y + 3] = samuraiID;
			if(position.y + 4 < gameMap[0].length)
				gameMap[position.x][position.y + 4] = samuraiID;
			break;
		case 2:
			if(position.x + 1 < gameMap.length)
				gameMap[position.x + 1][position.y] = samuraiID;
			if(position.x + 2 < gameMap.length)
				gameMap[position.x + 2][position.y] = samuraiID;
			if(position.x + 3 < gameMap.length)
				gameMap[position.x + 3][position.y] = samuraiID;
			if(position.x + 4 < gameMap.length)
				gameMap[position.x + 4][position.y] = samuraiID;
			break;
		case 3:
			if(position.y - 1 < gameMap[0].length)
				gameMap[position.x][position.y - 1] = samuraiID;
			if(position.y - 2 < gameMap[0].length)
				gameMap[position.x][position.y - 2] = samuraiID;
			if(position.y - 3 < gameMap[0].length)
				gameMap[position.x][position.y - 3] = samuraiID;
			if(position.y - 4 < gameMap[0].length)
				gameMap[position.x][position.y - 4] = samuraiID;
			break;
		case 4:
			if(position.y + 1 < gameMap.length)
				gameMap[position.x][position.y + 1] = samuraiID;
			if(position.y + 2 < gameMap.length)
				gameMap[position.x][position.y + 2] = samuraiID;
			if(position.y + 3 < gameMap.length)
				gameMap[position.x][position.y + 3] = samuraiID;
			if(position.y + 4 < gameMap.length)
				gameMap[position.x][position.y + 4] = samuraiID;
			break;

		default:
			break;
		}
		
		
		System.out.println("occupy : " + order);
		return 0;
	}

}
