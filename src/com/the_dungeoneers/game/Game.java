package com.the_dungeoneers.game;

import com.the_dungeoneers.game.input_handler.Keyboard;
import com.the_dungeoneers.game.states.Mainmenu;
import com.the_dungeoneers.game.states.StateManager;
import com.the_dungeoneers.game.states.levels.Level;
import com.the_dungeoneers.game.states.levels.Level1;
import processing.core.*;

public class Game extends PApplet{


	public StateManager states;

	@Override
	public void settings() {
		size(1280, 720);
	}

	@Override
	public void setup() {
		states = new StateManager();
		states.startState(new Mainmenu(this));
	}

	@Override
	public void draw() {
		update();
		
		background(45, 41, 41);
		drawEntities();
		drawUI();
	}
	
	private void drawEntities(){
		states.getState().drawEntities();
	}
	
	private void drawUI(){
		states.getState().drawUI();
	}
	
	private void update(){
		states.getState().update();
	}
	
	public void keyPressed(){
		states.getState().keyPressed();
	}
	
	public void keyReleased(){
		states.getState().keyReleased();
	}
	
	public void mousePressed(){
		states.getState().mousePressed();
	}
	
	public static void main(String[] args){
		PApplet.main("com.the_dungeoneers.game.Game");
	}
}
