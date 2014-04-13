package ar.edu.unq.arkanoid.mainscene.appearance;

import java.awt.Graphics2D;

import ar.edu.unq.americana.GameComponent;
import ar.edu.unq.americana.appearances.Shape;
import ar.edu.unq.americana.appearances.Sprite;
import ar.edu.unq.americana.utils.Vector2D;
import ar.edu.unq.arkanoid.mainscene.components.LiveCounter;

public class LiveAppearance extends Shape {
	private final Sprite inactiveSprite;
	private final Sprite activeSprite;
	private final int total;
	private int actual;

	public LiveAppearance(final int lives, final Sprite active,
			final Sprite inactive) {
		total = lives;
		activeSprite = active.copy();
		inactiveSprite = inactive.copy();
	}

	@Override
	public double getX() {
		return this.getComponent().getX();
	}

	@Override
	public void setComponent(final GameComponent<?> component) {
		super.setComponent(component);
		activeSprite.setComponent(component);
		inactiveSprite.setComponent(component);
	}

	@Override
	public double getWidth() {
		return activeSprite.getWidth() * total;
	}

	@Override
	public double getHeight() {
		return activeSprite.getHeight();
	}

	@SuppressWarnings("unchecked")
	@Override
	public LiveAppearance copy() {
		return new LiveAppearance(total, activeSprite, inactiveSprite);
	}

	@Override
	public void update(final double delta) {
		actual = ((LiveCounter) this.getComponent()).getLives();
	}

	@Override
	public void render(final GameComponent<?> component,
			final Graphics2D graphics) {
		double width = 0;
		if (actual > 0) {
			final Sprite active = activeSprite.repeatHorizontally(actual);
			width = active.getWidth();
			active.setComponent(component);
			active.offset = new Vector2D(0, 0);
			active.render(component, graphics);
		}
		if (actual < total) {
			final Sprite inactive = inactiveSprite.repeatHorizontally(total
					- actual);
			inactive.setComponent(component);
			inactive.offset = new Vector2D(1, 0).asVersor().producto(width);
			inactive.render(component, graphics);
		}

	}
}
