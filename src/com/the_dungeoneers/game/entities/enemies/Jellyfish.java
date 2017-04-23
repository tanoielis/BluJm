package com.the_dungeoneers.game.entities.enemies;

import Collision.Square;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.entities.MoveableEntity;
import processing.core.PImage;
import processing.core.PVector;

import static processing.core.PApplet.degrees;

/**
 * Created by Chris on 23/04/2017.
 */
public class Jellyfish extends MoveableEntity {

    PVector origPos;
    boolean movingUp = up;

    public Jellyfish(Game g, PVector pos, PVector vel, PVector accel) {
        super(g, pos, vel, accel);
        this.origPos = pos.copy();
        this.img = g.loadImage("images/Enemies/jellyfish.png");

        this.bb = new Square(g, pos.x, pos.y + 55, img.width, img.height - 55, degrees(vel.heading()) - 90);
    }

    public Jellyfish(Game g, PVector pos, PVector vel, PVector accel, boolean movingUp) {
        this(g, pos, vel, accel);
        this.movingUp = movingUp;
    }

    @Override
    protected void moveLeft() {

    }

    @Override
    protected void moveRight() {

    }

    @Override
    protected void moveUp() {
        if (pos.y == origPos.y - g.height/6 || pos.y == origPos.y + g.height/6) {
            movingUp = !movingUp;
            vel.y *= -1;
        }
        if (movingUp) {
            g.constrain(pos.y += vel.y, origPos.y, origPos.y - g.height/6);
        }
        else {
            g.constrain(pos.y += vel.y, origPos.y, origPos.y + g.height/6);
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

    @Override
    public void update() {

        this.bb = new Square(g, pos.x, pos.y + 55, img.width, img.height - 55, degrees(vel.heading()) - 90);
        moveUp();
    }

    @Override
    public void draw() {
        super.draw();
    }
}
