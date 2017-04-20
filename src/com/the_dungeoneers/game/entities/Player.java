package com.the_dungeoneers.game.entities;

import Collision.Square;
import com.the_dungeoneers.game.Game;
import processing.core.PVector;

/**
 * Created by Chris on 20/04/2017.
 */
public class Player extends Entity {

    Square playerBB;
    private float wd, ht;
    private PVector vel;
    private PVector accel;

    public Player(Game g, PVector pos, PVector speed, PVector accel) {
        super(g, pos, speed, accel);
    }


    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {

    }
}
