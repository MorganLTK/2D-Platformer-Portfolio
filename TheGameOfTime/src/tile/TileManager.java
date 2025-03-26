package tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import main.GamePanel;
import unused.BufferedImageLoader;
import unused.SpriteSheet;
import utils.LoadSave;

public class TileManager {
	
	GamePanel gp;
	public Tile[] bricks, windows, floors;
	
	public Tile[][] worldTiles;
	
	public int mapTileNum[][];
	public char mapTileChar[][];
	
	BufferedImage atlas;
	public ArrayList<Tile> tiles = new ArrayList<>();
	
	public TileManager(GamePanel gp){
		
		this.gp = gp;
		
		mapTileNum = new int[gp.MAX_WORLD_COL * 2][gp.MAX_WORLD_ROW * 2];
		mapTileChar = new char[gp.MAX_WORLD_COL * 2][gp.MAX_WORLD_ROW * 2];
		worldTiles = new Tile[gp.MAX_WORLD_COL * 2][gp.MAX_WORLD_ROW * 2];
		init();
		//loadMap("/maps/default_map.txt");
	}
	
//	public void loadMap(String filePath) {
//		try {
//			
//			InputStream is = getClass().getResourceAsStream(filePath);
//			BufferedReader br = new BufferedReader(new InputStreamReader(is));
//			
//			int col = 0;
//			int row = 0;
//			
//			while(col < gp.MAX_WORLD_COL * 2 && row < gp.MAX_WORLD_ROW * 2) {
//				
//				String line = br.readLine();
//				
//				while(col < gp.MAX_WORLD_COL * 2) {
//					String numbers[] = line.split(" ");
//					String temp = numbers[col];
//					
//					
//					mapTileChar[col][row] = temp.charAt(0);
//					temp = numbers[col].substring(1,numbers[col].length());
//					int num = Integer.parseInt(temp);
//					mapTileNum[col][row] = num;
//					
//					switch (mapTileChar[col][row]) {
//					case 'b':
//						worldTiles[col][row] = bricks[num];
//						break;
//					case 'w':
//						worldTiles[col][row] = windows[num];
//						break;
//					case 'f':
//						worldTiles[col][row] = floors[num];
//						break;
//					}
//					
//					col++;
//					
//					
//				}
//				if(col == gp.MAX_WORLD_COL * 2) {
//					col = 0;
//					row++;
//				}
//			}
//			br.close();
//		}catch(Exception e) {
//			System.out.println("Your code is shit dumbass");
//		}
//		
//	}
	public void init(){
    	
		//atlas = LoadSave.GetSpriteAtlas("/tiles/bricks.png");	
		//bricks = fillArray(false);
		//atlas = LoadSave.GetSpriteAtlas("/tiles/window.png");	
		//windows = fillArray(false);
		//atlas = LoadSave.GetSpriteAtlas("/tiles/floors.png");
		//floors = fillArray(true);
			
		
    	//createTiles(bricks);
    	//createTiles(windows);
    	//createTiles(floors);
    }
	
	public Tile[] fillArray(boolean collision) {
		SpriteSheet ss;
		Tile[] arr;
		ss = new SpriteSheet(atlas, 32);
    	arr = new Tile[ss.length];
    	
    	for(int i = 0; i < ss.length; i++) {
    		arr[i] = new Tile(ss.grabImage(i, 0));  		
    		arr[i].collision = collision;
    	}
    	return arr;
	}
	
	public void createTiles(Tile[] tiles) {
		for(int i = 0; i < tiles.length; i++)
			this.tiles.add(tiles[i]);
	}	
	
	public BufferedImage getSprite(int id) {
		return tiles.get(id).getSprite();
	}
	
	public void draw(Graphics2D g2) {
		
		int worldCol = 0;
		int worldRow = 0;
		int tileSize = gp.TILE_SIZE/2;
		
//		while(worldCol < gp.MAX_WORLD_COL * 2 && worldRow < gp.MAX_WORLD_ROW * 2) {
//		
//			
//			int worldX = worldCol * (gp.TILE_SIZE/2);
//			int worldY = worldRow * (gp.TILE_SIZE/2);
//			int screenX = worldX - gp.player.worldX + gp.player.screenX;
//			int screenY = worldY - gp.player.worldY + gp.player.screenY;
//			g2.drawImage(worldTiles[worldCol][worldRow].image, worldX, worldY, tileSize, tileSize, null);
//			
//			if (worldX + gp.TILE_SIZE > gp.player.worldX - gp.player.screenX && 
//				worldX - gp.TILE_SIZE < gp.player.worldX + gp.player.screenX &&
//				worldY + gp.TILE_SIZE > gp.player.worldY - gp.player.screenY &&
//				worldY - gp.TILE_SIZE < gp.player.worldY + gp.player.screenY) {
//				
//			
//				g2.drawImage(worldTiles[worldCol][worldRow].image, screenX, screenY, tileSize, tileSize, null);
//				
//			}
//			
//			worldCol++;
//			
//			if(worldCol == gp.MAX_WORLD_COL * 2) {
//				worldCol = 0;
//				worldRow++;
//			}
//			
//		}
		
		
		
	}
}
