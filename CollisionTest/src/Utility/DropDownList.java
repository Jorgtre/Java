package Utility;

import java.util.ArrayList;

public class DropDownList {
	private int x,y,w,h;
	private String text;
	private ArrayList<Button> subBtn = new ArrayList<>(1);
	
	
	public DropDownList(String text , int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.text = text;
	}
	public void updateAndRender(){
		
	}
	
	
	public void addSubBtn(String text){
	}
	
	
}
