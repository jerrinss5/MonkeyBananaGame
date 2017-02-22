package com.uta.game.monkey;

import javax.swing.JLabel;

/** Subject Class */
public class Subject {

	JLabel monkeyLabel = new JLabel();
	JLabel bananaLabel = new JLabel();
	MonkeyGameState monkeyGameState;
	String state;

	public JLabel getMonkeyLabel() {
		return monkeyLabel;
	}

	public void setMonkeyLabel(JLabel monkeyLabel) {
		this.monkeyLabel = monkeyLabel;
	}

	public JLabel getBananaLabel() {
		return bananaLabel;
	}

	public void setBananaLabel(JLabel bananaLabel) {
		this.bananaLabel = bananaLabel;
	}

	public Subject() {

	}

	public Subject(JLabel monkeyLabel, JLabel bananaLabel) {
		this.monkeyLabel = monkeyLabel;
		this.bananaLabel = bananaLabel;
		this.monkeyGameState = new Idle();
	}

	public void keyUpPressed(Subject subject) {
		monkeyGameState = monkeyGameState.keyUpPressed(subject);
	}

	public void keyDownPressed(Subject subject) {
		monkeyGameState = monkeyGameState.keyDownPressed(subject);
	}

	public void keyLeftPressed(Subject subject) {
		monkeyGameState = monkeyGameState.keyLeftPressed(subject);
	}

	public void keyRightPressed(Subject subject) {
		monkeyGameState = monkeyGameState.keyRightPressed(subject);
	}

	public void keyReleased(Subject subject) {
		monkeyGameState = monkeyGameState.keyReleased(subject);
	}

}
