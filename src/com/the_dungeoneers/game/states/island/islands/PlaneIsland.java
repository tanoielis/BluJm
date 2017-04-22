package com.the_dungeoneers.game.states.island.islands;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.island.IslandManager;
import com.the_dungeoneers.game.states.levels.Level9;

/**
 * End island
 */
public class PlaneIsland extends Island {

    public PlaneIsland(Game g, Player player, Camera camera) {
        super(g, "Plane Island", player, camera);
    }

    @Override
    public void setNeighbours(IslandManager im) {
        return;
    }
}
