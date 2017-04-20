package com.the_dungeoneers.game.entities;

import Collision.SAT_Collision;
import Collision.Square;
import com.the_dungeoneers.game.Game;
import processing.core.PConstants;
import processing.core.PVector;

import java.util.List;

import static processing.core.PApplet.constrain;

/**
 * Created by Chris on 20/04/2017.
 */
public class Player extends Entity {

    public Square bb;
    private float wd, ht;


    // States for the player
    private boolean onBlock = true;

    public Player(Game g, PVector pos, PVector vel, PVector accel) {
        super(g, pos, vel, accel);
        this.wd = g.blockSize;
        this.ht = g.blockSize*2;
        this.bb = new Square(g, pos, wd, ht);
    }


    public void moveLeft(){
		accel.set(-1, GRAVITY);
    }

    public void moveRight(){
		accel.set(1, GRAVITY);
    }
    
    public void jump(){
		vel.y = -10;
	}

    @Override
    public void update(){

		if (accel.x == 0) {
			vel.lerp(new PVector(), 0.1f);
		}

		vel.add(accel);
		vel.x = constrain(vel.x, -5, 5);
		
		pos.add(vel);
		accel.set(0, GRAVITY);
		
		bb.x = pos.x;
		bb.y = pos.y;
    }

    public void collisionDetection(List<Tile> boardTiles) {
        for (Tile tile : boardTiles) {
            if (tile instanceof Floor) {
                if (tile.collides(this)) {
                    this.vel.y = 0;
                    onBlock = true;
                    this.pos.y = tile.pos.y - this.ht;
                }
            }
        }
    }

    @Override
    public void draw() {
        g.rectMode(PConstants.CORNER);
        g.fill(230, 221, 214);
        g.noStroke();
        g.rect(pos.x, pos.y, wd, ht);
    }
}