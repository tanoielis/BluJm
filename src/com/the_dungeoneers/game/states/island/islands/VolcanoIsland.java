package com.the_dungeoneers.game.states.island.islands;

import com.the_dungeoneers.game.Game;
import com.the_dungeoneers.game.camera.Camera;
import com.the_dungeoneers.game.entities.Player;
import com.the_dungeoneers.game.states.island.Island;
import com.the_dungeoneers.game.states.levels.Level1;
import com.the_dungeoneers.game.states.levels.Level2;

/**
 * Home island
 */
public class VolcanoIsland extends Island {

    public VolcanoIsland(Game g, Player player, Camera camera) {
        super(g, "Volcano Island", player, camera);

        levels.put(new SkullIsland(g, player, camera), new Level1(g, player, camera, this));
        levels.put(new BigRockIsland(g, player, camera), new Level2(g, player, camera, this));
    }
}