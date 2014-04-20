package ar.edu.unq.arkanoid.scenes.levelScene;

import ar.edu.unq.americana.GameScene;
import ar.edu.unq.americana.appearances.Invisible;
import ar.edu.unq.americana.components.Mouse;
import ar.edu.unq.americana.utils.Tuning;
import ar.edu.unq.arkanoid.mainscene.components.Ball;
import ar.edu.unq.arkanoid.mainscene.components.Block;
import ar.edu.unq.arkanoid.mainscene.components.LiveCounter;
import ar.edu.unq.arkanoid.mainscene.components.Racket;
import ar.edu.unq.arkanoid.mainscene.components.Score;
import ar.edu.unq.arkanoid.mainscene.components.Table;
import ar.edu.unq.arkanoid.maps.MapCreator;

public class LevelScene extends GameScene {

	public static final Integer BORDER_WIDTH = Tuning
			.getInteger("table.border.width");
	public static final String BORDER_LEFT_ID = "left";
	public static final String BORDER_RIGHT_ID = "right";
	private final Ball ball;
	private final Score score;

	public LevelScene(final int level, final Score score) {
		Mouse.get().setAppearance(new Invisible());
		this.score = score;
		this.addComponent(score);
		ball = new Ball();
		final Racket racket = new Racket(ball);
		this.addComponent(ball);
		ball.setRacket(racket);
		this.addComponent(racket);
		final Table table = new Table();
		this.addComponent(table);
		this.addComponent(new LiveCounter(score));
		table.setBockCount(MapCreator.create(this, "levels/level" + level
				+ ".map"));
	}

	public void addBlock(final int x, final int y, final int lives) {
		if (lives > 0) {
			this.addComponent(new Block(x, y, lives));
		}
	}

	public Ball getBall() {
		return ball;
	}

	public Score getScore() {
		return score;
	}

}
