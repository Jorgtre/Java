package Editor;

import java.util.ArrayList;

import Game.Image;
import Game.Main;
import Objects.Buttons.labelButton;
import Utility.DropDownFolder;
import Utility.TileButton;
import Utility.folderUtility;
import block.Block;

public class SideBar {
	private static boolean inited = false;
	
//	public static ArrayList<TileButton> btnList = new ArrayList<>(1);
	public static ArrayList<DropDownFolder> tileFolder = new ArrayList<>(1);
	static String[] folderNames = folderUtility.getNameOfSubFolders("res/Blocks");
	
	public static void updateAndRender(){
		
		//-------init Folders and Buttons-----------------------
		if (!inited) 
		{
			inited = true;
			for (int x = 0; x < folderNames.length; x++) 
			{
				Utility.Folder folder = Image.imgFolder.get(x);
				tileFolder.add(new DropDownFolder(folderNames[x], Main.ScreenWidth - 200, 100, 200, 300, createTileBtns(folder.imgList())));
			
			}
		}
		//---------------------------------------------------------------
		
		
		
		
		for (DropDownFolder f: tileFolder){
			f.renderAndUpdate();
		}
		
		
		
		
		
		// updates the position of all folders to match the first folder
		
		for (int x = 1; x < tileFolder.size(); x++){
			int next = tileFolder.get(x-1).nextFolder();
			tileFolder.get(x).setY(next);
		}
		
		
		
	}
	private static TileButton[] createTileBtns(int imgList[]){
		TileButton[] btnList = new TileButton[imgList.length];
		for (int x = 0; x < imgList.length; x++){
			btnList[x] = new TileButton(x * 20, 100, Block.Width, Block.Height, imgList[x]);
		}
		return btnList;
	}
	
	
	
	
	
}
