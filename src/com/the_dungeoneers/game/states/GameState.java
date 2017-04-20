package com.the_dungeoneers.game.states;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.input_handler.Keyboard;

/**
 * Abstract game class
 */
public abstract class GameState implements State{
	
	protected Player player;
	protected Game g;
	
	public GameState(Game g, Player player){
		this.player = player;
		this.g = g;
	}
	
	@Override
	public void update(){
		player.update();
		Keyboard.runInput(player);
	}
	
	@Override
	public void drawUI(){
		
	}
	
	@Override
	public void drawEntities(){
		player.draw();
	}

	@Override
	public void keyPressed(){
		Keyboard.checkInput(g, player);
	}

	@Override
	public void keyReleased(){
		Keyboard.keyReleased(g, player);
	}

	@Override
	public void mousePressed(){

	}
}
