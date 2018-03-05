package dev.as0m3.tilegame.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage((x*32)-32, (y*32)-32, width, height);
	}
	
	public BufferedImage crop2(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}
}
