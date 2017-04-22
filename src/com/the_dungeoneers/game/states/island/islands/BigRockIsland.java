package com.the_dungeoneers.game.states.island.islands;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.island.IslandManager;
import com.the_dungeoneers.game.states.levels.Level2;
import com.the_dungeoneers.game.states.levels.Level4;
import com.the_dungeoneers.game.states.levels.Level7;

/**
 * Created by Chris on 22/04/2017.
 */
public class BigRockIsland extends Island {
    
    public BigRockIsland(Game g, Player player, Camera camera){
        super(g, "Big Rock Island", player, camera);
    }

    @Override
    public void setLevels() {
        levels.put(IslandManager.islands.get(5), new Level7(g, player, camera, this));
        levels.put(IslandManager.islands.get(1), new Level4(g, player, camera, this));
        levels.put(IslandManager.islands.get(0), new Level2(g, player, camera, this));
    }
}
