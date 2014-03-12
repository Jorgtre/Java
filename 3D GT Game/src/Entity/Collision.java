package Entity;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

import Utility.Draw;
import Entity.Characters.Template;
import Game.Input;
import Game.Main;
import Game.World;

public class Collision {
	
	private static float s = 0.5f;
	private static Template entity;
	private static Vector3f bPos = null;
	
	public static void Check(Template Entity){
		entity = Entity;
		//entity.setPos(new Vector3f(Entity.getP().getX(), -Entity.getP().getY()-2, Entity.getP().getZ()));
		float groundPoint = 0;
		
		for (BlockPackage.Template b: World.blockList){
			bPos = b.getPos();
			
			float s = 0.5f;
			
			
			
			float pb = 0.0001f;
			
			float PD = 0.40f;
			
			
			while (Right(PD))		{entity.setVelX(0); entity.addToPosX(-pb);}
			while (Left(PD))		{entity.setVelX(0); entity.addToPosX(pb);}
			while (Forward(PD))		{entity.setVelZ(0); entity.addToPosZ(-pb);}
			while (Backward(PD))	{entity.setVelZ(0); entity.addToPosZ(pb);}
			if (Down(0.40f))		{ groundPoint = b.getPos().getY()+s*2;}
			
			
			
			
				
			
			
		}
		entity.setGroundPoint(groundPoint);
		
		
	}
	
	private static boolean Right(float x){
	//	if (point2( s, s, 0)) {return true;}
		if (point2(	s, 0.3f, x))  {return true;}
		if (point2( s, 0.3f, -x)) {return true;}
		return false;
	}
	private static boolean Left(float x){
	//	if (point2(-s, s, 0)) {return true;}
		if (point2(-s, 0.3f, x)) {return true;}
		if (point2(-s, 0.3f, -x)) {return true;}
		return false;
	}
	private static boolean Forward(float x){
	//	if (point2(0, s, s)) {return true;}
		if (point2(x, 0.3f, s)) {return true;}
		if (point2(-x, 0.3f, s)) {return true;}
		return false;
	}
	private static boolean Backward(float x){
	//	if (point2(0, s, -s)) {return true;}
		if (point2(x, 0.3f, -s)) {return true;}
		if (point2(-x, 0.3f, -s)) {return true;}
		return false;
	}
	private static boolean Down(float x){
		
		if (point2( 0, 0, 0)){return true;}
		if (point2( -x, 0, -x)){return true;}
		if (point2( x, 0, x)){return true;}
		if (point2( -x, 0, x)){return true;}
		if (point2( x, 0, -x)){return true;}
		
		return false;
	}
	private static boolean Up(){
		return false;
	}
	
	private static boolean point2(float X, float Y, float Z){
			float x = entity.getP().getX() + X;
			float y = entity.getP().getY() + Y;
			float z = entity.getP().getZ() + Z;
			float s = 0.5f;
			Draw.Marker(x, y, z);
			//System.out.println("Z: "  + Z);
		return (Between(bPos.getX(), bPos.getX(), x) && 
				Between(bPos.getY()+s, bPos.getY(), y) && 
				Between(bPos.getZ(), bPos.getZ(), z));
	}
	private static boolean Between(float p1, float p2, float x){
		float s = 0.5f;
		return (x < p1+s && x > p1-s || x > p1-s && x < p1+s || x == p1);
	}
	
		
	
	
	
	
	
}
