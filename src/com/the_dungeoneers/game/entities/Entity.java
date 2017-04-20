package com.the_dungeoneers.game.entities;

import com.the_dungeoneers.game.Game;
import processing.core.PVector;

/**
 * An abstract entity
 */
public abstract class Entity{
	
	protected PVector pos;
	protected static Game g;
	protected float speed;
	public String id;
	
	public Entity(Game g, PVector pos, float speed){
		this.g = g;
		this.pos = pos;
		this.speed = speed;
	}
	
	public PVector getPos(){
		return pos.copy();
	}
	
	public abstract void moveLeft();
	
	public abstract void moveRight();
	
	public abstract void update();
	
	public abstract void draw();
	
}
