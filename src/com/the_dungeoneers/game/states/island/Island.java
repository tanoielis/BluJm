package com.the_dungeoneers.game.states.island;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.states.State;
import com.the_dungeoneers.game.states.levels.Level;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eli on 21/04/2017.
 */
public abstract class Island implements State {

	public Map<Island, Level> levels = new HashMap<>();
	protected String name;
	protected Game g;
	
	public Island(Game g, String name){
		this.g = g;
		this.name = name;
		levels = new HashMap<>();
	}

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
