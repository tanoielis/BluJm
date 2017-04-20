package com.the_dungeoneers.game.states;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;

/**
 * Abstract game class
 */
public abstract class GameState implements State{
	
	protected Player player;
	protected Camera camera;
	protected Game g;
	
	public GameState(Game g, Player player){
		this.player = player;
		this.g = g;
	}
	
	@Override
	public void update(){
		player.update();
	}
	
	@Override
	public void drawUI(){
		
	}
	
	@Override
	public void drawEntities(){
		g.pushMatrix();
			player.draw();
		g.popMatrix();
	}
	
	@Override
	public void keyPressed(){
		
	}
}
