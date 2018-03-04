package dev.as0m3.tilegame.entites.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.as0m3.tilegame.Handler;
import dev.as0m3.tilegame.gfx.Animation;
import dev.as0m3.tilegame.gfx.Assets;
import dev.as0m3.tilegame.gfx.Text;

public class Npc extends Creature {
	
	private Animation animIdle_left, animIdle_right;
	private Animation[] animations;
	
	int rnd;
	int count = 1;
	int temp = 1;

	public Npc(Handler handler, String name, float x, float y, int width, int height) {
		super(handler, name, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		// Collision HitBox
		bounds.x = 11*2; // x coordinate of hitbox starting point
		bounds.y = 19*2; // y coordinate of hitbox starting point
		bounds.width = 8*2; // width of hitbox
		bounds.height = 7*2; // height of hitbox
		
		
		// Animations
		animIdle_left = new Animation(500, Assets.npc_idle_left);
		animIdle_right = new Animation(500, Assets.npc_idle_right);
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
		Text.drawString(g, name, (int) (x - handler.getGameCamera().getxOffset() + 32), (int) (y - handler.getGameCamera().getyOffset() - 10), true, new Color(200, 200, 200), Assets.font12);
	}
	
	
	public BufferedImage pickAnimation() {
		
		rnd = (Math.random() <= 0.5) ? 1 : 2;
		
//		if (count > 2) {
//			count = 1;
//			switch(temp-1) {
//		    	
//			case 0:
//				animations[0].setDone(false);
//				temp = 2;
//				return animations[1].getCurrentFrame();
//			case 1:
//				animations[1].setDone(false);
//				temp = 1;
//				return animations[0].getCurrentFrame();
//			default:
//				return animations[0].getCurrentFrame();
//			}
//			
//			
//		} else {
			
			if (animations[temp - 1].isDone()) {
				animations[temp - 1].setDone(false);
				temp = rnd;
//				count++;
//				System.out.println(count);
				return animations[temp - 1].getCurrentFrame();
			} else {
				return animations[temp - 1].getCurrentFrame();
			} 
			
//		}
					

	}

}
