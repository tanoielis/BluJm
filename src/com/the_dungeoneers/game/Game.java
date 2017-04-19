package com.the_dungeoneers.game;

import processing.core.*;
import Collision.*;

public class Game extends PApplet{
	
	public void settings(){
		size(1000,1000);
	}
	
	public void setup(){

	}
	
	public void draw(){
		line(500,500,100,100);
	}
	
	public static void main(String[] args){
		PApplet.main("com.the_dungeoneers.game.Game");
	}

}
