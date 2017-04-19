package com.the_dungeoneers.game;

import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Enemy;
import com.the_dungeoneers.game.entities.Entity;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.input_handler.Keyboard;
import processing.core.*;

public class Game extends PApplet{

	private Camera activeCamera;
	private Player player;
	private Enemy enemy;
	
	@Override
	public void settings() {
		size(1000, 1000);
	}

	@Override
	public void setup() {
		player = new Player(this, new PVector());
		activeCamera = new Camera(this, player);
		enemy = new Enemy(this, new PVector(100,60));
	}

	@Override
	public void draw() {
		update();
		
		background(255);
		drawEntities();
		drawUI();
	}
	
	private void drawEntities(){
		pushMatrix();
			translate(activeCamera.getPos().x, activeCamera.getPos().y);
			player.draw();
			enemy.draw();
		popMatrix();
	}
	
	private void drawUI(){
		String camera = activeCamera.getFocus().id;
		fill(0);
		textSize(32);
		text("Camera "+camera, 100, 100);
	}
	
	private void update(){
		player.update();
		enemy.update();
		activeCamera.update();
	}
	
	public void keyPressed(){
		Keyboard.checkInput(this, player, this);
	}
	
	public void switchCamera(){
		Entity focus = activeCamera.getFocus() == player ? enemy : player;
		activeCamera.setFocus(focus);
	}
	
	public static void main(String[] args){
		PApplet.main("com.the_dungeoneers.game.Game");
	}
}
