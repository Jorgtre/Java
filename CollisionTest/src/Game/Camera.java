package Game;

import Player.PlayerTemp;




public class Camera {
	
	public static float X = 100;
	public static float Y = 3080;
	public static int EditorSpeed = 20;
	public static int Speed = 10;
	
	public static void Update(PlayerTemp Player) {
		int RS = (Grid.Width*Grid.Size) - Screen.Width + 10;
		
		
		
		
		if(Main.state == Main.State.Editor) {
			
			if(Input.W())						{Camera.Y -= Camera.EditorSpeed;}
			if(Input.S())						{Camera.Y += Camera.EditorSpeed;}
			if(Input.A())						{Camera.X -= Camera.EditorSpeed;}
			if(Input.D())						{Camera.X += Camera.EditorSpeed;}
			
			if(X < 0) { X = 0; }
			if(X > RS) { X = RS;}// Grid.Width*Grid.Size; }
			if(Y < 0) { Y = 0; }
			if(Y > (Grid.Height*Grid.Size) - (Main.ScreenHeight )) { Y = (Grid.Height*Grid.Size) - (Main.ScreenHeight ); }
			
			
		}else{
			
			float PX = Player.getX();
			float PY = Player.getY();
			float DistanceX = 0;
			float DistanceY = 0;
			
			
			
			
			if ( PX > X + (Main.ScreenWidth / 2) ) {
				DistanceX = (PX - (Main.ScreenWidth / 2)) - X;
				X += (int)DistanceX / Speed;
			}
			
			if ( PX < X + (Main.ScreenWidth / 2) ) {
				DistanceX = (PX - (Main.ScreenWidth / 2)) - X;
				X += (int)DistanceX / Speed;
			}
			
			if (PY > Y + (Main.ScreenHeight / 2) ) {
				DistanceY = (PY - (Main.ScreenHeight / 2) ) - Y;
				Y += (int)DistanceY / Speed;
			}
			
			if (PY < Y + (Main.ScreenHeight / 2) ) {
				DistanceY = (PY - (Main.ScreenHeight / 2 ) ) - Y;
				Y += (int)DistanceY / Speed;
			}
			
			if(X < 0) { X = 0; }
			if(X > RS) { X = RS;}// Grid.Width*Grid.Size; }
			if(Y < 0) { Y = 0; }
			if(Y > (Grid.Height*Grid.Size) - (Main.ScreenHeight )) { Y = (Grid.Height*Grid.Size) - (Main.ScreenHeight ); }
		
			
			
			
		
		}
	}
}
