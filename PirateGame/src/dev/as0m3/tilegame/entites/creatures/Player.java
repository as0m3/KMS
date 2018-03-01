package dev.as0m3.tilegame.entites.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import dev.as0m3.tilegame.Game;
import dev.as0m3.tilegame.gfx.Animation;
import dev.as0m3.tilegame.gfx.Assets;

public class Player extends Creature {
	
	// Animations
	private Animation animUp, animDown, animLeft, animRight, animIdle;
	
	private Game game;
	//episode 13
	
	public Player(Game game, String name, float x, float y) {
		super(name, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.game = game;
		
		// Animations
		animUp = new Animation(600, Assets.player_up);
		animDown = new Animation(600, Assets.player_down);
		animLeft = new Animation(400, Assets.player_left);
		animRight = new Animation(400, Assets.player_right);
		animIdle = new Animation(600, Assets.player_idle);
	}

	@Override
	public void tick() {
		getInput();
		move();
		
		// Animations
		animUp.tick();
		animDown.tick();
		animLeft.tick();
		animRight.tick();
		animIdle.tick();
	}
	
	private void getInput() { 
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up) {
			yMove = -speed;
		}
		
		if(game.getKeyManager().down) {
			yMove = speed;
		}
		
		if(game.getKeyManager().left) {
			xMove = -speed;
		}
		
		if(game.getKeyManager().right) {
			xMove = speed;
		}
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) x, (int) y, width, height, null);
	}
	
	
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0) {
			return animLeft.getCurrentFrame();
		} else if(xMove > 0) {
			return animRight.getCurrentFrame();
		} else if(yMove < 0) {
			return animUp.getCurrentFrame();
		} else if(yMove > 0){
			return animDown.getCurrentFrame();
		} else {
			return animIdle.getCurrentFrame();
		}
	}

}
