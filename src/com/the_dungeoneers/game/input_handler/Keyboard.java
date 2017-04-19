package com.the_dungeoneers.game.input_handler;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.entities.Entity;
import processing.core.PApplet;

/**
 * Handles all keyboard input
 */
public class Keyboard {
	
	private static final char LEFT = 'A';
	private static final char RIGHT = 'D';
	private static final char JUMP = ' ';
	
	public static void checkInput(PApplet p, Entity obj, Game game){
		switch(p.keyCode){
			case LEFT:
				obj.moveLeft();
				break;
			case RIGHT:
				obj.moveRight();
				break;
			case JUMP:
				game.switchCamera();
				break;
		}
	}
}
