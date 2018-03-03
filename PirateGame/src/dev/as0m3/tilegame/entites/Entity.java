package dev.as0m3.tilegame.entites;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.as0m3.tilegame.Handler;

public abstract class Entity {
	
	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected String name;
	protected Rectangle bounds;
	
	public Entity(Handler handler, String name, float x, float y, int width, int height) {
		this.handler = handler;
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(0, 0, width, height);
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);
}
