package com.uta.game.monkey;

import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Idle extends MonkeyGameState {

	JLabel monkeyLabel = new JLabel();
	JLabel bananaLabel = new JLabel();
	Point monkeyPoint;
	Point bananaPoint;
	int score;
	int bananaTimerCountdown;
	JTextArea scoreText;

	public Idle() {

	}

	public MonkeyGameState keyUpPressed(Subject subject) {

		if (subject != null && subject.getMonkeyLabel() != null) {
			this.monkeyLabel = subject.getMonkeyLabel();
			monkeyPoint = monkeyLabel.getLocation();
		}
		if (monkeyPoint.y - GameLayoutInit.ICONSIZE < 0) {
			// do nothing reached the edge
		} else {
			this.monkeyLabel.setLocation(monkeyPoint.x, (monkeyPoint.y - 35));
		}
		collision(subject);
		return new Move();
	}

	public MonkeyGameState keyDownPressed(Subject subject) {
		if (subject != null && subject.getMonkeyLabel() != null) {
			this.monkeyLabel = subject.getMonkeyLabel();
			monkeyPoint = monkeyLabel.getLocation();
		}
		if (monkeyPoint.y + GameLayoutInit.ICONSIZE > GameLayoutInit.HEIGHT - 100) {
			// do nothing reached the edge
		} else {
			this.monkeyLabel.setLocation(monkeyPoint.x,
					(monkeyPoint.y + GameLayoutInit.ICONSIZE));
		}
		collision(subject);
		return new Move();
	}

	public MonkeyGameState keyLeftPressed(Subject subject) {
		if (subject != null && subject.getMonkeyLabel() != null) {
			this.monkeyLabel = subject.getMonkeyLabel();
			monkeyPoint = monkeyLabel.getLocation();
		}
		if (monkeyPoint.x - GameLayoutInit.ICONSIZE < 0) {
			// do nothing reached the edge
		} else {
			this.monkeyLabel.setLocation(
					(monkeyPoint.x - GameLayoutInit.ICONSIZE), monkeyPoint.y);
		}
		collision(subject);
		return new Move();
	}

	public MonkeyGameState keyRightPressed(Subject subject) {
		if (subject != null && subject.getMonkeyLabel() != null) {
			this.monkeyLabel = subject.getMonkeyLabel();
			monkeyPoint = monkeyLabel.getLocation();
		}
		if (monkeyPoint.x + GameLayoutInit.ICONSIZE >= GameLayoutInit.WIDTH) {
			// do nothing reached the edge
		} else {
			this.monkeyLabel.setLocation(
					(monkeyPoint.x + GameLayoutInit.ICONSIZE), monkeyPoint.y);
		}
		collision(subject);
		return new Move();
	}

	public boolean collision(Subject subject) {
		if (subject != null && subject.getBananaLabel() != null) {
			this.bananaLabel = subject.getBananaLabel();
			this.bananaPoint = bananaLabel.getLocation();
		}
		if (subject != null && subject.getMonkeyLabel() != null) {
			this.monkeyLabel = subject.getMonkeyLabel();
			this.monkeyPoint = monkeyLabel.getLocation();
		}
		scoreText = GameLayoutInit.getScoreText();
		bananaTimerCountdown = GameLayoutInit.getBananaTimerCountdown();
		score = GameLayoutInit.getScore();
		if ((monkeyPoint.x == bananaPoint.x)
				&& (monkeyPoint.y == bananaPoint.y)) {
			score += 1;
			GameLayoutInit.setScore(score);
			scoreText.setText(" Score:  " + score);
			this.bananaLabel.setLocation(GameLayoutInit.randomizer(),
					GameLayoutInit.randomizer());
			bananaTimerCountdown = 5;
			GameLayoutInit.setBananaTimerCountdown(bananaTimerCountdown);
		}
		return true;
	}

	public String toString() {
		return "Idle";
	}
}
