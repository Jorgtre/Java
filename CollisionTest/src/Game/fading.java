package Game;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;


public class fading {
	
	enum state {out, inn, off,};
	static state phase = state.off;
	static float transp = 0;
	static boolean b = true;
	static Main.State nextstate = null;
	
	
	public static void update(){
		switch (phase) {
		case out:
			if (transp < 1)					{transp += 0.05;}	else 	{Main.state = nextstate;phase = state.inn;}
			render(transp);
			break;
		case inn:
			if (transp > 0.03 )				{transp -= 0.01;} else		{phase = state.off;}
			render(transp);
			break;
		case off:

			break;
		}
	}
	
	
	public static void start(Main.State s){
		nextstate = s;
		if (!(Main.state == s) ) phase = state.out;
		
	}
	
	
	
	
	private static void render(float alpha){
		int x = 0;
		int y = 0;
		int w = Main.ScreenWidth;
		int h  = Main.ScreenHeight;
		Image.Blank();
		glColor4f(0f, 0f, 0f, alpha);
		glBegin(GL_QUADS);
			glVertex2f(x,y);
			glVertex2f(x+w,y);
			glVertex2f(x+w,y+h);
			glVertex2f(x,y+h);
		glEnd();
	}
	
	
	
	

	
}
