package Editor;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL11.glViewport;

import org.lwjgl.opengl.Display;

public class Screen3 {
	
	public static void Handler(){
		
		glViewport(0, 0, Display.getWidth() / 2, Display.getHeight() / 2);
		
		glColor3f(0, 0, 1);
		glBegin(GL_QUADS);
		
		glVertex2f(0, 0);
		glVertex2f(Display.getWidth(), 0);
		glVertex2f(Display.getWidth(), Display.getHeight());
		glVertex2f(0, Display.getHeight());
		
		
		glEnd();
		
		
	}
	
	
}
