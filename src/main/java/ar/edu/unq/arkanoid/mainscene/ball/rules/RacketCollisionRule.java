package ar.edu.unq.arkanoid.mainscene.ball.rules;

import ar.edu.unq.americana.appearances.Appearance;
import ar.edu.unq.americana.colissions.CollisionDetector;
import ar.edu.unq.americana.rules.IRule;
import ar.edu.unq.americana.utils.Vector2D;
import ar.edu.unq.arkanoid.mainscene.components.Ball;
import ar.edu.unq.arkanoid.mainscene.components.Racket;
import ar.edu.unq.arkanoid.scenes.LevelScene;

public class RacketCollisionRule implements IRule<Ball, LevelScene> {

	private final Appearance racket;
	private final double b;
	private final double m;

	public RacketCollisionRule(final Racket racket) {
		this.racket = racket.getAppearance();
		final double lesserAngle = Ball.lesserAngle;
		final double graterAngle = Ball.greaterAngle;
		b = lesserAngle;
		m = (graterAngle - lesserAngle) / racket.getWidth();
	}

	@Override
	public boolean mustApply(final Ball ball, final Vector2D nextPosition,
			final LevelScene scene) {
		final Appearance ballAppearance = ball.getAppearance();
		final double cx = ballAppearance.getX();
		final double cy = ballAppearance.getY();
		final double cratio = ballAppearance.getHeight() / 2;
		final double rx = racket.getX();
		final double ry = racket.getY();
		final double rwidth = racket.getWidth();
		final double rheight = racket.getHeight();
		return CollisionDetector.collidesCircleAgainstRect(cx, cy, cratio, rx,
				ry, rwidth, rheight);
	}

	@Override
	public void apply(final Ball ball, final Vector2D nextPosition,
			final LevelScene scene) {
		ball.setY(racket.getY() - (ball.getAppearance().getHeight() / 2));
		ball.setDirection(this.getXDirection(ball), -1);
	}

	private double getXDirection(final Ball ball) {
		final double zero = racket.getX();
		final double x = ball.getX() - zero;
		return (m * x) + b;
	}

}
