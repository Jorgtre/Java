package Utility;

public class TileButton {
	private int x,y,w,h;
	private int img;
	private Button Btn;
	private boolean update = true;
	
	
	
	
	public TileButton(int x, int y, int w, int h, int img){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.img = img;
		
	}
	public void renderAndUpdate(){
		if (update)				{Btn = new Button(img, x, y, w, h);}
		if (Btn.isClicked())	{block.Block.Selected = img;}
		Btn.render();
		Btn.indicateMouseHover();
		
	}
	public void update(){
		update = true;
	}
	public void updatePositin(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
