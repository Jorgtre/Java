package Package;

import static org.lwjgl.opengl.GL11.*;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;



public class Initialize {
	
	public static void Camera(){
		Main.cam = new Camera();
	}
	
	public static void Display() {
		try {

			Display.setDisplayMode(new DisplayMode(Main.screenWidth,Main.screenHeight));

			Display.create();
			Display.setResizable(true);
			Display.setVSyncEnabled(true);
			GL11.glEnable(GL11.GL_DEPTH_TEST);

		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	public static void Projection3D(){
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(70, (float)Display.getWidth()/Display.getHeight(), 0.3f, 1000);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_DEPTH_TEST);
		glLoadIdentity();
		
	}
	public static void Projection2D(){
		// glDisable(GL_DEPTH_TEST);
		 glMatrixMode(GL_PROJECTION);
	     glLoadIdentity();
	     glEnable(GL_BLEND);
	     glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	     glOrtho(0.0f, Display.getWidth(), Display.getHeight(), 0.0f, 0.0f, -1.0f);
	     glMatrixMode(GL_MODELVIEW);
	     glLoadIdentity();
	     
	}
	
	
}
