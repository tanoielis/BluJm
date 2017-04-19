package com.the_dungeoneers.game.entities;

import Collision.Square;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

/**
 * Main player object
 */
public class Player extends Entity{
	
	private float wd, ht;
	private Square bb;
	
	public Player(PApplet p, PVector pos){
		super(p, pos, 10f);
		this.wd = 50;
		this.ht = 50;
		this.bb = new Square(p, pos, wd, ht);
		this.id = "Player";
	}
	
	@Override
	public void update(){
		bb.x = pos.x;
		bb.y = pos.y;
	}
	
	@Override
	public void draw(){
		p.rectMode(PConstants.CORNER);
		p.fill(0, 255, 0);
		p.noStroke();
		p.rect(pos.x, pos.y, wd, ht);
	}
	
	public void moveLeft(){
		pos.add(-speed, 0);
	}
	
	public void moveRight(){
		pos.add(speed, 0);
	}
	
}
