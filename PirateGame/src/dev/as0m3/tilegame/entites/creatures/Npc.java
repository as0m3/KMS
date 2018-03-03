package dev.as0m3.tilegame.entites.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.as0m3.tilegame.Handler;
import dev.as0m3.tilegame.gfx.Animation;
import dev.as0m3.tilegame.gfx.Assets;

public class Npc extends Creature {
	
	private Animation animIdle_left, animIdle_right;
	int rnd = 1; 

	public Npc(Handler handler, String name, float x, float y, int width, int height) {
		super(handler, name, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		// Animations
		animIdle_left = new Animation(600, Assets.npc_idle_left);
		animIdle_right = new Animation(600, Assets.npc_idle_right);
	}

	@Override
	public void tick() {
		animIdle_left.tick();
		animIdle_right.tick();
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(pickAnimation(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	
	public BufferedImage pickAnimation() {
		
		
		
		if(!animIdle_left.isDone()) {
			
			return animIdle_left.getCurrentFrame();
		} else if(!animIdle_right.isDone()) {
			
			return animIdle_right.getCurrentFrame();
		} else if(animIdle_left.isDone()) {
			
			rnd = (Math.random() <= 0.5) ? 1 : 2;
			
			if(rnd == 1) {
				animIdle_left.setDone(false);
				System.out.println("left 1: " + rnd);
				return animIdle_left.getCurrentFrame();
			} else {
				animIdle_left.setDone(false);
				System.out.println("left 2: " + rnd);
				return animIdle_right.getCurrentFrame();
			}
			
		} else if(animIdle_right.isDone()) {
			
			rnd = (Math.random() <= 0.5) ? 1 : 2;
			
			if(rnd == 1) {
				animIdle_right.setDone(false);
				System.out.println("right 1: " + rnd);
				return animIdle_left.getCurrentFrame();
			} else {
				animIdle_right.setDone(false);
				System.out.println("right 2: " + rnd);
				return animIdle_right.getCurrentFrame();
			}
			
		} else {
			return animIdle_right.getCurrentFrame();
		}
		
	
	}

}
