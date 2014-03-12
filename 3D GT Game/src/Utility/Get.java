package Utility;

import java.io.File;
import javax.naming.directory.DirContext;
import org.lwjgl.util.vector.Vector3f;

public class Get {
	
	
	public static int NumberOfFilesInFolder(String path){
		return new File(path).list().length;
	}
	public static String[] NameOfFilesInFolder(String path){
		return new File(path).list();
	}
	public static File[] FilesFromFolder(String path){
		return new File(path).listFiles();
	}
	public static void experiment(){
		File f = new File("lib");
		
		
	}
	
	
	
}
