package ar.edu.unq.arkanoid.maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ar.edu.unq.americana.exceptions.GameException;
import ar.edu.unq.arkanoid.scenes.MainScene;

public class MapCreator {

	public static void create(final MainScene scene, final String name) {
		final InputStream input = ClassLoader.getSystemResourceAsStream(name);
		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				input));
		String line = null;
		int row = 0, column = 0;
		try {
			while ((line = reader.readLine()) != null) {
				row++;
				final String[] columns = line.split(",");
				for (final String value : columns) {
					column++;
					scene.addBlock(column, row, Integer.parseInt(value));
				}
				column = 0;
			}
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
