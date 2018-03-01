package dev.as0m3.tilegame.entites.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.as0m3.tilegame.Handler;
import dev.as0m3.tilegame.gfx.Animation;
import dev.as0m3.tilegame.gfx.Assets;

public class Player extends Creature {
	
	// Animations
	private Animation animUp, animDown, animLeft, animRight, animIdle;

	//episode 13
	
	public Player(Handler game, String name, float x, float y) {
		super(game, name, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
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
		handler.getGameCamera().centerOnEntity(this);
		
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
		
		if(handler.getKeyManager().up) {
			yMove = -speed;
		}
		
		if(handler.getKeyManager().down) {
			yMove = speed;
		}
		
		if(handler.getKeyManager().left) {
			xMove = -speed;
		}
		
		if(handler.getKeyManager().right) {
			xMove = speed;
		}

		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
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
