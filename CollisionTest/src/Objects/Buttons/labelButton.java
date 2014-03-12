package Objects.Buttons;

import org.newdawn.slick.Color;

import Objects.Button;
import Utility.Shape;

import Game.MOUSE;

public class labelButton extends Button {
	
	private int size;
	private Color c;
	private String Text;
	private int font;

	public labelButton(String Text, int x, int y, int textSize, int font, Color color) {
		super(x, y, ((textSize / 2) * Text.length()) + 10, textSize);
		this.size = textSize;
		this.Text = Text;
		this.c = color;
		this.font = font;
	}
	
	public void render() {
		Shape.rect(x, y, w, h, c);
		Game.Text.print(Text, x, y, size, font, true);
		if (mouseHover()) {Shape.rect(x, y, w, h, 255, 255, 255, 0.4f);}
		
	}
}





