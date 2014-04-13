package ar.edu.unq.arkanoid.mainscene.ball.rules;

import ar.edu.unq.americana.rules.IRule;
import ar.edu.unq.americana.utils.Vector2D;
import ar.edu.unq.arkanoid.mainscene.components.Ball;
import ar.edu.unq.arkanoid.mainscene.components.Racket;
import ar.edu.unq.arkanoid.scenes.MainScene;

public class TableOutRule implements IRule<Ball, MainScene> {

	private final Racket racket;

	public TableOutRule(final Racket racket) {
		this.racket = racket;
	}

	@Override
	public boolean mustApply(final Ball ball, final Vector2D nextPosition,
			final MainScene scene) {
		return ball.getAppearance().getY() >= ball.getGame().getDisplayHeight();
	}

	@Override
	public void apply(final Ball ball, final Vector2D nextPosition,
			final MainScene scene) {
		final int displayWidth = ball.getGame().getDisplayWidth();
		ball.following();
		racket.setX(displayWidth / 2);
		ball.setY(racket.getAppearance().getY()
				- (ball.getAppearance().getHeight() / 2));
	}
}
