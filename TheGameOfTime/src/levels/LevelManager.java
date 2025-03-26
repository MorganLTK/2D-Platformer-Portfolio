package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


import main.Game;
import utils.LoadSave;

public class LevelManager {
	private Game game;
	private BufferedImage[] levelSprite;
	private Level levelOne;
	
	public LevelManager(Game game) {
		this.game = game;
		importOutsideSprites();
		levelOne = new Level(LoadSave.GetLevelData());
	}
	
	private void importOutsideSprites() {
		
		BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.BRICK_ATLAS);
		levelSprite = new BufferedImage[55];
		levelSprite[0] = null;
		for(int i = 0; i < 20; i++) {
			levelSprite[i + 1] = img.getSubimage(i * 32, 0, 32, 32);
		}
		img = LoadSave.GetSpriteAtlas(LoadSave.FLOOR_ATLAS);
		
		for(int i = 0; i < 32; i++) {
			levelSprite[i + 21] = img.getSubimage(i * 32, 0, 32, 32);
		}
	}

	public void update() {
		
	}
	
	public Level getCurrentLevel() {
		return levelOne;
	}
	
	public void draw(Graphics g, int lvlOffset) {
		for (int j = 0; j < Game.TILES_IN_HEIGHT; j++)
			for(int i = 0; i < levelOne.getLevelData()[0].length; i++) {
				int index = levelOne.getSpriteIndex(i, j);
				g.drawImage(levelSprite[index], Game.TILES_SIZE * i - lvlOffset, Game.TILES_SIZE * j, Game.TILES_SIZE, Game.TILES_SIZE, null);
			}
		
	}
}
