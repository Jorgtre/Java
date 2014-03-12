package Game;

import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;

import javax.jws.Oneway;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import Utility.DisplayUtil;
import Utility.Draw;
import WorldGenerator.Generator;
import BlockPackage.block;


public class Camera {

	private float speed;
	private Vector3f p = new Vector3f(); // Position
	private Vector3f r = new Vector3f(); // Rotation
	private Vector3f v = new Vector3f(); // Velocity
	private boolean camMode = false;
	private boolean KP;
	private float zoom;
	
	private float fov;
	private float aspect;
	private float near;
	private float far;
	
	public Camera(float fov, float aspect, float near, float far) {
		p.set(0, -3, 0);
		r.set(0, 180, 0);
		
		speed = 0.09f;
		
		this.fov = fov;
		this.aspect = aspect;
		this.near = near;
		this.far = far;
		Initialize.Projection3D();
		
	}
	
	
	
	public void useView(){
		
		//r.y += 0.4f;
		//p.z += 0.01f;
		
		
		glRotatef(r.x, 1, 0, 0);
		glRotatef(r.y, 0, 1, 0);
		glRotatef(r.z, 0, 0, 1);
		glTranslatef(p.x, p.y, p.z);
		
		
	}
	public void handler(){
		controls();
		rotate();
		update();
		useView();
	}

	
	
	
	
	public void move(float amt, float dir) {
		p.z += amt * Math.sin(Math.toRadians(r.y + 90 * dir));
		p.x += amt * Math.cos(Math.toRadians(r.y + 90 * dir));
		
		
		
		
		
		
		//PYspeed = amt * Math.tan(Math.toRadians(r.x * dir - 0.1));
		
		
		//p.y += PYspeed; 
		
		
	}
	
	
	
	public void rotate(){
		
		
		
		if (camMode)
		{
			if (!Display.isActive()) {camMode = false;}
			r.y += Input.mouseDX / 5;
			r.x -= Input.mouseDY / 5;
			
			
			
			
			Mouse.setGrabbed(true);
		}
		else
		{
			Mouse.setGrabbed(false);
		}
		
		//-----Limitation for Rotation on Y-axis (Up and Down)
		if (r.x > 90) 	{r.x = 90;}
		if (r.x < -90)	{r.x = -90;}
		//-----Limitation for Rotation on X-axis (Left and Right)
		if (r.y > 360)  {r.y = 0;}
		if (r.y < 0) 	{r.y = 360;}
		//---------------------------------------------------
		
		
		
	}
	public void controls(){
		
		if (!Main.camMounted) 
		{
			if (Input.keyP(Keyboard.KEY_W)) 		{move(speed , 1);}
			if (Input.keyP(Keyboard.KEY_S)) 		{move(-speed  , 1);}
			if (Input.keyP(Keyboard.KEY_D)) 		{move(-speed , 0);}
			if (Input.keyP(Keyboard.KEY_A))			{move(speed , 0);}
			if (Input.keyP(Keyboard.KEY_LSHIFT))	{p.y += speed;}
			if (Input.keyP(Keyboard.KEY_SPACE))		{p.y -= speed;}
			if (Input.keyP(Keyboard.KEY_LCONTROL))  {speed = 0.5f;} else {speed = 0.09f;}
		}
		
		
		
		if (Input.keyP(Keyboard.KEY_ESCAPE)) 	{System.exit(1);}
		if (Mouse.isButtonDown(2)) 	{	 if(!KP)	{camMode = !camMode; KP = true;}				} else {KP = false;}
		if (Input.oneClick(Keyboard.KEY_M)) {World.Save();}
		if (Input.oneClick(Keyboard.KEY_L)) {World.Load();}
		if (Input.oneClick(Keyboard.KEY_C)) {World.Clear();}
		if (Input.oneClick(Keyboard.KEY_F11)) {Utility.DisplayUtil.toggleFullscreen(!Display.isFullscreen());}
		if (Input.oneClick(Keyboard.KEY_T)) {Main.testMode = !Main.testMode;}
		
		if (Input.oneClick(Keyboard.KEY_F1)) {Game.gameState = Game.State.Game; DisplayUtil.updateViewport();}
		if (Input.oneClick(Keyboard.KEY_F2)) 
		{
			Game.gameState = Game.State.MapEditor;
			Main.cam.setPosition(-14, -5, -28);
			Main.cam.setRotation(0, 0, 0);
		}
		if (Input.oneClick(Keyboard.KEY_G)) {Generator.generate();}
		
	}

	public void update(){
		zoom += Input.DWheel / 100f;
		
		
	
	}
	
	
	
	
	
	//--------------------------------Getters----------------------------
	public Vector3f getPosition(){
		return new Vector3f(p);
	}
	public Vector3f getRotation(){
		return r;
	}
	public Vector3f getVelocity(){
		return v;
	}
	public float getFov(){
		return fov;
	}
	public float getAspect(){
		return aspect;
	}
	public float getNear(){
		return near;
	}
	public float getFar(){
		return far;
	}
	
	//--------------------------------Setters------------------------------
	public void setPosition(float x, float y, float z){
		p.set(x, y, z);
	}
	public void setPosition(Vector3f Position){
		this.p = Position;
	}
	public void setRotation(float x, float y, float z){
		r.set(x, y, z);
	}
	public void setRotation(Vector3f Rotation){
		this.r = Rotation;
	}
	public void X(float x){
		p.setX(x);
	}

	
	
	
	
}





















