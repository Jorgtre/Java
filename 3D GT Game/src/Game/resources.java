package Game;

public class resources {
	//---------Images-----------
	public static int grassImage;
	public static int stoneImage;
	public static int obsidianImage;
	public static int dirtImage;
	public static int xImage;
	
	
	//---------Models-----------
	public static int MaxModel;
	public static int Ball;
	public static int grassBlock;
	public static int stoneBlock;
	public static int dirtBlock;
	public static int obsidianBlock;
	
	
	
	public static void LoadImages(){
		grassImage = Image.Load("res/Blocks/grass.png");
		stoneImage = Image.Load("res/Blocks/stone.png");
		obsidianImage = Image.Load("res/Blocks/obsidian.png");
		dirtImage = Image.Load("res/Blocks/dirt.png");
		xImage = Image.Load("res/X.png");
		
		
	}
	
	public static void loadModels(){
		grassBlock = Model.create(grassImage);
		stoneBlock = Model.create(stoneImage);
		dirtBlock = Model.create(dirtImage);
		obsidianBlock = Model.create(obsidianImage);
	}
	
	
	
	
}
