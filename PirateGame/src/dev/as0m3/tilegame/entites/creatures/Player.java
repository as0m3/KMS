package dev.as0m3.tilegame.entites.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.text.Format;

import dev.as0m3.tilegame.Handler;
import dev.as0m3.tilegame.gfx.Animation;
import dev.as0m3.tilegame.gfx.Assets;
import dev.as0m3.tilegame.gfx.Text;

public class Player extends Creature {
	
	// Animations
	private Animation animUp, animDown, animLeft, animRight, animIdle /*,health*/;

	//episode 13
	
	public Player(Handler game, String name, float x, float y) {
		super(game, name, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		// DAMAGE HITBOX
//		bounds.x = 7*2; // x coordinate of hitbox starting point
//		bounds.y = 0*2; // y coordinate of hitbox starting point
//		bounds.width = 17*2; // width of hitbox
//		bounds.height = 32*2-1; // height of hitbox
		
		bounds.x = 7*2; // x coordinate of hitbox starting point
		bounds.y = 17*2; // y coordinate of hitbox starting point
		bounds.width = 17*2; // width of hitbox
		bounds.height = 17*2-1; // height of hitbox
		
		
		// Animations
		animUp = new Animation(600, Assets.player_up);
		animDown = new Animation(600, Assets.player_down);
		animLeft = new Animation(400, Assets.player_left);
		animRight = new Animation(400, Assets.player_right);
		animIdle = new Animation(600, Assets.player_idle);
		//health = new Animation(600, Assets.hp_bar);
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
		//health.tick();
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
		// Draw HitBox To Screen
//		g.setColor(Color.red);
//		g.fillRect((int) ((x + (bounds.x) - handler.getGameCamera().getxOffset())), (int) (y + (bounds.y) - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
		
		//g.drawImage(health.getCurrentFrame(), 10, 700, 32, 9, null);
		
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		Text.drawString(g, name, (int) (x - handler.getGameCamera().getxOffset() + 32), (int) (y - handler.getGameCamera().getyOffset() - 10), true, new Color(200, 200, 200), Assets.font12);
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
