package dev.as0m3.tilegame.entites.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.as0m3.tilegame.Handler;
import dev.as0m3.tilegame.gfx.Animation;
import dev.as0m3.tilegame.gfx.Assets;

public class Npc extends Creature {
	
	private Animation animIdle_left, animIdle_right;

	public Npc(Handler handler, String name, float x, float y, int width, int height) {
		super(handler, name, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		animIdle_left = new Animation(400, Assets.npc_idle_left);
		animIdle_right = new Animation(400, Assets.npc_idle_right);
	}

	@Override
	public void tick() {
		animIdle_left.tick();
		animIdle_right.tick();
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(pickAnimation(), (int) x, (int) y, width, height, null);
	}
	
	
	public BufferedImage pickAnimation() {
		int rnd = (Math.random() <= 0.5) ? 1 : 2;
		
		if(rnd == 1) {
			return  animIdle_left.getCurrentFrame();
		} else {
			return animIdle_right.getCurrentFrame();
		}
		
	}

}
