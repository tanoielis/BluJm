package com.the_dungeoneers.game.camera;

import static processing.core.PVector.lerp;
import com.the_dungeoneers.game.entities.Entity;
import processing.core.PApplet;
import processing.core.PVector;


/**
 * A camera object
 */
public class Camera{
	
	private Entity focus;
	private PVector pos;
	private float smoothness = 0.05f;
	private PApplet p;
	
	public Camera(PApplet p, Entity focus){
		this.focus = focus;
		this.p = p;
		this.pos = focus.getPos().add(p.width/2, p.height/2);
	}
	
	public void update(){
		PVector antipos = focus.getPos();
		float x = (-antipos.x)+p.width/2;
		float y = (-antipos.y)+p.height/2;
		pos = lerp(pos, new PVector(x,y), smoothness);
	}
	
	public PVector getPos(){
		return pos.copy();
	}
	
	public void setFocus(Entity focus){
		this.focus = focus;
	}
	
	public Entity getFocus(){
		return focus;
	}
}
