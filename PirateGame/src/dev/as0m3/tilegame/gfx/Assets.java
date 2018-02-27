package dev.as0m3.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage player; // list, all, of, them, out
		
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/PirateShipSprite.png"));
		
		player = sheet.crop(0, 0, 64, 64);
		
	}
}
