package ar.edu.unq.arkanoid.mainscene;

import java.awt.Color;

import ar.edu.unq.americana.GameScene;
import ar.edu.unq.americana.appearances.Circle;
import ar.edu.unq.americana.components.Button;
import ar.edu.unq.americana.components.Mouse;
import ar.edu.unq.arkanoid.Arkanoid;
import ar.edu.unq.arkanoid.gameover.GameOverScene;

public class TitleScene extends GameScene {

	public TitleScene() {
		Mouse.get().setAppearance(new Circle(Color.black, 3));
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
