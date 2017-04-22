package com.the_dungeoneers.game.entities;

import com.the_dungeoneers.game.Game;
import processing.core.PVector;

/**
 * Main player
 */
public class Player extends MoveableEntity {
	
	public static float speed = 1;
	public static float agility = 1;
	public static float lungs = 1;
	
	public static float baseLung = 30; //seconds
	public static float baseSpeed = 10;	//move left right
	public static float baseAgility = 5; //move up down
	
	public static float currentSpeed;
	public static float currentLung;
	public static float currentAgility;
	
	public Player(Game g, PVector pos, PVector vel, PVector accel){
		super(g, pos, vel, accel);
	}
	
	@Override
	protected void moveLeft(){
		accel.add(-currentSpeed, 0);
	}
	
	@Override
	protected void moveRight(){
		accel.add(currentSpeed, 0);
	}
	
	
	@Override
	protected void moveUp(){
		accel.add(0, -currentSpeed);
	}
	
	@Override
	protected void moveDown(){
		accel.add(0, currentSpeed);
	}
	
	@Override
	protected void moveUpLeft(){
		accel.add(-currentSpeed, -currentSpeed);
	}
	
	@Override
	protected void moveUpRight(){
		accel.add(currentSpeed, -currentSpeed);
	}
	
	@Override
	protected void moveDownLeft(){
		accel.add(currentSpeed, -currentSpeed);
	}
	
	@Override
	protected void moveDownRight(){
		accel.add(currentSpeed, currentSpeed);
	}
	
	@Override
	public void update(){
		super.update();
		vel.add(accel);
		pos.add(vel);
		accel.mult(0);
	}
	
	@Override
	public void draw(){
		super.draw();
	}
}
