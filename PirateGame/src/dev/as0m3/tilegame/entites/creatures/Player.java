package dev.as0m3.tilegame.entites.creatures;

import java.awt.Graphics;

import dev.as0m3.tilegame.Game;
import dev.as0m3.tilegame.gfx.Assets;

public class Player extends Creature {
	
	private Game game;
	//episode 13
	
	public Player(Game game, String name, float x, float y) {
		super(name, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.game = game;
	}

	@Override
	public void tick() {
		getInput();
		move();
		
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up)
			yMove = -speed;
		if(game.getKeyManager().down)
			yMove = speed;
		if(game.getKeyManager().left)
			xMove = -speed;
		if(game.getKeyManager().right)
			xMove = speed;
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) x, (int) y, width, height, null);
	}

}
