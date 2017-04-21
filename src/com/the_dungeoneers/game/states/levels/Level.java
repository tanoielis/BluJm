package com.the_dungeoneers.game.states.levels;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.states.State;
import com.the_dungeoneers.game.states.islands.Island;
import com.the_dungeoneers.game.states.islands.IslandManager;
import processing.core.PImage;

/**
 * Created by Eli on 21/04/2017.
 */
public abstract class Level implements State {

	private static PImage bg;
	private Game g;
	public boolean successful = true;	//todo don't forget to change this back to false

	public Level(Game g) {
		this.g = g;
		this.bg = g.loadImage("images/background.png");
	}

	@Override
	public void update(){
	}
	
	@Override
	public void drawUI(){
	}
	
	@Override
	public void drawEntities(){
		g.image(bg, 0,0);
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
