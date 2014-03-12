package Game;

import org.lwjgl.input.Mouse;

import Player.Player;
import block.Block;
import block.Blocks;



public class Game {
	
	public static void Boot(){
		
		Image.LoadImgs();
		Map.Loader.load(Map.Settings.GameSave);
		Blocks.Init();
		Color.Reset();
		Text.Init();
		Pause.Master.Init();
		Menu.buttons.Init();
	}
	
	
	public static void Render(){
		
		switch (Main.state) {
		case Game:
			Background.Render();
			Blocks.Render();
			Color.Reset();
			Player.render();
			
			
			
			
			global.fading();
			
			
			
			break;
		case Editor:
			Background.Render();
			Blocks.Render();
			
			
			Color.Reset();
			Blocks.dragPlace();
			Editor.SideBar.updateAndRender();
			
			global.fading();
			break;
		case Main_Menu:
			Image.print(Image.MenuBackground, true);
			
			Menu.buttons.render();
			
			
			global.fading();
			break;
		case Pause:
			
			Background.Render();
			Blocks.Render();
			Color.Reset();
			
			Pause.Master.render();
			
			
			
			
			
			
			global.fading();
			break;
		}
	}
	public static void Update(){
		switch (Main.state) {
		case Game:
			Player.controls();
			Player.friction();
			Player.speedlimit();
			Player.gravity();
			Player.borderCollision();
			Player.move();
			Player.collision();
			Player.camera();
			
			
			
			
			
			break;
		case Editor:
			Camera.Update(null);
			
			
			
			break;
		case Main_Menu:
			
			
			
			break;
		case Pause:
			
			
			
			
			
			
			break;
		}
	}
	public static void Keys(){
		switch (Main.state) {
		case Game:
			global.Keys();
			
			Input.Space();
			
			
			
			
			break;
		case Editor:
			global.Keys();
			
			
			
			if (Input.Up()&& Block.Selected < Block.Type.size())		{Block.Selected++;}
			if (Input.Down() && Block.Selected > 0)						{Block.Selected--;}
			if (Input.Ctrl_S())											{Map.Saver.save("GameSave");}
			if (Input.Ctrl_C())											{Map.Clearer.clear();}
			if (Input.L())												{Map.Loader.load("GameSave");}
			
			
			break;
		case Main_Menu:
			global.Keys();
			
			
			
			
			
			break;
		case Pause:
			global.Keys();
			
			
			
			
			
			
			break;
		}
	}
	public static void Events() {
		switch (Main.state) {
		case Game:
			
			Player.events();
			
			
			
			 
			
			break;
		case Editor:
			
		
			
			
		
			break;
		case Main_Menu:
			
			Menu.buttons.handleClick();
			
			
			break;
		case Pause:
			
			
			
			
			
			
			break;
		}
	}
}
