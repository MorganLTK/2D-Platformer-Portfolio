package unused;



import java.awt.Rectangle;

import entity.Entity;

public class CollisionChecker {
	
//	GamePanel gp;
//	
//	public Rectangle hitbox;
//	public CollisionChecker(GamePanel gp) {
//		this.gp = gp;
//		hitbox = new Rectangle();
//		}
//	
//	public void checkTile(Entity entity, String direction) {
//		int entityLeftWorldX = entity.worldX + entity.hitbox.x;
//		int entityRightWorldX = entity.worldX + entity.hitbox.x + entity.hitbox.width;
//		int entityTopWorldY = entity.worldY + entity.hitbox.y;
//		int entityBottomWorldY = entity.worldY + entity.hitbox.y + entity.hitbox.height;
//		
//		int entityLeftCol = entityLeftWorldX/gp.ORIGINAL_TILE_SIZE;
//		int entityRightCol = entityRightWorldX/gp.ORIGINAL_TILE_SIZE;
//		int entityTopRow = entityTopWorldY/gp.ORIGINAL_TILE_SIZE;
//		int entityBottomRow = (entityBottomWorldY)/gp.ORIGINAL_TILE_SIZE;
//		hitbox = new Rectangle(entityLeftWorldX, entityTopWorldY, entity.hitbox.width, entity.hitbox.height);
//
//		
//		switch(direction) {
//		case "up":
//			entityTopRow = (entityTopWorldY - entity.verticalSpeed)/gp.ORIGINAL_TILE_SIZE;
//			if(gp.tileM.worldTiles[entityLeftCol][entityTopRow].collision || gp.tileM.worldTiles[entityRightCol][entityTopRow].collision) {
//				entity.collisionOn = true;
//			}
//			break;
//		
//		case "right":
//			entityRightCol = (entityRightWorldX + entity.horizontalSpeed)/gp.ORIGINAL_TILE_SIZE;
//			//System.out.print(gp.tileM.worldTiles[entityRightCol][entityBottomRow].collision + " " + entityRightCol);
//			if(gp.tileM.worldTiles[entityRightCol][entityBottomRow].collision || gp.tileM.worldTiles[entityRightCol][entityTopRow].collision) {
//				entity.collisionOn = true;
//			}
//			break;
//		case "left":
//			entityLeftCol = (entityLeftWorldX - entity.horizontalSpeed)/gp.ORIGINAL_TILE_SIZE;
//			//System.out.print(gp.tileM.worldTiles[entityLeftCol][entityBottomRow].collision + " " + (entityLeftCol));
//			if(gp.tileM.worldTiles[entityLeftCol][entityBottomRow].collision || gp.tileM.worldTiles[entityLeftCol][entityTopRow].collision) {
//				entity.collisionOn = true;
//			}
//			break;
//		case "down":
//			entityBottomRow = (entityBottomWorldY + 4)/gp.ORIGINAL_TILE_SIZE;
//			if(gp.tileM.worldTiles[entityLeftCol][entityBottomRow].collision || gp.tileM.worldTiles[entityRightCol][entityBottomRow].collision) {
//			
//				entity.collisionOn = true;
//			}
//			break;
//		}
//		
//		
//		
//	}
}
