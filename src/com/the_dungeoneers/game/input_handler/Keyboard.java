package com.the_dungeoneers.game.input_handler;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.entities.Entity;

/**
 * Handles all keyboard input
 */
public class Keyboard {
	
	private static final char LEFT = 'A';
	private static final char RIGHT = 'D';
	private static final char JUMP = ' ';
	
	public static void checkInput(Game g, Entity obj){
		switch(g.keyCode){
			case LEFT:
				obj.moveLeft();
				break;
			case RIGHT:
				obj.moveRight();
				break;
			case JUMP:
				break;
		}
	}
}