package utils;

import java.awt.geom.Rectangle2D;

import main.Game;

public class HelpMethods {
	
	public static boolean CanMoveHere(float x, float y, float width, float height, int[][] lvlData) {
		
		if(!IsSolid(x,y,lvlData)) 
			if(!IsSolid(x + width, y+ height, lvlData))
				if(!IsSolid(x + width, y+ (height/2), lvlData))
					if(!IsSolid(x+width, y, lvlData))
						if(!IsSolid(x, y + height, lvlData))
							if(!IsSolid(x, y + (height/2), lvlData))
							return true;
		return false;
		
	}
	
	private static boolean IsSolid(float x, float y, int[][] lvlData) {
		int maxWidth = lvlData[0].length * Game.TILES_SIZE;
		if(x < 0 || x >= maxWidth)
			return true;
		if(y < 0 || y >= Game.GAME_HEIGHT)
			return true;
		
		float xIndex = x / Game.TILES_SIZE;
		float yIndex = y / Game.TILES_SIZE;
		
		return IsTileSolid((int) xIndex, (int) yIndex, lvlData);
	}
	
	public static boolean IsTileSolid(int xTile, int yTile, int[][] lvlData) {
			int value = lvlData[yTile][(int) xTile];
		
				if(value >= 55 || value <0 || value != 0)
						return true;
		
		return false;
	}
	
	public static float GetEntityXPosNextToWall(Rectangle2D.Float hitbox, float xSpeed) {
		int currentTile = (int)(hitbox.x/Game.TILES_SIZE);
		
		if(xSpeed > 0) {
			//Right
			int tileXPos = currentTile * Game.TILES_SIZE;
			int xOffset = (int)(Game.TILES_SIZE - hitbox.width);
			return tileXPos + xOffset - 1;
		}
		else{
			//Left
			return currentTile * Game.TILES_SIZE;
		}
	}
	
	public static float GetEntityYPosUnderRoofOrAboveFloor(Rectangle2D.Float hitbox, float airSpeed) {
		
		
		if(airSpeed > 0) {
			int currentTile = (int)((hitbox.y + hitbox.height) / Game.TILES_SIZE);
			//Falling
			int tileYPos = currentTile * Game.TILES_SIZE; 
			int yOffset = (int)(Game.TILES_SIZE - hitbox.height);
			return tileYPos + yOffset - 1;
		}
		else{
			int currentTile = (int)((hitbox.y) / Game.TILES_SIZE);
			//Jumping
			return currentTile * Game.TILES_SIZE;
		}
	}
	
	public static boolean IsEntityOnFloor(Rectangle2D.Float hitbox, int[][] lvlData) {
		if(!IsSolid(hitbox.x, hitbox.y + hitbox.height + 1, lvlData))
			if(!IsSolid(hitbox.x + hitbox.width, hitbox.y + hitbox.height + 1, lvlData))
				return false;
		
		return true;
	}
	
	public static boolean IsFloor(Rectangle2D.Float hitbox, float xSpeed, int[][] lvlData) {
		if(xSpeed > 0)
			return IsSolid(hitbox.x + hitbox.width + xSpeed, hitbox.y + hitbox.height + 1, lvlData);
		else
			return IsSolid(hitbox.x + xSpeed, hitbox.y + hitbox.height + 1, lvlData);
	}
	
	public static boolean IsAllTilesWalkable(int xStart, int xEnd, int y, int[][] lvlData) {
		for(int i = 0; i < xEnd - xStart; i++) {
			if(IsTileSolid(xStart + i, y, lvlData))
				return false;
			if(!IsTileSolid(xStart + i, y + 2, lvlData))
				return false;
		}
		return true;
	}
	
	public static boolean IsSightClear(int[][] lvlData, Rectangle2D.Float firstHitbox,  Rectangle2D.Float secondHitbox, int yTile) {
		int firstXTile = (int)(firstHitbox.x / Game.TILES_SIZE);
		int secondXTile = (int)(secondHitbox.x / Game.TILES_SIZE);
		
		if(firstXTile > secondXTile) 
			return IsAllTilesWalkable(secondXTile, firstXTile, yTile, lvlData);
		else 
			return IsAllTilesWalkable(firstXTile, secondXTile, yTile, lvlData);
		
	}
}
