package Package;

import static org.lwjgl.opengl.GL11.*;

public class World {
	public static int width = 50;
	public static int height = 50;
	public static int depth = 50;
	
	public static void render0(){
		
		for (int x = 0; x < width; x++){
			for (int z = 0; z < depth; z++){
				
				
				glPushMatrix();
				glBegin(GL_LINES);
				
				glColor3f(0.4f, 0.4f, 0.4f);
				
				glVertex3f(x, 0, 0);
				glVertex3f(x, 0, z);

				glVertex3f(x, 0, z);
				glVertex3f(0, 0, z);

				glEnd();
				glPopMatrix();
				
			}
		}
		//-------render the middel of the grid---------
		
		glPushMatrix();
		glScalef(0.3f, 0.3f, 0.3f);
		glBegin(GL_QUADS);
		
		
		glColor3f(1, 0, 0);
		glVertex3f(-1, 0, 1);
		
		glColor3f(0, 1, 0);
		glVertex3f(-1, 0, -1);
		
		glColor3f(0, 0, 1);
		glVertex3f(1, 0, -1);
		
		glColor3f(1, 1, 1);
		glVertex3f(1, 0, 1);
		
		
		glEnd();
		glPopMatrix();
		
		
		//------render X Y Z mark----------
		
		
		glPushMatrix();
		
		glLineWidth(3);
		glBegin(GL_LINES);
		
		
		glColor3f(1, 0, 0);//---
		glVertex3f(0, 1, 0);//------ X
		glVertex3f(1, 1, 0);//---
		
		glColor3f(0, 1, 0);//---
		glVertex3f(0, 1, 0);//------ Y
		glVertex3f(0, 2, 0);//---
		
		glColor3f(0, 0, 1);//---
		glVertex3f(0, 1, 0);//------ Z
		glVertex3f(0, 1, 1);//---
		
		
		glColor3f(0.6f, 0, 0);
		glVertex3f(-5, -1, -5);
		glVertex3f(-5, -3, -5);
		
		
		glEnd();
		
		glPopMatrix();
		
		
	}
	
	
}
