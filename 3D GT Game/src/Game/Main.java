package Game;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glDeleteLists;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.*;

import java.awt.Font;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
public class Main {
	
	static UnicodeFont font;
	
	public static int screenWidth = 1920;
	public static int screenHeight = 1080;
	static int fps;
	public static Camera cam = null;
	public static int Block;
	public static int ballModel;
	static int Line;
	static long lastFrame;
	static long lastFPS;
	static float delta;
	public static int Img;
	public static int GrassBlock;
	public static int ObsidianBlock;
	static int Model_Line;
	public static int MaxModel;
	public static boolean camMounted = false;
	public static int bullet;
	public static int gun;
	public static int ak47;
	public static boolean testMode = false;
	
	
	public static void main(String[] args) {
		lastFrame = getTime();
		lastFPS = getTime();
		Initialize.Display();
		Initialize.Camera();
		Initialize.loadFonts();
		Initialize.Resources();
		//ObsidianBlock = Model.create(Image.Load("res/obsidian.png"));
		//GrassBlock = Model.create(Image.Load("res/stone.png"));
		Initialize.Models();
		Initialize.Blocks();
		Initialize.Entities();
		
		
		
		
		
		gameLoop();
		cleanUp();
	}
	
	
	
	
	private static void gameLoop(){
		
		
		
		
		while (!Display.isCloseRequested()) 
		{
			//if (Mouse.isButtonDown(0)) {RayTest.select();}
			delta = getDelta();
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			glLoadIdentity();
			
			
			
			Game.run();
			
			
			
			
			
			
			
			updateWindow();
			updateFPS();
			Display.update();
			Display.sync(60);
			
			
			
		}
	}
	
	//----------Testing crapp------------------

	
	
	
	
	//-------------------------------------------
	
	public static void updateWindow(){
		if (Display.wasResized()) {
			screenHeight = Display.getHeight();
			screenWidth = Display.getWidth();
			glViewport(0, 0, screenWidth, screenHeight);
		}
	}
	
	
	public static void cleanUp(){
		Display.destroy();
		System.exit(1);
		glDeleteLists(Block, 1);
		
		
		glDeleteLists(Utility.ObjLoader.Loader.bunnyObj, 1);
		
	}

	
	
	

	public static void updateFPS() {
		
		if (getTime() - lastFPS > 1000) {
			Display.setTitle("Games Through G" + " (FPS " + fps +")");
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}
	public static long getTime() {
		return(Sys.getTime() * 1000 / Sys.getTimerResolution());	
	}
	private static int getDelta() {
		long currentTime = getTime();
		int delta = (int) (currentTime - lastFrame);
		lastFrame = getTime();
		return delta;
	}
	
}














