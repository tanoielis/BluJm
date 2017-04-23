package com.the_dungeoneers.game.states.island.islands;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.island.IslandManager;
import com.the_dungeoneers.game.states.levels.*;

/**
 * Created by Chris on 22/04/2017.
 */
public class BurningIsland extends Island {
    
    public BurningIsland(Game g, Player player, Camera camera){
        super(g, "Burning Island", player, camera);
    }

    @Override
    public void setNeighbours(IslandManager im) {
        levels.put(IslandManager.islands.get("TreasureIsland"), new Level8(g, player, camera, IslandManager.islands.get("TreasureIsland"), im));
        levels.put(IslandManager.islands.get("YellowIsland"), new Level4(g, player, camera, IslandManager.islands.get("YellowIsland"), im));
        levels.put(IslandManager.islands.get("VolcanoIsland"), new Level2(g, player, camera, IslandManager.islands.get("VolcanoIsland"), im));
    }
}
