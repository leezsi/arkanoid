package ar.edu.unq.arkanoid.mainscene.components;

import ar.edu.unq.americana.rules.IRule;
import ar.edu.unq.americana.utils.Vector2D;
import ar.edu.unq.arkanoid.scenes.MainScene;

public class NoCollisionRule implements IRule<Ball, MainScene> {

	@Override
	public boolean mustApply(final Ball component, final Vector2D nextPosition,
			final MainScene scene) {
		return true;
	}

	@Override
	public void apply(final Ball ball, final Vector2D nextPosition,
			final MainScene scene) {
		ball.move(nextPosition);
	}

}
