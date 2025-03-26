package unused;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	public BufferedImage image;
	public int tileSize;
	public int length;
	
	public SpriteSheet(BufferedImage image, int tileSize) {
		this.image = image;	
		this.tileSize = tileSize;
		length = (image.getWidth()/this.tileSize);
	}
	
	public BufferedImage grabImage(int col, int row) {
		BufferedImage img = image.getSubimage(col * tileSize, row * tileSize, tileSize, tileSize);
		return img;
	}
}
