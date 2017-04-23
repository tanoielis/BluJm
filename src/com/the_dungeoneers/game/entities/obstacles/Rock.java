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
public class Rock extends Entity{
	
	private PImage img;
	
	public Rock(Game g, PVector pos, String name, Square bb){
		super(g, pos);
		
		img = g.loadImage(name);
		this.bb = bb;
	}
	
	@Override
	public void update(){
		
	}
	
	@Override
	public void draw(){
		g.imageMode(PConstants.CORNER);
		g.image(img, pos.x, pos.y, bb.wd, bb.ht);
	}
}
