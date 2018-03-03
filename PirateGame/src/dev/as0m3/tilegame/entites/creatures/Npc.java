package dev.as0m3.tilegame.entites.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.as0m3.tilegame.Handler;
import dev.as0m3.tilegame.gfx.Animation;
import dev.as0m3.tilegame.gfx.Assets;

public class Npc extends Creature {
	
	private Animation animIdle_left, animIdle_right;
	private Animation[] animations;
	
	int rnd;
	int count = 0;
	int temp = 1;

	public Npc(Handler handler, String name, float x, float y, int width, int height) {
		super(handler, name, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		// Animations
		animIdle_left = new Animation(250, Assets.npc_idle_left);
		animIdle_right = new Animation(250, Assets.npc_idle_right);
		animations = new Animation[2]; 
		
		animations[0] = animIdle_left; 
		animations[1] = animIdle_right;
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
		
		rnd = (Math.random() <= 0.5) ? 1 : 2;
		
//		if (count > 2) {
//			
//			switch(temp-1) {
//			case 0:
//				animations[0].setDone(false);
//				temp = 2;
//				count = 0;
//				return animations[1].getCurrentFrame();
//			case 1:
//				animations[1].setDone(false);
//				temp = 1;
//				count = 0;
//				return animations[0].getCurrentFrame();
//			default:
//				count = 0;
//				return animations[0].getCurrentFrame();
//			}
//			
//			
//		} else {
			
			if (animations[temp - 1].isDone()) {
				animations[temp - 1].setDone(false);
				temp = rnd;
				count++;
				return animations[temp - 1].getCurrentFrame();
			} else {
				return animations[temp - 1].getCurrentFrame();
			} 
			
	//	}
					

	}

}
