package com.the_dungeoneers.game;

import processing.core.*;

public class Game extends PApplet{

	
	@Override
	public void settings() {
		size(1000, 1000);
	}

	@Override
	public void setup() {
		
	}

	@Override
	public void draw() {
		update();
		
		background(255);
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
