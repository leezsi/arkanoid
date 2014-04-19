package ar.edu.unq.arkanoid.mainscene.events;

import java.awt.Color;

import ar.edu.unq.americana.Game;
import ar.edu.unq.americana.events.game.GameEvent;
import ar.edu.unq.arkanoid.gameover.GameOverScene;
import ar.edu.unq.arkanoid.gameover.WinnerGameOverScene;
import ar.edu.unq.arkanoid.mainscene.components.Score;

public class GameOverEvent extends GameEvent {

	public static enum State {
		WIN {

			@Override
			public void changeScene(final Game game) {
				game.setCurrentScene(new WinnerGameOverScene(score,
						"Yeah!!!! your score is " + score.getScore(),
						Color.green));
			}

		},
		LOSE {
			@Override
			public void changeScene(final Game game) {
				game.setCurrentScene(new GameOverScene(score,
						"Bad luck, try again. your score is "
								+ score.getScore(), Color.red));
			}
		};

		public Score score;

		public abstract void changeScene(Game game);
	}

	private final Score score;
	private final State state;

	public GameOverEvent(final Score score, final State state) {
		this.score = score;
		this.state = state;
		state.score = score;
	}

	public Score getScore() {
		return score;
	}

	public State getState() {
		return state;
	}

}
