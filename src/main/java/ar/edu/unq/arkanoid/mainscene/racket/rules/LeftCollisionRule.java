package ar.edu.unq.arkanoid.mainscene.racket.rules;

import ar.edu.unq.americana.rules.IRule;
import ar.edu.unq.americana.utils.Vector2D;
import ar.edu.unq.arkanoid.mainscene.components.Racket;
import ar.edu.unq.arkanoid.scenes.MainScene;

public class LeftCollisionRule implements IRule<Racket, MainScene> {

	@Override
	public boolean mustApply(final Racket racket, final Vector2D nextPosition,
			final MainScene scene) {
		return (nextPosition.getX() - (racket.getAppearance().getWidth() / 2)) <= 0;
	}

	@Override
	public void apply(final Racket racket, final Vector2D nextPosition,
			final MainScene scene) {
		racket.setX(racket.getAppearance().getWidth() / 2);
	}

}
