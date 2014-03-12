package BlockPackage;

import org.lwjgl.util.vector.Vector3f;

import BlockPackage.block.type;
import Game.Main;

abstract public class Template {
	private float x;
	private float y;
	private float z;
	private boolean solid;
	private block.type blockType;
	
	public Template(type blockType ,float x, float y, float z, boolean solid) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.solid = solid;
		this.blockType = blockType;
	}
	
	//------------abstract methodes-----------------
	abstract public void render();
	abstract public void update();
	
	
	//---------------------Getters-----------------
	public int X(){
		return (int) x;
	}
	public int Y(){
		return (int) y;
	}
	public int Z(){
		return (int) z;
	}
	public Vector3f getPos(){
		return new Vector3f(x,y,z);
	}
	public boolean solid(){
		return solid;
	}
	public type blockType(){
		return this.blockType;
	}
	
}
