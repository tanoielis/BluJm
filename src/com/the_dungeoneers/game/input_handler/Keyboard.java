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
	
	private static boolean leftDown;
	private static boolean rightDown;
	
	public static void checkInput(Game g, MoveableEntity obj){
		switch(g.keyCode){
			case LEFT:
				leftDown = true;
				break;
			case RIGHT:
				rightDown = true;
				break;
		}
	}
	
	public static void keyReleased(Game g, Entity obj){
		switch(g.keyCode){
			case LEFT:
				leftDown = false;
				break;
			case RIGHT:
				rightDown = false;
				break;
		}
	}
	
	public static void runInput(Entity obj){
		if(leftDown){
		}
		if(rightDown){
		}
	}
}