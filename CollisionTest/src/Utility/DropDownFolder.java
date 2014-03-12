package Utility;

import org.newdawn.slick.Color;
import Objects.Buttons.*;


public class DropDownFolder {
	private int x,y,w,h;
	private labelButton Btn;
	private String text;
	private boolean open;
	private TileButton btnList[];
	private boolean updated = false;
	
	public DropDownFolder(String text ,int x, int y, int w, int h, TileButton btnList[]){
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
		this.btnList = btnList;
		this.text = text;
		Btn = new labelButton(text, x, y, 20, 0, Color.gray);
	}
	
	
	public void renderAndUpdate(){
		if (!updated)	{ Btn = new labelButton(text, x, y, 20, 0, Color.gray);}
		
		if (open)
		{
			
			Shape.rect(x, y, w, h , Color.gray);
			Shape.rect(x+5, y+20, w-10, h-25, Color.lightGray);
			updateAndRenderTileBtns();
			Btn.render();
			
			
			if (Btn.isClicked())	
			{
				open = !open;
				updated = false;
			}
		}
		else
		{
			Utility.Shape.rect( x , y, w, 20, Color.gray);
			Btn.render();
			
			if(Btn.isClicked())	
			{
				open = !open;
				updated = false;
			}
		}
		Btn.mouseHover();
		
		
		
	}
	public int X(){
		return x;
	}
	public int Y(){
		return y;
	}
	public int W(){
		return w;
	}
	public int H(){
		return h;
	}
	public boolean open(){
		return open;
	}
	public void setY(int y){
		this.y = y;
	}
	public int nextFolder(){
		if (open)	{return y+h;}
		return y+20;
	}
	private void updateAndRenderTileBtns(){
		for(int x = 0; x < btnList.length; x++){
			btnList[x].renderAndUpdate();
		}
		int y = this.y;
		int x = this.x;
		for (TileButton btn : btnList) {
			
			btn.updatePositin(x + 10, y + 25);
			if (y < this.y + (5* 42))
			{
				
				y += 42;
				
				
			}
			else 
			{
				y = this.y;
				x += 42;
				
			}
			
		}
	}
}






