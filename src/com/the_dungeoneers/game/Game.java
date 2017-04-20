package com.the_dungeoneers.game;

import com.the_dungeoneers.game.states.Menu;
import com.the_dungeoneers.game.states.StateManager;
import processing.core.*;

public class Game extends PApplet{
	
	private StateManager states;
	
	@Override
	public void settings() {
		size(1280, 720);
	}

	@Override
	public void setup() {
		states = new StateManager(new Menu(this));
	}

	@Override
	public void draw() {
		update();
		
		background(255);
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
		
	}
	
	public static void main(String[] args){
		PApplet.main("com.the_dungeoneers.game.Game");
	}
}
