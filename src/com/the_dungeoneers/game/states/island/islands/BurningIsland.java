package com.the_dungeoneers.game.states.island.islands;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.island.IslandManager;
import com.the_dungeoneers.game.states.levels.Level4;
import com.the_dungeoneers.game.states.levels.Level5;
import com.the_dungeoneers.game.states.levels.Level9;

/**
 * Created by Chris on 22/04/2017.
 */
public class BurningIsland extends Island {
    
    public BurningIsland(Game g, Player player, Camera camera){
        super(g, "Burning Island", player, camera);

        levels.put(IslandManager.islands.get(6), new Level9(g, player, camera, this));
        levels.put(IslandManager.islands.get(1), new Level5(g, player, camera, this));
    }
}
