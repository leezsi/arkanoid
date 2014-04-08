package ar.edu.unq.arkanoid;

import java.awt.Dimension;

import ar.edu.unq.americana.Game;
import ar.edu.unq.americana.utils.Tuning;
import ar.edu.unq.arkanoid.scenes.MainScene;

public class Arkanoid extends Game {

	static {
		Tuning.load("game.properties");
	}

	public static final Integer WINDOW_WIDTH = Tuning
			.getInteger("window.width");
	public static final Integer WINDOW_HEIGHT = Tuning
			.getInteger("window.height");
	private Dimension dimension;

	@Override
	protected void initializeResources() {
		dimension = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);

	}

	@Override
	protected void setUpScenes() {
		final MainScene mainScene = new MainScene();
		this.setCurrentScene(mainScene);
	}

	@Override
	public Dimension getDisplaySize() {
		return dimension;
	}

	@Override
	public String getTitle() {
		return "Arkanoid";
	}

}
