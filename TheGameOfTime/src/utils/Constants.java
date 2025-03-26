package utils;

import main.Game;

public class Constants {
	
	public static class EnemyConstants {
		public static final int SKELETON = 0;
		
		public static final int IDLE = 0;
		public static final int WALKING = 1;
		public static final int ATTACK = 5;
		public static final int HIT = 8;
		public static final int DEAD = 9;
		
		public static final int SKELETON_WIDTH_DEFAULT = 128;
		public static final int SKELETON_HEIGHT_DEFAULT = 128;
		
		public static final int SKELETON_WIDTH = (int) (SKELETON_WIDTH_DEFAULT * Game.SCALE);
		public static final int SKELETON_HEIGHT = (int) (SKELETON_HEIGHT_DEFAULT * Game.SCALE);
		
		public static final int SKELETON_DRAWOFFSET_X = (int) (58 * Game.SCALE);
		public static final int SKELETON_DRAWOFFSET_Y = (int) (63 * Game.SCALE);
		
		public static int GetSpriteAmount(int enemy_type, int enemy_state) {
			switch(enemy_type) {
			case SKELETON:
				switch(enemy_state) {
				case IDLE:
				case WALKING:
					return 7;
				case ATTACK:
					return 6;
				case HIT:
					return 2;
				case DEAD:
					return 4;
				
				}
			}
			return 0;
		}
		
	}
	public static class Environment{
		public static final int TOWN_BG_WIDTH_DEFAULT = 320;
		public static final int TOWN_BG_HEIGHT_DEFAULT = 131;
		public static final int FIRE_BG_WIDTH_DEFAULT = 320;
		public static final int FIRE_BG_HEIGHT_DEFAULT = 30;
		
		public static final int TOWN_BG_WIDTH = (int) (TOWN_BG_WIDTH_DEFAULT * Game.SCALE);
		public static final int TOWN_BG_HEIGHT = (int) (TOWN_BG_HEIGHT_DEFAULT * Game.SCALE);
		public static final int FIRE_BG_WIDTH = (int) (FIRE_BG_WIDTH_DEFAULT * Game.SCALE);
		public static final int FIRE_BG_HEIGHT = (int) (FIRE_BG_HEIGHT_DEFAULT * Game.SCALE);
	}
	public static class UI{
		public static class Buttons{
			public static final int B_WIDTH_DEFAULT = 96;
			public static final int B_HEIGHT_DEFAULT = 32;
			public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT * Game.SCALE);
			public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT * Game.SCALE);
		}
	}
	public static class Directions{
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}
	
	public static class PlayerConstants{
		
		public static final int IDLE = 0;
		public static final int WALK = 1;
		public static final int RUN = 2;
		public static final int RUNNING_ATTACK = 3;
		public static final int ATTACK_1 = 4;
		public static final int ATTACK_2 = 5;
		public static final int ATTACK_3 = 6;
		public static final int BLOCK_HIT = 7;
		public static final int HIT= 8;
		public static final int JUMP = 9;
		public static final int DEATH = 10;
		public static final int BLOCK = 11;
		public static final int FALL = 12;		
		
		public static int GetSpriteAmount(int player_action) {
			
			switch(player_action) {
			case WALK:
				return 8;
			case RUN:
				return 7;
			case DEATH:
			case RUNNING_ATTACK:
			case JUMP:
				return 3;
			case ATTACK_1:
			case BLOCK:
				return 5;
			case ATTACK_2:
			case ATTACK_3:
			case IDLE:
				return 4;
			case HIT:			
				return 2;
			case BLOCK_HIT: 
			case FALL:
				return 1;
			default:
				return 1;
			}
		}
	}
}
