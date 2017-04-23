package com.the_dungeoneers.game.states;

import com.the_dungeoneers.game.Game;
import processing.core.PConstants;
import processing.core.PImage;

/**
 * Created by Chris on 22/04/2017.
 */
public class Instructions implements State {

    private PImage bg;
    private Game g;

    public Instructions(Game g) {
        this.g = g;
        bg = g.loadImage("images/Backgrounds/instructions.png");
    }

    @Override
    public void update() {

    }

    @Override
    public void drawUI() {
        g.imageMode(PConstants.CORNER);
        g.image(bg, 0, 0, g.width, g.height);
    }

    @Override
    public void drawEntities() {

    }

    @Override
    public void keyPressed() {

    }

    @Override
    public void keyReleased() {

    }

    @Override
    public void mousePressed() {

    }
}
