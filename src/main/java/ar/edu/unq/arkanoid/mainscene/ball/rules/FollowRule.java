package ar.edu.unq.arkanoid.mainscene.ball.rules;

import ar.edu.unq.americana.rules.IRule;
import ar.edu.unq.americana.utils.Vector2D;
import ar.edu.unq.arkanoid.mainscene.components.Ball;
import ar.edu.unq.arkanoid.scenes.MainScene;

public class FollowRule implements IRule<Ball, MainScene> {

	@Override
	public boolean mustApply(final Ball component, final Vector2D nextPosition,
			final MainScene scene) {
		return true;
	}

	@Override
	public void apply(final Ball ball, final Vector2D nextPosition,
			final MainScene scene) {
		ball.setX(ball.getRacket().getX());
	}
}
