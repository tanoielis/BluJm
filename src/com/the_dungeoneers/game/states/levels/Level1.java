package com.the_dungeoneers.game.states.levels;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.entities.enemies.Shark;
import com.the_dungeoneers.game.entities.enemies.Spear;
import com.the_dungeoneers.game.entities.enemies.Whale;
import com.the_dungeoneers.game.entities.obstacles.Bomb;
import com.the_dungeoneers.game.states.island.Island;
import processing.core.PConstants;
import processing.core.PVector;

/**
 * Created by Chris on 22/04/2017.
 */
public class Level1 extends Level {

    private Shark s;
    private Whale w;
    
    public Level1(Game g, Player player, Camera camera, Island from) {
        super(g, player, camera, from);
        s = new Shark(g, new PVector(7000, player.getPos().y), new PVector(), new PVector());
        w = new Whale(g, new PVector(7000, 300), new PVector(), new PVector());
    }

    @Override
    public void update() {
        super.update();
        
        
        if(s.getPos().x + s.bb.wd > 0){
            s.update();
        }
        
        if(w.getPos().x + w.bb.wd > 0 || w.spearsActive){
            w.update();
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
            if(s.getPos().x + s.bb.wd > 0){
                s.draw();
            }
            if(w.getPos().x + w.bb.wd > 0 || w.spearsActive){
                w.draw();
			}
        g.popMatrix();
    
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
