package dev.as0m3.tilegame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import dev.as0m3.tilegame.Game;

public class KeyManager implements KeyListener {
	//episode 14
	private boolean[] keys;
	public boolean up, down, left, right;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}
