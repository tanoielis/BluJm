package com.the_dungeoneers.game.input_handler;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.entities.Entity;
import com.the_dungeoneers.game.entities.Player;

/**
 * Handles all keyboard input
 */
public class Keyboard {
	
	private static final char LEFT = 'A';
	private static final char RIGHT = 'D';
	private static final char JUMP = ' ';
	
	private static boolean leftDown;
	private static boolean rightDown;
	
	public static void checkInput(Game g, Entity obj){
		switch(g.keyCode){
			case LEFT:
				leftDown = true;
				break;
			case RIGHT:
				rightDown = true;
				break;
			case JUMP:
				obj.jump();
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
			case JUMP:
				break;
		}
	}
	
	public static void runInput(Entity obj){
		if(leftDown){
			obj.moveLeft();
		}
		if(rightDown){
			obj.moveRight();
		}
	}
}