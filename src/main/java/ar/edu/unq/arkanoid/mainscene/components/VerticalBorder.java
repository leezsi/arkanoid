package ar.edu.unq.arkanoid.mainscene.components;

import java.awt.Color;

import ar.edu.unq.americana.GameComponent;
import ar.edu.unq.americana.appearances.Rectangle;
import ar.edu.unq.arkanoid.scenes.MainScene;

public class VerticalBorder extends GameComponent<MainScene> {

	private final Integer width;
	private final Integer height;
	private final String id;

	public VerticalBorder(final double x, final double y, final Integer width,
			final Integer height, final Color color, final String id) {
		this.setX(x);
		this.setY(y);
		this.width = width;
		this.height = height;
		this.setAppearance(new Rectangle(color, width, height));
		this.id = id;
	}

	public Integer getWidth() {
		return width;
	}

	public Integer getHeight() {
		return height;
	}

	public String getId() {
		return id;
	}

}
