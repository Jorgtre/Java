package Entity.Characters;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import Utility.Check;
import Utility.Draw;
import BlockPackage.block;
import Entity.Entities;
import Game.Input;
import Game.Main;
import Game.Model;
import Game.World;
import Game.text;



public class Player extends Template {
	
	private boolean camMounted;
	
	
	public Player(float size, float PosX, float PosY, float PosZ) {
		super(Main.MaxModel, size, PosX, PosY, PosZ);
		
	}

	public void update() {
		Controls();
		camera();
		misc();
	}
	public void misc(){
		if (Main.testMode)
		{
			text.print(120, 10, "Position X: " + getP().getX());
			text.print(120, 30, "Position Y: " + getP().getY());
			text.print(120, 50, "Position Z: " + getP().getZ());
			text.print(120, 70, "Jumping: " + isJumping());
			text.print(120, 90, "Ground: " + ground());
			
			
			
		}
	}
	
	
	private void camera(){
		
		if (Game.Main.camMounted) 
		{
			setRY(Main.cam.getRotation().getY());
			setRX(Main.cam.getRotation().getX());
			Main.cam.setPosition(-getP().getX(), -getP().getY()-4, -getP().getZ());
			
			//setPos(new Vector3f(-Main.cam.getPosition().getX(), Main.cam.getPosition().getY(),-Main.cam.getPosition().getZ()));
			
			
		}
		else 
		{
			setRY(0);
			setRX(0);
		}
		
		
		
		
	}
	public void render(){
		
		if (!Main.testMode) {Model.render(this.getModel(), color, getP(), new Vector3f(0, -getR().getY(), 0), size);}
		
		
	}
	
	
	private void move(float amt, float dir) {
		addToPosZ( (float) -( amt * Math.sin(Math.toRadians(getR().getY() + 90 * dir))));
		addToPosX( (float) - (amt * Math.cos(Math.toRadians(getR().getY() + 90 * dir))));
		
		//System.out.println( (float) -( amt * Math.sin(Math.toRadians(getR().getY() + 90 * dir))));
	}
	
	private void Controls(){
		if (Game.Main.camMounted)
		{
			if (Input.keyP(Keyboard.KEY_A))		{move(speed , 4);}
			if (Input.keyP(Keyboard.KEY_D))		{move(speed , 6);}
			if (Input.keyP(Keyboard.KEY_W))		{move(speed , 1);}
			if (Input.keyP(Keyboard.KEY_S))		{move(speed , 3);}
			if (Input.keyP(Keyboard.KEY_SPACE)) {isjumping(true);} else isjumping(false);
			
			
		}
		else 
		{
			if (Input.keyP(Keyboard.KEY_LEFT))	{setVelX(+speed);}
			if (Input.keyP(Keyboard.KEY_RIGHT))	{setVelX(-speed);}
			if (Input.keyP(Keyboard.KEY_UP))	{setVelZ(+speed);}
			if (Input.keyP(Keyboard.KEY_DOWN))	{setVelZ(-speed);}
			if (Input.keyP(Keyboard.KEY_J)) 	{isjumping(true);} else {isjumping(false);}
		}
		
		
		
		if (Input.oneClick(Keyboard.KEY_Y))		{Game.Main.camMounted = !Game.Main.camMounted;}
		if (Input.oneClick(Keyboard.KEY_R))		{setPos(new Vector3f(0, 0, 0)); setVel(new Vector3f(0, 0, 0));}
		
		//if (Mouse.isButtonDown(0) && p.x > 0 && p.x <World.width && p.z > 0 && p.z < World.depth)
		//{
		//	block.place(block.type.grass, (int)p.x, (int)p.y, (int)p.z);
		//}
		
	}
	
	public void showPosition() {}
	

	
	
	

	
	
	
	
	


	
	
}
	
	

	
	

	
	
	
	
	

