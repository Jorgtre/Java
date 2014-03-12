package Game;

public class Background {
	
	
	public static void Render(){
		Image.print(Image.GameBackground, 0, 0, Grid.Width * Grid.Size, Grid.Height * Grid.Size, false);
	}
}
