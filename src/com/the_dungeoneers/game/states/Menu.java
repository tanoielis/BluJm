package com.the_dungeoneers.game.states;

import Collision.Square;
import com.the_dungeoneers.game.Game;
import processing.core.PConstants;

/**
 * Main menu
 */
public class Menu implements State{
	
	private Game g;
	private Square play;
	
	public Menu(Game g){
		this.g = g;
		play = new Square(g, g.width/2-200, g.height/2-50, 400, 100);
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
	
	@Override
	public void keyPressed(){
		
	}
	
	@Override
	public void mousePressed(){
		float x = g.mouseX;
		float y = g.mouseY;
		if(x > play.x && x < play.wd + play.x && y > play.y && y < play.ht + play.y){
			g.states.startState(new Level1(g, g.player));
		}
	}
}
