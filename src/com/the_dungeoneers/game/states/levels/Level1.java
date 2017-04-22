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

    private Whale w;
    private int timer;
	
    public Level1(Game g, Player player, Camera camera, Island from) {
        super(g, player, camera, from);
		timer = -1;
		w = new Whale(g, new PVector(2500,50), new PVector(), new PVector());
    }

    @Override
    public void update() {
        super.update();
        
		if(timer == -1){
			timer = g.millis();
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
