package ar.edu.unq.arkanoid.rules;

import ar.edu.unq.americana.events.game.GameEvent;

public class GameStatusEvent extends GameEvent {

	public static enum State {
		PLAY {
			@Override
			public void fill(final GameStatusEvent gameStatusEvent) {
				gameStatusEvent.playing = true;
			}
		},
		PAUSE {
			@Override
			public void fill(final GameStatusEvent gameStatusEvent) {
				gameStatusEvent.playing = false;
			}
		};

		public abstract void fill(GameStatusEvent gameStatusEvent);
	}

	private boolean playing;

	public GameStatusEvent(final State state) {
		state.fill(this);
	}

	public boolean isPlaying() {
		return playing;
	}

}
