package com.the_dungeoneers.game.states.levels;

import Collision.SAT_Collision;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.entities.enemies.Jellyfish;
import com.the_dungeoneers.game.entities.obstacles.Bomb;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.island.IslandManager;
import processing.core.PConstants;
import processing.core.PVector;

/**
 * Created by Chris on 22/04/2017.
 */
public class Level4 extends Level {

    private Bomb[] bombs;
    private Jellyfish[] jellyfish;

    public Level4(Game g, Player player, Camera camera, Island from, IslandManager im) {
        super(g, player, camera, from, im);
        bg = g.loadImage("images/Backgrounds/Levels/greeny/part2.png");

        bombs = new Bomb[12];
        jellyfish = new Jellyfish[4];

        init();
    }

    private void init() {

        // Circle 1
        bombs[0] = new Bomb(g,new PVector(455, 305));
        bombs[1] = new Bomb(g,new PVector(600, 105));
        bombs[2] = new Bomb(g,new PVector(600, 520));
        bombs[3] = new Bomb(g,new PVector(835, 105));
        bombs[4] = new Bomb(g,new PVector(835, 520));
        bombs[5] = new Bomb(g,new PVector(970, 305));

        // Jellyfish
        jellyfish[0] = new Jellyfish(g, new PVector(1130, 145), new PVector(0, 3), new PVector());
        jellyfish[1] = new Jellyfish(g, new PVector(1130, 430), new PVector(0, 3), new PVector());
        jellyfish[2] = new Jellyfish(g, new PVector(1610, 145), new PVector(0, 3), new PVector());
        jellyfish[3] = new Jellyfish(g, new PVector(1610, 430), new PVector(0, 3), new PVector());


        // Circle 2
        bombs[6] = new Bomb(g,new PVector(1785, 305));
        bombs[7] = new Bomb(g,new PVector(1930, 105));
        bombs[8] = new Bomb(g,new PVector(1930, 520));
        bombs[9] = new Bomb(g,new PVector(2170, 105));
        bombs[10] = new Bomb(g,new PVector(2170, 520));
        bombs[11] = new Bomb(g,new PVector(2302, 305));
    }

    @Override
    public void update() {
        super.update();
        collisionDetection();
    }

    private void collisionDetection() {
        for (int i = 0; i < g.max(jellyfish.length, bombs.length); i++) {
            if (i < jellyfish.length) {
                if (jellyfish[i] != null) {
                    jellyfish[i].update();
                    if (SAT_Collision.intersects(player.bb, jellyfish[i].bb)) {
                        successful = false;
                        running = false;
                    }
                }
            }
            if (i < bombs.length) {
                if (bombs[i] != null) {
                    bombs[i].update();
                    if (SAT_Collision.intersects(player.bb, bombs[i].bb)) {
                        successful = false;
                        running = false;
                    }
                }
            }
        }
    }

    @Override
    public void drawUI() {
        super.drawUI();
    }

    @Override
    public void drawEntities() {
        g.pushMatrix();
        g.translate(camera.getPos().x, 0);
        g.imageMode(PConstants.CORNER);
        g.image(bg, 0,0);
        player.draw();
        drawBombs();
        drawJellyFish();
        g.popMatrix();
    }

    private void drawJellyFish() {
        for(Jellyfish jf : jellyfish){
            if(jf != null){
                jf.draw();
            }
        }
    }

    private void drawBombs() {
        for(Bomb b : bombs){
            if(b != null){
                b.draw();
            }
        }
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
