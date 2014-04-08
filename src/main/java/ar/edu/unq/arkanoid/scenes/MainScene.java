package ar.edu.unq.arkanoid.scenes;

import ar.edu.unq.americana.GameScene;
import ar.edu.unq.arkanoid.mainscene.components.Racket;

public class MainScene extends GameScene {

	public MainScene() {
		this.addComponent(new Racket());
	}

}
