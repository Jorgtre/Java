package Utility;

import org.lwjgl.util.vector.Vector3f;

public class Compare {
	
	public static boolean Vector(Vector3f v1, Vector3f v2, boolean X, boolean Y, boolean Z){
		boolean x,y,z;
		
		if (X) {x = (v1.x == v2.x);} else {x = true;}
		if (Y) {y = (v1.y == v2.y);} else {y = true;}
		if (Z) {z = (v1.z == v2.z);} else {z = true;}
		
		
		if (x && y && z) {return true;}
		
		return false;
	}
	
	
	
	
	
	
	
	
}
