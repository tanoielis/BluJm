package com.the_dungeoneers.game.states.levels;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.input_handler.Keyboard;
import com.the_dungeoneers.game.states.Instructions;
import com.the_dungeoneers.game.states.State;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.island.IslandManager;
import processing.core.PImage;

/**
 * Created by Eli on 21/04/2017.
 */
public abstract class Level implements State {

	protected static PImage bg;
	protected Game g;
	public boolean successful;
	public boolean running;
	public Player player;
	protected Camera camera;
	private Island to;
	private IslandManager im;

	public Level(Game g, Player player, Camera camera, Island to, IslandManager im) {
		this.g = g;
		this.player = player;
		this.camera = camera;
		
		this.successful = false;
		this.running = true;
		
		this.im = im;
		this.to = to;
	}

	@Override
	public void update(){
		if(!running){
			g.states.endState();
			g.states.endState();
			im.attempt(successful, to, this);
		}else {
			camera.update();
			player.update();
			if(player.getPos().x > 2670){
				successful = true;
				running = false;
			}
		}
	}
	
	@Override
	public void drawUI(){
	}
	
	@Override
	public void drawEntities(){
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
