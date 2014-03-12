package Game;

import org.lwjgl.input.Keyboard;



public class global {
	
	
	
	public static void Keys(){
		if (Input.F1()) {fading.start(Main.State.Game);}
		if (Input.F2()) {fading.start(Main.State.Editor);}
		if (Input.F3()) {fading.start(Main.State.Main_Menu);}
		if (Input.ESC()){fading.start(Main.State.Pause);}
	}
	public static void fading(){
		fading.update();
	}
	
	
	
}
