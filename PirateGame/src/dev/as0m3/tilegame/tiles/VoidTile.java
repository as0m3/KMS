package dev.as0m3.tilegame.tiles;

import dev.as0m3.tilegame.gfx.Assets;

public class VoidTile extends Tile {

	public VoidTile(int id) {
		super(Assets.voidtile, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
	
}
