package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import states.Playing;
import utils.LoadSave;
import static utils.Constants.EnemyConstants.*;
public class EnemyManager {
	
	private Playing playing;
	private BufferedImage[][] skeletonArr;
	private ArrayList<Skeleton> skeletons = new ArrayList<>();
	
	public EnemyManager(Playing playing) {
		this.playing = playing;
		loadEnemyImgs();
		addEnemies();
	}
	
	private void addEnemies() {
		skeletons = LoadSave.getSkeletons();
		
	}

	public void update(int[][] lvlData, Player player) {
		for(Skeleton s : skeletons)
			s.update(lvlData, player);
	}
	
	public void draw(Graphics g, int xLevelOffset) {
		drawSkeletons(g, xLevelOffset);
	}
	
	private void drawSkeletons(Graphics g, int xLevelOffset) {
		for(Skeleton s : skeletons) {
			g.drawImage(skeletonArr[s.getEnemyState()][s.getAniIndex()], (int) (s.getHitbox().x - SKELETON_DRAWOFFSET_X) - xLevelOffset, (int) (s.getHitbox().y - SKELETON_DRAWOFFSET_Y), SKELETON_WIDTH, SKELETON_HEIGHT, null);
			s.drawHitbox(g, xLevelOffset);
		}
		
	}

	private void loadEnemyImgs() {
		skeletonArr = new BufferedImage[10][8];
		BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.SKELTON_SPRITE);
		for(int j = 0; j < skeletonArr.length; j++)
			for(int i = 0; i < skeletonArr[j].length; i++)
				skeletonArr[j][i] = temp.getSubimage(i * SKELETON_WIDTH_DEFAULT, j * SKELETON_HEIGHT_DEFAULT, SKELETON_WIDTH_DEFAULT, SKELETON_HEIGHT_DEFAULT);
	}
	
	
}
