package com.the_dungeoneers.game.states.levels;

import Collision.SAT_Collision;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.entities.enemies.Shark;
import com.the_dungeoneers.game.entities.enemies.Spear;
import com.the_dungeoneers.game.entities.enemies.Whale;
import com.the_dungeoneers.game.entities.obstacles.Bomb;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.island.IslandManager;
import processing.core.PConstants;
import processing.core.PVector;

/**
 * Created by Chris on 22/04/2017.
 */
public class Level1 extends Level {

	private Bomb[] bombs;
	private Shark shark;
	private int timer;
	
    public Level1(Game g, Player player, Camera camera, Island to, IslandManager im) {
        super(g, player, camera, to, im);
		
		bombs = new Bomb[]{
				new Bomb(g, new PVector(643, 536)),
				new Bomb(g, new PVector(513, 202)),
				new Bomb(g, new PVector(951, 302)),
				new Bomb(g, new PVector(1171, 120)),
				new Bomb(g, new PVector(1175, 564)),
				new Bomb(g, new PVector(1196, 407)),
				new Bomb(g, new PVector(1525, 8)),
				new Bomb(g, new PVector(1508, 284)),
				new Bomb(g, new PVector(1662, 522)),
				new Bomb(g, new PVector(1761, 382)),
				new Bomb(g, new PVector(1964, 249)),
				new Bomb(g, new PVector(1765, 105)),
				new Bomb(g, new PVector(2238, 151)),
				new Bomb(g, new PVector(2356, 396)),
				new Bomb(g, new PVector(2129, 500))
		};
		
		timer = 4000;
		bg = g.loadImage("images/Backgrounds/Levels/bluey/part1.png");
    }

    @Override
    public void update() {
		super.update();

		if(timer == 4000){
			timer = g.millis();
		}

        collisionDetection();
		
		if(g.millis() > timer + 4000 && shark == null){
			shark = new Shark(g, new PVector(3000, player.getPos().y), new PVector(), new PVector());
		}
                
    }

    private void collisionDetection() {
        for(int i=0; i<bombs.length; i++){
            if(bombs[i] != null){
                bombs[i].update();
                if(SAT_Collision.intersects(player.bb, bombs[i].bb)){
                    successful = false;
                    running = false;
                }
            }
        }

        if(shark != null){
            shark.update();
            if(SAT_Collision.intersects(player.bb, shark.bb)){
                shark = null;
                successful = false;
                running = false;
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
            drawBombs();
            drawSharks();
            player.draw();
        g.popMatrix();
    
    }

    private void drawSharks() {
        if(shark != null){
            shark.draw();
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
