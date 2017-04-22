package com.the_dungeoneers.game.entities;

import Collision.Square;
import com.the_dungeoneers.game.Game;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

/**
 * Abstract movable entity
 */
public abstract class MoveableEntity extends Entity{
	
	public Square bb;
	public PVector vel, accel;
	public boolean left, right, up, down;
	protected PImage img;
	
	public MoveableEntity(Game g, PVector pos, PVector vel, PVector accel){
		super(g, pos);
		this.vel = vel;
		this.accel = accel;
	}
	
	protected void movement(){
		if (up) {
			if (left) {
				moveUpLeft();
			} else if (right) {
				moveUpRight();
			} else {
				moveUp();
			}
		} else if (down) {
			if (left) {
				moveDownLeft();
			} else if (right) {
				moveDownRight();
			} else {
				moveDown();
			}
		} else if (left) {

			moveLeft();
		} else if (right) {
			moveRight();
		}
	}
	
	@Override
	public void update(){
		movement();
		
		bb.x = pos.x;
		bb.y = pos.y;
		
		vel.add(accel);
		pos.add(vel);
		accel.mult(0);
	}
	
	@Override
	public void draw(){
		g.imageMode(PConstants.CORNER);
		g.image(img, pos.x, pos.y);
	}
	
	protected abstract void moveLeft();
	protected abstract void moveRight();
	protected abstract void moveUp();
	protected abstract void moveDown();
	protected abstract void moveUpLeft();
	protected abstract void moveUpRight();
	protected abstract void moveDownLeft();
	protected abstract void moveDownRight();
}
