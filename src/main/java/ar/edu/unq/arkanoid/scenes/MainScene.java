package ar.edu.unq.arkanoid.scenes;

import java.awt.Color;

import ar.edu.unq.americana.GameScene;
import ar.edu.unq.americana.utils.Tuning;
import ar.edu.unq.arkanoid.Arkanoid;
import ar.edu.unq.arkanoid.mainscene.components.Ball;
import ar.edu.unq.arkanoid.mainscene.components.Racket;
import ar.edu.unq.arkanoid.mainscene.components.VerticalBorder;

public class MainScene extends GameScene {

	public static final Integer BORDER_WIDTH = Tuning
			.getInteger("table.border.width");
	private static final Integer BORDER_HEIGHT = Arkanoid.WINDOW_HEIGHT
			- BORDER_WIDTH;
	public static final String BORDER_LEFT_ID = "left";
	public static final String BORDER_RIGHT_ID = "right";

	private VerticalBorder leftBorder;

	public MainScene() {
		this.addComponent(new Racket());
		this.addComponent(new Ball());
		this.addComponent(leftBorder = new VerticalBorder(0, BORDER_WIDTH,
				BORDER_WIDTH, BORDER_HEIGHT, Color.RED, BORDER_LEFT_ID));
		this.addComponent(new VerticalBorder(Arkanoid.WINDOW_WIDTH
				- BORDER_WIDTH, BORDER_WIDTH, BORDER_WIDTH, BORDER_HEIGHT,
				Color.RED, BORDER_RIGHT_ID));
	}

}
