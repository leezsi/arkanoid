package ar.edu.unq.arkanoid.mainscene.block.rules;

import ar.edu.unq.americana.appearances.Appearance;
import ar.edu.unq.americana.colissions.CollisionDetector;
import ar.edu.unq.americana.utils.Vector2D;
import ar.edu.unq.arkanoid.mainscene.components.Ball;
import ar.edu.unq.arkanoid.mainscene.components.Block;
import ar.edu.unq.arkanoid.scenes.levelScene.LevelScene;

public class RightCollisionRule extends AbstractCollisionRule {

	@Override
	public void apply(final Block block, final Vector2D nextPosition,
			final LevelScene scene) {
		block.die();
		final Ball ball = scene.getBall();
		final Appearance appearance = block.getAppearance();
		ball.setX(appearance.getX() + appearance.getWidth()
				+ (ball.getAppearance().getWidth() / 2));
		ball.horizontalFlip();
		ball.moreSpeed();
	}

	@Override
	protected boolean isCollide(final double cx, final double cy,
			final double radious, final double left, final double top,
			final double right, final double bottom) {
		return CollisionDetector.collidesCircleAgainstLine(cx, cy, radious,
				right, top, right, bottom);
	}

}
