package ar.edu.unq.arkanoid.maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ar.edu.unq.americana.exceptions.GameException;
import ar.edu.unq.arkanoid.scenes.LevelScene;

public class MapCreator {

	public static int create(final LevelScene scene, final String name) {
		final InputStream input = ClassLoader.getSystemResourceAsStream(name);
		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				input));
		String line = null;
		int row = 0, column = 0, total = 0;

		try {
			while ((line = reader.readLine()) != null) {
				row++;
				final String[] columns = line.split(",");
				for (final String value : columns) {
					column++;
					final int lives = Integer.parseInt(value);
					total += lives == 0 ? 0 : 1;
					scene.addBlock(column, row, lives);
				}
				column = 0;
			}
			return total;
		} catch (final IOException e) {
			throw new GameException(e);
		} finally {
			try {
				reader.close();
			} catch (final IOException e) {
				throw new GameException(e);
			}
		}

	}
}
