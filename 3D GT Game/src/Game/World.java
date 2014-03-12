package Game;

import static org.lwjgl.opengl.GL11.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.LogRecord;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Random;

import BlockPackage.Template;
import BlockPackage.block;


public class World {
	public static int width = 30;
	public static int height =30;
	public static int depth = 30;
	public static float gravity = 0.09f;
	public static float baseLine = 0;
	
	
	public static ArrayList<Template>blockList = new ArrayList<>(1);
	
	public static void render(){

		//---------renders the floor grid----------
		glPushMatrix();
		for (int z = 0; z < depth+1; z++){
			for (int x = 0; x < width+1; x++){
				
				glPushMatrix();
				glLineWidth(2);
				glBegin(GL_LINES);
				{
					glColor3f(0.4f, 0.4f, 0.4f);
					glVertex3f(x-0.5f, 0, 0);
					glVertex3f(x-0.5f, 0, z-0.5f);
					glVertex3f(0, 0, z-0.5f);
					glVertex3f(x-0.5f, 0, z-0.5f);
				}
				glEnd();
				
			}
		}
		glPopMatrix();
		
		//-------Middle-Mark-------
		glPushMatrix();
		glScalef(0.5f, 0.5f, 0.5f);
		glBegin(GL_QUADS);
		{
			glColor3f(0, 1, 0);
			
			
			glVertex3f(-1, 0, 1);
			glVertex3f(1, 0, 1);
			glVertex3f(1, 0, -1);
			glVertex3f(-1, 0, -1);
			
		}
		glEnd();
		
		
		
		glTranslatef(29f, -0.0001f, 29);
		glScalef(30, 30, 30);
		glColor3f(0.2f, 0.2f, 0.2f);
		glBegin(GL_QUADS);
		glVertex3f(-1, 0, 1);
		glVertex3f(1, 0, 1);
		glVertex3f(1, 0, -1);
		glVertex3f(-1, 0, -1);
		
		
		glEnd();
		glPopMatrix();
		
		
		//------------walls-----------
		
		
		/*
		float w = width-0.5f;
		float d = depth-0.5f;
		float h = height-0.5f;

		glPushMatrix();
		glBegin(GL_LINES);
		{
			for (int y = 0; y < height; y++) {
				glColor4f(0, 0, 1, 0.4f);
				glVertex3f(w, y, d);
				glVertex3f(-0.5f, y, d);
				
				glVertex3f(w, y, -0.5f);
				glVertex3f(w, y, d);
				
				glVertex3f(-0.5f, y, d);
				glVertex3f(-0.5f, y, -0.5f);
				
				glVertex3f(w, y, -0.5f);
				glVertex3f(-0.5f, y, -0.5f);
			}
		}
		glEnd();
		glPopMatrix();
		*/
		
		
		
		
		for (BlockPackage.Template t: blockList){
			t.render();
		}
		
		
		
		
		
	}
	
	public static void Save(){
		
		String saveName = "SaveFile.GTG";
		Formatter F = null;
		
		try {
			F = new Formatter(saveName);
			
			for (BlockPackage.Template t: blockList){
				
				
				String X = String.format("%03d", t.X());
				String Y = String.format("%03d", t.Y());
				String Z = String.format("%03d", t.Z());
				String T = t.blockType().toString();
				String S = " ";
				
				F.format("%s%s%s%s%s%s%s%n", X,S,Y,S,Z,S,T);
				
				
				
			}
			
			
			
			//---------------------------------------------------------------------------
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		F.close();
	}
	public static void Load(){
		World.Clear();
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader("SaveFile.GTG"));
			
			String line = reader.readLine();
			
			while (line != null)
			{
				int x = Integer.valueOf(line.substring(0, 3));
				int y = Integer.valueOf(line.substring(5, 7));
				int z = Integer.valueOf(line.substring(9, 11));
				block.type type = block.type.valueOf(line.substring(12));
				
				block.add(type, x, y, z);
				
				line = reader.readLine();
			}
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	public static void Clear(){
		
		
		
		if (!blockList.isEmpty())
		{
			blockList.clear();
		}
	}

	
}
