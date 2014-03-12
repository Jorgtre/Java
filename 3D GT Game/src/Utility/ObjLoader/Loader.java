package Utility.ObjLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.lwjgl.util.vector.Vector3f;

import Game.Main;

import static org.lwjgl.opengl.GL11.*;

public class Loader {
	
	public static int bunnyObj;
	
	
	public static int LoadObjects(String File){
		
		int i = glGenLists(1);
		glNewList(i, GL_COMPILE);
		
		Model m = new Model();
		
		try {
			m = loadModel(new File(File));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		glBegin(GL_TRIANGLES);
		
		
			for (Face face : m.faces){
				Vector3f n1 = m.normals.get((int) face.normal.x -1);
                glNormal3f(n1.x, n1.y, n1.z);
                
                Vector3f v1 = m.vertecies.get((int) face.vertex.x - 1);
                glVertex3f(v1.x, v1.y, v1.z);
                
                Vector3f n2 = m.normals.get((int) face.normal.y - 1);
                glNormal3f(n2.x, n2.y, n2.z);
                
                Vector3f v2 = m.vertecies.get((int) face.vertex.y - 1);
                glVertex3f(v2.x, v2.y, v2.z);
                
                Vector3f n3 = m.normals.get((int) face.normal.z - 1);
                glNormal3f(n3.x, n3.y, n3.z);
                
                Vector3f v3 = m.vertecies.get((int) face.vertex.z - 1);
                glVertex3f(v3.x, v3.y, v3.z);
				
			}
		
			
		glEnd();
		glEndList();
		
		return i;
	}
	
	
	
	
	
	public static Model loadModel(File f) throws FileNotFoundException, IOException{
		BufferedReader reader = new BufferedReader(new FileReader(f));
		Model m = new Model();
		String line;
		
		while ((line = reader.readLine()) != null){
			if (line.startsWith("v ")) 						{ m.vertecies.add(fillVector(line));}
			else if (line.startsWith("vn ")) 				{ m.normals.add(fillNormal(line)); }
			else if (line.startsWith("f "))
			{
				Vector3f vertexIndecies = new Vector3f(
						Float.valueOf(line.split(" ")[1].split("/")[0]),
						Float.valueOf(line.split(" ")[2].split("/")[0]),
						Float.valueOf(line.split(" ")[3].split("/")[0]));
				
				Vector3f normalIndecies = new Vector3f(
						Float.valueOf(line.split(" ")[1].split("/")[2]),
						Float.valueOf(line.split(" ")[2].split("/")[2]),
						Float.valueOf(line.split(" ")[3].split("/")[2]));
						
				m.faces.add(new Face(vertexIndecies, normalIndecies));
				
			}
		}
		reader.close();
		return m;
	}
	private static Vector3f fillVector(String line){
		float x = Float.valueOf(line.split(" ")[2]);
		float y = Float.valueOf(line.split(" ")[3]);
		float z = Float.valueOf(line.split(" ")[4]);
		
		return new Vector3f(x, y, z);
	}
	private static Vector3f fillNormal(String line){
		
		//float x = Float.valueOf(line.split(" ")[1]);
		//float y = Float.valueOf(line.split(" ")[2]);
		//float z = Float.valueOf(line.split(" ")[3]);
		float x = Float.valueOf(line.split(" ")[2]);
		float y = Float.valueOf(line.split(" ")[3]);
		float z = Float.valueOf(line.split(" ")[4]);
		
		return new Vector3f(x, y, z);
	}
	
	
	
}
