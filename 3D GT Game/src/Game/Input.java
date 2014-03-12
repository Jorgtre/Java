package Game;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;


public class Input {
	
	public static float mouseDX = Mouse.getDX();
	public static float mouseDY = Mouse.getDY();
	public static float DWheel = Mouse.getDWheel();
	
	private static boolean[] KP = new boolean[300];	
	public static boolean A(){
		return Keyboard.isKeyDown(Keyboard.KEY_A);
	}
	
	public static boolean keyP(int key){
		return Keyboard.isKeyDown(key);
	}
	public static boolean oneClick(int Key){
		if(Keyboard.isKeyDown(Key)) 	{	 if(!KP[Key])	{ KP[Key] = true; return true;}				} else {KP[Key] = false;}
		return false;
	}
	
	
	public static void update(){
		
			mouseDY = Mouse.getDY();
			mouseDX = Mouse.getDX();
			DWheel = Mouse.getDWheel();
		
	}
	
	
	
	
	
	
}
