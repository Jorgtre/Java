package Game;


import static org.lwjgl.opengl.GL11.glViewport;

import org.lwjgl.opengl.Display;

import Editor.MapEditor;
import Utility.Misc;

public class Game {
	
	public static enum State {Game, Pause, Main_Menu, MapEditor;}
	public static State gameState = State.Game;
	
	
	
	public static void run(){
		
		//------------------allways Update stuff-----------------------
		
		Input.update();
		
		
		switch (gameState) {
		case Main_Menu:
		{
			
			
			
			
			
		}
			break;
		case Game:
		{
			
			
			
			
			
			Main.cam.handler();
			
			
			
			
			World.render();
			Entity.Entities.Handler();
			Misc.showGameInfo();
			
			text.printStringList();
			
			RayTest.RayTest();
			
			render.crosshair();
			
			
			
			
			
			
		}
			break;
		case Pause:
		{
			
			
			
			
			
			
			
		}	
			break;
		case MapEditor:
			
			
			
			MapEditor.Handler();
			glViewport(Display.getWidth() / 2, 0, Display.getWidth() / 2, Display.getHeight() / 2);
			Main.cam.handler();
			World.render();
			render.crosshair();
			
			
			
			
			text.printStringList();
			break;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
















