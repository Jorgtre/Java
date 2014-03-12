package Package;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glDeleteLists;
import static org.lwjgl.opengl.GL11.glLoadIdentity;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Main {
	public static int screenWidth = 1920;
	public static int screenHeight = 1080;
	static int fps = 60;
	static Camera cam;
	

	public static void main(String[] args) {
		Initialize.Display();
		Initialize.Camera();
		
		gameLoop();
		
		
		cleanUp();
	}
	private static void gameLoop(){
		
		while (!Display.isCloseRequested())
		{
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			glLoadIdentity();
			
			
			Game.run();
			
			
			Display.update();
			Display.sync(fps);
		}
	}
	public static void updateWindow(){
		if (Display.wasResized()){
			screenWidth = Display.getWidth();
			screenHeight = Display.getWidth();
		}
	}
	
	
	public static void cleanUp(){
		Display.destroy();
		System.exit(1);
	}
	
	
	
	
}
