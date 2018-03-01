package dev.as0m3.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	// STATIC STUFF HERE
	                      //increase size of array if need be
	public static Tile[] tiles = new Tile[256];
	
	public static Tile voidTile = new VoidTile(0);
	public static Tile grassTile = new GrassTile(1);
	public static Tile dirtTile = new DirtTile(2);
	public static Tile sandTile = new SandTile(3);
	
	// CLASS
	
	public static final int TILE_WIDTH = 32, TILE_HEIGHT = 32;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	// OVERRIDE IF TILE IS SOLID
	public boolean isSolid() {
		return false;
	}
	
	public int getId() {
		return id;
	}

}
