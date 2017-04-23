package com.the_dungeoneers.game.entities.enemies;

import Collision.Square;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.entities.MoveableEntity;
import processing.core.PApplet;
import processing.core.PVector;

import static java.lang.Math.abs;
import static processing.core.PApplet.constrain;
import static processing.core.PApplet.degrees;
import static processing.core.PApplet.radians;
import static processing.core.PConstants.CENTER;
import static processing.core.PConstants.CORNER;

/**
 * Spear
 */
public class Spear extends MoveableEntity{
	
	private float speed = 10;
	
	public Spear(Game g, PVector pos, PVector vel, PVector accel){
		super(g, pos, vel, accel);
		
		this.img = g.loadImage("images/Enemies/spear.png");
		this.bb = new Square(g, pos.x, pos.y, img.width, img.height, degrees(-(vel.heading())) + 90);
	}
	
	@Override
	public void update(){
		vel.add(accel);
		pos.add(vel);

		vel.setMag(constrain(vel.mag(), -speed, speed));

		this.bb = new Square(g, pos.x, pos.y, img.width, img.height, degrees(-(vel.heading())) + 90);

	}
	
	@Override
	public void draw(){
		g.pushMatrix();
			g.imageMode(CENTER);
			g.translate(pos.x + img.width/2, pos.y + img.height/2);
			g.rotate(vel.heading() - PApplet.radians(90));
			g.image(img, 0, 0);
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
