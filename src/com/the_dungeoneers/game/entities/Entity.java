package com.the_dungeoneers.game.entities;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * An abstract entity
 */
public abstract class Entity{
	
	protected PVector pos;
	protected PApplet p;
	protected float speed;
	public String id;
	
	public Entity(PApplet p, PVector pos, float speed){
		this.p = p;
		this.pos = pos;
		this.speed = speed;
		this.id = "Enemy";
	}
	
	public PVector getPos(){
		return pos.copy();
	}
	
	public abstract void moveLeft();
	
	public abstract void moveRight();
	
	public abstract void update();
	
	public abstract void draw();
	
}
