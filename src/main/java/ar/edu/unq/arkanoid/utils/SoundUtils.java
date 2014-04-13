package ar.edu.unq.arkanoid.utils;

import java.io.InputStream;

import ar.edu.unq.americana.sound.Sound;
import ar.edu.unq.americana.sound.SoundBuilder;

public class SoundUtils {
	private SoundUtils() {
	}

	public static Sound getSound(final String path) {
		final InputStream input = ClassLoader.getSystemResourceAsStream(path);
		return new SoundBuilder().buildSound(input);
	}
}
