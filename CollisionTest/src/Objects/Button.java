package Objects;

import Game.MOUSE;

public abstract class Button {
	
	protected int x,y,w,h;
	protected String path;
	
	
	public Button(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
	}

	public boolean isClicked(){
		int X = MOUSE.X();
		int Y = MOUSE.Y();
		return (X > x && Y > y && X < x+w && Y < y+h && MOUSE.oneClick(0)) ;
	}
	public boolean mouseHover(){
		int X = MOUSE.X();
		int Y = MOUSE.Y();
		if (X > x && Y > y && X < x+w && Y < y+h) {return true;}
		return false;
	}
	
	public abstract void render();
	
	
	
	
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
}
