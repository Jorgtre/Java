package Entity.Weapons;

import java.util.ArrayList;

import javax.swing.text.html.parser.Entity;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

import Utility.Misc;

import Entity.Entities;
import Entity.Characters.Template;
import Game.Input;
import Game.Main;
import Game.Model;
import Game.World;

public class gun extends WeaponTemplate  {
	
	
	public gun(Template Holder){
		setWeaponPosition(Holder.X(), Holder.Y(), Holder.Z());
		setHolder(Holder);
		setWeaponModel(Main.gun);
		
		
	}
	
	
	public void render() {
		glPushMatrix();
			glColor3f(0.2f, 0.2f, 0.2f);
			glTranslatef(WeaponX(), WeaponY(), WeaponZ());
			glRotatef(WeaponRY(), 0, 1, 0);
			glRotatef(WeaponRX(), 1, 0, 0);
			glScalef(0.4f, 0.4f, 0.4f);
		glCallList(getWeaponModel());
		
		
		glPopMatrix();
		
		
	}
	public void update() {
		//----Position----
		setWeaponPosition(getHolder().X()-0.6f, getHolder().Y()+2, getHolder().Z());
		setWeaponRotation(getHolder().getR().getX(), -getHolder().getR().getY()-180, getHolder().getR().getZ());
		
		if (Mouse.isButtonDown(0)) {fire();}
	}
	
	public void fire(){
		Entities.projectileList.add(new bullet(Entities.WeaponList[0]));
	}
	
	
	
	
	
	
	
	public class bullet extends WeaponTemplate.projectile{

		public bullet(WeaponTemplate Weapon) {
			super(Weapon);
			this.projectileModel = Main.bullet;
			speed = 1f;
		}

		public void render() {
			glPushMatrix();
			
			
			
			
			glColor3f(1, Misc.Random(0, 255) / 255, Misc.Random(0, 255) / 255);
			glTranslatef(WeaponX(), WeaponY(), WeaponZ());
			glRotatef(WeaponRY(), 0, 1, 0);
			glRotatef(WeaponX(), 1, 0, 0);
			
			glScalef(0.1f, 0.1f, 0.1f);
			
			glCallList(projectileModel);
			
			glPopMatrix();
		}

		
		
	}
	
	
	
	

	
	
}
