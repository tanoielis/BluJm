package com.the_dungeoneers.game;

import com.the_dungeoneers.game.states.Menu;
import com.the_dungeoneers.game.states.StateManager;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import processing.core.*;

public class Game extends PApplet{

	Player player;
	Camera activeCamera;


	int HEIGHT = 720;
	int WIDTH = 1280;
	int blockSize = 16;


	private StateManager states;

	@Override
	public void settings() {
		size(WIDTH, HEIGHT);
	}

	@Override
	public void setup() {
		states = new StateManager(new Menu(this));
		player = new Player(this, new PVector(blockSize*3, height - blockSize * 6), new PVector(0,0), new PVector((float)0.1, (float)0.3));
	}

	@Override
	public void draw() {
		update();
		
		background(45, 41, 41);
		drawEntities();
		drawUI();
	}
	
	private void drawEntities(){
		
	}
	
	private void drawUI(){
		
	}
	
	private void update(){
		
	}
	
	public void keyPressed(){
	
	}
	
	public static void main(String[] args){
		PApplet.main("com.the_dungeoneers.game.Game");
	}
}
