package ar.edu.unq.arkanoid.mainscene.ball.events;

import ar.edu.unq.americana.events.game.GameEvent;
import ar.edu.unq.arkanoid.mainscene.components.Racket;

public class BallFollow extends GameEvent {

	private final Racket racket;

	public BallFollow(final Racket racket) {
		this.racket = racket;
	}

	public Racket getRacket() {
		return racket;
	}

}
