package com.uta.game.monkey;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MonkeyKeyListener implements KeyListener {

	Subject subject;
	
	
	public MonkeyKeyListener(Subject subject) {
		this.subject = subject;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_UP:
			if(GameLayoutInit.getRunning())
				subject.keyUpPressed(subject);
			break;
		case KeyEvent.VK_DOWN:
			if(GameLayoutInit.getRunning())
				subject.keyDownPressed(subject);
			break;
		case KeyEvent.VK_LEFT:
			if(GameLayoutInit.getRunning())
				subject.keyLeftPressed(subject);
			break;
		case KeyEvent.VK_RIGHT:
			if(GameLayoutInit.getRunning())
				subject.keyRightPressed(subject);
			break;
		}
		subject.keyReleased(subject);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// do nothing implementation
	}

}
