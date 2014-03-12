package BlockPackage;

import java.util.ArrayList;

import org.lwjgl.util.vector.Vector3f;

import BlockPackage.BlockFolder.standarBlock;
import Game.World;

public class block {
	
	public enum type
	{
		 air,
		 grass,
		 stone,
		 obsidian,
		 dirt,
		 wood,
		 iron,
		 gass,
		 water,
		 gold,
		 ruby,
		 emerald
	};
	
	public static type selected;
	
	
	
	public static void add(type BlockType ,int x, int y, int z){
		World.blockList.add(new standarBlock(BlockType, x, y, z));
		System.out.println("Block added at (X: " + x + " Y " + y + " Z " + z);
	}
	public static void add(type blockType, Vector3f pos){
		add(blockType, (int)pos.getX(), (int)pos.getY(), (int)pos.getZ());
	}
	
	public static void remove(int x, int y, int z){
		ArrayList<Template> delList = new ArrayList<Template>(1);
		
		for (Template p: World.blockList){
			if (p.X() == x && p.Y() == y && p.Z() == z) {delList.add(p);}
		}
		for (int x1 = 0; x1 < delList.size(); x1++){
			World.blockList.remove(delList.get(x1));
		}
	}
	public static boolean exists(int x, int y, int z){
		for (Template p: World.blockList){
			if (p.X() == x && p.Y() == y && p.Z() == z) {return true;};
		}
		return false;
	}
	public static boolean exists(Vector3f Block){
		return exists((int)Block.getX(), (int)Block.getY(), (int)Block.getZ());
	}
	
	
}















