package com.the_dungeoneers.game.states.levels;

import Collision.SAT_Collision;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Entity;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.entities.enemies.Jellyfish;
import com.the_dungeoneers.game.entities.enemies.Shark;
import com.the_dungeoneers.game.entities.obstacles.Pyramid;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.island.IslandManager;
import processing.core.PConstants;
import processing.core.PVector;

import java.util.ArrayList;

import static processing.core.PApplet.max;

/**
 * Created by Chris on 22/04/2017.
 */
public class Level5 extends Level {

    private int sharkTimer;
    private ArrayList<Shark> sharks;
    private ArrayList<Entity> removearr = new ArrayList<>();
    
    private Pyramid pyramid;

    public Level5(Game g, Player player, Camera camera, Island from, IslandManager im) {
        super(g, player, camera, from, im);
        
        bg = g.loadImage("images/Backgrounds/Levels/level5.png");
        this.pyramid = new Pyramid(g, new PVector(805, 720), new PVector(1382, 117), new PVector(2096, 720));

        sharks = new ArrayList<>();
        sharkTimer = 3000;
    }
    
    @Override
    public void update(){
        super.update();
        collision();

        if (g.millis() > sharkTimer + 3000) {
            sharks.add(new Shark(g, new PVector(player.getPos().x + 1500 < 3000 ? player.getPos().x + 1500 : 3000, 55), new PVector(), new PVector()));
            sharkTimer = g.millis();
        }
    }
    
    private void collision(){
        for (int i = 0; i < sharks.size(); i++) {
            if (i < sharks.size()) {
                if (sharks.get(i) != null) {
                    sharks.get(i).update();
                    if (SAT_Collision.intersects(player.bb, sharks.get(i).bb)) {
                        sharks.clear();
                        successful = false;
                        running = false;
                    } else if (sharks.get(i).despawn) {
                        removearr.add(sharks.get(i));
                    }
                }
                removearr.clear();
            }
        }

        float playerX = player.getPos().x;
    
        if(playerX + player.bb.wd >= pyramid.p1.x && playerX <= pyramid.p3.x && SAT_Collision.intersects(pyramid.bb, player.bb)){
            // TODO: Make look nice / understand / fix jittery slipping up rock
            if(playerX < pyramid.p2.x){
                //Deal with p1 to p2
                //P = d(p2 - p1) + p1
                PVector line = PVector.sub(pyramid.p2, pyramid.p1).normalize();
                float dist = PVector.dist(pyramid.p1, PVector.add(player.getPos(), new PVector(player.bb.wd, player.bb.ht)));
                PVector inter = (line.mult(dist)).add(pyramid.p1);
                System.out.println(inter.x +" " + inter.y);
                
                player.setPos(inter.sub(player.bb.wd, player.bb.ht));
            }else{
                //Deal with p2 to p3
                //P = d(d3 - d2) + d2
                PVector line = PVector.sub(pyramid.p3, pyramid.p2).normalize();
                float dist = PVector.dist(pyramid.p3, PVector.add(player.getPos(), new PVector(0, player.bb.ht)));
                PVector inter = (line.mult(dist)).add(pyramid.p2);
                
                player.setPos(inter.sub(0, player.bb.ht));
            }
        }
    }

    private void drawEnemies(){
        for (int i = 0; i < sharks.size(); i++) {
            if (sharks.get(i) != null) {
                Shark s = sharks.get(i);
                s.draw();
            }
        }
    }
    
    @Override
    public void drawUI(){
        super.drawUI();
    }
    
    @Override
    public void drawEntities(){
        
        g.pushMatrix();
            g.translate(camera.getPos().x, 0);
            g.imageMode(PConstants.CORNER);
            g.image(bg, 0, 0);
            drawEnemies();
            player.draw();
        g.popMatrix();
	
	}
}
