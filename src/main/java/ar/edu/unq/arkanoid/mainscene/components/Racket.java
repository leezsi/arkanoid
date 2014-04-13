package ar.edu.unq.arkanoid.mainscene.components;

import ar.edu.unq.americana.DeltaState;
import ar.edu.unq.americana.GameComponent;
import ar.edu.unq.americana.appearances.Shape;
import ar.edu.unq.americana.appearances.Sprite;
import ar.edu.unq.americana.constants.Key;
import ar.edu.unq.americana.events.annotations.Events.Keyboard;
import ar.edu.unq.americana.utils.Tuning;
import ar.edu.unq.arkanoid.Arkanoid;
import ar.edu.unq.arkanoid.rules.GameStatusEvent;
import ar.edu.unq.arkanoid.rules.GameStatusEvent.State;
import ar.edu.unq.arkanoid.scenes.MainScene;

public class Racket extends GameComponent<MainScene> {

	private static final int DELTA_TOP = Tuning.getInteger("racket.deltaTop");
	private static final int SPEED = Tuning.getInteger("racket.speed");
	private static final int WIDTH = Tuning.getInteger("racket.width");
	private static final int HEIGHT = Tuning.getInteger("racket.height");
	private boolean leftCollision = false;
	private boolean rightCollision = false;
	private final Ball ball;

	public Racket(final Ball ball) {
		this.alignHorizontalCenterTo(Arkanoid.WINDOW_WIDTH / 2);
		this.setY(this.calculateTop());
		this.setAppearance(this.getImage());
		this.ball = ball;
		ball.setRacket(this);
	}

	private Shape getImage() {
		final Sprite image = Sprite.fromImage("assets/paddleRed.png");
		return image.scaleHorizontally(WIDTH / image.getWidth())
				.scaleVertically(HEIGHT / image.getHeight());
	}

	private double calculateTop() {
		return (Arkanoid.WINDOW_HEIGHT - DELTA_TOP) + (HEIGHT / 2);
	}

	@Keyboard.BeingHold(Key.A)
	public void holdA(final DeltaState state) {
		rightCollision = false;
		if (!leftCollision) {
			this.move(-SPEED * state.getDelta(), 0);
		}
	}

	@Keyboard.BeingHold(Key.D)
	public void holdD(final DeltaState state) {
		leftCollision = false;
		if (!rightCollision) {
			this.move(SPEED * state.getDelta(), 0);
		}
	}

	@Keyboard.Press(Key.ENTER)
	public void start(final DeltaState state) {
		this.fireEvent(new GameStatusEvent(State.PLAY));
	}

	public int getWidth() {
		return WIDTH;
	}

	public Ball getBall() {
		return ball;
	}

}
