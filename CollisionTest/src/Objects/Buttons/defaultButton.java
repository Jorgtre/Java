package Objects.Buttons;

import Game.Image;
import Game.Text;
import Objects.Button;

public class defaultButton extends Button {
	
	private String text;
	private int activeImg, inActiveImg;
	private int font, size, imgP;
	
	public defaultButton(String text, int x, int y, int font,int size) {
		super(x, y, (size / 2) * text.length(), size);
		activeImg = Image.Load("res/Buttons/ActiveButton.png");
		inActiveImg = Image.Load("res/Buttons/InActiveButton.png");
		this.size = size;
		this.font = font;
		this.text = text;
	}
	
	public void render() {
		imgP = 20;
		if (mouseHover())
		{
			Image.print(activeImg, (x - imgP / 2) + 5, y - imgP / 2, w + imgP,  h + imgP, true);
			
			Text.print(text, x, y, size, font, true);
		}
		else
		{
			Image.print(inActiveImg, (x - imgP / 2) + 5, y - imgP / 2, w + imgP,  h + imgP, true);
			Text.print(text, x, y, size, font, true);
		}
	}

}
