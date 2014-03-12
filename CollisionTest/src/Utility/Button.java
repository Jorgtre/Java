package Utility;



import org.newdawn.slick.Color;

import Game.Image;
import Game.MOUSE;

public class Button {
	private String Text;
	private int size;
	private int x;
	private int y;
	private int w;
	private int h;
	private int Img;
	private Color c;
	private int ID;
	private int hoverImg;
	
	public Button(int Image, int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.Img = Image;
		ID = 0;
	}
	public Button(String Text, int x, int y, int size){
		this.x = x;
		this.y = y;
		this.w = (size / 2) * Text.length();
		this.h = size;
		this.size = size;
		this.Text = Text;
		ID = 1;
	}
	public Button(String Text, int x, int y, int size, Color color){
		this.x = x;
		this.y = y;
		this.w = ((size / 2) * Text.length()) + 10;
		this.h = size;
		this.size = size;
		this.Text = Text;
		this.c = color;
		ID = 2;
	}

	public Button(String path, int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
		this.Img = Image.Load(path);
		this.hoverImg = Utility.ImageUtility.setOutLineOnImage(path);
		this.ID = 3;
	}
	
	
	
	
	public void render(){
		if (ID == 0)	{Image.print(Img, x, y, w, h, true);}
		if (ID == 1)	{Game.Text.print(Text, x, y, size,1, true);}
		if (ID == 2) 
		{
			Shape.rect(x, y, w, h, c);
			Game.Text.print(Text, x, y, size,1, true);
		}
		
		if (ID == 3)	{Image.print(Img, x, y, w, h, true);}
		
		
	}
	public boolean isClicked(){
		int X = MOUSE.X();
		int Y = MOUSE.Y();
		return (X > x && Y > y && X < x+w && Y < y+h && MOUSE.oneClick(0)) ;
	}
	
	public void indicateMouseHover(){
		int X = MOUSE.X();
		int Y = MOUSE.Y();
		if (X > x && Y > y && X < x+w && Y < y+h) 
		{
			if (ID == 0) {Utility.Shape.rect(x, y, w, h,  255, 255, 255, 0.4f);}
			if (ID == 1) {Utility.Shape.rect(x, y, w, h,  255, 255, 255, 0.4f);}
			if (ID == 2) {Utility.Shape.rect(x, y, w, h,  255, 255, 255, 0.4f);}
			
			if (ID == 3) {Image.print(hoverImg, x, y, w, h, true);}
		}
		
	}
	public int H(){
		return h;
	}
	public int W(){
		return w;
	}
	public int X(){
		return x;
	}
	public int Y(){
		return y;
	}
	
	
	
	
	
}





































