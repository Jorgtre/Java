package Entity.Weapons;

import static org.lwjgl.opengl.GL11.*;

import javax.swing.text.Position;

import org.lwjgl.input.Mouse;

import Utility.Misc;

import Entity.Entities;
import Entity.Characters.Template;
import Entity.Weapons.gun.bullet;
import Game.Main;

public class ak47 extends WeaponTemplate {
	
	
	public ak47(Template Holder){
		setWeaponPosition(Holder.X(), Holder.Y(), Holder.Z());
		setHolder(Holder);
		setWeaponModel(Main.ak47);
	}
	
	public void render() {
		glPushMatrix();
		
		glColor3f(0.15f, 0.15f, 0.15f);
		glTranslatef(WeaponX(), WeaponY(), WeaponZ());
		glRotatef(WeaponRY(), 0, 1, 0);
		glRotatef(WeaponRX(), 1, 0, 0);
		glScalef(0.06f, 0.06f, 0.06f);
		
		
		glCallList(getWeaponModel());
		
		glPopMatrix();
		
	}

	
	public void update() {
		setWeaponPosition(getHolder().X()-0.6f, getHolder().Y()+2, getHolder().Z());
		setWeaponRotation(getHolder().getR().getX(), -getHolder().getR().getY()-180, getHolder().getR().getZ());
		if (Mouse.isButtonDown(0)) {fire();}
	}
	
	public void fire() {
		Entities.projectileList.add(new ak47_bullet(Entities.WeaponList[0]));
	}
	
	
	
	
	public class ak47_bullet extends projectile{

		public ak47_bullet(WeaponTemplate Weapon) {
			super(Weapon);
			this.projectileModel = Main.bullet;
		}

		public void render() {
			glPushMatrix();

			glColor3f(1, Misc.Random(0, 255) / 255, Misc.Random(0, 255) / 255);
			glTranslatef(getProjectilePosition().getX(), getProjectilePosition().getY(), getProjectilePosition().getZ());
			glRotatef(-getProjectileRotation().getY(), 0, 1, 0);
			glRotatef(WeaponRX(), 1, 0, 0);

			glScalef(0.1f, 0.1f, 0.1f);

			glCallList(projectileModel);

			glPopMatrix();
		}
		
	}






	
	
	
	
}
