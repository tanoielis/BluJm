package com.the_dungeoneers.game.states.levels;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.states.State;
import com.the_dungeoneers.game.states.islands.Island;
import com.the_dungeoneers.game.states.islands.IslandManager;

/**
 * Created by Eli on 21/04/2017.
 */
public abstract class Level implements State {

	private Game g;
	public boolean successful = true;	//todo don't forget to change this back to false

	public Level(Game g) {
		this.g = g;
	}

	@Override
	public void update(){
	}
	
	@Override
	public void drawUI(){
		
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
