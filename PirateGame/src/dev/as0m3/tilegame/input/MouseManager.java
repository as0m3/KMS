package dev.as0m3.tilegame.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import dev.as0m3.tilegame.ui.UIManager;

public class MouseManager implements MouseListener, MouseMotionListener {

	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
	private UIManager uiManager;
	
	public MouseManager() {
		
	}
	
	public void setUIManager(UIManager uimanager) {
		this.uiManager = uimanager;
	}
	
	// Getters
	public boolean isLeftPressed() {
		return leftPressed;
	}
	
	public boolean isRightPressed() {
		return rightPressed;
	}
	
	public int getMouseX() {
		return mouseX;
	}
	
	public int getMouseY() {
		return mouseY;
	}
	
	// Implemented Methods
	@Override
	public void mousePressed(MouseEvent e) {
		// left click
		if(e.getButton() == MouseEvent.BUTTON1) {
			leftPressed = true;
		}
		// right click
		else if(e.getButton() == MouseEvent.BUTTON3) {
			rightPressed = true;
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// left click
		if(e.getButton() == MouseEvent.BUTTON1) {
			leftPressed = false;
		}
		// right click
		else if(e.getButton() == MouseEvent.BUTTON3) {
			rightPressed = false;
		}
		if(uiManager != null)
			uiManager.onMouseRelease(e);
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
		if(uiManager != null)
			uiManager.onMouseMove(e);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}


}
