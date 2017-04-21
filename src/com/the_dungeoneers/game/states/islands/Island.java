package com.the_dungeoneers.game.states.islands;

import com.the_dungeoneers.game.states.State;
import com.the_dungeoneers.game.states.levels.Level;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Eli on 21/04/2017.
 */
public abstract class Island implements State {
	
	public Map<Island, Level> levels;
	
	public Island(){
//		new
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
