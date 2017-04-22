package com.the_dungeoneers.game.states.levels;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.island.IslandManager;

/**
 * Created by Chris on 22/04/2017.
 */
public class Level3 extends Level  {

    public Level3(Game g, Player player, Camera camera, Island from, IslandManager im) {
        super(g, player, camera, from, im);
    }
    
    @Override
    public void update(){
        super.update();
		
    }
    
    @Override
    public void drawEntities(){
        super.drawEntities();
    }
    
    
}
