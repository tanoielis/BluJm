package com.the_dungeoneers.game;

import com.the_dungeoneers.game.input_handler.Keyboard;
import com.the_dungeoneers.game.states.Menu;
import com.the_dungeoneers.game.states.StateManager;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import processing.core.*;

public class Game extends PApplet{

	Player player;
	Camera activeCamera;


	public int HEIGHT = 720;
	public int WIDTH = 1280;
	public int blockSize = 16;


	private StateManager states;

	@Override
	public void settings() {
		size(WIDTH, HEIGHT);
	}

	@Override
	public void setup() {
		states = new StateManager(new Menu(this));
		player = new Player(this, new PVector(blockSize*3, height - blockSize * 6), new PVector(0,0), new PVector((float)0.1, (float)0.3));
		activeCamera = new Camera(this, player);
	}

	@Override
	public void draw() {
		update();
		
		background(45, 41, 41);
		drawEntities();
		drawUI();
	}
	
	private void drawEntities(){
		//states.getState().drawEntities();
	}
	
	private void drawUI(){
		//states.getState().drawUI();
	}
	
	private void update(){
		player.update();
		activeCamera.update();
	}
	
	public void keyPressed(){
		Keyboard.checkInput(this, player);
	}
	
	public static void main(String[] args){
		PApplet.main("com.the_dungeoneers.game.Game");
	}
}
