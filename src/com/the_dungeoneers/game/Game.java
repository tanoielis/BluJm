package com.the_dungeoneers.game;

import processing.core.*;

public class Game extends PApplet{
	
	public void settings(){
		size(1000,1000);
	}
	
	public void setup(){
		PVector poo = new PVector();
	}
	
	public void draw(){
		line(500,500,100,100);
        line(600,500,300,400);
	}
	
	public static void main(String[] args){
		PApplet.main("com.the_dungeoneers.game.Game");
	}
}
