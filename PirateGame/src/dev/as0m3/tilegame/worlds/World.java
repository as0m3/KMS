package dev.as0m3.tilegame.worlds;

import java.awt.Graphics;

import dev.as0m3.tilegame.Handler;
import dev.as0m3.tilegame.entites.EntityManager;
import dev.as0m3.tilegame.entites.creatures.Npc;
import dev.as0m3.tilegame.entites.creatures.Player;
import dev.as0m3.tilegame.tiles.Tile;
import dev.as0m3.tilegame.utils.Utils;

public class World {
	
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	//Entities
	private EntityManager entityManager;
	
	public World(Handler handler, String path) {
		loadWorld(path);
		
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, "Username", spawnX, spawnY));
		entityManager.addEntity(new Npc(handler, "Cpt. Vane", spawnX + 64, spawnY - 32, width, height));
		entityManager.addEntity(new Npc(handler, "Cpt. Bane", spawnX + 140, spawnY - 32, width, height));
		
		
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void tick() {
		entityManager.tick();
	}
	
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		//Entities
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.grassTile;
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null) {
			return Tile.voidTile;
		}
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2])*64;
		spawnY = Utils.parseInt(tokens[3])*64-24;
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public int getSpawnX() {
		return spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}

	
}
