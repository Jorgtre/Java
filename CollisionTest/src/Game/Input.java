package Game;

import org.lwjgl.input.Keyboard;

import block.Block;





public class Input {

	static boolean[]KP = new boolean[300];
	
	
	
	public static boolean isPressed(int Key){
		if(Keyboard.isKeyDown(Key)) 	{	 if(!KP[Key])	{ KP[Key] = true; return true;}				} else {KP[Key] = false;}
		return false;
	}
		
	public static boolean ESC(){
		return isPressed(Keyboard.KEY_ESCAPE);
	}

	public static boolean Up(){
		return isPressed(Keyboard.KEY_UP);
	}
	public static boolean Down(){
								
		return isPressed(Keyboard.KEY_DOWN);
	}
	public static boolean F1(){
		return isPressed(Keyboard.KEY_F1);
	}
	public static boolean F2(){
			return isPressed(Keyboard.KEY_F2);
	}
	public static boolean F3(){
		return isPressed(Keyboard.KEY_F3);
	}
	public static boolean Ctrl_S(){
		if( Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) && isPressed(Keyboard.KEY_S)) {return true;}
		return false;
	}
	public static boolean Ctrl_C(){
		if( Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) && isPressed(Keyboard.KEY_C)) {return true;}
		return false;
	}
	public static boolean L(){
		return isPressed(Keyboard.KEY_L);
	}
	public static void KEY_1(){
		if(Keyboard.isKeyDown(Keyboard.KEY_1))  													{	 if(!KP[6])	{Block.Selected = Image.list[0]; KP[6] = true;}		} else {KP[6] = false;}
	}
	
	public static boolean Space(){
		return Keyboard.isKeyDown(Keyboard.KEY_SPACE);
	}
	
	
	public static boolean ADD(){
	//	return isPressed(Keyboard.isKeyDown(Keyboard.KEY_ADD),6);
		return false;
		
	}
	public static boolean SUBTRACT(){
	//	return isPressed(Keyboard.isKeyDown(Keyboard.KEY_SUBTRACT),7);
		return false;
	}
	public static boolean F5(){
		return isPressed(Keyboard.KEY_F5);
	}
	public static boolean X(){
		return isPressed(Keyboard.KEY_X);
	}
	public static boolean A(){
		if(Keyboard.isKeyDown(Keyboard.KEY_A))		{return true;}
		return false;
	}
	public static boolean D(){
		if(Keyboard.isKeyDown(Keyboard.KEY_D))		{return true;}
		return false;
	}
	public static boolean W(){
		if(Keyboard.isKeyDown(Keyboard.KEY_W))		{return true;}
		return false;
	}
	public static boolean S(){
		if(Keyboard.isKeyDown(Keyboard.KEY_S))		{return true;}
		return false;
	}
	
	public static boolean CTRL(){
		return isPressed(Keyboard.KEY_LCONTROL);
	}

	
	

}
