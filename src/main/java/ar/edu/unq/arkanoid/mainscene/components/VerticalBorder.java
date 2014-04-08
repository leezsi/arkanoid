package ar.edu.unq.arkanoid.mainscene.components;

import java.awt.Color;

import ar.edu.unq.americana.GameComponent;
import ar.edu.unq.americana.appearances.Rectangle;
import ar.edu.unq.arkanoid.scenes.MainScene;

public class VerticalBorder extends GameComponent<MainScene> {

	private final Integer width;
	private final Integer height;

	public VerticalBorder(final Integer width, final Integer height,
			final Color color) {
		this.width = width;
		this.height = height;
		this.setAppearance(new Rectangle(color, width, height));
	}

	public Integer getWidth() {
		return width;
	}

	public Integer getHeight() {
		return height;
	}

}
