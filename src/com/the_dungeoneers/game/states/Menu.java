package com.the_dungeoneers.game.states;

import com.the_dungeoneers.game.Game;
import processing.core.PConstants;

/**
 * Main menu
 */
public class Menu implements State{
	
	Game g;
	
	public Menu(Game g){
		this.g = g;
	}
	
	@Override
	public void update(){
		
	}
	
	@Override
	public void drawUI(){
		g.background(0);
		g.rectMode(PConstants.CENTER);
		g.fill(120);
		g.stroke(0);
		g.rect(g.width/2, g.height/2, 400, 100);
		g.fill(255);
		g.textSize(60);
		g.textAlign(PConstants.CENTER, PConstants.CENTER);
		g.text("Play", g.width/2, g.height/2);
		
	}
	
	@Override
	public void drawEntities(){
		
	}
}
