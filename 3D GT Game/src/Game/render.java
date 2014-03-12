package Game;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glCallList;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLineWidth;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTexCoord3f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL11.glVertex2i;
import static org.lwjgl.opengl.GL11.glVertex3f;

import org.newdawn.slick.Color;

public class render {
	
	
	static float x = 50;
	
	
	
	
	public static void model(int model, float alpha, float x, float y, float z, float ScaleX, float ScaleY, float ScaleZ, float RotateX, float RotateY, float RotateZ){
		//Main.cam.initProjection3D();
		glPushMatrix();
		glEnable(GL_BLEND);
		glDisable(GL_TEXTURE_2D);
		glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
		glTranslatef(-x, y, -z);
		glScalef(ScaleX, ScaleY, ScaleZ);
		glRotatef(RotateX, 1, 0, 0);
		glRotatef(RotateY, 0, 1, 0);
		glRotatef(RotateZ, 0, 0, 1);
		
		glColor4f(1,1,1,1);
		glCallList(model);
		glEnd();
		glPopMatrix();
		
	}
	
	
	
	public static void crosshair(){
		Initialize.Projection2D();
		
		int l = 10;
		int h = 10;
		glPushMatrix();
		glColor3f(1f, 1f, 1f);
		glLineWidth(3);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
		glBegin(GL_LINES);
		  glVertex2i(Main.screenWidth/2, Main.screenHeight/2-10);
	      glVertex2i(Main.screenWidth/2, Main.screenHeight/2+10);
	      glVertex2i(Main.screenWidth/2-10, Main.screenHeight/2);
	      glVertex2i(Main.screenWidth/2+10, Main.screenHeight/2);
	      
		
		glEnd();
		glPopMatrix();
		glDisable(GL_BLEND);
		
		
		Initialize.Projection3D();
	}


	
	
	public static void block(float alpha){
		
		glPushMatrix();
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
		glBindTexture(GL_TEXTURE_2D, Main.GrassBlock);
		glEnable(GL_TEXTURE_2D);
		glTranslatef(0, 0, 0);
		glRotatef(0, 0, 0, 0);
		glBegin(GL_QUADS);
		{
			/*
			//FrontFace
			glColor4f(0, 0, 1, alpha);
			glVertex3f(-1,-1,1);
			glVertex3f(-1,1,1);
			glVertex3f(1,1,1);
			glVertex3f(1,-1,1);
			*/
			
			//----------
			//glColor4f(0, 1, 1, alpha);
			
			glVertex3f(-1, -1, 1);
			glTexCoord3f(-1, -1, 1);
			
			glVertex3f(1, -1, 1);
			glTexCoord3f(1, -1, 1);
			
			glVertex3f(1, 1, 1);
			glTexCoord3f(1, 1, 1);
			
			glVertex3f(-1, 1, 1);
			glTexCoord3f(-1, 1, 1);
			//----------
			
			/*
			//BackFace
			glColor4f(0, 1, 1, alpha);
			glVertex3f(-1, -1, -1);
			glVertex3f(-1, 1, -1);
			glVertex3f(1, 1, -1);
			glVertex3f(1, -1, -1);
			
			//BottomFace
			glColor4f(1, 1, 1, alpha);
			glVertex3f(-1,-1,-1);
			glVertex3f(-1,-1,1);
			glVertex3f(-1,1,1);
			glVertex3f(-1,1,-1);
			
			//TopFace
			glColor4f(0, 0, 0, alpha);
			glVertex3f(1,-1,-1);
			glVertex3f(1,-1,1);
			glVertex3f(1,1,1);
			glVertex3f(1,1,-1);
			
			
			//LeftFace
			glColor4f(1, 0, 1, alpha);
			glVertex3f(-1,-1,-1);
			glVertex3f(1,-1,-1);
			glVertex3f(1,-1,1);
			glVertex3f(-1,-1,1);
			
			//RightFace
			glColor4f(1, 0, 0, alpha);
			glVertex3f(-1,1,-1);
			glVertex3f(1,1,-1);
			glVertex3f(1,1,1);
			glVertex3f(-1,1,1);
			*/
			
			//front
			
			/*
			glVertex3f(-2, 1, 1);
			glTexCoord3f(-1, 1, 1);
			
			glVertex3f(1, 1, 1);
			glTexCoord3f(1, 1, 1);
			
			glVertex3f(1, -1, 1);
			glTexCoord3f(1, -1, 1);
			
			glVertex3f(-1, -1, 1);
			glTexCoord3f(-1, -1, 1);
			*/
			//Back
			
			
			
			
		}
		glEnd();
		glPopMatrix();
		glDisable(GL_TEXTURE_2D);
	}
	

	
	public static void line(float x, float y, float z,float x2, float y2, float z2){
		//Main.cam.initProjection3D();
		glPushMatrix();
		glColor3f(1.0f, 0.5f, 0f);
		glLineWidth(1);
		glTranslatef(0, 0, 0);
		glRotatef(0, 0, 0, 0);
		glBegin(GL_LINES);
		{
			
			glColor3f(0f, 0f, 1f);
			glVertex3f(-x,y,-z);
			glVertex3f(-x2,y2,-z2);
			
		}
		glEnd();
		glPopMatrix();
	}
	
	
	
}


































