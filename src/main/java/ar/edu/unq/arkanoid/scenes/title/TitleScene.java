package ar.edu.unq.arkanoid.scenes.title;

import ar.edu.unq.americana.GameScene;
import ar.edu.unq.americana.components.Button;
import ar.edu.unq.americana.components.Mouse;
import ar.edu.unq.arkanoid.Arkanoid;
import ar.edu.unq.arkanoid.scenes.gameover.GameOverScene;

public class TitleScene extends GameScene {

	public TitleScene() {
		Mouse.get().setAppearance(Arkanoid.BLUE_BALL.copy());
		this.addButton();
	}

	private void addButton() {
		final Button<GameOverScene> button = new Button<GameOverScene>(
				"New Game", Arkanoid.blocks.get(1), Arkanoid.blocks.get(-1)) {
			@Override
			public void action() {
				((Arkanoid) this.getGame()).firstLevel();
			}

		};
		button.alignHorizontalCenterTo((Arkanoid.WINDOW_WIDTH / 2));
		button.setY(Arkanoid.WINDOW_HEIGHT * .40);

		this.addComponent(button);
	}

}
