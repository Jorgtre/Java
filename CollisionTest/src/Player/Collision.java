package Player;

import Game.Grid;


public class Collision {
	static float PushBack = 0.5f;
	static int X1 = 0;
	static int Y1 = 0;
	
	static float X;
	static float Y;
	static int W;
	static int H;
	
	
	
	
	
	public static void Handler( PlayerTemp p ) {
		X = p.getX();
		Y = p.getY();
		W = p.getW();
		H = p.getH();
		while	(Left())
		{
			update(p);
			p.setVlx(0);
			p.addToX(0.5f);
		}
		
		while	(Right())		
		{
			update(p);
			p.setVlx(0);
			p.addToX(-0.5f);
		}
		
		while	(Up()) 			
		{
			update(p);
			p.setVly(0);
			p.addToY(0.001f);
		}
		
		while	(Down())		
		{
			update(p);
			p.setVly(0);
			p.addToY(-Player.gravity);
		}
		
	}
	private static void update(PlayerTemp p){
		X =  p.getX();
		Y =  p.getY();
	}
	
	
	public static boolean Point(int X3, int Y3) {
		int X1 = 0;
		int Y1 = 0;
		if (X >=  W)	{ X1 =  W - 1; } else { X1 = 0; }
		if (Y >=  H)	{ Y1 =  H - 1; } else { Y1 = 0; }
		
		
		
	if (Safe(X1,Y1)) {
			int PX = (int)(X + X3) / Grid.Size;
			int PY = (int)(Y + Y3) / Grid.Size;
			if ( isSolid(PX,PY) )	{ return true;}
		}
		return false;
	}
	public static boolean isSolid(int x, int y){
		if (Safe(W, H)){
			for(block.BlockTemplate b : block.Block.Type){
				if(Grid.map[y][x] == b.Img()){return b.isSolid();}
			}
		}
		return false;
	}
	public static boolean Left() {
		
		if(Point(1, 1) && Point(1, H))	{return true;}
		
		
		return false;	
	}
	public static boolean Right() {
		if(Point(W -1, 0) && Point(W -1, H)){return true;}
		
		
		
		return false;
	}
	public static boolean Up() {
		if(Point(W / 2 ,0)){return true;}
		
		for (int x = 2; x < W ; x += 1){
			if (Point(x, 0) && Point(x - 1, 1)){return true;}
		}
		
		return false;
	}
	public static boolean Down() {
		
		
		
		//while (Point(40,40)){return true;}
		
		for (int x = 2; x < W ; x += 1){
			if (Point(x, H) && Point(x - 1, H -1)){return true;}
		}
		
		
		/*
		if (Point(1, y) && Point(2,y  -1)){return true;}
		if (Point(10,y) && Point(15,y  -1)){return true;}
		if (Point(15,y) && Point(20,y  -1)){return true;}
		if (Point(20,y) && Point(25,y  -1)){return true;}
		if (Point(25,y) && Point(30,y  -1)){return true;}
		if (Point(30,y) && Point(35,y  -1)){return true;}
		if (Point(38,y) && Point(w - 1 ,y  -1)){return true;}
		*/
		return false;
	}

	public static boolean Safe( int MoveX, int MoveY) {
		
		if(X <= -1 || X + MoveX >= Grid.Width * Grid.Size) 		{ return false;}
		if(Y <= -1 || Y + MoveY >= Grid.Height * Grid.Size) 	{ return false;}
		
		return true;
	}
	
	
	
	
	
	

}
