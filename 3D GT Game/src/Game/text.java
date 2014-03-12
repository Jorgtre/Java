package Game;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Formatter;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

public class text {
	
	private static ArrayList<String> printList = new ArrayList<String>(1);
	private static Formatter formatter;
	
	public static void print(int x, int y, String text){
		
		String X = String.format("%04d", x);
		String Y = String.format("%04d", y);
		String FString = X+Y+text;
		
		
		printList.add(FString);
		
		
		
		
		
	}
	public static void printStringList(){
		glPushMatrix();
		Initialize.Projection2D();
		for (String s: printList){
		
		
		
			int x = Integer.valueOf(s.substring(0, 4));
			int y = Integer.valueOf(s.substring(4, 8));
			String text = s.substring(8);

			

			Main.font.drawString(x, y, text);
			glDisable(GL_TEXTURE_2D);
			
			
			
		}
		printList.clear();
		Initialize.Projection3D();
		glPopMatrix();
	}
	

	
	
	
	
	
	
	
}
