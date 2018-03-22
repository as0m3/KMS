package dev.as0m3.tilegame.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	// Menu Buttons
	public static BufferedImage[] btn_start;
	public static BufferedImage[] btn_stop;
	
	//Menu Background
	public static BufferedImage[] background;
	
	// Font
	public static Font font8, font12 , font24, titleFont;
//	public static HashMap<Character, BufferedImage> font; 
	
	//TILES
	public static BufferedImage voidtile, grass, sand, rock, dirt;// list, all, of, them, out
	
	//Entities
//	public static BufferedImage tree;
	
	//Animations
	public static BufferedImage[] player_up, player_down, player_left, player_right, player_idle;
	public static BufferedImage[] npc_idle_left, npc_idle_right;
		
	public static void init() {
		SpriteSheet spritesheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet.png"));
		SpriteSheet tilesheet = new SpriteSheet(ImageLoader.loadImage("/textures/TileSheet.png"));
		SpriteSheet startButtonSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Start_Button.png"));
		SpriteSheet stopButtonSheet = new SpriteSheet(ImageLoader.loadImage("/textures/Quit_Button.png"));
		SpriteSheet backgroundSheet = new SpriteSheet(ImageLoader.loadImage("/textures/MainMenu.png"));
		// ------> SpriteSheet entitysheet = new SpriteSheet(ImageLoader.loadImage("/textures/EntitySheet.png"));
		
		//Entities
		// ------> tree = entitysheet.crop(1, 1, width, height);
		
		// Buttons
		btn_start = new BufferedImage[2];
		btn_stop = new BufferedImage[2];
				
		btn_start[0] = startButtonSheet.crop2(0, 0, 162, 64);
		btn_start[1] = startButtonSheet.crop2(162, 0, 162, 64);
		
		btn_stop[0] = stopButtonSheet.crop2(0, 0, 64, 64);
		btn_stop[1] = stopButtonSheet.crop2(64, 0, 64, 64);
		
		//Background
		background = new BufferedImage[7];
		
		background[0] = backgroundSheet.crop2(0, 0, 1080, 810);
		background[1] = backgroundSheet.crop2(1080, 0, 1080, 810);
		background[2] = backgroundSheet.crop2(1080 * 2, 0, 1080, 810);
		background[3] = backgroundSheet.crop2(0, 810, 1080, 810);
		background[4] = backgroundSheet.crop2(1080, 810, 1080, 810);
		background[5] = backgroundSheet.crop2(1080 * 2, 810, 1080, 810);
		background[6] = backgroundSheet.crop2(0, 810 * 2, 1080, 810);
		
		// Font
		font8 = FontLoader.loadFont("res/fonts/Minecraftia.ttf", 8);
		font12 = FontLoader.loadFont("res/fonts/Minecraftia.ttf", 12);
		font24 = FontLoader.loadFont("res/fonts/Minecraftia.ttf", 24);
		titleFont = FontLoader.loadFont("res/fonts/Minecraftia.ttf", 96);
		
		
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
