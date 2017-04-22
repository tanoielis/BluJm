package com.the_dungeoneers.game.entities.enemies;

import Collision.Square;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.entities.MoveableEntity;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

import static processing.core.PApplet.constrain;

/**
 * Created by Eli on 22/04/2017.
 */
public class Shark extends MoveableEntity{
	
	private float acc = 0.6f;
	private float speed = 50;
	
	public Shark(Game g, PVector pos, PVector vel, PVector accel){
		super(g, pos, vel, accel);
		this.img = g.loadImage("images/Enemies/shark.png");
		this.bb = new Square(g, pos.x, pos.y, img.width, img.height);
	}
	
	@Override
	protected void moveLeft(){
		accel.add(-acc, 0);
	}
	
	@Override
	protected void moveRight(){
		accel.add(acc, 0);
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
		
		vel.x = constrain(vel.x, -speed, speed);
		
		moveLeft();
	}
	
	@Override
	public void draw(){
		super.draw();
	}
}
