package ar.edu.unq.arkanoid.mainscene.ball.rules;

import ar.edu.unq.americana.rules.IRule;
import ar.edu.unq.americana.utils.Vector2D;
import ar.edu.unq.arkanoid.mainscene.components.Ball;
import ar.edu.unq.arkanoid.scenes.levelScene.LevelScene;

public class TableLeftCollisionRule implements IRule<Ball, LevelScene> {

	@Override
	public boolean mustApply(final Ball ball, final Vector2D nextPosition,
			final LevelScene scene) {
		return nextPosition.getX() <= 0;
	}

	@Override
	public void apply(final Ball ball, final Vector2D nextPosition,
			final LevelScene scene) {
		ball.setX(ball.getAppearance().getWidth() / 2);
		final Vector2D direction = ball.getDirection();
		ball.setDirection(-direction.getX(), direction.getY());
	}

}
