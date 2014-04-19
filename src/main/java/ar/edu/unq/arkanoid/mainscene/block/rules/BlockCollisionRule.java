package ar.edu.unq.arkanoid.mainscene.block.rules;

import ar.edu.unq.americana.colissions.CollisionDetector;
import ar.edu.unq.americana.rules.IRule;
import ar.edu.unq.americana.utils.Vector2D;
import ar.edu.unq.arkanoid.mainscene.components.Ball;
import ar.edu.unq.arkanoid.mainscene.components.Block;
import ar.edu.unq.arkanoid.scenes.LevelScene;

public class BlockCollisionRule implements IRule<Block, LevelScene> {

	@Override
	public boolean mustApply(final Block block, final Vector2D nextPosition,
			final LevelScene scene) {

		return CollisionDetector.perfectPixel(scene.getBall(), block);
	}

	@Override
	public void apply(final Block block, final Vector2D nextPosition,
			final LevelScene scene) {
		final Ball ball = scene.getBall();
		ball.horizontalFlip();
		ball.verticalFlip();

	}

}
