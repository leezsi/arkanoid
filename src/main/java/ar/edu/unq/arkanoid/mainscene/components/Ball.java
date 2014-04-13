package ar.edu.unq.arkanoid.mainscene.components;

import ar.edu.unq.americana.DeltaState;
import ar.edu.unq.americana.GameComponent;
import ar.edu.unq.americana.appearances.Appearance;
import ar.edu.unq.americana.appearances.Shape;
import ar.edu.unq.americana.appearances.Sprite;
import ar.edu.unq.americana.constants.Key;
import ar.edu.unq.americana.events.annotations.Events.Keyboard.Press;
import ar.edu.unq.americana.events.annotations.Events.Update;
import ar.edu.unq.americana.rules.IRule;
import ar.edu.unq.americana.utils.Tuning;
import ar.edu.unq.americana.utils.Vector2D;
import ar.edu.unq.arkanoid.Arkanoid;
import ar.edu.unq.arkanoid.mainscene.ball.rules.FollowRule;
import ar.edu.unq.arkanoid.mainscene.ball.rules.RacketCollisionRule;
import ar.edu.unq.arkanoid.mainscene.ball.rules.TableLeftCollisionRule;
import ar.edu.unq.arkanoid.mainscene.ball.rules.TableOutRule;
import ar.edu.unq.arkanoid.mainscene.ball.rules.TableRightCollisionRule;
import ar.edu.unq.arkanoid.mainscene.ball.rules.TableTopCollisionRule;
import ar.edu.unq.arkanoid.scenes.MainScene;

public class Ball extends GameComponent<MainScene> {
	private static final int BALL_DIAMETER = Tuning.getInteger("ball.diameter");

	public static double greaterAngle = Math.PI / 3;
	public static double lesserAngle = -Math.PI / 3;

	private Racket racket;

	private final double currentSpeed;

	public Ball() {
		this.alignHorizontalCenterTo(Arkanoid.WINDOW_WIDTH / 2);
		final Shape image = this.getImage();
		this.setAppearance(image);
		currentSpeed = Tuning.getDouble("racket.speed");
	}

	@Press(Key.SPACE)
	public void free(final DeltaState delta) {
		this.setDirection(1, -1);
		this.changeRules(this.freeRules());
	}

	private IRule<?, ?>[] freeRules() {
		return new IRule<?, ?>[] { new TableTopCollisionRule(),
				new TableLeftCollisionRule(), new TableRightCollisionRule(),
				new RacketCollisionRule(racket), new TableOutRule(racket),
				new NoCollisionRule() };
	}

	public double getV(final double angle) {
		return Math.sin(angle);
	}

	public double getU(final double angle) {
		return Math.cos(angle);
	}

	private Shape getImage() {
		final Sprite image = Sprite.fromImage("assets/ballBlue.png");
		return image.scale(BALL_DIAMETER / image.getWidth());
	}

	private double calculateTop() {
		final Appearance rect = racket.getAppearance();
		return (racket.getY() - (rect.getHeight() / 2))
				- (this.getAppearance().getHeight() / 2);
	}

	@Update
	public void update(final double delta) {
	}

	public void setRacket(final Racket racket) {
		this.racket = racket;
		this.setY(this.calculateTop());
	}

	@Override
	protected IRule<?, ?>[] rules() {
		return followRules();
	}

	private IRule<?, ?>[] followRules() {
		return new IRule<?, ?>[] { new FollowRule() };
	}

	public void following() {
		this.changeRules(this.followRules());
	}

	public Racket getRacket() {
		return racket;
	}

	@Override
	protected double getSpeed() {
		return currentSpeed;
	}

	public void horizontalFlip() {
		final Vector2D d = this.getDirection();
		this.setDirection(-d.getX(), d.getY());
	}

	public void verticalFlip() {
		final Vector2D d = this.getDirection();
		this.setDirection(d.getX(), -d.getY());
	}

}
