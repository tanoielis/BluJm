package com.the_dungeoneers.game.entities.enemies;

import Collision.Square;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.entities.MoveableEntity;
import processing.core.PApplet;
import processing.core.PVector;

import static processing.core.PApplet.abs;
import static processing.core.PApplet.constrain;

/**
 * Spear
 */
public class Spear extends MoveableEntity{
	
	private float speed = 7;
	
	public Spear(Game g, PVector pos, PVector vel, PVector accel){
		super(g, pos, vel, accel);
		
		this.img = g.loadImage("images/spear.png");
		this.bb = new Square(g, pos.x, pos.y, img.width, img.height, vel.heading());
	}
	
	@Override
	public void update(){
		vel.add(accel);
		pos.add(vel);
		pos.x = abs(pos.x);
		pos.y = abs(pos.y);
		vel.x = constrain(vel.x, -speed, speed);
		vel.y = constrain(vel.y, -speed, speed);
	}
	
	@Override
	public void draw(){
		g.pushMatrix();
			g.rotate(vel.heading()- PApplet.radians(90));
			g.image(img, pos.x, pos.y);
		g.popMatrix();
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
}
