package Editor.Utility;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

import Game.Image;

abstract public class btnTemplate {

	private int x;
	private int y;
	private int w;
	private int h;
	private boolean b;

	public btnTemplate(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
	}
	public boolean isClicked() {
		int mx = Mouse.getX();
		int my = -(Mouse.getY() - Display.getHeight()) ;

		if (mx > x && mx < x + w && my > y && my < y + h) {
			if (Mouse.isButtonDown(0)) 		{if (!b) {b = true; return true;}} else {b = false;}
		}
		
		return false;
	}
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// ----------------abstract methodes----------------
	abstract public void render();
	abstract public void handler();
	// ----------------getters----------------
	public void x(int x){
		this.x = x;
	}
	public void y(int y){
		this.y = y;
	}
	public void w(int w){
		this.w = w;
	}
	public void h(int h){
		this.h = h;
	}
	// ----------------setters----------------
	public int x(){
		return this.x;
	}
	public int y(){
		return this.y;
	}
	public int w(){
		return this.w;
	}
	public int h(){
		return this.h;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
