package com.the_dungeoneers.game.states;

import com.the_dungeoneers.game.Game;

/**
 * Created by Eli on 23/04/2017.
 */
public class Quit implements State{
	Game g;
	public Quit(Game g){
		this.g = g;
	}
	
	@Override
	public void update(){
		g.exit();
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
