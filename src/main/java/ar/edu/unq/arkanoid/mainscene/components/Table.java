package ar.edu.unq.arkanoid.mainscene.components;

import ar.edu.unq.americana.GameComponent;
import ar.edu.unq.americana.events.annotations.Events;
import ar.edu.unq.americana.events.annotations.Events.Fired;
import ar.edu.unq.arkanoid.mainscene.events.BlockDestroyed;
import ar.edu.unq.arkanoid.mainscene.events.GameOverEvent;
import ar.edu.unq.arkanoid.scenes.levelScene.LevelScene;

public class Table extends GameComponent<LevelScene> {

	private int blocks;

	@Fired(GameOverEvent.class)
	public void gameOver(final GameOverEvent event) {
		event.getState().changeScene(getGame());
	}

	@Events.Fired(BlockDestroyed.class)
	public void add(final BlockDestroyed destroyed) {
		if (--blocks == 0) {
			this.fireEvent(new GameOverEvent(this.getScene().getScore(),
					GameOverEvent.State.WIN));
		}
	}

	public void setBockCount(final int blocks) {
		this.blocks = blocks;
	}
}
