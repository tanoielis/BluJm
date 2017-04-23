package com.the_dungeoneers.game.states.levels;

import Collision.SAT_Collision;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Entity;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.entities.enemies.Jellyfish;
import com.the_dungeoneers.game.entities.enemies.Shark;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.island.IslandManager;
import processing.core.PConstants;
import processing.core.PVector;

import static processing.core.PApplet.max;

import java.util.ArrayList;

/**
 * Created by Chris on 22/04/2017.
 */
public class Level2 extends Level {

    int sharkTimer;

    private Jellyfish[] jellyFish = new Jellyfish[5];
    private ArrayList<Shark> sharks;
    private ArrayList<Entity> removearr = new ArrayList<>();


    public Level2(Game g, Player player, Camera camera, Island from, IslandManager im) {
        super(g, player, camera, from, im);
        bg = g.loadImage("images/Backgrounds/Levels/bluey/part2.png");

        init();

        sharks = new ArrayList<>();
        sharkTimer = 3000;
    }

    private void init() {
        jellyFish[0] = new Jellyfish(g, new PVector(496, 120), new PVector(0, 3), new PVector());
        jellyFish[1] = new Jellyfish(g, new PVector(1085, 407), new PVector(0, 3), new PVector());
        jellyFish[2] = new Jellyfish(g, new PVector(1600, 308), new PVector(0, 3), new PVector());
        jellyFish[3] = new Jellyfish(g, new PVector(2062, 527), new PVector(0, 3), new PVector());
        jellyFish[4] = new Jellyfish(g, new PVector(2194, 67), new PVector(0, 3), new PVector());
    }

    @Override
    public void update() {
        super.update();
        collisionDetection();

        if (g.millis() > sharkTimer + 4000) {
            sharks.add(new Shark(g, new PVector(player.getPos().x + 1500 < 3000 ? player.getPos().x + 1500 : 3000, player.getPos().y), new PVector(), new PVector()));
            sharkTimer = g.millis();
        }
    }

    private void collisionDetection() {
        for (int i = 0; i < g.max(jellyFish.length, sharks.size()); i++) {
            if (i < jellyFish.length) {
                if (jellyFish[i] != null) {
                    jellyFish[i].update();
                    if (SAT_Collision.intersects(player.bb, jellyFish[i].bb)) {
                        successful = false;
                        running = false;
                    }
                }
            }
            if (i < sharks.size()) {
                if (sharks.get(i) != null) {
                    sharks.get(i).update();
                    if (SAT_Collision.intersects(player.bb, sharks.get(i).bb)) {
                        sharks.clear();
                        successful = false;
                        running = false;
                    }
                    else if (sharks.get(i).despawn) {
                        removearr.add(sharks.get(i));
                    }
                }
                sharks.removeAll(removearr);
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
            drawEnemies();
        g.popMatrix();
    }

    private void drawEnemies(){
        for(int i=0; i<max(sharks.size(), jellyFish.length); i++){
			if(i<sharks.size()){
				Shark s = sharks.get(i);
				if(s != null){
					s.draw();
				}
			}
			if(i<jellyFish.length){
				Jellyfish j = jellyFish[i];
				if(j != null){
					j.draw();
				}
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
