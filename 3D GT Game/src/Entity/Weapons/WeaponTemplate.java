package Entity.Weapons;

import static org.lwjgl.opengl.GL11.glRotatef;

import org.lwjgl.util.vector.Vector3f;

import Entity.Entities;
import Entity.Characters.Template;
import Game.World;

abstract public class WeaponTemplate {
	
	
	
	private float WeaponX;
	private float WeaponY;
	private float WeaponZ;
	private float WeaponRX;
	private float WeaponRY;
	private float WeaponRZ;
	private int WeaponModel;
	
	private int magazineSize;
	private Entity.Characters.Template Holder;
	private int ID;
	private boolean destroyWeapon = false;
	
	
	abstract public void render();
	abstract public void update();
	abstract public void fire();
	
	

	
	
	//---------------getters---------------
	public float WeaponX(){
		return WeaponX;
	}
	public float WeaponY(){
		return WeaponY;
	}
	public float WeaponZ(){
		return WeaponZ;
	}
	public float WeaponRX(){
		return WeaponRX;
	}
	public float WeaponRY(){
		return WeaponRY;
	}
	public float WeaponRZ(){
		return WeaponRZ;
	}
	public Template getHolder(){
		return this.Holder;
	}
	public int getWeaponModel(){
		return WeaponModel;
	}
	public int getID(){
		return ID;
	}
	public boolean destroyWeapon(){
		return destroyWeapon;
	}
	
	
	//-----------------setters--------------
	public void setWeaponPosition(float X, float Y, float Z){
		this.WeaponX = X;
		this.WeaponY = Y;
		this.WeaponZ = Z;
	}
	public void setWeaponRotation(float x, float y, float z){
		this.WeaponRX = x;
		this.WeaponRY = y;
		this.WeaponRZ = z;
	}
	public void setHolder(Template Holder){
		this.Holder = Holder;
	}
	public void setID(int ID){
		this.ID = ID;
	}
	public void setWeaponModel(int model){
		this.WeaponModel = model;
	}
	
	
	//--------------------PROJECTILE!-------------------------------
	
	
	
	public abstract class projectile{
	//	protected float px;
	//	protected float py;
	//	protected float pz;
		private Vector3f projectilePosition = new Vector3f();
		private Vector3f projectileRotation = new Vector3f();
		protected float speed;
		protected int projectileModel;
		private boolean destroyBullet = false;
		
		public projectile(WeaponTemplate Weapon) {
			speed = 1;
			projectilePosition.set(WeaponX(), WeaponY(), WeaponZ());
			
			projectileRotation.setX((float) (speed * Math.sin(Math.toRadians(WeaponRY()))));
			projectileRotation.setY((float) (speed * Math.tan(Math.toRadians(WeaponRX()))));
			projectileRotation.setZ((float) (speed * Math.cos(Math.toRadians(WeaponRY()))));
			
			
			
		}

		abstract public void render();
		public void update(){
			Vector3f.add(projectilePosition, projectileRotation, projectilePosition);
			
			if (projectilePosition.getX() > World.width ||
				projectilePosition.getX() < 0 || projectilePosition.getY() > World.height ||
				projectilePosition.getY() < 0 || projectilePosition.getZ() > World.depth  ||
				projectilePosition.getZ() < 0)
				{destroyBullet = true;}
		}
		
		
		//---getters---
		public boolean destroyBullet(){
			return destroyBullet;
		}
		public Vector3f getProjectilePosition(){
			return projectilePosition;
		}
		public Vector3f getProjectileRotation(){
			return projectileRotation;
		}
		
	}
	
	
	
	
	
	
	
	
}
