package Utility;

import java.io.File;

import Game.Image;

public class folderUtility {
	
	
	
	
	public static String[] getNameOfSubFolders(String path){
		File subFiles[] = new File(path).listFiles();
		String subFolderNames[] = new String[subFiles.length];
		for (int x = 0; x < subFiles.length; x++)	{
			subFolderNames[x] = subFiles[x].getName();
		}
		return subFolderNames;
	}
	public static String[] getNameOfFilesInFolder(String path){
		File files[] = new File(path).listFiles();
		String fileNames[] = new String[files.length];
		for (int x = 0; x < files.length; x++){
			fileNames[x] = files[x].getName();
		}
		return fileNames;
	}
	public static int getNumOfFilesInFolder(String path){
		File files[] = new File(path).listFiles();
		return files.length;
	}
	public static String getNameOfFileAt(String path, int index){
		String filenames[] = getNameOfFilesInFolder(path);
		return filenames[index];
	}
	public static int[] getImgListFromFolder(String path, int startAt){
		File [] filelist = new File(path).listFiles();
		int [] imgList = new int[filelist.length + startAt];
			for (int x = startAt; x < imgList.length; x++) {
			imgList[x] = Image.Load(filelist[x - startAt].toString());
		}
			return imgList;
	}
	public static String getSizeOfImg(String path){
		
		return null;
	}
	
	
	
}
