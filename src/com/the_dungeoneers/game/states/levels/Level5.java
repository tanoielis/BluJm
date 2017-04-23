package com.the_dungeoneers.game.states.levels;

import Collision.SAT_Collision;
import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.entities.obstacles.Pyramid;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.island.IslandManager;
import processing.core.PConstants;
import processing.core.PVector;

/**
 * Created by Chris on 22/04/2017.
 */
public class Level5 extends Level {
    
    private Pyramid pyramid;

    public Level5(Game g, Player player, Camera camera, Island from, IslandManager im) {
        super(g, player, camera, from, im);
        
        bg = g.loadImage("images/Backgrounds/Levels/level5.png");
        this.pyramid = new Pyramid(g, new PVector(805, 720), new PVector(1382, 117), new PVector(2096, 720));
    }
    
    @Override
    public void update(){
        super.update();
     
        collision();
		
		
    }
    
    private void collision(){
    
        float playerX = player.getPos().x;
    
        if(playerX + player.bb.wd >= pyramid.p1.x && playerX <= pyramid.p3.x && SAT_Collision.intersects(pyramid.bb, player.bb)){
            if(playerX < pyramid.p2.x){
                //Deal with p1 to p2
                //P = d(p2 - p1) + p1
                PVector line = PVector.sub(pyramid.p2, pyramid.p1);
                float dist = PVector.dist(pyramid.p1, PVector.add(player.getPos(), new PVector(player.bb.wd, player.bb.ht)));
                PVector inter = (line.mult(dist)).add(pyramid.p1);
                
                player.setPos(inter.sub(player.bb.wd, player.bb.ht));
            }else{
                //Deal with p2 to p3
                //P = d(d3 - d2) + d2
                PVector line = PVector.sub(pyramid.p3, pyramid.p2);
                float dist = PVector.dist(pyramid.p3, PVector.add(player.getPos(), new PVector(0, player.bb.ht)));
                PVector inter = (line.mult(dist)).add(pyramid.p2);
                
                player.setPos(inter.sub(0, player.bb.ht));
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
            player.draw();
        g.popMatrix();
	
	}
}
