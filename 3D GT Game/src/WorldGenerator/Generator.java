package WorldGenerator;

import java.util.Random;

import org.lwjgl.util.vector.Vector3f;

import BlockPackage.Template;
import BlockPackage.block;
import Game.World;
import Utility.Check;
import Utility.Misc;

public class Generator {
	
	
	public static void generate(){
		
		
		block.add(block.type.grass, 10, 2, 14);
		
		
		for (Template b: World.blockList){
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		//for (int i = 0; i < 100; i++){
			
			//Vector3f RndGenPos = autoGen();
			//if (!block.exists(RndGenPos)) {block.add(block.type.grass, RndGenPos);}
			
			
			
			
		//}
		
		
	}
	
	public static void place(Vector3f Block){
		
	}
	
	
	private static Vector3f autoGen(){
		int x = Misc.Random(0, World.width);
		int y = Misc.Random(0, World.height);
		int z = Misc.Random(0, World.depth);
		
		
		
		
		return new Vector3f(x, y, z);
	}
	
	
	
	private static Vector3f nextBlock(Vector3f b){
		
		int dist = 1;
		int x = 0;
		int y = 0;
		int z = 0;
		x = Misc.Random((int)b.x-dist, (int)b.x+dist);
		y = Misc.Random((int)b.y-dist, (int)b.y+dist);
		z = Misc.Random((int)b.z-dist, (int)b.z+dist);
		
		//System.out.println(b.x - dist);
		
		while (x < 0) {x = Misc.Random((int)b.x-dist, (int)b.x+dist);}
		while (y < 0) {y = Misc.Random((int)b.y-dist, (int)b.y+dist);}
		while (z < 0) {z = Misc.Random((int)b.z-dist, (int)b.z+dist);}
		
		
		
		//if (!block.exists(x,y,z)) {return new Vector3f(x, y, z);}
		
		return new Vector3f(x, y, z);
	}
	
	
	
	
	
}




















