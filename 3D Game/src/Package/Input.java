package Package;
import org.lwjgl.input.Keyboard;


public class Input {
	private static boolean KP[] = new boolean[200];
	

	
	public static boolean keyP(int key){
		return Keyboard.isKeyDown(key);
	}
	public static boolean oneClick(int key){
		if(Keyboard.isKeyDown(key)) 	{	 if(!KP[key])	{ KP[key] = true; return true;}				} else {KP[key] = false;}
		return false;
	}
}
