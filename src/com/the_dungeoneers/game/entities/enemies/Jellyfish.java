package com.the_dungeoneers.game.entities.enemies;

import Collision.Square;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.entities.MoveableEntity;
import processing.core.PImage;
import processing.core.PVector;

/**
 * Created by Chris on 23/04/2017.
 */
public class Jellyfish extends MoveableEntity {

    PImage img;
    PVector origPos;
    boolean movingUp = up;

    public Jellyfish(Game g, PVector pos, PVector vel, PVector accel) {
        super(g, pos, vel, accel);
        this.origPos = pos.copy();
        this.img = g.loadImage("images/Enemies/jellyfish.png");

        this.bb = new Square(g, pos.x, pos.y, img.width, img.height);

    }

    @Override
    protected void moveLeft() {

    }

    @Override
    protected void moveRight() {

    }

    @Override
    protected void moveUp() {
        if (pos.y <= origPos.y - 10 || pos.y >= origPos.y + 10) {
            movingUp = !movingUp;
            vel.y *= -1;
        }
        if (movingUp) {
            g.constrain(pos.y += vel.y, origPos.y, origPos.y - 10);
        }
        else {
            g.constrain(pos.y += vel.y, origPos.y, origPos.y + 10);
        }
    }

    @Override
    protected void moveDown() {

    }

    @Override
    protected void moveUpLeft() {

    }

    @Override
    protected void moveUpRight() {

    }

    @Override
    protected void moveDownLeft() {

    }

    @Override
    protected void moveDownRight() {

    }
}
