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
    public void setLevels() {
        levels.put(IslandManager.islands.get(4), new Level1(g, player, camera, this));
        levels.put(IslandManager.islands.get(3), new Level2(g, player, camera, this));
    }
}