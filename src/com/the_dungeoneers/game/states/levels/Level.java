package com.the_dungeoneers.game.states.levels;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.input_handler.Keyboard;
import com.the_dungeoneers.game.states.State;
import com.the_dungeoneers.game.states.island.Island;
import processing.core.PImage;

/**
 * Created by Eli on 21/04/2017.
 */
public abstract class Level implements State {

	protected static PImage bg;
	protected Game g;
	public boolean successful = false;	//todo don't forget to change this back to false
	public boolean running = true;	//todo don't forget to change this back to false
	public Player player;
	protected Camera camera;
	Island from;

	public Level(Game g, Player player, Camera camera, Island from) {
		this.g = g;
		this.from = from;
		this.bg = g.loadImage("images/background.png");
		this.player = player;
		this.camera = camera;
	}

	@Override
	public void update(){
		if(!running){
			g.states.endState();
			g.states.endState();
		}else {
			camera.update();
			player.update();
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
