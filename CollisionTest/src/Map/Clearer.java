package Map;

import Game.Grid;

public class Clearer {

	public static void clear() {
		for (int y = 0; y < Grid.Height; y++) {
			for (int x = 0; x < Grid.Width; x++) {
				Grid.map[y][x] = 0;
			}
		}
	}
}
