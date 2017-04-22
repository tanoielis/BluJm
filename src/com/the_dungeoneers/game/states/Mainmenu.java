package com.the_dungeoneers.game.states;

import Collision.Point;
import Collision.Square;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.states.island.IslandManager;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

/**
 * Mainmenu
 */
public class Mainmenu implements State{

	private Game g;
	private PImage menu;

	private Square playBtn;
	private Square instructionsBtn;
	private Square quitBtn;

	public Mainmenu(Game g){
		this.g = g;

		menu = g.loadImage("images/Backgrounds/mainMenu.png");

		playBtn = new Square(g, new PVector(320, 575), 495, 115);
		instructionsBtn = new Square(g, new PVector(270, 500), 425, 532);
		quitBtn = new Square(g, new PVector(620, 435), 115, 25);
	}

	@Override
	public void update(){

	}

	@Override
	public void drawUI(){
		g.background(menu);
	}

	@Override
	public void drawEntities(){

	}

	@Override
	public void keyPressed(){

	}

	@Override
	public void keyReleased(){

	}

	@Override
	public void mousePressed(){
		if(playBtn.contains(new Point(g, g.mouseX, g.mouseY))){
			g.states.startState(new IslandManager(g));
		}
		else if(instructionsBtn.contains(new Point(g, g.mouseX, g.mouseY))){
			g.states.startState(new Instructions(g));
		}
		else if(quitBtn.contains(new Point(g, g.mouseX, g.mouseY))){
			g.exit();
		}
	}
}
