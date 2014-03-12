package Game;

import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;
import java.util.Vector;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;
import org.newdawn.slick.Color;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COMPILE;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEndList;
import static org.lwjgl.opengl.GL11.glGenLists;
import static org.lwjgl.opengl.GL11.glNewList;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTexCoord3f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex3f;

public class Model {
	
	
	
	public static int create(int Img){
		
		int model;
		model = glGenLists(1);
		glNewList(model , GL_COMPILE);
		
		
		
		Begin(Img);
		
		//front
		setPoint(-1, 1, 1);// top-left
		setPoint(1, 1, 1);// top-right
		setPoint(1, -1, 1);//bot-right
		setPoint(-1, -1, 1);//bot-left
		
		//back
		setPoint(-1, 1, -1);
		setPoint(1, 1, -1);
		setPoint(1, -1, -1);
		setPoint(-1, -1, -1);
		
		//left
		setPoint(-1, 1, -1);
		setPoint(-1, 1, 1);
		setPoint(-1, -1, 1);
		setPoint(-1, -1, -1);
		
		//right
		setPoint(1, 1, 1);
		setPoint(1, 1, -1);
		setPoint(1, -1, -1);
		setPoint(1, -1, 1);
		
		//top
		setPoint(-1, 1, 1);
		setPoint(-1, 1, -1);
		setPoint(1, 1, -1);
		setPoint(1, 1, 1);
		
		//bot
		setPoint(-1, -1, 1);
		setPoint(1, -1, 1);
		setPoint(1, -1, -1);
		setPoint(-1, -1, -1);
		
		End();
		glEndList();
		glLoadIdentity();
		
		return model;
		
		
	}
	private static void Begin(int Img){
		glPushMatrix();
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
		glBindTexture(GL_TEXTURE_2D, Img);
		glEnable(GL_TEXTURE_2D);
		glBegin(GL_QUADS);
		glColor4f(255, 255, 255, 255);
	}
	
	private static void End(){
		glEnd();
		glPopMatrix();
		glDisable(GL_TEXTURE_2D);
	}
	private static void setPoint(float x, float y, float z){
		float x2 = x;
		float y2 = y;
		float z2 = z;
		if (x == -1) {x2 = 0;}
		if (y == -1) {y2 = 0;}
		if (z == -1) {z2 = 0;}
		
		glTexCoord3f(x2, y2, z2);
		glVertex3f(x, y, z);
	}
	
	
	
	
	public static void render(int Model ,float RotateX, float RotateY, float RotateZ, float PosX, float PosY, float PosZ,float scaleX, float scaleY, float scaleZ, float r, float g, float b, float alpha){
		glPushMatrix();
		{
			glColor4f(r, g, b , alpha);
			glTranslatef(PosX, PosY, PosZ);
			glRotatef(RotateY, 0, 1, 0);
			glRotatef(RotateX, 1, 0, 0);
			//glRotatef(RotateY, 0, 1, 0);
			glRotatef(RotateZ, 0, 0, 1);
			glScalef(scaleX, scaleY, scaleZ);
			glCallList(Model);
		}
		glPopMatrix();
		
	}
	
	public static void render(int model, Color Color ,Vector3f p, Vector3f r, float scale){
		render(model, r.x, r.y, r.z, p.x, p.y, p.z, scale, scale, scale, Color.r, Color.g, Color.b, 255);
	}
	public static void render(int model, Vector3f Position, Vector3f Rotation, float size){
		render(model, Rotation.x, Rotation.y, Rotation.z, Position.x, Position.y, Position.z, size, size, size, 255, 255, 255, 255);
	}
	public static void render(int model, float x, float y, float z, float size){
		render(model, 0, 0, 0, x, y, z, size, size, size, 255, 255, 255, 255);
		
	}
	
	
	
}









