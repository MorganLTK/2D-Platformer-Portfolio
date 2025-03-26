package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public abstract class Entity {
	public int worldX, worldY;

	public int horizontalSpeed;
	public int verticalSpeed;

	public final int GRAVITY = 1;
	public final int TERMINAL_VELOCITY = 30;

	public BufferedImage displayedImage;
	public String direction;

	public int spriteCounter = 0;
	public int spriteNum = 0;

	public boolean collisionOn = false;

	protected float x, y;
	protected int width, height;
	protected Rectangle2D.Float hitbox;

	public Entity(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

	}

	protected void drawHitbox(Graphics g, int xLevelOffset) {
		g.setColor(Color.pink);
		g.drawRect((int) hitbox.x - xLevelOffset, (int) hitbox.y, (int) hitbox.width, (int) hitbox.height);
	}

	protected void initHitbox(float x, float y, int width, int height) {
		hitbox = new Rectangle2D.Float(x, y, width, height);
	}

	public Rectangle2D.Float getHitbox() {
		return hitbox;
	}
}
