package ar.edu.unq.arkanoid.scenes.gameover;

import java.awt.Color;

import ar.edu.unq.americana.components.Button;
import ar.edu.unq.arkanoid.Arkanoid;
import ar.edu.unq.arkanoid.mainscene.components.Score;

public class WinnerGameOverScene extends GameOverScene {

	public WinnerGameOverScene(final Score score, final String text,
			final Color color) {
		super(score, text, color);
		this.addNextLevel();
	}

	private void addNextLevel() {
		final Button<GameOverScene> button = new Button<GameOverScene>(
				"Next level", Arkanoid.blocks.get(1), Arkanoid.blocks.get(-1)) {

			@Override
			public void action() {
				final Arkanoid arkanoid = ((Arkanoid) this.getGame());
				arkanoid.nextLevel(WinnerGameOverScene.this.getScore());
			}

		};
		button.alignHorizontalCenterTo((Arkanoid.WINDOW_WIDTH / 2));
		button.setY(Arkanoid.WINDOW_HEIGHT * .40);
		this.addComponent(button);
	}

}
