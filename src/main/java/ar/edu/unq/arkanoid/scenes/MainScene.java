package ar.edu.unq.arkanoid.scenes;

import ar.edu.unq.americana.GameScene;
import ar.edu.unq.americana.utils.Tuning;
import ar.edu.unq.arkanoid.mainscene.components.Ball;
import ar.edu.unq.arkanoid.mainscene.components.Block;
import ar.edu.unq.arkanoid.mainscene.components.HigherScore;
import ar.edu.unq.arkanoid.mainscene.components.LiveCounter;
import ar.edu.unq.arkanoid.mainscene.components.Racket;
import ar.edu.unq.arkanoid.mainscene.components.Score;
import ar.edu.unq.arkanoid.mainscene.components.Table;
import ar.edu.unq.arkanoid.maps.MapCreator;

public class MainScene extends GameScene {

	public static final Integer BORDER_WIDTH = Tuning
			.getInteger("table.border.width");
	public static final String BORDER_LEFT_ID = "left";
	public static final String BORDER_RIGHT_ID = "right";
	private final Ball ball;

	public MainScene() {
		this.addComponent(new Score("Score: "));
		this.addComponent(new HigherScore("High score: "));
		ball = new Ball();
		final Racket racket = new Racket(ball);
		this.addComponent(ball);
		ball.setRacket(racket);
		this.addComponent(racket);
		this.addComponent(new Table());
		this.addComponent(new LiveCounter());
		MapCreator.create(this, "levels/level1.map");
	}

	public void addBlock(final int x, final int y, final int lives) {
		if (lives > 0) {
			this.addComponent(new Block(x, y, lives));
		}
	}

	public Ball getBall() {
		return ball;
	}

}
