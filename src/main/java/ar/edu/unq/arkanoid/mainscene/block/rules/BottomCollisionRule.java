package ar.edu.unq.arkanoid.mainscene.block.rules;

import ar.edu.unq.americana.appearances.Appearance;
import ar.edu.unq.americana.colissions.CollisionDetector;
import ar.edu.unq.americana.utils.Vector2D;
import ar.edu.unq.arkanoid.mainscene.components.Ball;
import ar.edu.unq.arkanoid.mainscene.components.Block;
import ar.edu.unq.arkanoid.scenes.levelScene.LevelScene;

public class BottomCollisionRule extends AbstractCollisionRule {

	@Override
	public void apply(final Block block, final Vector2D nextPosition,
			final LevelScene scene) {
		block.die();
		final Ball ball = scene.getBall();
		ball.verticalFlip();
		ball.moreSpeed();
		final Appearance appearance = block.getAppearance();
		ball.setY((appearance.getY() + appearance.getHeight())
				+ (ball.getAppearance().getHeight() / 2));
	}

	@Override
	protected boolean isCollide(final double cx, final double cy,
			final double radious, final double left, final double top,
			final double right, final double bottom) {
		return CollisionDetector.collidesCircleAgainstLine(cx, cy, radious,
				left, bottom, right, bottom);
	}

}
