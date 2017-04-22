package com.the_dungeoneers.game.input_handler;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.entities.Entity;
import com.the_dungeoneers.game.entities.MoveableEntity;

/**
 * Handles all keyboard input
 */
public class Keyboard {
	
	private static final char LEFT = 'A';
	private static final char RIGHT = 'D';
	private static final char UP = 'W';
	private static final char DOWN = 'S';
	
	public static void checkInput(Game g, MoveableEntity obj){
		switch(g.keyCode){
			case LEFT:
				obj.left = true;
				break;
			case RIGHT:
				obj.right = true;
				break;
			case UP:
				obj.up = true;
				break;
			case DOWN:
				obj.down = true;
		}
	}
	
	public static void keyReleased(Game g, MoveableEntity obj){
		switch(g.keyCode){
			case LEFT:
				obj.left = false;
				break;
			case RIGHT:
				obj.right = false;
				break;
			case UP:
				obj.up = false;
				break;
			case DOWN:
				obj.down = false;
		}
	}
}