package dev.as0m3.tilegame.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.as0m3.tilegame.Handler;
import dev.as0m3.tilegame.gfx.Animation;
import dev.as0m3.tilegame.gfx.Assets;
import dev.as0m3.tilegame.gfx.Text;
import dev.as0m3.tilegame.ui.ClickListener;
import dev.as0m3.tilegame.ui.UIImageButton;
import dev.as0m3.tilegame.ui.UIManager;

public class MenuState extends State {
	
	private UIManager uiManager;
	
	private Animation character, background;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		character = new Animation(600, Assets.player_idle);
		background = new Animation(300, Assets.background);
		
		// ----- Buttons -----
		// Start
		uiManager.addObject(new UIImageButton((1080/2)-((162*2)/2), 480, 162*2, 64*2, Assets.btn_start, new ClickListener() {
			
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				
			}
		}));
		// Quit
		uiManager.addObject(new UIImageButton(10, (810-64)-74, 128, 128, Assets.btn_stop, new ClickListener() {
			
			@Override
			public void onClick() {
				System.exit(1);
			}
		}));
		// Mute 
		uiManager.addObject(new UIImageButton((1080-64)-74, (810-64)-74, 128, 128, Assets.btn_mute, Assets.btn_mute2, new ClickListener() {
			
			@Override
			public void onClick() {
				handler.getGame().toggleMute();
			}
		}));
	}

	@Override
	public void tick() {
		uiManager.tick();
		character.tick();
		background.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(background.getCurrentFrame(), 0, 0, 1080, 810, null);
		uiManager.render(g);
		g.drawImage(character.getCurrentFrame(), (1080/2)-(256/2), 200, 256, 256, null);
		//title
		Text.drawString(g, "Broadside!", (1080/2), 100, true, Color.white, Assets.titleFont);
	}
	
	
}
