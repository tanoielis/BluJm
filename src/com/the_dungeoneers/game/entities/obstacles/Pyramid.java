package com.the_dungeoneers.game.entities.obstacles;

import Collision.Triangle;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.entities.Entity;
import processing.core.PImage;
import processing.core.PVector;

/**
 * Created by Eli on 23/04/2017.
 */
public class Pyramid extends Entity{
	
	public PVector p1, p2, p3;
	public Triangle bb;
	
	public Pyramid(Game g, PVector p1, PVector p2, PVector p3){
		super(g, new PVector(p1.x, p2.y));
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		
		this.bb = new Triangle(g, p1, p2, p3);
	}
	
	@Override
	public void update(){
		
	}
	
	@Override
	public void draw(){
		
	}
}
