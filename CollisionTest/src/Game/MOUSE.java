package Game;

import org.lwjgl.input.Mouse;


public class MOUSE {
	private static boolean MP;
	
	
	public static int X(){
		return Mouse.getX();
	}
	public static int Y(){
		return Main.ScreenHeight - Mouse.getY();
	}
	
	
	public static boolean isOver(int x, int y, int w, int h ,boolean FollowCamera){
		return (X() > x && Y() > y && X() < x+w && Y() < y+h);
	}

	public static boolean oneClick(int button){
		if(Mouse.isButtonDown(button)) 	{	 if(!MP)	{ MP = true; return true;}				} else {MP = false;}
		
		return false;
	}
	
	
}
