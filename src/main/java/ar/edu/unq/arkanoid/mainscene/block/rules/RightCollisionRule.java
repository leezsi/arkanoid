package ar.edu.unq.arkanoid.mainscene.block.rules;

import ar.edu.unq.americana.appearances.Appearance;
import ar.edu.unq.americana.colissions.CollisionDetector;
import ar.edu.unq.americana.rules.IRule;
import ar.edu.unq.americana.utils.Vector2D;
import ar.edu.unq.arkanoid.mainscene.components.Ball;
import ar.edu.unq.arkanoid.mainscene.components.Block;
import ar.edu.unq.arkanoid.scenes.MainScene;

public class RightCollisionRule implements IRule<Block, MainScene> {

	@Override
	public boolean mustApply(final Block block, final Vector2D nextPosition,
			final MainScene scene) {

		final Appearance appearance = block.getAppearance();
		final double x = appearance.getX() + appearance.getWidth();
		final double top = appearance.getY();
		final Ball ball = scene.getBall();
		final Appearance ballAppearance = ball.getAppearance();
		return CollisionDetector.collidesCircleAgainstLine(ball.getX(),
				ball.getY(), ballAppearance.getWidth() / 2, x, top, x, top
						+ appearance.getHeight());
	}

	@Override
	public void apply(final Block block, final Vector2D nextPosition,
			final MainScene scene) {
		block.die();
		final Ball ball = scene.getBall();
		ball.horizontalFlip();
		final Appearance appearance = block.getAppearance();
		ball.setX(appearance.getX() + appearance.getWidth()
				+ (ball.getAppearance().getWidth() / 2));
	}

}
