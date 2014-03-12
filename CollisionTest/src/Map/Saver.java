package Map;

import java.util.Formatter;

import Game.Grid;

public class Saver {
	
	private static Formatter F;
	
	public static void save(String GameSave){
		
		try {
			F = new Formatter(GameSave + ".txt");

			for (int y = 0; y < Grid.Height; y++) {
				for (int x = 0; x < Grid.Width; x++) {
					
					
					if (Grid.map[y][x] > 0){ SaveGame(x,y,Grid.map[y][x]);}
					
					
				}
			}
			F.close();
			System.out.println("File Saved");
			Settings.SavedLoaded = true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
	}
	private static void SaveGame(int x, int y, int ID){
		F.format("%s%s%s%s%n", String.format("%03d", x), " ", String.format("%03d ", y), ID);
	}
}
