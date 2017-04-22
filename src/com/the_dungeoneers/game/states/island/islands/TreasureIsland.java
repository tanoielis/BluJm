package com.the_dungeoneers.game.states.island.islands;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.island.IslandManager;
import com.the_dungeoneers.game.states.levels.Level1;
import com.the_dungeoneers.game.states.levels.Level6;
import com.the_dungeoneers.game.states.levels.Level7;
import com.the_dungeoneers.game.states.levels.Level8;

/**
 * Created by Chris on 22/04/2017.
 */
public class TreasureIsland extends Island {
    
    public TreasureIsland(Game g, Player player, Camera camera){
        super(g, "Treasure Island", player, camera);
    }

    @Override
    public void setLevels() {
        levels.put(IslandManager.islands.get("PlaneIsland"), new Level8(g, player, camera, this));
        levels.put(IslandManager.islands.get("BurningIsland"), new Level7(g, player, camera, this));
        levels.put(IslandManager.islands.get("YellowIsland"), new Level6(g, player, camera, this));
    }
}
