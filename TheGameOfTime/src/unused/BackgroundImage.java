//package unused;
//
//import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//
//public class BackgroundImage {
//
//	BufferedImage[] image;
//	GamePanel gp;
//	public  BackgroundImage(GamePanel gp) {
//		
//		this.gp = gp;
//		init();
//	}
//	
//	public void init() {
//		BufferedImageLoader loader = new BufferedImageLoader();
//		image = new BufferedImage[2];
//		try {
//			image[0] = loader.loadImage("/background/layer_1.png");
//			image[1] = loader.loadImage("/background/layer_2.png");
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public void draw(Graphics2D g2) {
//		for(int i = 0; i < image.length ; i++) {
//			
//			g2.drawImage(image[i], 0, 0, gp.SCREEN_WIDTH, gp.SCREEN_HEIGHT, null);
//			
//		}
//		
//	}
//}
