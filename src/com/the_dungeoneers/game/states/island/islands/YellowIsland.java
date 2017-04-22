package com.the_dungeoneers.game.states.island.islands;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.island.IslandManager;
import com.the_dungeoneers.game.states.levels.Level3;
import com.the_dungeoneers.game.states.levels.Level4;
import com.the_dungeoneers.game.states.levels.Level5;
import com.the_dungeoneers.game.states.levels.Level6;

/**
 * Created by Chris on 22/04/2017.
 */
public class YellowIsland extends Island {


    public YellowIsland(Game g, Player player, Camera camera) {
        super(g, "Yellow Island", player, camera);
        
        levels.put(IslandManager.islands.get(4), new Level3(g, player, camera, this));
        levels.put(IslandManager.islands.get(2), new Level4(g, player, camera, this));
        levels.put(IslandManager.islands.get(5), new Level6(g, player, camera, this));
        levels.put(IslandManager.islands.get(3), new Level5(g, player, camera, this));
    }
}