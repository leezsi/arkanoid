package ar.edu.unq.arkanoid.scenes;

import ar.edu.unq.americana.GameScene;
import ar.edu.unq.americana.utils.Tuning;
import ar.edu.unq.arkanoid.mainscene.components.Ball;
import ar.edu.unq.arkanoid.mainscene.components.Block;
import ar.edu.unq.arkanoid.mainscene.components.Racket;
import ar.edu.unq.arkanoid.mainscene.components.Table;

public class MainScene extends GameScene {

	public static final Integer BORDER_WIDTH = Tuning
			.getInteger("table.border.width");
	public static final String BORDER_LEFT_ID = "left";
	public static final String BORDER_RIGHT_ID = "right";

	public MainScene() {
		final Ball ball = new Ball();
		final Racket racket = new Racket(ball);
		this.addComponent(ball);
		ball.setRacket(racket);
		this.addComponent(racket);
		this.addComponent(new Table());
		// MapCreator.create(this, "levels/level1.map");
	}

	public void addBlock(final int x, final int y, final int lives) {
		if (lives > 0) {
			this.addComponent(new Block(x, y, lives));
		}
	}

}
