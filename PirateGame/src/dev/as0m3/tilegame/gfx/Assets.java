package dev.as0m3.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	//TILES
	public static BufferedImage voidtile, grass, sand, rock, dirt; // list, all, of, them, out
	//Entities
	public static BufferedImage tree;
	//Animations
	public static BufferedImage[] player_up, player_down, player_left, player_right, player_idle;
	public static BufferedImage[] npc_idle_left, npc_idle_right;
		
	public static void init() {
		SpriteSheet spritesheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet.png"));
		SpriteSheet tilesheet = new SpriteSheet(ImageLoader.loadImage("/textures/TileSheet.png"));
		// ------> SpriteSheet entitysheet = new SpriteSheet(ImageLoader.loadImage("/textures/EntitySheet.png"));
		
		//Entities
		// ------> tree = entitysheet.crop(1, 1, width, height);
		
		//Tiles
		voidtile = tilesheet.crop(1, 2, width, height);
		grass = tilesheet.crop(1, 1, width, height);
		sand = tilesheet.crop(2, 2, width, height);
		dirt = tilesheet.crop(2, 1, width, height);
		
		
		// Player
		player_up = new BufferedImage[2];
		player_down = new BufferedImage[2];
		player_left = new BufferedImage[3];
		player_right = new BufferedImage[3];
		player_idle = new BufferedImage[2];
		
		player_up[0] = spritesheet.crop(1, 4, width, height); 
		player_up[1] = spritesheet.crop(3, 3, width, height);                             
		
		player_down[0] = spritesheet.crop(1, 1, width, height);
		player_down[1] = spritesheet.crop(2, 1, width, height);
		
		player_left[0] = spritesheet.crop(3, 2, width, height);
		player_left[1] = spritesheet.crop(1, 3, width, height);
		player_left[2] = spritesheet.crop(2, 3, width, height);
		
		player_right[0] = spritesheet.crop(3, 1, width, height);
		player_right[1] = spritesheet.crop(1, 2, width, height);
		player_right[2] = spritesheet.crop(2, 2, width, height);
		
		player_idle[0] = spritesheet.crop(2, 4, width, height);
		player_idle[1] = spritesheet.crop(3, 4, width, height);
		
		// Npc
		npc_idle_left = new BufferedImage[5];
		npc_idle_right = new BufferedImage[5];
		
		npc_idle_left[0] = spritesheet.crop(1, 5, width, height);
		npc_idle_left[1] = spritesheet.crop(2, 5, width, height); 
		npc_idle_left[2] = spritesheet.crop(3, 5, width, height); 
		npc_idle_left[3] = spritesheet.crop(2, 5, width, height); 
		npc_idle_left[4] = spritesheet.crop(1, 5, width, height); 
		
		npc_idle_right[0] = spritesheet.crop(1, 5, width, height);
		npc_idle_right[1] = spritesheet.crop(1, 6, width, height); 
		npc_idle_right[2] = spritesheet.crop(2, 6, width, height);
		npc_idle_right[3] = spritesheet.crop(1, 6, width, height);
		npc_idle_right[4] = spritesheet.crop(1, 5, width, height);
		
		
	}
}
