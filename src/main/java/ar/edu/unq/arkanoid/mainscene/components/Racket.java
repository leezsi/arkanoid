package ar.edu.unq.arkanoid.mainscene.components;

import java.awt.Color;

import ar.edu.unq.americana.DeltaState;
import ar.edu.unq.americana.GameComponent;
import ar.edu.unq.americana.appearances.Rectangle;
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

	public Racket() {
		this.setY(this.calculateTop());
		this.getAppearanceData().setOffset(-1, WIDTH / 2, -1, HEIGHT / 2);
		this.alignHorizontalCenterTo(Arkanoid.WINDOW_WIDTH / 2);
		this.setAppearance(new Rectangle(Color.YELLOW, WIDTH, HEIGHT));
	}

	private double calculateTop() {
		return Arkanoid.WINDOW_HEIGHT - DELTA_TOP - (HEIGHT / 2);
	}

	@KeyboarEvents.Press(Key.A)
	public void pressA(final DeltaState state, final Key key) {
	}

	@KeyboarEvents.BeingHold(Key.A)
	public void holdA(final DeltaState state, final Key key) {
		this.move(-SPEED * state.getDelta(), 0);
	}

	@KeyboarEvents.BeingHold(Key.D)
	public void holdD(final DeltaState state, final Key key) {
		this.move(SPEED * state.getDelta(), 0);
	}

}
