package com.the_dungeoneers.game.entities;

import com.the_dungeoneers.game.Game;
import processing.core.PVector;

/**
 * An abstract entity
 */
public abstract class Entity{
	
	protected PVector pos;
	protected Game g;
	public String id;
	
	public Entity(Game g, PVector pos) {
		this.g = g;
		this.pos = pos;
	}
	
	public PVector getPos(){
		return pos.copy();
	}
	
	public abstract void update();
	
	public abstract void draw();
	
}
