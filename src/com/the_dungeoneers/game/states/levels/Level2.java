package com.the_dungeoneers.game.states.levels;

import Collision.Square;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.entities.enemies.Jellyfish;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.island.IslandManager;
import processing.core.PVector;

/**
 * Created by Chris on 22/04/2017.
 */
public class Level2 extends Level {

    private Jellyfish[] jellyFish =    {
                                    new Jellyfish(g, new PVector(496, 120), new PVector(0, 6), new PVector()),
                                    new Jellyfish(g, new PVector(1085, 407), new PVector(0, 6), new PVector()),
                                    new Jellyfish(g, new PVector(1600, 308), new PVector(0, 6), new PVector()),
                                    new Jellyfish(g, new PVector(2062, 527), new PVector(0, 6), new PVector()),
                                    new Jellyfish(g, new PVector(2194, 67), new PVector(0, 6), new PVector())
                                    };

    public Level2(Game g, Player player, Camera camera, Island from, IslandManager im) {
        super(g, player, camera, from, im);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void drawUI() {
        super.drawUI();
    }

    @Override
    public void drawEntities() {
        super.drawEntities();
    }

    @Override
    public void keyPressed() {
        super.keyPressed();
    }

    @Override
    public void keyReleased() {
        super.keyReleased();
    }

    @Override
    public void mousePressed() {
        super.mousePressed();
    }
}
