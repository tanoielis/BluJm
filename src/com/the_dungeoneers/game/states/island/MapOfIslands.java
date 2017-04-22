package com.the_dungeoneers.game.states.island;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.states.State;
import com.the_dungeoneers.game.states.island.islands.SkullIsland;
import processing.core.PConstants;
import processing.core.PImage;

/**
 * A map of islands
 */
public class MapOfIslands implements State {
	
	private static PImage map;
	private Game g;
	private IslandManager im;
	private Player player;
	private Camera camera;


	public MapOfIslands(Game g, IslandManager im, Player player, Camera camera){
		this.g = g;
		this.im = im;
		this.camera = camera;
		this.player = player;
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
		im.changeIsland(new SkullIsland(g, player, camera));
	}


}
