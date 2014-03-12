package Utility;

import static org.lwjgl.opengl.GL11.*;

import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glVertex3f;

import org.lwjgl.util.vector.Vector3f;

import Game.Main;

public class Draw {
	
	
	public static void line(float p1x, float p1y, float p1z, float p2x, float p2y, float p2z){
		glPushMatrix();
		glLineWidth(5);
		glBegin(GL_LINES);
		
		glVertex3f(p1x, p1y, p1z);
		glVertex3f(p2x, p2y, p2z);
		
		glEnd();
		glPopMatrix();
	}
	
	public static void Marker(float x, float y, float z){
		float size = 0.1f;
		glPushMatrix();
		
		glColor3f(1, 0, 0);
		glTranslatef(x, y, z);
		glScalef(size, size, size);
		glCallList(Main.ballModel);
		
		glPopMatrix();
		
	}
	public static void Marker(Vector3f pos){
		Marker(pos.getX(), pos.getY(), pos.getZ());
	}
	
	
	
	
	public static void line(Vector3f p1, Vector3f p2){
		line(p1.getX(), p1.getY(), p1.getZ(), p2.getX(), p2.getY(), p2.getZ());
	}
	
	
	
	
}
