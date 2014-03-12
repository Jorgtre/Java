package BlockPackage.BlockFolder;

import org.lwjgl.util.vector.Vector3f;

import BlockPackage.Template;
import BlockPackage.block;
import BlockPackage.block.type;
import Game.Model;
import Game.resources;

public class standarBlock extends Template {
	
	
	
	public standarBlock(type BlockType, float x, float y, float z) {
		super(BlockType, x, y, z, true);
	}
	
	public void render() {
		if (blockType() == type.grass) {Model.render(resources.grassBlock, new Vector3f(X(), Y()+0.5f, Z()), new Vector3f(180, 0, 0), 0.5f);}
		if (blockType() == type.stone) {Model.render(resources.stoneBlock, X(), Y()+0.5f, Z(), 0.5f);}
		if (blockType() == type.dirt) {Model.render(resources.dirtBlock, X(), Y()+0.5f, Z(), 0.5f);}
		
		
	}

	public void update() {
		
	}
	
	
}
