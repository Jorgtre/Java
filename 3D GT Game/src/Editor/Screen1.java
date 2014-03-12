package Editor;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL11.glViewport;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;
import org.newdawn.slick.Color;


import BlockPackage.block;
import BlockPackage.block.type;
import Editor.Utility.blockBtn;
import Editor.Utility.normalBtn;
import Game.Input;
import Game.Main;
import Game.World;
import Game.resources;

public class Screen1 {
	private static boolean[][] mapList = new boolean[World.width][World.height];
	private static block.type[][] maplist = new type[World.width][World.height];
	private static normalBtn clearBtn = new normalBtn(515, 5, 30, 30, resources.xImage);
	private static normalBtn grassBtn = new normalBtn(515, 40, 30, 30, resources.grassImage);
	private static normalBtn stoneBtn = new normalBtn(515, 75, 30, 30, resources.stoneImage);
	private static float size = 17f;
	private static int grid;
	private static boolean B = false;
	
	
	
	public static void Handler(){
		glViewport(0, Display.getHeight() / 2, Display.getWidth() / 2, Display.getHeight() / 2);
		Render();
		
		edit();
		
		if (Input.oneClick(Keyboard.KEY_F5)) {updateMap();}
		Interface();
		
		
	}
	
	
	private static void Render(){
		if (!B) {createGrid(); B = true;}
		
		glCallList(grid);
		
		for (int x = 0; x < World.width; x++){
			for (int y = 0; y < World.height; y++) {
				if (maplist[x][y] != null) {renderSquare(x, y, (int)size);}
			}
		}
		
		
		
	}
	private static void createGrid(){
		grid = glGenLists(1);
		glNewList(grid, GL_COMPILE);
		glPushMatrix();
		glColor3f(0, 1, 0);
		glLineWidth(1);
		glBegin(GL_LINES);

		for (int x = 0; x < World.width+1; x++) {
			for (int y = 0; y < World.height; y++) {
				float s = size * 2;

				glVertex2f(x, y * s);
				glVertex2f(x * s, y * s);

				glVertex2f(x * s, y);
				glVertex2f(x * s, y * s);
			}
		}
		glEnd();
		glPopMatrix();
		glEndList();
		
		
	}
	private static void renderSquare(int x, int y, int size){
		size = size * 2;
		
		x = x * size;
		y = y * size;
		
		glColor3f(255, 0, 0);
		glBegin(GL_QUADS);
			glVertex2f(x, y);
			glVertex2f(x+size, y);
			glVertex2f(x+size, y+size);
			glVertex2f(x, y+size);
		glEnd();
	}
	
	private static void edit(){
		int mx = (int) (Mouse.getX() / size);
		int my = (int) ((-(Mouse.getY() - Display.getHeight())) / size);
		
		if (mx > -1 && mx < World.width && my > -1 && my < World.height-1)
		{

			if (Mouse.isButtonDown(0)) {maplist[mx][my] = block.selected;}
			if (Mouse.isButtonDown(1)) {maplist[mx][my] = null;}
			
			
		}
		
		updateMap();
	}
	
	
	private static void updateMap(){
		
		for (int x = 0; x < World.width; x++) {
			for (int y = 0; y < World.height; y++) {
				if (maplist[x][y] != null)
				{
				//	int x2 = World.width - x;
					int y2 = World.height -y;
					
					if (!block.exists(x, y2, 0)) {block.add(block.selected, x, y2, 0);}
				}
				else
				{
				//	int x2 = World.width - x;
					int y2 = World.height -y;
					block.remove(x, y2, 0);
				}
				
				
			}
		}
	}
	private static void clearGrid(){
		
		for (int x = 0; x < World.width; x++) {
			for (int y = 0; y < World.height; y++) {
				maplist[x][y] = null;
			}
		}
		updateMap();

	}
	
	private static void Interface(){
		clearBtn.render();
		grassBtn.render();
		stoneBtn.render();
		
		
		if (clearBtn.isClicked()) {clearGrid();}
		if (grassBtn.isClicked()) {block.selected = block.type.grass;}
		if (stoneBtn.isClicked()) {block.selected = block.type.stone;}
		
		
		
		
		
	}
	
}

















