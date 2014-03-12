package Package;

import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLineWidth;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2i;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
	private Vector3f p = new Vector3f();
	private Vector3f r = new Vector3f();
	private Vector3f v = new Vector3f();
	private float speed = 0.03f;
	private boolean MP;
	
	
	public Camera() {
		p.set(0, -1, 0);
		r.set(0, 0, 0);
		v.set(0, 0, 0);
		
		
		Initialize.Projection3D();
		
	}
	
	
	
	
	public void renderCrosshair(){
		
		Initialize.Projection2D();
		glPushMatrix();
		glColor3f(1f, 1f, 1f);
		glLineWidth(3);
		glBegin(GL_LINES);
		
		  glVertex2i(Main.screenWidth/2, Main.screenHeight/2-10);
	      glVertex2i(Main.screenWidth/2, Main.screenHeight/2+10);
	      glVertex2i(Main.screenWidth/2-10, Main.screenHeight/2);
	      glVertex2i(Main.screenWidth/2+10, Main.screenHeight/2);
		
		glEnd();
		glPopMatrix();
		
		Initialize.Projection3D();
	}
	public void useView(){
		glRotatef(r.x, 1, 0, 0);
		glRotatef(r.y, 0, 1, 0);
		glRotatef(r.z, 0, 0, 1);
		glTranslatef(p.x, p.y, p.z);
	}
	public void move(float amt, float dir) {
		p.x -= amt * Math.sin(Math.toRadians(r.y + 90 * dir));
		p.z += amt * Math.cos(Math.toRadians(r.y + 90 * dir));
		
	}
	public void rotateCam(){
		if (Mouse.isGrabbed()){
			r.x -= (float)Mouse.getDY() / 14;
			r.y += (float)Mouse.getDX() / 14;
		}
		
		if (r.y > 360) {r.y = 0;}
		if (r.y < 0)   {r.y = 360;}
		while (r.x < -90) {r.x = -89.9999999999999999999999f;}
		
		
		
		
		
		
	}
	public void controls(){
		
		if (Input.oneClick(Keyboard.KEY_ESCAPE)) {Main.cleanUp();}
		
		if (Input.keyP(Keyboard.KEY_W)) 		 {move(speed, 0);}
		if (Input.keyP(Keyboard.KEY_S)) 		 {move(-speed, 0);}
		
		if (Input.keyP(Keyboard.KEY_A)) 		 {move(-speed, 1);}
		if (Input.keyP(Keyboard.KEY_D)) 		 {move(speed,  1);}
		
		if (Input.keyP(Keyboard.KEY_SPACE))		 {p.y -= speed;}
		if (Input.keyP(Keyboard.KEY_LSHIFT))	 {p.y += speed;}
		if (Input.keyP(Keyboard.KEY_RETURN))	 
		{
			p.set(-5,-1,-5);
			r.set(0,0,0);
		}
		
		
		
		if(Mouse.isButtonDown(1)) 	{	 if(!MP)	{Mouse.setGrabbed(!Mouse.isGrabbed()); MP = true;}				} else {MP = false;}
		
		Display.setTitle("X = " + p.x + " | Y = " + p.y + " | Z = " + p.z + " | RX = " + r.x + " | RY = " + r.y);
	}
	
	
	
	

}

















