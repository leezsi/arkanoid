package ar.edu.unq.arkanoid.utils;

import ar.edu.unq.americana.appearances.Sprite;

public class SpriteUtils {
	private SpriteUtils() {
	}

	public static Sprite get(final String path, final double widthScale,
			final double heightScale) {
		Sprite image = Sprite.fromImage(path);
		image = image.scaleHorizontally(widthScale / image.getWidth());
		image = image.scaleVertically(heightScale / image.getHeight());
		return image;
	}
}
