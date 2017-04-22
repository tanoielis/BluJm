package com.the_dungeoneers.game.states.island;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.states.State;
import com.the_dungeoneers.game.states.levels.Level;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eli on 21/04/2017.
 */
public abstract class Island implements State {

	protected Map<Island, Level> levels = new HashMap<>();
	public String name;
	protected Game g;
	protected Player player;
	protected Camera camera;
	
	public Island(Game g, String name, Player player, Camera camera){
		this.g = g;
		this.name = name;
		this.camera = camera;
		this.player = player;
	}

	public abstract void setLevels();
	
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
	
	@Override
	public boolean equals(Object obj){
		System.out.println(obj.getClass() == this.getClass());
		return obj.getClass() == this.getClass();
	}
}
