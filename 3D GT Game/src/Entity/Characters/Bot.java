package Entity.Characters;

import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

import Game.Input;
import Game.World;
import Game.text;
import Utility.Misc;

public class Bot extends Template {
	
	
	
	private enum state{normal, frenzy}
	private state behavior = state.normal;
	
	private enum move{ jump,left, right, forward, backward, stop};
	private move action = move.stop;
	
	private boolean left,right,up,down;
	
	
	public Bot( float size, float PosX, float PosY, float PosZ) {
		super(Game.Main.MaxModel, size, PosX, PosY, PosZ);
	}
	
	
	public void update() {
		Ai();
		
	}
	private void Ai(){
		Random rnd = new Random();
		
		int x = rnd.nextInt(100);
		
		if (x == 10) {action = move.forward;}
		if (x == 30) {action = move.backward;}
		if (x == 50) {action = move.left;}
		if (x == 55) {isjumping(true);} else {isjumping(false);}
		if (x == 80) {action = move.right;}
		if (x == 99) {action = move.stop;}
		
		
		
		switch (action) {
		
		case left:
			
			addToVelX(-0.05f);
			
			break;
		case forward:
			
			addToVelZ(0.05f);
			
			
			break;
		case right:
			
			addToVelX(0.05f);
			
			
			break;
		case backward:
			
			addToVelZ(-0.05f);
			
			
			break;
		case stop:
			setVelX(0);
			setVelZ(0);
			
			
			break;
		}
		
		
		
		
		
		
	}

	
	
}
