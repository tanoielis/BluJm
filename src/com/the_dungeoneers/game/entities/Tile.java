package com.the_dungeoneers.game.entities;

import Collision.SAT_Collision;
import Collision.Square;
import com.the_dungeoneers.game.Game;
import processing.core.PConstants;
import processing.core.PVector;

/**
 * Created by Chris on 20/04/2017.
 */
public class Tile {

    PVector pos = new PVector();
    float wd, ht;
    Square bb; // Bounding box
    Game g;
    int col;

    public Tile(Game g, PVector pos, float wd, float ht, int col) {
        this.g = g;
        this.pos = pos;
        this.wd = wd;
        this.ht = ht;
        this.col = col;
        bb = new Square(this.g, this.pos, this.wd, this.ht);
    }

    public void draw() {
        g.rectMode(PConstants.CORNER);
        g.fill(this.col);
        g.noStroke();
        g.rect(pos.x, pos.y, wd, ht);
    }

    public boolean collides(Entity obj){
        if(obj instanceof Player){
            Player p = (Player) obj;
            if(SAT_Collision.intersects(p.bb, this.bb)){
                return true;
            }
        }
        return false;
    }
}
