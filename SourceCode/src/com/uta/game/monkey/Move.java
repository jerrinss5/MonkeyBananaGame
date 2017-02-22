package com.uta.game.monkey;

public class Move extends MonkeyGameState {

	public Move() {

	}

	public MonkeyGameState keyReleased(Subject subject) {
		return new Idle();
	}

	public String toString() {
		return "Move";
	}
}
