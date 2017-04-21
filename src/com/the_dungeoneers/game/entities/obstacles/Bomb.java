package com.the_dungeoneers.game.entities.obstacles;

import Collision.Square;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.entities.Entity;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

/**
 * Created by Eli on 22/04/2017.
 */
public class Bomb extends Entity{
	
	private PImage img;
	private Square bb;
	
	public Bomb(Game g, PVector pos){
		super(g, pos);
		
		this.img = g.loadImage("images/mine.png");
		bb = new Square(g, pos.x, pos.y, 100, 100);
	}
	
	@Override
	public void update(){
		
	}
	
	@Override
	public void draw(){
		g.imageMode(PConstants.CORNER);
		g.image(img, pos.x, pos.y, 100, 100);
	}
}
