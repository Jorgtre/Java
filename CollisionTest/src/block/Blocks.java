package block;

import static org.lwjgl.opengl.GL11.GL_LINES;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2i;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;

import Game.Camera;
import Game.Grid;
import Game.Image;
import Game.Input;
import Game.MOUSE;
import Game.Main;


public class Blocks {
	static boolean []KP = new boolean[2];
	static int startY;
	static int startX;
	static boolean blocksPlaced = true;
	static boolean blocksPlaced2 = true;	
	static int g  = Grid.Size;
	
	
	
	public static void Init(){
		for (Utility.Folder f: Image.imgFolder){
			
			for (int x = 0; x < f.numberOfImgs(); x++){
				Block.Type.add(new BlockTemplate(f.imgName(x), f.imgList(x), f.sBlock(), f.eBlock()));
			}
		}
	}
	public static void dragPlace(){
		int stopX = ((MOUSE.X()  + (int)Camera.X)) / g;
		int stopY = ((MOUSE.Y()  + (int)Camera.Y)) / g;
		
		if (mouseP(0) || mouseP(1))
		{
			startX = (int) ((MOUSE.X() + Camera.X) / g);
			startY = (int) ((MOUSE.Y() + Camera.Y) / g);
		}
		
		if (Mouse.isButtonDown(1))	
		{
			renderOverlay(startX, startY, stopX, stopY, 0);
			blocksPlaced2 = false;
		}
		
		if (Mouse.isButtonDown(0))
		{
			renderOverlay(startX, startY, stopX, stopY, Block.Selected);
			blocksPlaced = false;
		}
		
		if(!blocksPlaced && !Mouse.isButtonDown(0))
		{
			block.Blocks.PlaceMore(startX, startY,stopX,stopY, Block.Selected);
			blocksPlaced = true;
		}
		
		if(!blocksPlaced2 && !Mouse.isButtonDown(1))
		{
			block.Blocks.PlaceMore(startX, startY,stopX,stopY, 0);
			blocksPlaced2 = true;
		}
	}
	
	
	

	
	private static void renderOverlay(int startX, int startY, int stopX, int stopY, int blocktype){
		int cx = (int) Camera.X;
		int cy = (int) Camera.Y;
		
		if (blocktype > 0)
		{
			
			for (int y = 0; y < stopY - startY; y++) {
				for (int x = 0; x < stopX - startX; x++) {
					Image.print(blocktype, startX*g + (x*g) , startY*g + (y*g), Block.Width, Block.Height,false);
				}
			}
		}
		renderOutline((startX * g) - cx, (startY * g ) - cy, (stopX * g) - cx, (stopY * g) - cy);
	}

	private static void renderOutline(int x, int y, int x2,int y2){
		
		org.newdawn.slick.Color.white.bind();
		glBindTexture(GL_TEXTURE_2D, Image.Blank);
		
		glBegin(GL_LINES);
			glVertex2i(x2, y);
			glVertex2i(x2, y2);
			glVertex2i(x, y2);
			glVertex2i(x2, y2);
			glVertex2i(x, y);
			glVertex2i(x2, y);
			glVertex2i(x, y);
			glVertex2i(x, y2);
        glEnd();
	}
	private static boolean mouseP(int mouseBtn){
		if(Mouse.isButtonDown(mouseBtn))  		{	 if(!KP[mouseBtn])	{KP[mouseBtn] = true; return true;}				} else {KP[mouseBtn] = false;}
		return false;
	}
	
	
	private static void PlaceMore(int startX, int startY, int  stopX, int stopY ,int BlockType){
		for (int y = startY ; y < stopY ; y++){
			for(int x  = startX; x < stopX; x++){
				Grid.map[y][x] = BlockType;
			}
		}
	}

	public static void Render() {

		for (int y = 0; y < Grid.Height; y++) {
			for (int x = 0; x < Grid.Width; x++) {

				int X2 = x * Grid.Size;
				int Y2 = y * Grid.Size;
				if(Grid.map[y][x] > 0) {
					
					if(X2-Camera.X > -Block.Width && X2-Camera.X < Main.ScreenWidth && Y2-Camera.Y > -Block.Height && Y2-Camera.Y < Main.ScreenHeight) {
						Image.print(Grid.map[y][x], X2, Y2, Block.Width, Block.Height,false);
					}
				}
			}
		}
	}
}
