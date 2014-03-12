package Objects.Buttons;

import Game.Image;
import Objects.Button;
import Utility.Shape;

public class imageButton extends Button {
	private int img;
	private int hoverImg;
	
	public imageButton(int img, int x, int y, int w, int h) {
		super(x, y, w, h);
		this.img = img;
	}
	public imageButton(String ImageName, int x, int y, int w, int h) {
		super(x, y, w, h);
		
		
		
	}
	
	
	public void render(){
		Image.print(img, x, y, w, h, true);
		if (mouseHover()) {Shape.rect(this.x, this.y, this.w, this.h, 255, 255, 255, 0.4f);}
	}
}
