package Package;

import static org.lwjgl.opengl.GL11.*;

public class Game {
	public static enum State {Game, Pause, Main_Menu;}
	public static State gameState = State.Game;
	
	
	public static void run(){
		switch (gameState) {
		case Main_Menu:
		{
			
			
			
		}
			break;
		case Game:
		{
			
			
			Main.cam.renderCrosshair();
			Main.cam.controls();
			Main.cam.rotateCam();
			Main.cam.useView();
			
			
			
		
			
			
			World.render0();
			
		}
			break;
		case Pause:
		{
		
			
			
			
		}	
			break;
		}
	}
	
}
