package Editor;

import static org.lwjgl.opengl.GL11.*;

import javax.swing.ViewportLayout;

import org.lwjgl.opengl.Display;

import Game.Initialize;

public class MapEditor {
	
	public static void Handler(){
		
		Initialize.Projection2D();
		
		
		Screen1.Handler();
		Screen2.Handler();
		Screen3.Handler();
		
		Initialize.Projection3D();
		
		
	}
}
