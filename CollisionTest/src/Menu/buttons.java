package Menu;

import java.util.ArrayList;

import Game.Main.State;
import Game.Main;
import Game.fading;
import Objects.Buttons.textButton;
import Objects.Buttons.textImgButton;
import Objects.other.textbox;
import Utility.Button;

public class buttons {
	private static Button startbtn = new Button("res/Buttons/startgame.png", 100, 100, 264, 101);
	private static Button editorbtn = new Button("res/Buttons/Editmap.png", 100, 300, 400, 101);
	
	private static ArrayList<Objects.Button> btnList = new ArrayList<>(1);
	
	public static void Init(){
		btnList.add(new textImgButton("StartGame", 2, 100, 100));
		btnList.add(new textImgButton("EditMap", 2, 100, 200));
	}
	
	
	
	public static void render(){
		for (Objects.Button btn: btnList){
			btn.render();
		}
		
	}
	
	public static void handleClick(){
		if (btnList.get(0).isClicked()) {fading.start(Main.State.Game);}
		if (btnList.get(1).isClicked()) {fading.start(Main.State.Editor);}
	}
	
	
	
}
