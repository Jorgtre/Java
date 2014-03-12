package Utility;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.newdawn.slick.Color;

import Game.Image;

public class Label {
	private int x,y,w,h,size;
	private String Text;
	
	
	public Label(String Text, int x, int y, int size){
		this.x = x;
		this.y = y;
		this.size = size;
		this.w = ((size / 2) * Text.length()) + 10;
		this.h = size;
		this.Text = Text;
		
	}
	public void render(){
		Image.Blank();
		Color.gray.bind();
		glBegin(GL_QUADS);
			glVertex2f(x,y);
			glVertex2f(x+w,y);
			glVertex2f(x+w,y+h);
			glVertex2f(x,y+h);
		glEnd();
		Game.Text.print(Text, x, y, size, 0, true);
	}
}
