package Game;

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
import static org.lwjgl.opengl.GL11.*;

import java.awt.Font;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

import BlockPackage.Template;
import BlockPackage.block;
import Utility.ObjLoader.Loader;

public class Initialize {
	
	
	
	public static void Lists(){
		
	}
	
	public static void Entities(){
		Entity.Entities.Init();
	}
	
	@SuppressWarnings("unchecked")
	public static void loadFonts(){
		Main.font = new UnicodeFont(new Font("There is no font here.NoFontHere",Font.BOLD, 18));
		Main.font.getEffects().add(new ColorEffect(java.awt.Color.white));
		Main.font.addAsciiGlyphs();

		try {
			Main.font.loadGlyphs();
		} catch (SlickException e) {
			e.printStackTrace();
			Main.cleanUp();
		}
	}
	public static void Resources(){
		resources.LoadImages();
		resources.loadModels();
	}
	
	
	public static void Blocks(){
		
		
	}
	public static void Camera(){
		Main.cam = new Camera(70, (float)Display.getWidth()/Display.getHeight(), 0.3f, 1000);
	}
	public static void Models(){
		Main.MaxModel = Loader.LoadObjects("res/MaxModel.obj");
		Main.bullet = Loader.LoadObjects("res/bullet.obj");
		Main.gun = Loader.LoadObjects("res/gun.obj");
		Main.ak47 = Loader.LoadObjects("res/ak47.obj");
		Main.ballModel = Loader.LoadObjects("res/ball.obj");
	}
	public static void Display() {
		try {
			
			
			

			//Display.setDisplayMode(new DisplayMode(Main.screenWidth,Main.screenHeight));
			Display.setDisplayMode(new DisplayMode(Main.screenWidth, Main.screenHeight));
			Display.create();
			Display.setResizable(true);
			Display.setVSyncEnabled(false);
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
		 glMatrixMode(GL_PROJECTION);
	     glLoadIdentity();
	     glEnable(GL_BLEND);
	     glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	     glOrtho(0.0f, Display.getWidth(), Display.getHeight(), 0.0f, 0.0f, -1.0f);
	     glMatrixMode(GL_MODELVIEW);
	     glLoadIdentity();
	     
	}

}
