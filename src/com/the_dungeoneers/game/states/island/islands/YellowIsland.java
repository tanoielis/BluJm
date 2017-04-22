package com.the_dungeoneers.game.states.island.islands;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.island.IslandManager;
import com.the_dungeoneers.game.states.levels.Level2;
import com.the_dungeoneers.game.states.levels.Level3;
import com.the_dungeoneers.game.states.levels.Level5;
import com.the_dungeoneers.game.states.levels.Level6;

/**
 * Created by Chris on 22/04/2017.
 */
public class YellowIsland extends Island {

    public YellowIsland(Game g, Player player, Camera camera) {
        super(g, "Yellow Island", player, camera);
    }

    @Override
    public void setNeighbours() {
        levels.put(IslandManager.islands.get("BigRockIsland"), new Level2(g, player, camera, IslandManager.islands.get("BigRockIsland")));
        levels.put(IslandManager.islands.get("BurningIsland"), new Level5(g, player, camera, IslandManager.islands.get("BurningIsland")));
        levels.put(IslandManager.islands.get("TreasureIsland"), new Level6(g, player, camera, IslandManager.islands.get("TreasureIsland")));
        levels.put(IslandManager.islands.get("SkullIsland"), new Level3(g, player, camera, IslandManager.islands.get("SkullIsland")));
    }
}