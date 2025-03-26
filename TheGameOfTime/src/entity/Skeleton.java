package entity;

import static utils.Constants.Directions.LEFT;
import static utils.Constants.EnemyConstants.*;
import static utils.HelpMethods.CanMoveHere;
import static utils.HelpMethods.GetEntityYPosUnderRoofOrAboveFloor;
import static utils.HelpMethods.IsEntityOnFloor;
import static utils.HelpMethods.IsFloor;

import main.Game;

public class Skeleton extends Enemy {

	public Skeleton(float x, float y) {
		super(x, y, SKELETON_WIDTH, SKELETON_HEIGHT, SKELETON);
		initHitbox(x, y, (int) (20 * Game.SCALE), (int) (63 * Game.SCALE));		
		
	}
	
	public void update(int[][] lvlData, Player player) {
		
		updateMove(lvlData, player);
		updateAnimationTick();
		
	}
	
	private void updateMove(int[][] lvlData, Player player) {
		if(firstUpdate) 
			firstUpdateCheck(lvlData);
		
		if(inAir) 
			updateInAir(lvlData);
		else {
			switch(enemyState) {
			case IDLE:
				newState(WALKING);
				break;
			case WALKING:
				
				if(canSeePlayer(lvlData, player)) {
					turnTowardsPlayer(player);
					if(isPlayerCloseForAttack(player))
						newState(ATTACK);
				}
				move(lvlData);
				break;
			}
		}
		
	}
}
