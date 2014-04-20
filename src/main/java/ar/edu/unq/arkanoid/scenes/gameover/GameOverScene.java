package ar.edu.unq.arkanoid.scenes.gameover;

import java.awt.Color;
import java.awt.Font;

import ar.edu.unq.americana.GameComponent;
import ar.edu.unq.americana.GameScene;
import ar.edu.unq.americana.appearances.Label;
import ar.edu.unq.americana.components.Button;
import ar.edu.unq.americana.components.Mouse;
import ar.edu.unq.arkanoid.Arkanoid;
import ar.edu.unq.arkanoid.mainscene.components.Score;

public class GameOverScene extends GameScene {

	private final String text;
	private final Color color;
	private final Score score;

	public GameOverScene(final Score score, final String text, final Color color) {
		Mouse.get().setAppearance(Arkanoid.BLUE_BALL.copy());
		this.text = text;
		this.color = color;
		this.addLabel();
		this.addExitLevel();
		this.score = score;
	}

	private void addExitLevel() {
		final Button<GameOverScene> button = new Button<GameOverScene>("Exit",
				Arkanoid.blocks.get(1), Arkanoid.blocks.get(-1)) {
			@Override
			public void action() {
				((Arkanoid) this.getGame()).mainScene();
			}

		};
		button.alignHorizontalCenterTo((Arkanoid.WINDOW_WIDTH / 2));
		button.setY(Arkanoid.WINDOW_HEIGHT * .60);

		this.addComponent(button);
	}

	private void addLabel() {
		final Label label = new Label(new Font("verdana", Font.BOLD, 24),
				color, text);
		this.addComponent(new GameComponent<GameOverScene>() {
			{
				this.alignHorizontalCenterTo(Arkanoid.WINDOW_WIDTH / 2);
				this.setY(Arkanoid.WINDOW_HEIGHT * .20);
				this.setAppearance(label);
			}
		});
	}

	public Score getScore() {
		return score;
	}

}
