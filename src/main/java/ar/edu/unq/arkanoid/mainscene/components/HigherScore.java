package ar.edu.unq.arkanoid.mainscene.components;

import ar.edu.unq.americana.events.annotations.Events.Update;

public class HigherScore extends Score {

	public HigherScore(final String text) {
		super(text);
	}

	@Update
	public void updateX(final double delta) {
		final int displayWidth = this.getGame().getDisplayWidth();
		this.setX(displayWidth - (this.getAppearance().getWidth() / 2) - 15);
	}
}
