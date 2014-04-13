package ar.edu.unq.arkanoid.mainscene.ball.rules;

import ar.edu.unq.americana.rules.IRule;
import ar.edu.unq.americana.utils.Vector2D;
import ar.edu.unq.arkanoid.mainscene.components.Ball;
import ar.edu.unq.arkanoid.scenes.MainScene;

public class TableTopCollisionRule implements IRule<Ball, MainScene> {

	@Override
	public boolean mustApply(final Ball ball, final Vector2D nextPosition,
			final MainScene scene) {
		return nextPosition.getY() <= 0;
	}

	@Override
	public void apply(final Ball ball, final Vector2D nextPosition,
			final MainScene scene) {
		ball.setY(ball.getAppearance().getHeight() / 2);
		ball.setDirection(ball.getDirection().getX(), 1);
	}

}
