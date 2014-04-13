package ar.edu.unq.arkanoid.mainscene.ball.rules;

import ar.edu.unq.americana.rules.IRule;
import ar.edu.unq.americana.utils.Vector2D;
import ar.edu.unq.arkanoid.mainscene.components.Ball;
import ar.edu.unq.arkanoid.scenes.MainScene;

public class TableRightCollisionRule implements IRule<Ball, MainScene> {

	@Override
	public boolean mustApply(final Ball ball, final Vector2D nextPosition,
			final MainScene scene) {
		return nextPosition.getX() >= ball.getGame().getDisplayWidth();
	}

	@Override
	public void apply(final Ball ball, final Vector2D nextPosition,
			final MainScene scene) {
		final int gameWidth = ball.getGame().getDisplayWidth();
		final double delta = ball.getAppearance().getWidth() / 2;
		ball.setX(gameWidth - delta);
		final Vector2D direction = ball.getDirection();
		ball.setDirection(-direction.getX(), direction.getY());
	}

}
