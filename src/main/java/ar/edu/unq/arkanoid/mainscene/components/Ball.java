package ar.edu.unq.arkanoid.mainscene.components;

import java.awt.Color;

import ar.edu.unq.americana.GameComponent;
import ar.edu.unq.americana.appearances.Circle;
import ar.edu.unq.americana.utils.Tuning;
import ar.edu.unq.arkanoid.scenes.MainScene;

public class Ball extends GameComponent<MainScene> {

	private static final int BALL_DIAMETER = Tuning.getInteger("ball.diameter");

	public Ball() {
		this.setAppearance(new Circle(Color.BLUE, BALL_DIAMETER));

	}

}
