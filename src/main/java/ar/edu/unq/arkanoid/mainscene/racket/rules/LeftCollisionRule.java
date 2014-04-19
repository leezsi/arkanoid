package ar.edu.unq.arkanoid.mainscene.racket.rules;

import ar.edu.unq.americana.rules.IRule;
import ar.edu.unq.americana.utils.Vector2D;
import ar.edu.unq.arkanoid.mainscene.components.Racket;
import ar.edu.unq.arkanoid.scenes.LevelScene;

public class LeftCollisionRule implements IRule<Racket, LevelScene> {

	@Override
	public boolean mustApply(final Racket racket, final Vector2D nextPosition,
			final LevelScene scene) {
		return (nextPosition.getX() - (racket.getAppearance().getWidth() / 2)) <= 0;
	}

	@Override
	public void apply(final Racket racket, final Vector2D nextPosition,
			final LevelScene scene) {
		racket.setX(racket.getAppearance().getWidth() / 2);
	}

}
