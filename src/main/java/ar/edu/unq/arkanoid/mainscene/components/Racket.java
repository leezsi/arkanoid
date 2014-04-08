package ar.edu.unq.arkanoid.mainscene.components;

import java.awt.Color;

import ar.edu.unq.americana.DeltaState;
import ar.edu.unq.americana.GameComponent;
import ar.edu.unq.americana.appearances.Appearance;
import ar.edu.unq.americana.appearances.Rectangle;
import ar.edu.unq.americana.colissions.CollisionDetector;
import ar.edu.unq.americana.colissions.annotations.CollitionChecker;
import ar.edu.unq.americana.constants.Key;
import ar.edu.unq.americana.events.annotations.KeyboarEvents;
import ar.edu.unq.americana.utils.Tuning;
import ar.edu.unq.arkanoid.Arkanoid;
import ar.edu.unq.arkanoid.scenes.MainScene;

public class Racket extends GameComponent<MainScene> {

	private static final int WIDTH = Tuning.getInteger("racket.defaultWidth");
	private static final int HEIGHT = Tuning.getInteger("racket.defaultHeight");
	private static final int DELTA_TOP = Tuning.getInteger("racket.deltaTop");
	private static final int SPEED = Tuning.getInteger("racket.speed");
	private String borderCollide;

	public Racket() {
		this.setY(this.calculateTop());
		this.setAppearenceOffset(-1, WIDTH / 2, -1, HEIGHT / 2);
		this.alignHorizontalCenterTo(Arkanoid.WINDOW_WIDTH / 2);
		this.setAppearance(new Rectangle(Color.YELLOW, WIDTH, HEIGHT));
	}

	private double calculateTop() {
		return Arkanoid.WINDOW_HEIGHT - DELTA_TOP - (HEIGHT / 2);
	}

	@KeyboarEvents.BeingHold(Key.A)
	public void holdA(final DeltaState state) {
		if ((borderCollide == null)
				|| borderCollide.equals(MainScene.BORDER_RIGHT_ID)) {
			this.move(-SPEED * state.getDelta(), 0);
			borderCollide = null;
		}
	}

	@KeyboarEvents.BeingHold(Key.D)
	public void holdD(final DeltaState state) {
		if ((borderCollide == null)
				|| borderCollide.equals(MainScene.BORDER_LEFT_ID)) {
			this.move(SPEED * state.getDelta(), 0);
			borderCollide = null;
		}
	}

	@CollitionChecker.Against(target = VerticalBorder.class, fire = "collide")
	public boolean borderCollide(final VerticalBorder border) {
		final Appearance thisAppearance = this.getAppearance();
		final double x1 = thisAppearance.getX();
		final double y1 = thisAppearance.getY();
		final int width1 = (int) thisAppearance.getWidth();
		final int height1 = (int) thisAppearance.getHeight();
		final Appearance borderAppearance = border.getAppearance();
		final double x2 = borderAppearance.getX();
		final double y2 = borderAppearance.getY();
		final int width2 = (int) borderAppearance.getWidth();
		final int height2 = (int) borderAppearance.getHeight();
		return CollisionDetector.collidesRectAgainstRect(x1, y1, width1,
				height1, x2, y2, width2, height2);
	}

	public void collide(final VerticalBorder border) {
		if (border.getId().equals(MainScene.BORDER_LEFT_ID)) {
			this.setX(MainScene.BORDER_WIDTH + (WIDTH / 2));
		} else {
			this.setX(Arkanoid.WINDOW_WIDTH - MainScene.BORDER_WIDTH
					- (WIDTH / 2));
		}
	}

}
