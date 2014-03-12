package Utility;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex3f;

public class render {
	
	public static void block(float width, float height ,float depth,float lx, float ly, float lz){
		glPushMatrix();
	//	glScalef((float)width / 100, (float)height / 100, (float)depth / 100);
	//	glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
		glColor3f(1.0f, 0.5f, 0f);
		glTranslatef(0, 0, 0);
		glRotatef(0, 0, 0, 0);
		glBegin(GL_QUADS);
		{
			
			//FrontFace
			glColor3f(1, 0, 0);
			glVertex3f(-width+lx,-height+ly,depth+lz);
			glVertex3f(-width+lx,height+ly,depth+lz);
			glVertex3f(width+lx,height+ly,depth+lz);
			glVertex3f(width+lx,-height+ly,depth+lz);
			
			//BackFace
			glColor3f(1, 1, 0);
			glVertex3f(-width+lx, -height+ly, -depth+lz);
			glVertex3f(-width+lx, height+ly, -depth+lz);
			glVertex3f(width+lx, height+ly, -depth+lz);
			glVertex3f(width+lx, -height+ly, -depth+lz);
			
			//BottomFace
			glColor3f(0, 1, 0);
			glVertex3f(-width+lx,-height+ly,-depth+lz);
			glVertex3f(-width+lx,-height+ly,depth+lz);
			glVertex3f(-width+lx,height+ly,depth+lz);
			glVertex3f(-width+lx,height+ly,-depth+lz);
			
			//TopFace
			glColor3f(1, 0, 1);
			glVertex3f(width+lx,-height+ly,-depth+lz);
			glVertex3f(width+lx,-height+ly,depth+lz);
			glVertex3f(width+lx,height+ly,depth+lz);
			glVertex3f(width+lx,height+ly,-depth+lz);
			
			//LeftFace
			glColor3f(0, 1, 1);
			glVertex3f(-width+lx,-height+ly,-depth+lz);
			glVertex3f(width+lx,-height+ly,-depth+lz);
			glVertex3f(width+lx,-height+ly,depth+lz);
			glVertex3f(-width+lx,-height+ly,depth+lz);
			
			//RightFace
			glColor3f(0, 0, 1);
			glVertex3f(-width+lx,height+ly,-depth+lz);
			glVertex3f(width+lx,height+ly,-depth+lz);
			glVertex3f(width+lx,height+ly,depth+lz);
			glVertex3f(-width+lx,height+ly,depth+lz);
			
			
		}
		glEnd();
		glPopMatrix();
	}
	
}
