package com.the_dungeoneers.game.entities;

import com.the_dungeoneers.game.Game;
import processing.core.PVector;

/**
 * Main player
 */
public class Player extends MoveableEntity{
	
	public static int speed = 1;
	public static int agility = 1;
	public static int lungs = 1;
	
	public Player(Game g, PVector pos, PVector vel, PVector accel){
		super(g, pos, vel, accel);
		
	}
	
	@Override
	protected void moveLeft(){
		
	}
	
	@Override
	protected void moveRight(){
		
	}
	
	
	@Override
	protected void moveUp(){
		
	}
	
	@Override
	protected void moveDown(){
		
	}
	
	@Override
	protected void moveUpLeft(){
		
	}
	
	@Override
	protected void moveUpRight(){
		
	}
	
	@Override
	protected void moveDownLeft(){
		
	}
	
	@Override
	protected void moveDownRight(){
		
	}
	
	@Override
	public void update(){
		super.update();
	}
	
	@Override
	public void draw(){
		super.draw();
	}
}
