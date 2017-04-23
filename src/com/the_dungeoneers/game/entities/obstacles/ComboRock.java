package com.the_dungeoneers.game.entities.obstacles;

import Collision.ComboPolygon;
import Collision.Square;
import Collision.Triangle;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.entities.Entity;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

/**
 * Created by Eli on 23/04/2017.
 */
public class ComboRock extends Entity{
	
	public ComboPolygon bb;
	public float wd, ht;
	private PImage bg;
	private boolean upsideDown;
	
	public ComboRock(Game g, PVector pos, float wd, float ht, boolean upsideDown){
		super(g, pos);
		this.wd = wd;
		this.ht = ht;
		bg = g.loadImage("images/Rocks/rock4.png");
		this.upsideDown = upsideDown;
		bb = new ComboPolygon(g, 0, new Square(g, new PVector(pos.x, 130), wd, 160),
									new Square(g, new PVector(pos.x + 70, pos.y), 218, pos.x+125));
	}
	
	@Override
	public void update(){
		
	}
	
	@Override
	public void draw(){
		g.imageMode(PConstants.CORNER);
		if(upsideDown){
			g.pushMatrix();
				g.scale(1, -1);
				g.image(bg, pos.x, pos.y+ht, wd, ht);
			g.popMatrix();
		}else{
			g.image(bg, pos.x, pos.y, wd, ht);
		}
	}
}
