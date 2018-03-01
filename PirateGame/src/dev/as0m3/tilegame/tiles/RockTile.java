package dev.as0m3.tilegame.tiles;

import dev.as0m3.tilegame.gfx.Assets;

public class RockTile extends Tile {

	public RockTile(int id) {
		super(Assets.rock, id);
		
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
	
}
