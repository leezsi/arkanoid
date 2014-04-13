package ar.edu.unq.arkanoid.mainscene.components;

import ar.edu.unq.americana.GameComponent;
import ar.edu.unq.americana.exceptions.GameException;
import ar.edu.unq.americana.rules.IRule;
import ar.edu.unq.arkanoid.Arkanoid;
import ar.edu.unq.arkanoid.mainscene.block.rules.BottomCollisionRule;
import ar.edu.unq.arkanoid.mainscene.block.rules.LeftCollisionRule;
import ar.edu.unq.arkanoid.mainscene.block.rules.RightCollisionRule;
import ar.edu.unq.arkanoid.mainscene.block.rules.TopCollisionRule;
import ar.edu.unq.arkanoid.mainscene.events.BlockDestroyed;
import ar.edu.unq.arkanoid.scenes.MainScene;

public class Block extends GameComponent<MainScene> {

	private int lives;

	public Block(final int x, final int y, final int lives) {
		if ((lives < 0) || (lives > 4)) {
			throw new GameException("lives for block must be between 0 - 4");
		}
		this.lives = lives;
		this.updateAppearace();
		this.setX(this.calculateX(x));
		this.setY(this.calculateY(y));
	}

	private double calculateY(final int y) {
		return 10 + (getAppearance().getHeight() * y);
	}

	private double calculateX(final int x) {
		return (Arkanoid.WINDOW_WIDTH * .01)
				+ (getAppearance().getWidth() * (x - 1));
	}

	private void updateAppearace() {
		this.setAppearance(Arkanoid.blocks.get(lives).copy());
	}

	public void die() {
		this.fireEvent(new BlockDestroyed());
		if (--lives == 0) {
			this.getScene().removeComponent(this);
		} else {
			updateAppearace();
		}
	}

	@Override
	protected IRule<?, ?>[] rules() {
		return new IRule<?, ?>[] { new LeftCollisionRule(),
				new RightCollisionRule(), new TopCollisionRule(),
				new BottomCollisionRule() };
	}
}
