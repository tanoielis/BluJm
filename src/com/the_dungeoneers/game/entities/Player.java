package com.the_dungeoneers.game.entities;

import Collision.Square;
import com.the_dungeoneers.game.Game;
import processing.core.PImage;
import processing.core.PVector;

import static processing.core.PApplet.constrain;
import static processing.core.PApplet.lerp;
import static processing.core.PApplet.max;
import static processing.core.PConstants.CENTER;
import static processing.core.PConstants.CORNER;

/**
 * Main player
 */
public class Player extends MoveableEntity {
	
	public float speed = 1;
	public float agility = 1;
	public float lungs = 1;
	
	public static float baseLung = 30; //seconds
	public static float baseSpeed = 7;//move left right
	public static float baseAgility = 0.35f; //move up down
	
	public static float currentSpeed;
	public static float currentLung;
	public static float currentAgility;
	
	private boolean facingRight;
	
	public int upgradePoints;
	
	private PImage[] swimImages = new PImage[8];
	private PImage[] stopImages = new PImage[10];
	private int timer;
	private int swimCount = 0;
	private int stopCount = 0;
	
	public Player(Game g, PVector pos, PVector vel, PVector accel){
		super(g, pos, vel, accel);
		loadImages();
		timer = g.millis();
		upgradePoints = 0;
		facingRight = true;
	}
	
	private void loadImages(){
		for(int i=0; i<max(swimImages.length, stopImages.length); i++){
			if(i < swimImages.length) swimImages[i] = g.loadImage("images/Player/Swimming/swim/"+i+".png");
			if(i < stopImages.length) stopImages[i] = g.loadImage("images/Player/Swimming/stop/"+i+".png");
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
		movement();
		
		bb.x = pos.x;
		bb.y = pos.y;
		
		vel.add(accel);
		pos.add(vel);
		accel.mult(0);
		
		currentAgility = baseAgility * agility;
		currentSpeed = baseSpeed * speed;
		
		if(!(left || right)){
			vel.x = lerp(vel.x, 0, 0.1f);
		}
		if(!(up || down)){
			vel.y = lerp(vel.y, 0, 0.1f);
		}
		if(!(up || down || left || right)){
			accel.add(0, 0.2f);
		}
		
		pos.x = constrain(pos.x, 0, 3000-img.width);
		pos.y = constrain(pos.y, 0, g.height-img.height);
		vel.setMag(constrain(vel.mag(), -currentSpeed, currentSpeed));
		
		facingRight = (vel.x >= 0);
	}
	
	@Override
	public void draw(){
		
		if(left || right || up || down){
			swim();
		} else {
			stop();
		}
		
		
		g.pushMatrix();
			g.translate(pos.x+bb.wd/2, pos.y+bb.ht/2);
			if(!facingRight){
				g.scale(-1, 1);
			}
			g.imageMode(CENTER);
			g.image(img, 0, 0);
		g.popMatrix();
	}
	
	private void swim(){
		if(stopCount > 0){
			if(g.millis() > timer + 50){
				timer = g.millis();
				img = stopImages[--stopCount];
			}
		} else {
			if(g.millis() > timer + 100){
				timer = g.millis();
				swimCount = ++swimCount % swimImages.length;
				img = swimImages[swimCount];
				this.bb = new Square(g, pos, img.width, img.height);
			}
		}
		
	}
	
	private void stop(){
		if(g.millis() > timer + 50 && stopCount < stopImages.length){
			timer = g.millis();
			img = stopImages[stopCount++];
			this.bb = new Square(g, pos, img.width, img.height);
		}
	}
	
	public void setPos(PVector pos){
		this.pos = pos;
	}
}
