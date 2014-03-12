package Utility;

import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL11.glVertex2i;

import org.newdawn.slick.Color;

import Game.Image;

public class Shape {

	
	public static void rect(int x, int y, int w, int h,Color c){
		Image.Blank();
		c.bind();
		glBegin(GL_QUADS);
			glVertex2f(x,y);
			glVertex2f(x+w,y);
			glVertex2f(x+w,y+h);
			glVertex2f(x,y+h);
		glEnd();
	}
	public static void rect(int x, int y, int w, int h,int r, int g, int b, float ALPHA){
		
		Image.Blank();
		glBegin(GL_QUADS);
		glColor4f(r, g, b, ALPHA);
			glVertex2f(x,y);
			glVertex2f(x+w,y);
			glVertex2f(x+w,y+h);
			glVertex2f(x,y+h);
		glEnd();
	}
	
	
	
	
	public static void borderLine(int x, int y, int w, int  h, Color c){
		Image.Blank();
		c.bind();
		glBegin(GL_LINES);
		glVertex2i(x, y);
		glVertex2i(x+w, y);
		
		glVertex2i(x, y);
		glVertex2i(x, y+h +1);
		
		glVertex2i(x+w,y+h);
		glVertex2i(x, y+h);
		
		glVertex2i(x+w, y+h);
		glVertex2i(x+w, y);
    glEnd();
			
		
		
	}
}
