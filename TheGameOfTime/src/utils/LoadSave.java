package utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import entity.Skeleton;

import java.awt.Color;
import main.Game;
import static utils.Constants.EnemyConstants.*;

public class LoadSave {
	
	public static final String PLAYER_ATLAS = "player/player_sprites.png";
	public static final String BRICK_ATLAS = "tiles/bricks.png";
	public static final String WINDOW_ATLAS = "tiles/windows.png";
	public static final String FLOOR_ATLAS = "tiles/floors.png";
	public static final String LEVEL_ONE_DATA = "maps/level_one_data.png";
	public static final String MENU_BUTTONS = "menu/menu_buttons.png";
	public static final String PLAYING_BG_IMG = "background/layer_1.png";
	public static final String TOWN_BG_IMG = "background/layer_2.png";
	public static final String FIRE_BG_IMG = "background/layer_3.png";
	public static final String SKELTON_SPRITE = "enemies/skeleton_sprites.png";
	public static BufferedImage GetSpriteAtlas(String fileName){
		
		BufferedImage img = null;
		InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);
    	try {
    		img = ImageIO.read(is);	
    	} catch (IOException e){
    		e.printStackTrace();
    	} finally {
    		try {
    			is.close();
    		}catch(IOException e) {
    			e.printStackTrace();
    		}
    	}
    	return img;
	}
	
	public static ArrayList<Skeleton> getSkeletons(){
		BufferedImage img = GetSpriteAtlas(LEVEL_ONE_DATA);
		ArrayList<Skeleton> list = new ArrayList<>();
		for(int j = 0; j < img.getHeight(); j++)
			for(int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getGreen();
				if(value == SKELETON)
					list.add(new Skeleton(i * Game.TILES_SIZE, j * Game.TILES_SIZE));
				}
		return list;
	}
	public static int[][] GetLevelData(){
		
		BufferedImage img = GetSpriteAtlas(LEVEL_ONE_DATA);
		int[][] lvlData = new int[img.getHeight()][img.getWidth()];
		for(int j = 0; j < img.getHeight(); j++)
			for(int i = 0; i < img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i, j));
				int value = color.getRed();
				if(value >= 51)
					value = 0;
				lvlData[j][i] = value;
				}
		return lvlData;
	}
}
