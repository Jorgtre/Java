package Editor.Utility;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import Game.Image;

public class blockBtn extends btnTemplate {
	
	private int Img;
	private boolean b;
	private boolean selected;
	
	public blockBtn(int x, int y, int w, int h, int Img){
		super(x*2, y*2, w*2, h*2); // multiplied be 2 cuz the viewport is devided by 2;
		this.Img = Img;
	}
	public void handler(){
		isClicked();
		render();
	}
	
	
	
	public void render(){
		int x = x();
		int y = y();
		int w = w();
		int h = w();
		if (selected) {Image.print2D(this.Img, x-5, y-5, w+10, h+10);} else {Image.print2D(this.Img, x, y, w, h);}
	}
	
	public boolean isClicked(){
		int x = x();
		int y = y();
		int w = w();
		int h = w();
		int mx = Mouse.getX()*2;
		int my = -(Mouse.getY()-Display.getHeight())*2;
		if (mx > x && mx < x+w && my > y && my < y+h) 
		{
			if(Mouse.isButtonDown(0)) 	{	 if(!b)	{ b = true; selected = !selected; return true;}				} else {b = false;}
			
		}
		return false;
	}
	
	//---------getters-----------
	public boolean selected(){
		return selected;
	}
	

	

	
}