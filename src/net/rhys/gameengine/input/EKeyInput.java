package net.rhys.gameengine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EKeyInput implements KeyListener {

	private boolean[] keys = new boolean[120];
	public boolean up, down, left, right, interact, action, sprint;
	
	public void update() {
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W] || keys[KeyEvent.VK_SPACE];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		action = keys[KeyEvent.VK_B];
		sprint = keys[KeyEvent.VK_CONTROL];
		
	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}
	
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	public void keyTyped(KeyEvent e) {}
}
