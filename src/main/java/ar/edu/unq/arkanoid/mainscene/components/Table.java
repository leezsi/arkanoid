package ar.edu.unq.arkanoid.mainscene.components;

import ar.edu.unq.americana.GameComponent;
import ar.edu.unq.arkanoid.Arkanoid;
import ar.edu.unq.arkanoid.scenes.MainScene;

public class Table extends GameComponent<MainScene> {

	public int getWidth() {
		return Arkanoid.WINDOW_WIDTH;
	}

	public int getHeight() {
		return Arkanoid.WINDOW_HEIGHT;
	}

}
