package dev.as0m3.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage something; // list, all, of, them, out
	public static BufferedImage[] player_up, player_down, player_left, player_right, player_idle;
		
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet.png"));
		
		player_up = new BufferedImage[2];
		player_down = new BufferedImage[2];
		player_left = new BufferedImage[3];
		player_right = new BufferedImage[3];
		player_idle = new BufferedImage[2];
		
		player_up[0] = sheet.crop(1, 4, width, height); 
		player_up[1] = sheet.crop(3, 3, width, height);                             
		
		player_down[0] = sheet.crop(1, 1, width, height);
		player_down[1] = sheet.crop(2, 1, width, height);
		
		player_left[0] = sheet.crop(3, 2, width, height);
		player_left[1] = sheet.crop(1, 3, width, height);
		player_left[2] = sheet.crop(2, 3, width, height);
		
		player_right[0] = sheet.crop(3, 1, width, height);
		player_right[1] = sheet.crop(1, 2, width, height);
		player_right[2] = sheet.crop(2, 2, width, height);
		
		player_idle[0] = sheet.crop(2, 4, width, height);
		player_idle[1] = sheet.crop(3, 4, width, height);
		
	}
}
