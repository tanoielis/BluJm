package com.the_dungeoneers.game.states.levels;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.entities.enemies.Jellyfish;
import com.the_dungeoneers.game.entities.obstacles.Bomb;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.island.IslandManager;
import processing.core.PVector;

/**
 * Created by Chris on 22/04/2017.
 */
public class Level4 extends Level {

    private Bomb[] bombs = new Bomb[12];

    public Level4(Game g, Player player, Camera camera, Island from, IslandManager im) {
        super(g, player, camera, from, im);
        this.bg = g.loadImage("images/Backgrounds/Levels/greeny/part2.png");
        init();
    }

    private void init() {

    }

    @Override
    public void update() {
        super.update();
    }
}
