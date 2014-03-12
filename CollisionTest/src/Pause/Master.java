package Pause;

import java.util.ArrayList;

import Game.Main;
import Game.Text;
import Objects.Button;
import Objects.Buttons.defaultButton;
import Objects.Buttons.textButton;
import Objects.Buttons.textImgButton;

public class Master {
	
	
	static ArrayList<Button> btnList = new ArrayList<Button>(1);
	
	
	
	
	public static void Init(){
		
		//btnList.add(new textImgButton("StartGame", 1 ,500, 100));
		btnList.add(new defaultButton("EDIT MAP", 500, 100, 0,40));

	}
	
	
	
	public static void render(){
		Utility.Shape.rect(0, 0, Main.ScreenWidth, Main.ScreenHeight, 0, 0, 0, 0.85f);
		for (Button btn: btnList){
			btn.render();
		}
		
		//Text.print("abcdefghijklmnopqrstuvwxyz  ABCDEFGHIJKLMNOPQRSTUVWXYZ", 100, 100, 35, 0, true);
		
		
		
	}
	public static void update(){
		
		
	}
	
	
	
	
	
}
