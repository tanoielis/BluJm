package com.the_dungeoneers.game.entities;

import Collision.SAT_Collision;
import Collision.Square;
import com.the_dungeoneers.game.Game;
import processing.core.PConstants;
import processing.core.PVector;

/**
 * Created by Eli on 20/04/2017.
 */
public class Boat extends Entity{
	
	public Square bb;
	private float wd, ht;
	
	public Boat(Game g, PVector pos, PVector vel, PVector accel){
		super(g, pos, vel, accel);
		this.wd = g.blockSize*3;
		this.ht = g.blockSize;
	}
	
	@Override
	public PVector getPos(){
		return super.getPos();
	}
	
	@Override
	public boolean collides(Entity obj){
		if(obj instanceof Player){
			Player p = (Player)obj;
			if(SAT_Collision.intersects(p.bb, this.bb)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void moveLeft(){
		
	}
	
	@Override
	public void moveRight(){
		
	}
	
	@Override
	public void jump(){
		
	}
	
	@Override
	public void update(){
		
	}
	
	@Override
	public void draw(){
		g.rectMode(PConstants.CORNER);
		g.fill(150, 150, 150);
		g.rect(pos.x, pos.y, wd, ht);
	}
}
