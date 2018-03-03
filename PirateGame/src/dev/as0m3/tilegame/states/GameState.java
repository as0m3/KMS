package dev.as0m3.tilegame.states;

import java.awt.Graphics;

import dev.as0m3.tilegame.Handler;
import dev.as0m3.tilegame.entites.creatures.Player;
import dev.as0m3.tilegame.worlds.World;

public class GameState extends State {

	private World world;
	
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		
	}
	
	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
