package com.the_dungeoneers.game.entities;

import com.the_dungeoneers.game.Game;
import processing.core.PVector;

/**
 * An abstract entity
 */
public abstract class Entity{
	
	protected static final float GRAVITY = 0.5f;
	
	protected PVector pos;
	protected Game g;
	protected PVector vel;
	protected PVector accel;
	public String id;
	
	public Entity(Game g, PVector pos, PVector vel, PVector accel) {
		this.g = g;
		this.pos = pos;
		this.vel = vel;
		this.accel = accel;
	}
	
	public PVector getPos(){
		return pos.copy();
	}
	
	public abstract void moveLeft();
	
	public abstract void moveRight();
	
	public abstract void jump();
	
	public abstract void update();
	
	public abstract void draw();
	
}
