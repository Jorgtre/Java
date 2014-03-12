package Objects.Buttons;

import Objects.Button;

public class textButton extends Button {
	
	private int size;
	private String Text;
	
	
	
	public textButton(String Text ,int x, int y, int size) {
		super(x, y, (size / 2) * Text.length(), size);
		
		this.size = size;
		this.Text = Text;
		
		
		
	}
	public void render(){
		if (mouseHover()) 
		{
			Game.Text.print(Text, x, y, size+1, 0, true);
		}
		else 
		{
			Game.Text.print(Text, x, y, size, 0, true);
		}
	}
}
