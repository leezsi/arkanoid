package ar.edu.unq.arkanoid.mainscene.components;

import java.awt.Color;
import java.awt.Font;

import ar.edu.unq.americana.GameComponent;
import ar.edu.unq.americana.appearances.Label;
import ar.edu.unq.americana.events.annotations.Events;
import ar.edu.unq.arkanoid.mainscene.events.BlockDestroyed;
import ar.edu.unq.arkanoid.scenes.MainScene;

public class Score extends GameComponent<MainScene> {

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
		this.setX((label.getWidth() / 2) + 15);
		this.setY(15);
	}

	@Events.Fired(BlockDestroyed.class)
	public void add(final BlockDestroyed destroyed) {
		value++;
		label.setText(text + String.valueOf(value));
	}
}
