package Entity;

import java.util.ArrayList;

import javax.swing.text.html.parser.Entity;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import Entity.Characters.Bot;
import Entity.Characters.Player;
import Entity.Characters.Template;
import Entity.Weapons.*;
import Game.Input;
import Game.Main;
import Game.text;

public class Entities {
	public static ArrayList<Template> entityList = new ArrayList<Template>(1);
	
	
	
	public static void Init(){
		entityList.add(new Player(1, 0, 0, 0));
		
		
	}
	
	
	
	public static void Handler(){
		update();
		render();
	}
	
	
	
	public static void render(){
		for (Template e: entityList){
			e.render();
		}
		
		
	
		
		
		
	}
	public static void update(){
		if (Input.oneClick(Keyboard.KEY_P)) {entityList.add(new Bot(1, 0, 0, 0));}
		
		
		int counter = 0;
		for (Template e: entityList){
			e.update();
			e.borderCollision();
			e.speedLimit();
			e.friction();
			Collision.Check(e);
			e.gravity();
			e.UpdateMovement();
			counter++;
		}
			
		text.print(10, 70, "Entitys : " + counter);
		
		
	}

	
	
	


}
