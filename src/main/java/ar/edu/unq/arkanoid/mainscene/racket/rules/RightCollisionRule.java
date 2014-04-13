package ar.edu.unq.arkanoid.mainscene.racket.rules;

import ar.edu.unq.americana.rules.IRule;
import ar.edu.unq.americana.utils.Vector2D;
import ar.edu.unq.arkanoid.mainscene.components.Racket;
import ar.edu.unq.arkanoid.scenes.MainScene;

public class RightCollisionRule implements IRule<Racket, MainScene> {

	@Override
	public boolean mustApply(final Racket racket, final Vector2D nextPosition,
			final MainScene scene) {
		final double delta = racket.getAppearance().getWidth() / 2;
		return (nextPosition.getX() + delta) >= racket.getGame()
				.getDisplayWidth();
	}

	@Override
	public void apply(final Racket racket, final Vector2D nextPosition,
			final MainScene scene) {
		final double delta = racket.getAppearance().getWidth() / 2;
		final int width = racket.getGame().getDisplayWidth();
		racket.setX(width - delta);
	}

}
