package Entity.Characters;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_LIGHTING;
import static org.lwjgl.opengl.GL11.GL_SMOOTH;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glShadeModel;

import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;
import org.newdawn.slick.Color;

import Entity.Collision;
import Entity.Entities;
import Entity.Weapons.WeaponTemplate;
import Game.Input;
import Game.Main;
import Game.Model;
import Game.World;
import Game.render;
import Game.text;
import Utility.Check;
import Utility.Draw;
import Utility.Misc;
import Utility.Number;

public abstract class Template {
	private Vector3f p = new Vector3f(); // Position
	private Vector3f r = new Vector3f(); // Rotation
	private Vector3f v = new Vector3f(); // Velocity
	protected Entity.Weapons.WeaponTemplate weapon;
	protected float size;
	private boolean jumping;
	private boolean ground;
	private float groundPoint;
	private int model;
	protected Color color;
	protected int ID;
	protected boolean destroyEntity = false;
	
	protected float speed = 0.05f;
	private float limit = 0.1f;
	private float friction = 0.01f;
	
	
	public Template(int model , float size, float PosX, float PosY, float PosZ){
		this.p.set(PosX, PosY, PosZ);
		this.model = model;
		this.size = size;
		
		
		
		
		
		//picking a Color
		
		int r = Misc.Random(0, 255);
		int g = Misc.Random(0, 255);
		int b = Misc.Random(0, 255);
		
		this.color = new Color(r, g, b);
		
		
		
	}
	public void showPosition(){
		text.print(100, 100, "X : " + p.x);
		text.print(100, 120, "Y : " + p.y);
		text.print(100, 140, "Z : " + p.z);
		text.print(100, 160, "Velocity X = " + v.x);
		text.print(100, 180, "Velocity Z = " + v.z);
	}
	public void gravity(){
		
		
		
		if (p.y > 0 && p.y > groundPoint) {ground = false;} else {ground = true;}
		
		
		
		if (!ground) 
		{
			if (p.y > groundPoint) {v.y -= 0.01f;}
			
		}
		else
		{
			if (p.getY() < groundPoint-0.00001f){jumping = false;}
			if (jumping) {v.y += 0.2f;}
			else 
			{
				
				v.y = 0;
				p.y = groundPoint-0.00001f;
				
			}
		}
		
		
		
		
	}
	public void render(){
		
		Model.render(model, color, p, new Vector3f(0, 0, 0), size);
		
		
	}
	public void UpdateMovement(){
		Vector3f.add(p, v, p);
	}
	public void borderCollision(){
		float s = size;
		
		if (p.x + s > World.width ) {v.x = 0; p.x = World.width - s;}//Left side (+X)
		if (p.x - s < -1)	{v.x = 0; p.x = -1 + s;}//Right side (-X)
		if (p.z + s > World.depth)	{v.z = 0; p.z = World.depth - s;}//Top side (+Z)
		if (p.z - s < -1)	{v.z = 0; p.z = -1 + s;}//Bot side (-Z)
		
		/*
		if (p.x + s > World.width ) {v.x = 0; p.x = World.width - s;}//Left side (+X)
		if (p.x - s < -World.width)	{v.x = 0; p.x = -World.width + s;}//Right side (-X)
		if (p.z + s > World.depth)	{v.z = 0; p.z = World.depth - s;}//Top side (+Z)
		if (p.z - s < -World.depth)	{v.z = 0; p.z = -World.depth + s;}//Bot side (-Z)
		*/
	}
	
	public void speedLimit(){
		if (v.x > limit) {v.x = limit - 0.00000001f;}// speedLimiter (+X)
		if (v.x < -limit) {v.x = -limit - 0.000000001f;}// speedLimiter (-X)
		if (v.z > limit) {v.z = limit - 0.000000001f;}// speedLimiter (+Z)
		if (v.z < -limit){v.z = -limit - 0.000000001f;}// speedLimiter (-Z)
	}
	public void friction(){
		if (v.x > 0.001) {v.x -= friction;}
		if (v.x < -0.001){v.x += friction;}
		if (v.x < 0.000001 && v.x > -0.0001) {v.x = 0;}
		if (v.z > 0.001) {v.z -= friction;}
		if (v.z < -0.001){v.z += friction;}
		if (v.z < 0.000001 && v.z > -0.0001) {v.z = 0;}
	}

	

	

	
	
	
	
	
	//---------abstract-methodes----------
	abstract public void update();
	
	
	
	//--------------getters--------------
	public int getModel(){
		return model;
	}
	public Vector3f getP(){
		return p;
	}
	public Vector3f getR() {
		return r;
	}
	public Vector3f getV() {
		return v;
	}
	public float X(){
		return p.x;
	}
	public float Y(){
		return p.y;
	}
	public float Z(){
		return p.z;
	}
	public WeaponTemplate getWeapon(){
		return this.weapon;
	}
	public boolean destroyEntity(){
		return this.destroyEntity;
	}
	public boolean isJumping(){
		return jumping;
	}
	public boolean ground(){
		return this.ground;
	}
	
	
	//--------------setters--------------
	public void setPosX(float x){
		p.x = x;
	}
	public void setPosY(float y) {
		p.y = y;
	}
	public void setPosZ(float z) {
		p.z = z;
	}
	public void setPos(Vector3f pos){
		p.set(pos);
	}
	public void addToPosX(float x){
		p.setX(p.getX() + x);
	}
	public void addToPosY(float y){
		p.setY(p.getY() + y);
	}
	public void addToPosZ(float z){
		p.setZ(p.getZ() + z);
	}
	
	
	
	
	public void setVelX(float x){
		v.setX(x);
	}
	public void setVelY(float y){
		v.setY(y);
	}
	public void setVelZ(float z){
		v.setZ(z);
	}
	public void setVel(Vector3f Vel){
		v.set(Vel);
	}
	public void addToVelX(float VelX){
		v.setX(v.getX() + VelX);
	}
	public void addToVelY(float VelY){
		v.setY(v.getY() + VelY);
	}
	public void addToVelZ(float VelZ){
		v.setZ(v.getZ() + VelZ);
	}
	public void setRX(float RX){
		r.setX(RX);
	}
	public void setRY(float RY){
		r.setY(RY);
	}
	public void setRZ(float RZ){
		r.setZ(RZ);
	}
	
	
	
	public void giveWeapon(WeaponTemplate weapon){
		this.weapon = weapon;
	}
	public void setID(int ID){
		this.ID = ID;
	}
	public void isjumping(boolean jumping){
		this.jumping = jumping;
	}
	public void setGroundPoint(float groundPoint){
		this.groundPoint = groundPoint;
	}
}












