package com.the_dungeoneers.game.entities;

import Collision.Square;
import com.the_dungeoneers.game.Game;
import processing.core.PImage;
import processing.core.PVector;

import static processing.core.PApplet.constrain;
import static processing.core.PApplet.lerp;

/**
 * Main player
 */
public class Player extends MoveableEntity {
	
	public static float speed = 1;
	public static float agility = 1;
	public static float lungs = 1;
	
	public static float baseLung = 30; //seconds
	public static float baseSpeed = 7;//move left right
	public static float baseAgility = 0.3f; //move up down
	
	public static float currentSpeed;
	public static float currentLung;
	public static float currentAgility;
	
	public int upgradePoints;
	
	private PImage[] swimImages = new PImage[8];
	private int timer;
	private int count = 0;
	
	public Player(Game g, PVector pos, PVector vel, PVector accel){
		super(g, pos, vel, accel);
		loadImages();
		timer = g.millis();
		upgradePoints = 0;
	}
	
	private void loadImages(){
		for(int i=0; i<swimImages.length; i++){
			swimImages[i] = g.loadImage("images/Player/Swimming/swim/"+i+".png");
		}
		img = swimImages[0];
		this.bb = new Square(g, pos.x, pos.y ,img.width, img.height);
	}
	
	@Override
	protected void moveLeft(){
		accel.add(-currentAgility, 0);
	}
	
	@Override
	protected void moveRight(){
		accel.add(currentAgility, 0);
	}
	
	@Override
	protected void moveUp(){
		accel.add(0, -currentAgility);
	}
	
	@Override
	protected void moveDown(){
		accel.add(0, currentAgility);
	}
	
	@Override
	protected void moveUpLeft(){
		accel.add(-currentAgility, -currentAgility);
	}
	
	@Override
	protected void moveUpRight(){
		accel.add(currentAgility, -currentAgility);
	}
	
	@Override
	protected void moveDownLeft(){
		accel.add(-currentAgility, currentAgility);
	}
	
	@Override
	protected void moveDownRight(){
		accel.add(currentAgility, currentAgility);
	}
	
	@Override
	public void update(){
		super.update();
		
		currentAgility = baseAgility * agility;
		currentSpeed = baseSpeed * speed;
		
		if(!(left || right)){
			vel.x = lerp(vel.x, 0, 0.1f);
		}
		if(!(up || down)){
			vel.y = lerp(vel.y, 0, 0.1f);
		}
		
		pos.y = constrain(pos.y, 0, g.height-img.height);
		vel.x = constrain(vel.x, -currentSpeed, currentSpeed);
		vel.y = constrain(vel.y, -currentSpeed, currentSpeed);
	}
	
	@Override
	public void draw(){
		super.draw();
		
		if(g.millis() > timer+100){
			timer = g.millis();
			count = (count+1)%swimImages.length;
			img = swimImages[count];
		}
	}
}
