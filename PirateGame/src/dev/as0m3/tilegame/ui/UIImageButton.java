package dev.as0m3.tilegame.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject {
	
	private BufferedImage[] images, toggle;
	private ClickListener clicker;
	private boolean toggled = false;
	private boolean toggleeable = false;

	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
	}
	//toggleable buttons
	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, BufferedImage[] toggle, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
		this.toggle = toggle;
		this.toggleeable = true;
	}
	@Override
	public void tick() {}

	@Override
	public void render(Graphics g) {
		if(toggleeable == false) {
			if(hovering)
				g.drawImage(images[1], (int)x, (int)y, width, height, null);
			else
				g.drawImage(images[0], (int)x, (int)y, width, height, null);
		} else {
			if(toggled == true) {
				if(hovering)
					g.drawImage(toggle[1], (int)x, (int)y, width, height, null);
				else
					g.drawImage(toggle[0], (int)x, (int)y, width, height, null);
			} else {
				if(hovering)
					g.drawImage(images[1], (int)x, (int)y, width, height, null);
				else
					g.drawImage(images[0], (int)x, (int)y, width, height, null);
			}
		}
		
	}

	@Override
	public void onClick() {
		if(toggleeable == false) {
			clicker.onClick();
		} else {
			if(toggled == false)
				toggled = true;
			else
				toggled = false;
		}
		
	}
	

}
