package Utility;

public class Number {
	
	public static int roundUp(float i){
		float x =  i - (int)i;
		
		if (x > 0.0001) {return (int)i+1;}
		
		return (int)i;
	}
	public static int roundDown(float i){
		float x =  i - (int)i;
		
		if (x < 0.0001) {return (int)i-1;}
		
		return (int)i;
	}
	
	

}
