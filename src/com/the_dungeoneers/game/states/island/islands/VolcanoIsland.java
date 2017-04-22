package com.the_dungeoneers.game.states.island.islands;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.island.IslandManager;
import com.the_dungeoneers.game.states.levels.Level1;
import com.the_dungeoneers.game.states.levels.Level2;

/**
 * Home island
 */
public class VolcanoIsland extends Island {

    public VolcanoIsland(Game g, Player player, Camera camera) {
        super(g, "Volcano Island", player, camera);
    }

    @Override
    public void setNeighbours() {
        levels.put(IslandManager.islands.get("SkullIsland"), new Level1(g, player, camera, IslandManager.islands.get("SkullIsland")));
        levels.put(IslandManager.islands.get("BurningIsland"), new Level2(g, player, camera, IslandManager.islands.get("BurningIsland")));
    }
}