package com.the_dungeoneers.game.entities;

import com.the_dungeoneers.game.Game;
import processing.core.PVector;

/**
 * Created by Chris on 20/04/2017.
 */
public class Floor extends Tile {

    public Floor(Game g, PVector pos, float wd, float ht, int col) {
        super(g, pos, wd, ht, col);
    }
}
