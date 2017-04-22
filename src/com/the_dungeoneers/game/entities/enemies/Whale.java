package com.the_dungeoneers.game.entities.enemies;

import Collision.Square;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.entities.MoveableEntity;
import com.the_dungeoneers.game.states.levels.Level;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

import static processing.core.PApplet.abs;
import static processing.core.PApplet.constrain;

/**
 * Created by Eli on 22/04/2017.
 */
public class Whale extends MoveableEntity{
	
	private float acc = 0.5f;
	private float speed = 30;
	private int timer;
	
	private Spear[] spears;
	private boolean spawned;
	
	public Whale(Game g, PVector pos, PVector vel, PVector accel){
		super(g, pos, vel, accel);
		this.img = g.loadImage("images/whale.png");
		this.bb = new Square(g, pos.x, pos.y, img.width, img.height);
	}
	
	@Override
	public void update(){
		super.update();
		moveLeft();
		
		vel.x = constrain(vel.x, -speed, speed);
		
		if(abs(pos.x - ((Level)g.states.getState()).player.getPos().x) < 200 && !spawned){
			spawnSpears();
			spawned = true;
			timer = g.millis();
		
		}
		
		if(spawned && g.millis() < timer + 10000){
			handleSpears();
		}
		
	}
	
	@Override
	public void draw(){
		super.draw();
		if(spawned){
			for(Spear s : spears){
				s.draw();
			}
		}
	}
	
	private void spawnSpears(){
		int num = (int)g.random(3, 9);
		spears = new Spear[num];
		for(int i=0; i<num; i++){
			spears[i] = new Spear(g, new PVector(pos.x, 0), new PVector(0, 5), new PVector());
		}
	}
	
	private void handleSpears(){
		for(Spear s : spears){
			s.update();
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
