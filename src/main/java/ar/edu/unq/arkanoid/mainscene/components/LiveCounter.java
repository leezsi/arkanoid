package ar.edu.unq.arkanoid.mainscene.components;

import ar.edu.unq.americana.GameComponent;
import ar.edu.unq.americana.appearances.Sprite;
import ar.edu.unq.americana.events.annotations.Events.Fired;
import ar.edu.unq.americana.utils.Tuning;
import ar.edu.unq.arkanoid.Arkanoid;
import ar.edu.unq.arkanoid.mainscene.appearance.LiveAppearance;
import ar.edu.unq.arkanoid.mainscene.ball.events.BallOut;
import ar.edu.unq.arkanoid.mainscene.events.GameOverEvent;
import ar.edu.unq.arkanoid.scenes.MainScene;

public class LiveCounter extends GameComponent<MainScene> {

	private static final int LIVES = Tuning.getInteger("game.lives");
	private int lives;

	public LiveCounter() {
		this.setX(15);
		final Sprite blueBall = Arkanoid.BLUE_BALL;
		this.setY(Arkanoid.WINDOW_HEIGHT - 2 - blueBall.getHeight());
		this.setAppearance(new LiveAppearance(LIVES, blueBall,
				Arkanoid.GREY_BALL));
		lives = LIVES;

	}

	@Fired(BallOut.class)
	public void ballOut(final BallOut ballOut) {
		if (lives-- == 0) {
			this.fireEvent(new GameOverEvent());
		}
	}

	public int getLives() {
		return lives;
	}

}
