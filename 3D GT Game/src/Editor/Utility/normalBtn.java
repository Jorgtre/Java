package Editor.Utility;

import static org.lwjgl.opengl.GL11.*;

import javax.swing.ViewportLayout;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;
import org.newdawn.slick.Color;


import Game.Image;
import Game.Main;
import Game.text;

public class normalBtn extends btnTemplate {
	
	private int Img;
	private boolean b;
	
	public normalBtn(int x, int y, int w, int h, int Img){
		super(x*2, y*2, w*2, h*2); // multiplied be 2 cuz the viewport is devided by 2;
		this.Img = Img;
	}
	public void handler(){
		
	}
	public void render(){
		int x = x();
		int y = y();
		int w = w();
		int h = w();
		Image.print2D(this.Img, x, y, w, h);
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
			if(Mouse.isButtonDown(0)) 	{	 if(!b)	{ b = true; return true;}				} else {b = false;}
			
		}
		return false;
	}

	

	

	
}
