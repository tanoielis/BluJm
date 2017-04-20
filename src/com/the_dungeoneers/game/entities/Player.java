package com.the_dungeoneers.game.entities;

import Collision.Square;
import com.the_dungeoneers.game.Game;
import processing.core.PConstants;
import processing.core.PVector;

/**
 * Created by Chris on 20/04/2017.
 */
public class Player extends Entity {

    Square bb;
    private float wd, ht;

    public Player(Game g, PVector pos, PVector vel, PVector accel) {
        super(g, pos, vel, accel);
        this.wd = g.blockSize;
        this.ht = g.blockSize*2;
        this.bb = new Square(g, pos, wd, ht);
    }


    public void moveLeft(){
        pos.add(-vel.x, 0);
    }

    public void moveRight(){
        pos.add(vel.x, 0);
    }

    @Override
    public void update(){
        bb.x = pos.x;
        bb.y = pos.y;
    }

    @Override
    public void draw() {
        g.rectMode(PConstants.CORNER);
        g.fill(230, 221, 214);
        g.noStroke();
        g.rect(pos.x, pos.y, wd, ht);
    }
}