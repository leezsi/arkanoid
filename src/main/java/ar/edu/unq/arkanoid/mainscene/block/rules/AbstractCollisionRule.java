package ar.edu.unq.arkanoid.mainscene.block.rules;

import ar.edu.unq.americana.appearances.Appearance;
import ar.edu.unq.americana.rules.IRule;
import ar.edu.unq.americana.utils.Vector2D;
import ar.edu.unq.arkanoid.mainscene.components.Ball;
import ar.edu.unq.arkanoid.mainscene.components.Block;
import ar.edu.unq.arkanoid.scenes.levelScene.LevelScene;

public abstract class AbstractCollisionRule implements IRule<Block, LevelScene> {

	double delta = -0.3;

	@Override
	public boolean mustApply(final Block block, final Vector2D nextPosition,
			final LevelScene scene) {
		final Appearance appearance = block.getAppearance();
		final double left = appearance.getX() - delta;
		final double top = appearance.getY() - delta;
		final double right = left + appearance.getWidth() + delta;
		final double bottom = top + appearance.getHeight() + delta;

		final Ball ball = scene.getBall();
		final Appearance ballAppearance = ball.getAppearance();
		final double cx = ball.getX();
		final double cy = ball.getY();
		final double radious = ballAppearance.getWidth() / 2;
		return this.isCollide(cx, cy, radious, left, top, right, bottom);
	}

	protected abstract boolean isCollide(double cx, double cy, double radious,
			double left, double top, double right, double bottom);

}
