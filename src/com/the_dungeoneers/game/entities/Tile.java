package com.the_dungeoneers.game.entities;

import processing.core.PVector;

/**
 * Created by Chris on 20/04/2017.
 */
public class Tile {

    PVector pos = new PVector();
    PVector size = new PVector();

    public Tile(PVector pos, PVector size) {
        this.pos = pos;
        this.size = size;
    }

}
