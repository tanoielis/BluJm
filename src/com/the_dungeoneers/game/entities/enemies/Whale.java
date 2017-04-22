package com.the_dungeoneers.game.entities.enemies;

import Collision.Square;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.entities.MoveableEntity;
import com.the_dungeoneers.game.states.levels.Level;
import processing.core.PVector;

import static processing.core.PApplet.abs;
import static processing.core.PApplet.constrain;
import static processing.core.PApplet.radians;

/**
 * Created by Eli on 22/04/2017.
 */
public class Whale extends MoveableEntity{
	
	private float acc = 0.5f;
	private float speed = 15;
	
	public Spear[] spears;
	private boolean spawned;
	public boolean spearsActive;
	
	public Whale(Game g, PVector pos, PVector vel, PVector accel){
		super(g, pos, vel, accel);
		this.img = g.loadImage("images/Enemies/whale.png");
		this.bb = new Square(g, pos.x, pos.y, img.width, img.height);
	}
	
	@Override
	public void update(){
		super.update();
		moveLeft();
		
		vel.x = constrain(vel.x, -speed, speed);
		
		if(abs(pos.x - ((Level) g.states.getState()).player.getPos().x) < 200 && !spawned){
			spawnSpears();
			spawned = true;
			spearsActive = true;
		}
		
		if(spearsActive){
			handleSpears();
		}
	}
	
	@Override
	public void draw(){
		super.draw();
		if(spearsActive){
			drawSpears();
		}
	}
	
	private void spawnSpears(){
		int num = (int)g.random(3, 9);
		spears = new Spear[num];
		for(int i=0; i<num; i++){
			if(spears[i] == null){
				PVector direction = PVector.fromAngle(radians(g.random(60, 120)));
				spears[i] = new Spear(g, new PVector(((Level)g.states.getState()).player.getPos().x + g.random(-150, 150), -150), direction, direction);
			}
		}
		System.out.println("Loaded");
	}
	
	public void handleSpears(){
		
		int nulls = 0;
		for(int i=0; i<spears.length; i++){
			if(spears[i] != null){
				spears[i].update();
				if(spears[i].getPos().y > g.height || spears[i].getPos().x < 0 || spears[i].getPos().x > 7000){
					spears[i] = null;
				}
			}else {
				nulls++;
			}
		}
		if(nulls == spears.length){
			spearsActive = false;
		}
	}
	
	public void drawSpears(){
		for(Spear s : spears){
			if(s != null){
				s.draw();
			}
		}
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
}
