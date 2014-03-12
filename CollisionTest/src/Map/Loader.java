package Map;

import java.io.BufferedReader;
import java.io.FileReader;

import Game.Grid;



public class Loader {

	public static void load(String File) {

		
		Clearer.clear();

		try {
			BufferedReader br = new BufferedReader(
					new FileReader(File + ".txt"));

			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {

				int x  =  Integer.valueOf(line.substring(0, 3));
				int y  =  Integer.valueOf(line.substring(4, 7));
				int ID =  Integer.valueOf(line.substring(8)	  );
				
				if (ID > 0 ){Grid.map[y][x] = ID;}
				

				sb.append(line);
				sb.append("\n");
				line = br.readLine();

			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("File Loaded");
		
	}
}
