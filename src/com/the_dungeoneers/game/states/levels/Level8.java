package com.the_dungeoneers.game.states.levels;

import Collision.SAT_Collision;
import Collision.Square;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Entity;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.entities.enemies.Shark;
import com.the_dungeoneers.game.entities.enemies.Spear;
import com.the_dungeoneers.game.entities.enemies.Whale;
import com.the_dungeoneers.game.entities.obstacles.Rock;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.island.IslandManager;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;

/**
 * Created by Chris on 22/04/2017.
 */
public class Level8 extends Level  {

    private Rock[] rocks;
    private PImage bg;
    private ArrayList<Shark> whales;
    private int whaleTimer;
    private ArrayList<Entity> removearr = new ArrayList<>();

    public Level8(Game g, Player player, Camera camera, Island from, IslandManager im) {
        super(g, player, camera, from, im);

        bg = g.loadImage("images/Backgrounds/levels/level3.png");

        rocks = new Rock[]{
                new Rock(g, new PVector(612, 289), "images/Rocks/rock5.png", new Square(g, new PVector(612, 289), 91, 431)),
                new Rock(g, new PVector(936, 0), "images/Rocks/rock7.png", new Square(g, new PVector(936, 0), 91, 431)),
                new Rock(g, new PVector(1236, 289), "images/Rocks/rock5.png", new Square(g, new PVector(1236, 289), 91, 431)),
                new Rock(g, new PVector(1541, 0), "images/Rocks/rock7.png", new Square(g, new PVector(1541, 0), 91, 431)),
                new Rock(g, new PVector(1901, 289), "images/Rocks/rock5.png", new Square(g, new PVector(1901, 289), 91, 431)),
                new Rock(g, new PVector(2252, 0), "images/Rocks/rock7.png", new Square(g, new PVector(2252, 0), 91, 431)),
        };

        whaleTimer = 4000;
    }

    @Override
    public void update(){
        super.update();

        collisionDetection();

        if (g.millis() > whaleTimer + 3000) {
            whaleTimer = g.millis();
        }
    }

    private void collisionDetection() {
        for(int i = 0; i < rocks.length; i++) {
            if(SAT_Collision.intersects(rocks[i].bb, player.bb)){
                PVector playerPos = player.getPos();
                float playerX = playerPos.x;
                float playerY = playerPos.y;
                float playerWd = player.bb.wd;
                float playerHt = player.bb.ht;
                float rockX = rocks[i].bb.x;
                float rockY = rocks[i].bb.y;
                float rockWd = rocks[i].bb.wd;
                float rockHt = rocks[i].bb.ht;

                if (playerX + playerWd >= rockX && playerX <= rockX + 30 && (playerY > rockY + 30 && playerY < rockY + rockHt - 30)) {
                    player.setPos(new PVector(rockX - playerWd, playerY));
                }
                else if (playerX + player.vel.x <= rockX + rockWd && (playerY > rockY + 30 && playerY < rockY + rockHt - 30)){
                    player.setPos(new PVector(rockX + rockWd, playerY));
                }
                if (playerY + playerHt >= rockY && playerY + playerHt <= rockY + 30) {
                    player.setPos(new PVector(playerX, rockY - playerHt));
                }
                else if (playerY <= rockY + rockHt && playerY >= rockY + rockHt - 30) {
                    player.setPos(new PVector(playerX, rockY + rockHt));
                }
            }
        }
    }


    @Override
    public void drawEntities(){
        g.pushMatrix();
        g.translate(camera.getPos().x, 0);
        g.imageMode(PConstants.CORNER);
        g.image(bg, 0, 0);

        player.draw();

        
        g.popMatrix();
    }


}
