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
import processing.core.PConstants;
import processing.core.PVector;

/**
 * Created by Chris on 22/04/2017.
 */
public class Level1 extends Level {

	private Bomb[] bombs;
	
    public Level1(Game g, Player player, Camera camera, Island from) {
        super(g, player, camera, from);
		
		bombs = new Bomb[]{	//todo set bomb positions
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
		
    }

    @Override
    public void update() {
        super.update();
        
		for(Bomb b : bombs){
			if(b != null){
				b.update();
				if(SAT_Collision.intersects(player.bb, b.bb)){
					
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
            for(Bomb b : bombs){
				if(b != null){
					b.draw();
				}
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
