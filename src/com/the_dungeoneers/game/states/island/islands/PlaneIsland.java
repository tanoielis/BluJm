package com.the_dungeoneers.game.states.island.islands;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.states.island.Island;

/**
 * End island
 */
public class PlaneIsland extends Island {

    public PlaneIsland(Game g, Player player, Camera camera) {
        super(g, "Plane island", player, camera);
    }
}
