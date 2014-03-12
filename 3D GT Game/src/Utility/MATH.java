package Utility;

import java.math.BigDecimal;

public class MATH {
	
	
	public static float round(float d, int decimalPlace) {
		BigDecimal bd = new BigDecimal(Float.toString(d));
		bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
		return bd.floatValue();
	}
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
