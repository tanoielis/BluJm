package com.the_dungeoneers.game.entities.enemies;

import Collision.Square;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.entities.MoveableEntity;
import com.the_dungeoneers.game.states.levels.Level;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

import static processing.core.PApplet.constrain;
import static processing.core.PApplet.map;
import static processing.core.PApplet.sin;

/**
 * Created by Eli on 22/04/2017.
 */
public class Shark extends MoveableEntity{
	
	private float acc = 0.6f;
	private float speed = 30;
	public boolean despawn;
	
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
		
		if(pos.x + bb.wd < 0){
			despawn = true;
		}
	}
	
	@Override
	public void draw(){
		super.draw();
	}
}
