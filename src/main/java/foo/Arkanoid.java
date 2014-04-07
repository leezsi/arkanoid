package foo;

import java.awt.Color;
import java.awt.Dimension;

import ar.edu.unq.americana.DeltaState;
import ar.edu.unq.americana.DesktopGameLauncher;
import ar.edu.unq.americana.Game;
import ar.edu.unq.americana.GameComponent;
import ar.edu.unq.americana.GameScene;
import ar.edu.unq.americana.appearances.Circle;

public class Arkanoid extends Game {

	private Dimension dimension;

	@Override
	protected void initializeResources() {
		dimension = new Dimension(800, 600);

	}

	@Override
	protected void setUpScenes() {
		final GameScene scene = new GameScene();
		final int diameter = 50;
		scene.addComponent(new GameComponent<GameScene>(new Circle(Color.blue,
				diameter), 0, 290) {
			int direction = 1;
			double velocity = 100;

			@Override
			public void update(final DeltaState deltaState) {
				this.setX(this.getX()
						+ (direction * velocity * deltaState.getDelta()));
				if (this.getX() <= 0) {
					this.setX(0);
					direction = -direction;
				} else if ((this.getX() + diameter) >= dimension.width) {
					this.setX(dimension.width - diameter);
					direction = -direction;
				}
			}
		});
		this.setCurrentScene(scene);
	}

	@Override
	public Dimension getDisplaySize() {
		return dimension;
	}

	@Override
	public String getTitle() {
		return "Arkanoid";
	}

	public static void main(final String[] args) {
		new DesktopGameLauncher(new Arkanoid()).launch();
	}

}
