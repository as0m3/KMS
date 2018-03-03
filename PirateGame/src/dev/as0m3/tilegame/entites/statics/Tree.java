package dev.as0m3.tilegame.entites.statics;

import java.awt.Graphics;

import dev.as0m3.tilegame.Handler;
import dev.as0m3.tilegame.gfx.Assets;
import dev.as0m3.tilegame.tiles.Tile;

public class Tree extends StaticEntity {

	public Tree(Handler handler, String name, float x, float y, int width, int height) {
		super(handler, name, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

}
