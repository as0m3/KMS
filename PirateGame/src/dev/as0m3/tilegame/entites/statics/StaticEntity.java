package dev.as0m3.tilegame.entites.statics;

import dev.as0m3.tilegame.Handler;
import dev.as0m3.tilegame.entites.Entity;

public abstract class StaticEntity extends Entity {
	
	public StaticEntity(Handler handler, String name, float x, float y, int width, int height) {
		super(handler, name, x, y, width, height);
	}
	
	
	
}
