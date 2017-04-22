package com.the_dungeoneers.game.states.island;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.states.State;
import processing.core.PConstants;
import processing.core.PImage;

/**
 * A map of islands
 */
public class MapOfIslands implements State {
	
	private static PImage map;
	private Game g;
	private IslandManager im;

	public MapOfIslands(Game g, IslandManager im){
		this.g = g;
		this.im = im;
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
