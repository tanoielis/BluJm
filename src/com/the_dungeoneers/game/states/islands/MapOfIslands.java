package com.the_dungeoneers.game.states.islands;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.states.State;
import processing.core.PConstants;
import processing.core.PImage;

/**
 * A map of islands
 */
public class MapOfIslands implements State{
	
	private static PImage map;
	Game g;
	
	public MapOfIslands(Game g){
		this.g = g;
		map = g.loadImage("images/map.png");
	}
	
	@Override
	public void update(){
		
	}
	
	@Override
	public void drawUI(){
		g.imageMode(PConstants.CORNER);
		g.image(map, 0, 0);
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
		
	}
}
