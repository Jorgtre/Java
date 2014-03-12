package Game;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import java.awt.Dimension;
import java.awt.Toolkit;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;






public class Main {
	
	public enum State {Editor, Main_Menu, Game, Pause};
	public static State state = State.Main_Menu;
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static int ScreenWidth = (int) screenSize.getWidth();
	public static int ScreenHeight = (int)screenSize.getHeight();
	static int SIZE = 10;
	static float Bounce = 1;
	static float MaxSpeed = 20;
	public static float Gravity = 0.8f;
	static int PushBack = 1;
	static float Friction = 0.8f;
	static float JumpForce = 20;
	public static float delta;
	static long lastFrame;
	static long lastFPS;
	static int fps;
	
	
	
	
	
	
	public static String WinName = "Window";
	
	public Main() {

		try {
			Display.setDisplayMode(new DisplayMode(ScreenWidth, ScreenHeight));
			Display.create();
			Display.setResizable(true);
			Display.setVSyncEnabled(true);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		
		lastFrame = getTime();
		lastFPS = getTime();
		
		
		
		
		initOpenGL();
		Game.Boot();
		
		
		
		
		
		while (!Display.isCloseRequested()) {
			
			delta = getDelta() / 16;
			
			if(Map.Settings.SavedLoaded) { delta = 1; Map.Settings.SavedLoaded = false;}
			delta = 1;
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			
			Game.Events();
			Game.Update();
			Game.Render();
			Game.Keys();
			
			
			
			

			updateWindow();
			updateFPS();
			Display.update();
			Display.sync(60);
			
			
		}
		Display.destroy();
		System.exit(1);
	}

	public static void main(String[] args) {
		new Main();
	}
	
	public static void initOpenGL(){
		GL11.glViewport(0,0,ScreenWidth, ScreenHeight);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity(); // Resets any previous projection matrices
		glOrtho(0,ScreenWidth, ScreenHeight, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
	}
	
	public static void updateWindow(){
		if (Display.wasResized()) {
			ScreenHeight = Display.getHeight();
			ScreenWidth = Display.getWidth();
			initOpenGL();
		}
	}

	public void updateFPS() {
		if (getTime() - lastFPS > 1000) {
			Display.setTitle("FPS: " + fps);
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}
	public long getTime() {
		return(Sys.getTime() * 1000 / Sys.getTimerResolution());	
	}
	
	private int getDelta() {
		long currentTime = getTime();
		int delta = (int) (currentTime - lastFrame);
		lastFrame = getTime();
		return delta;
	}
	

}



