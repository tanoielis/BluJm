package com.the_dungeoneers.game.entities;

import com.the_dungeoneers.game.Game;
import processing.core.PVector;

/**
 * Abstract movable entity
 */
public abstract class MoveableEntity extends Entity{
	
	public PVector vel, accel;
	private boolean left, right, up, down;
	
	public MoveableEntity(Game g, PVector pos, PVector vel, PVector accel){
		super(g, pos);
		this.vel = vel;
		this.accel = accel;
	}
	
	private void movement(){
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
	}
	
	@Override
	public void draw(){
		
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
