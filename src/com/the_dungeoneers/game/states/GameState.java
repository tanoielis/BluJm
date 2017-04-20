package com.the_dungeoneers.game.states;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;

/**
 * Abstract game class
 */
public abstract class GameState implements State{
	
	private Player player;
	private Camera camera;
	private Game g;
	
	public GameState(Game g, Player player, Camera camera){
		this.player = player;
		this.camera = camera;
		this.g = g;
	}
	
	@Override
	public void update(){
		player.update();
		camera.update();
	}
	
	@Override
	public void drawUI(){
		
	}
	
	@Override
	public void drawEntities(){
		g.pushMatrix();
			g.translate(camera.getPos().x, camera.getPos().y);
			player.draw();
		g.popMatrix();
	}
	
	@Override
	public void keyPressed(){
		
	}
}
