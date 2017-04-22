package com.the_dungeoneers.game.entities.enemies;

import Collision.Square;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.entities.MoveableEntity;
import com.the_dungeoneers.game.states.levels.Level;
import processing.core.PVector;

import static processing.core.PApplet.abs;
import static processing.core.PApplet.constrain;

/**
 * Created by Eli on 22/04/2017.
 */
public class Whale extends MoveableEntity{
	
	private float acc = 0.5f;
	private float speed = 15;
	private int timer;
	
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
			timer = g.millis();
		}
		
		if(spawned){
			handleSpears();
		}
	}
	
	@Override
	public void draw(){
		super.draw();
		if(spawned){
			drawSpears();
		}
	}
	
	private void spawnSpears(){
		int num = (int)g.random(3, 9);
		int nulls = 0;
		spears = new Spear[num];
		for(int i=0; i<num; i++){
			if(spears[i] == null){
				spears[i] = new Spear(g, new PVector(pos.x + g.random(-100, 100), 0), new PVector(0, 5), new PVector());
			}else{
				nulls++;
			}
		}
		
		if(nulls == spears.length-1){
			spearsActive = false;
		}
	}
	
	public void handleSpears(){
		for(int i=0; i<spears.length; i++){
			if(spears[i] != null){
				spears[i].update();
				if(spears[i].getPos().y > g.height){
					spears[i] = null;
					System.out.println("Despawned");
				}
			}
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
