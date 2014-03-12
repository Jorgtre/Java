package Utility;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import static org.lwjgl.opengl.GL11.*;


public class Check {
	public static boolean isBetween(float p1, float p2, float x){
		return (x < p1 && x > p1 || x > p1 && x < p1 || x == p1);
	}
	
	
	
}
