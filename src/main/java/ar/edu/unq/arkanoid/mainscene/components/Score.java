package ar.edu.unq.arkanoid.mainscene.components;

import java.awt.Color;
import java.awt.Font;

import ar.edu.unq.americana.GameComponent;
import ar.edu.unq.americana.appearances.Label;
import ar.edu.unq.americana.events.annotations.Events;
import ar.edu.unq.arkanoid.Arkanoid;
import ar.edu.unq.arkanoid.mainscene.events.BlockDestroyed;
import ar.edu.unq.arkanoid.scenes.LevelScene;

public class Score extends GameComponent<LevelScene> {

	private int value;
	protected final Label label;
	protected String text;

	public Score(final String text) {
		value = 0;
		this.text = text;
		label = new Label(new Font("verdana", Font.BOLD, 36), Color.BLACK, text
				+ String.valueOf(value));
		this.setAppearance(label);
		this.setZ(Integer.MAX_VALUE);
		this.setX(Arkanoid.WINDOW_WIDTH / 2);
		this.setY(15);
		label.changeOffset(-1, Arkanoid.WINDOW_WIDTH / 2, -1,
				label.getHeight() / 2);
	}

	@Events.Fired(BlockDestroyed.class)
	public void add(final BlockDestroyed destroyed) {
		value++;
		label.setText(text + String.valueOf(value));
	}

	public int getScore() {
		return value;
	}
}
