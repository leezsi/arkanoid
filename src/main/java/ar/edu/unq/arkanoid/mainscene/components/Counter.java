package ar.edu.unq.arkanoid.mainscene.components;

import java.awt.Color;
import java.awt.Font;

import ar.edu.unq.americana.GameComponent;
import ar.edu.unq.americana.appearances.Label;
import ar.edu.unq.americana.events.annotations.Events;
import ar.edu.unq.arkanoid.mainscene.events.BlockDestroyed;
import ar.edu.unq.arkanoid.scenes.MainScene;

public class Counter extends GameComponent<MainScene> {

	private int value;

	public Counter() {
		value = 0;
		this.setAppearance(new Label(new Font("verdana", Font.BOLD, 36),
				Color.BLACK, String.valueOf(value)));
		this.setZ(Integer.MAX_VALUE);
		this.setX(10);
		this.setY(10);
	}

	@Events.Fired(BlockDestroyed.class)
	public void add(final BlockDestroyed destroyed) {
		value++;
		this.setAppearance(new Label(new Font("verdana", Font.BOLD, 36),
				Color.BLACK, String.valueOf(value)));
	}
}
