package com.the_dungeoneers.game.states.levels;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.entities.obstacles.Bomb;
import com.the_dungeoneers.game.states.island.Island;
import processing.core.PVector;

/**
 * Created by Chris on 22/04/2017.
 */
public class Level1 extends Level {

    Bomb b;

    public Level1(Game g, Player player, Camera camera, Island from) {
        super(g, player, camera, from);
        b = new Bomb(g, new PVector(50, 100));
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
