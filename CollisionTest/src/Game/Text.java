package Game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Text{
	
	//static int[][] fontList = new int[][] = loadFonts
	static ArrayList<int[]> fontList = new ArrayList<>(1);
	
	static int[] list = new int[128];
	static BufferedImage[] glowFont;
	static int[] outLineFont;
	
	public static void Init(){
		list = Image.getSubImgList(128, "font8", 16, 8, 32, 32, 32, 32);
		
		for (int x = 0; x < Utility.folderUtility.getNumOfFilesInFolder("res/Fonts"); x++) {
			fontList.add(loadFont(x));
		}
		
	}
	
	public static void print(String text,int x, int y,int size, int font ,boolean FollowCamera){
		
		int I = 0;
		
		for(int y2 = 0; y2 < text.length() ;y2++){
			Image.print(fontList.get(font)[text.charAt(y2)], x + I, y, size, size, FollowCamera);
			//I+= 18;
			I += 0.5 * size;
		}
	}
	private static int[] loadFont(int fileIndex){
		return Image.getSubImgList(128, "font"+ fileIndex, 16, 8, 32, 32, 32, 32);
	}
	
	
}


