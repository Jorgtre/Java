package Utility;

import static org.lwjgl.opengl.GL11.GL_COMPILE;
import static org.lwjgl.opengl.GL11.glEndList;
import static org.lwjgl.opengl.GL11.glGenLists;
import static org.lwjgl.opengl.GL11.glNewList;

import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;



import Game.Main;
import Game.Model;
import Game.World;
import Game.render;
import Game.text;

public class Misc {
	private static long ctime = System.currentTimeMillis();
	private static long stime = System.currentTimeMillis();
	private static DecimalFormat Formatter = new DecimalFormat("000.0");
	private static Timer timer = new Timer();
	
	

	
	public static void showGameInfo(){
		float x = Main.cam.getPosition().getX();
		float y = Main.cam.getPosition().getY();
		float z = Main.cam.getPosition().getZ();
		float rx = Main.cam.getRotation().getX();
		float ry = Main.cam.getRotation().getY();
		
		
		//text.print(100, 50, "X : " + Formatter.format(x) + " Y : " + Formatter.format(y) + " Z : " + Formatter.format(z) + "  RX : " + Formatter.format(rx) + " RY : " + Formatter.format(ry));
		text.print(10, 10, "X : " + Formatter.format(x));
		text.print(10, 30, "Y : " + Formatter.format(y));
		text.print(10, 50, "Z : " + Formatter.format(z));
		
		
		
	}
	
	public static void Timer(float delay){
		
		
		
	}
	public static int Random(int from, int to){
		
		Random rnd = new Random();
		
		int x = rnd.nextInt(to+1);
		
		
		
		
		return x;
	}
	public static boolean RndTrue(int chance){
		Random rnd = new Random();
		return rnd.nextInt(chance) == chance / 2;
	}
	
	
	
	public static boolean isWithinArray(float x, float y, float z){
		 return(x < World.width && x > 0 && y < World.height && y > 0 && x < World.depth -1  && x > 0);
	}
	
	
	
	
}













