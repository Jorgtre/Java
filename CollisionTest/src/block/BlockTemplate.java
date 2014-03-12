package block;

import Game.Grid;
import Player.PlayerTemp;



public class BlockTemplate {
	private int Image;
	private String Name;
	private boolean Solid;
	private boolean isEventBlock;
	
	public BlockTemplate(String Name, int Image, boolean Solid, boolean isEventBlock){
		this.Image = Image;
		this.Name = Name;
		this.Solid = Solid;
		this.isEventBlock = isEventBlock;
	}
	public String getName(){
		return Name;
	}
	public int Img(){
		return Image;
	}
	public boolean isSolid(){
		return Solid;
	}
	public boolean Triggerd(){
		if (isEventBlock){
			PlayerTemp p = Player.Player.Player1;
		
				int x = (int) ((p.getX()) / Grid.Size);
				int y = (int) ((p.getY()) / Grid.Size);
				if(Safe(40, 0)){
					if ((Grid.map[y][x + 1] == Image || Grid.map[y][x] == Image ))	{ return true;}
				}
			}
		
		return false;
	}
	
	public boolean Safe( int MoveX, int MoveY) {
		PlayerTemp p = new PlayerTemp(0, 0, 0, 0);
		
		
			if(p.getX() < 0 || p.getX() + p.getW() + MoveX > Grid.Width * Grid.Size) 	{ return false;}
			if(p.getY() < 0 || p.getY() + p.getH() + MoveY > Grid.Height * Grid.Size) 	{ return false;}
		
		return true;
	}


}
