package Utility;

public class Folder {
	private String name;
	private String[] imgNameList;
	private int[] imgList;
	private boolean solidBlocks;
	private boolean eventBlocks;
	
	
	
	
	public Folder(String name, int imgList[], String imgNameList[], boolean isSolidBlock, boolean isEventBlock){
		this.name = name;
		this.imgList = imgList;
		this.imgNameList = imgNameList;
		this.solidBlocks = isSolidBlock;
		this.eventBlocks = isEventBlock;
		
	}
	public Folder(String path){
		this.imgList = folderUtility.getImgListFromFolder(path, 0);
		this.imgNameList = folderUtility.getNameOfFilesInFolder(path);
		
	}
	public String name(){
		return name;
	}
	public int[] imgList(){
		return imgList;
	}
	public int imgList(int index){
		return imgList[index];
	}
	public String imgName(int index){
		return imgNameList[index];
	}
	public String info(){
		return "FolderName: " + name + " Number of Images : " + imgList.length;
	}
	public int numberOfImgs(){
		return imgList.length;
	}
	public boolean sBlock(){
		return solidBlocks;
	}
	public boolean eBlock(){
		return eventBlocks;
	}
	
	
	
}
