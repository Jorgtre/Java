package Player;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

import Game.Camera;
import Game.Grid;
import Game.Input;
import block.Block;

public class Player {
	public static float speedinc = 2;
	public static float gravity = 0.7f;
	public static float friction = 1f;
	public static float speedlimit = 35;
	public static float jumpforce = 20;

	
	public static PlayerTemp Player1 = new PlayerTemp(100, 3080, 40, 40);
	
	
	public static void controls(){
		
			if (Keyboard.isKeyDown(Keyboard.KEY_A))		{Player1.addToVlx(-speedinc);}
			if (Keyboard.isKeyDown(Keyboard.KEY_D))		{Player1.addToVlx(speedinc);}
			if (Input.Space() && (Collision.Point(Player1.getW() -1 , Player1.getH() +1) || Collision.Point(1, Player1.getH() +1)))		{Player1.addToVly(-jumpforce);}
		
	}
	public static void move(){
		Player1.move();
	}
	public static void camera(){
		Camera.Update(Player1);
	}
	public static void collision(){
		Collision.Handler(Player1);
	}
	public static void gravity(){
		Player1.addToVly(gravity);
	}
	public static void borderCollision() {
		PlayerTemp p = Player1;
		
		
			int x = (int) p.getX();
			int y = (int) p.getY();
			int w = p.getW();
			int h = p.getH();
			int gh = Grid.Height * Grid.Size;
			int gw = Grid.Width  * Grid.Size;
			
			if (x < 0)			{p.setVlx(0); p.setX(0);}
			if (y < 0)			{p.setVly(0); p.setY(0);}
			if (x + w > gw )	{p.setVlx(0); p.setX(gw - w);}
			if (y + h > gh )	{p.setVly(0); p.setY(gh - h);}
		
	}
	public static void friction(){
	PlayerTemp p = Player1;
		
			if (p.getVlx() > 0) { p.addToVlx(-(friction)); 
			if (p.getVlx() < 0.05) {p.setVlx(0);}
			} else {p.addToVlx(friction * Game.Main.delta);
			if (p.getVlx() > -0.05) {p.setVlx(0);}
			}
	}
	public static void speedlimit(){
		PlayerTemp p = Player1;
		
			float vlx = p.getVlx();
			float vly = p.getVly();
			float sl = speedlimit;
			
			if (vlx > sl ) {p.setVlx(sl - 0.01f);}
			if (vlx < -sl) {p.setVlx(-(sl - 0.01f));}
			if (vly > sl ) {p.setVly(sl - 0.01f);}
			if (vly < -sl ) {p.setVly(-(sl - 0.01f));}
			
		
	}
	
	
	public static void events(){
		PlayerTemp p = Player1;
		int I = 20;
		
		if (Block.Type.get(4).Triggerd()) {p.addToVlx(-I);}
		if (Block.Type.get(5).Triggerd()) {p.addToVlx(-I); p.addToVly(-I);}
		if (Block.Type.get(6).Triggerd()) {p.addToVly(-I);}
		if (Block.Type.get(7).Triggerd()) {p.addToVlx(I); p.addToVly(-I);}
		if (Block.Type.get(8).Triggerd()) {p.addToVlx(I);}
		if (Block.Type.get(9).Triggerd()) {p.addToVlx(I); p.addToVly(+I);}
		if (Block.Type.get(10).Triggerd()) {p.addToVly(I);}
		if (Block.Type.get(11).Triggerd()) {p.addToVlx(-I); p.addToVly(+I);}
	}	
	
	
	public static void render(){
		PlayerTemp p = Player1;
		
		float X = p.getX();
		float Y = p.getY();
		int W = p.getW();
		int H = p.getH();
		
		Color.red.bind();
		glBegin(GL_QUADS);
			glVertex2f(X - Camera.X, Y - Camera.Y);
			glVertex2f(X - Camera.X + W, Y - Camera.Y);
			glVertex2f(X - Camera.X + W, Y + H - Camera.Y);
			glVertex2f(X - Camera.X, Y + H - Camera.Y);
		glEnd();
		
	}
		
		
		
		
	
	
}
