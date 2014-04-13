package ar.edu.unq.arkanoid;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import ar.edu.unq.americana.Game;
import ar.edu.unq.americana.appearances.Sprite;
import ar.edu.unq.americana.sound.Sound;
import ar.edu.unq.americana.utils.Tuning;
import ar.edu.unq.arkanoid.mainscene.components.Ball;
import ar.edu.unq.arkanoid.scenes.MainScene;
import ar.edu.unq.arkanoid.utils.SoundUtils;
import ar.edu.unq.arkanoid.utils.SpriteUtils;

public class Arkanoid extends Game {

	static {
		Tuning.load("game.properties");
	}

	public static final Integer WINDOW_WIDTH = Tuning
			.getInteger("window.width");
	public static final Integer WINDOW_HEIGHT = Tuning
			.getInteger("window.height");

	public static final double HORIZONTAL_SPACE = WINDOW_WIDTH * .98;
	public static final double VERTICAL_SPACE = WINDOW_HEIGHT * .50;

	private static int ROWS = Tuning.getInteger("table.rows");
	private static int COLUMNS = Tuning.getInteger("table.columns") - 1;

	private Dimension dimension;
	public static Sound SOUND_BOOM;
	public static Sprite GREY_BALL;
	public static Sprite BLUE_BALL;

	public static Map<Integer, Sprite> blocks = new HashMap<Integer, Sprite>();

	@Override
	protected void initializeResources() {
		dimension = new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
		initializeSprites();
		SOUND_BOOM = SoundUtils.getSound("assets/sound/rumble.wav");
	}

	private void initializeSprites() {
		final double widthScale = HORIZONTAL_SPACE / COLUMNS;
		final double heightScale = VERTICAL_SPACE / ROWS;
		blocks.put(1, SpriteUtils.get(
				"assets/blocks/element_blue_rectangle_glossy.png", widthScale,
				heightScale));
		blocks.put(2, SpriteUtils.get(
				"assets/blocks/element_green_rectangle_glossy.png", widthScale,
				heightScale));
		blocks.put(3, SpriteUtils.get(
				"assets/blocks/element_yellow_rectangle_glossy.png",
				widthScale, heightScale));
		blocks.put(4, SpriteUtils.get(
				"assets/blocks/element_red_rectangle_glossy.png", widthScale,
				heightScale));
		blocks.put(5, SpriteUtils.get(
				"assets/blocks/element_purple_rectangle_glossy.png",
				widthScale, heightScale));
		blocks.put(-1, SpriteUtils.get(
				"assets/blocks/element_grey_rectangle_glossy.png", widthScale,
				heightScale));

		BLUE_BALL = SpriteUtils.get("assets/balls/ballBlue.png",
				Ball.BALL_DIAMETER, Ball.BALL_DIAMETER);

		GREY_BALL = SpriteUtils.get("assets/balls/ballGrey.png",
				Ball.BALL_DIAMETER, Ball.BALL_DIAMETER);
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
